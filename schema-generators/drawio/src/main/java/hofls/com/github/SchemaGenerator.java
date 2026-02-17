package hofls.com.github;

import java.io.FileWriter;
import java.lang.reflect.Field;
import java.util.List;

public class SchemaGenerator {

    record Table(String name, List<Field> fields) {}

    record Field(String cyrillicName, String englishName, String type) {}

    public void generate(List<Table> tables) {
        StringBuilder xml = new StringBuilder();
        xml.append("<mxfile host=\"Electron\" version=\"21.0.0\">");
        xml.append("<diagram name=\"DynamicSchema\">");
        xml.append("<mxGraphModel dx=\"1000\" dy=\"1000\" grid=\"1\" gridSize=\"10\" guides=\"1\" tooltips=\"1\" connect=\"1\" arrows=\"1\" fold=\"1\" page=\"1\">");
        xml.append("<root>");
        xml.append("<mxCell id=\"0\" />");
        xml.append("<mxCell id=\"1\" parent=\"0\" />");

        int xPosition = 40;

        for (int t = 0; t < tables.size(); t++) {
            Table table = tables.get(t);
            String tableId = "table_" + t;

            // 1. Calculate Dynamic Width based on longest field string
            int maxChars = table.name.length();
            for (Field f : table.fields) {
                String fullString = "+ " + f.cyrillicName + " (" + f.englishName + "): " + f.type;
                if (fullString.length() > maxChars) maxChars = fullString.length();
            }

            // Heuristic: ~7 pixels per char + padding. Minimum 180px.
            int dynamicWidth = Math.max(180, (maxChars * 6) + 40);
            int rowHeight = 14;
            int headerHeight = 30;
            int totalHeight = headerHeight + (table.fields.size() * rowHeight);

            // Table Style
            String tableStyle = "shape=table;startSize=" + headerHeight + ";container=1;collapsible=0;childLayout=0;" +
                    "fixedRows=1;rowLines=1;fontStyle=1;align=center;rounded=1;arcSize=12;whiteSpace=wrap;html=1;";

            xml.append(String.format("<mxCell id=\"%s\" value=\"%s\" style=\"%s\" vertex=\"1\" parent=\"1\">",
                    tableId, table.name, tableStyle));
            xml.append(String.format("<mxGeometry x=\"%d\" y=\"80\" width=\"%d\" height=\"%d\" as=\"geometry\" />",
                    xPosition, dynamicWidth, totalHeight));
            xml.append("</mxCell>");

            for (int f = 0; f < table.fields.size(); f++) {
                Field field = table.fields.get(f);
                String label = String.format("+ %s (%s): %s", field.cyrillicName, field.englishName, field.type);

                // Row Style
                String rowStyle = "shape=tableRow;horizontal=1;startSize=0;swimlaneHead=0;swimlaneBody=0;top=0;left=0;bottom=0;right=0;" +
                        "collapsible=0;dropTarget=0;fillColor=none;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;" +
                        "align=left;verticalAlign=middle;spacingLeft=10;whiteSpace=wrap;html=1;fontSize=11;";

                int yOffset = headerHeight + (f * rowHeight);
                xml.append(String.format("<mxCell id=\"%s_row_%d\" value=\"%s\" style=\"%s\" vertex=\"1\" parent=\"%s\">",
                        tableId, f, label, rowStyle, tableId));
                xml.append(String.format("<mxGeometry y=\"%d\" width=\"%d\" height=\"%d\" as=\"geometry\" />",
                        yOffset, dynamicWidth, rowHeight));
                xml.append("</mxCell>");
            }

            xPosition += (dynamicWidth + 50); // Offset next table by its own width
        }

        xml.append("</root></mxGraphModel></diagram></mxfile>");
        saveToFile(xml.toString(), "dynamic_schema.drawio");
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
