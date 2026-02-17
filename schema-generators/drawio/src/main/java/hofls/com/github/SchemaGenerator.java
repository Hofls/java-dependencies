package hofls.com.github;

import java.io.FileWriter;
import java.util.List;

public class SchemaGenerator {

    record Table(String name, List<Field> fields) {}

    record Field(String cyrillicName, String englishName, String type) {}

    private static final int ROW_HEIGHT = 14;
    private static final int HEADER_HEIGHT = 30;
    private static final int SPACING = 50;

    public void generate(List<Table> tables) {
        StringBuilder xml = new StringBuilder();
        addRootStart(xml);

        int xPosition = 40;
        for (int t = 0; t < tables.size(); t++) {
            Table table = tables.get(t);
            String tableId = "table_" + t;
            int dynamicWidth = calculateWidth(table);
            int totalHeight = HEADER_HEIGHT + (table.fields.size() * ROW_HEIGHT);

            addTable(xml, table, tableId, xPosition, dynamicWidth, totalHeight);
            for (int f = 0; f < table.fields.size(); f++) {
                addRow(xml, table.fields.get(f), tableId, f, dynamicWidth);
            }

            xPosition += (dynamicWidth + SPACING);
        }

        addRootEnd(xml);
        saveToFile(xml.toString(), "dynamic_schema.drawio");
    }

    private void addRootStart(StringBuilder xml) {
        xml.append("<mxfile host=\"Electron\" version=\"21.0.0\">");
        xml.append("<diagram name=\"DynamicSchema\">");
        xml.append("<mxGraphModel dx=\"1000\" dy=\"1000\" grid=\"1\" gridSize=\"10\" guides=\"1\" tooltips=\"1\" connect=\"1\" arrows=\"1\" fold=\"1\" page=\"1\">");
        xml.append("<root>");
        xml.append("<mxCell id=\"0\" />");
        xml.append("<mxCell id=\"1\" parent=\"0\" />");
    }

    private void addTable(StringBuilder xml, Table table, String id, int x, int width, int height) {
        String style = "shape=table;startSize=" + HEADER_HEIGHT + ";container=1;collapsible=0;childLayout=0;" +
                "fixedRows=1;rowLines=1;fontStyle=1;align=center;rounded=1;arcSize=12;whiteSpace=wrap;html=1;";

        xml.append(String.format("<mxCell id=\"%s\" value=\"%s\" style=\"%s\" vertex=\"1\" parent=\"1\">",
                id, table.name, style));
        xml.append(String.format("<mxGeometry x=\"%d\" y=\"80\" width=\"%d\" height=\"%d\" as=\"geometry\" />",
                x, width, height));
        xml.append("</mxCell>");
    }

    private void addRow(StringBuilder xml, Field field, String tableId, int index, int width) {
        String label = String.format("+ %s (%s): %s", field.cyrillicName, field.englishName, field.type);
        String style = "shape=tableRow;horizontal=1;startSize=0;swimlaneHead=0;swimlaneBody=0;top=0;left=0;bottom=0;right=0;" +
                "collapsible=0;dropTarget=0;fillColor=none;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;" +
                "align=left;verticalAlign=middle;spacingLeft=10;whiteSpace=wrap;html=1;fontSize=11;";

        int yOffset = HEADER_HEIGHT + (index * ROW_HEIGHT);

        xml.append(String.format("<mxCell id=\"%s_row_%d\" value=\"%s\" style=\"%s\" vertex=\"1\" parent=\"%s\">",
                tableId, index, label, style, tableId));
        xml.append(String.format("<mxGeometry y=\"%d\" width=\"%d\" height=\"%d\" as=\"geometry\" />",
                yOffset, width, ROW_HEIGHT));
        xml.append("</mxCell>");
    }

    private void addRootEnd(StringBuilder xml) {
        xml.append("</root></mxGraphModel></diagram></mxfile>");
    }

    private int calculateWidth(Table table) {
        int maxChars = table.name.length();
        for (Field f : table.fields) {
            String fullString = "+ " + f.cyrillicName + " (" + f.englishName + "): " + f.type;
            maxChars = Math.max(maxChars, fullString.length());
        }
        // Heuristic: ~6 pixels per char + padding.
        return Math.max(180, (maxChars * 6) + 40);
    }

    private void saveToFile(String content, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(content);
            System.out.println("Diagram successfully exported to: " + filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
