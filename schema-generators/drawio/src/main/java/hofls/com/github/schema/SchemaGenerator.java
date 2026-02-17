package hofls.com.github.schema;

import java.io.FileWriter;
import java.util.List;

public class SchemaGenerator {

    public record DBEntity(String cyrillicName, String englishName, List<DBField> fields, String type) {}

    public record DBField(String cyrillicName, String englishName, String type) {}

    private static final int ROW_HEIGHT = 14;
    private static final int HEADER_HEIGHT = 30;
    private static final int SPACING = 50;

    public static void generate(List<DBEntity> entities) {
        StringBuilder xml = new StringBuilder();
        addRootStart(xml);

        int xPosition = 40;
        int yPosition = 80;
        int maxHeightInCurrentRow = 0;

        for (int t = 0; t < entities.size(); t++) {
            DBEntity entity = entities.get(t);
            boolean isEnum = "enum".equalsIgnoreCase(entity.type());

            // If it's NOT an enum, we move to a new vertical "line"
            if (!isEnum && t > 0) {
                xPosition = 40; // Reset X
                yPosition += maxHeightInCurrentRow + SPACING; // Move Y down
                maxHeightInCurrentRow = 0; // Reset row height tracker
            }

            String entityId = "entity_" + t;
            int dynamicWidth = calculateWidth(entity);
            int totalHeight = HEADER_HEIGHT + (entity.fields.size() * ROW_HEIGHT);

            // Update the max height for the current horizontal row (mostly for enums)
            maxHeightInCurrentRow = Math.max(maxHeightInCurrentRow, totalHeight);

            // Pass yPosition to addTable
            addTable(xml, entity, entityId, xPosition, yPosition, dynamicWidth, totalHeight);

            for (int f = 0; f < entity.fields.size(); f++) {
                addRow(xml, entity.fields.get(f), entityId, f, dynamicWidth);
            }

            // Enums keep moving right; Standard tables move right only if multiple
            // standard tables are allowed per row (otherwise they've already reset X above)
            xPosition += (dynamicWidth + SPACING);
        }

        addRootEnd(xml);
        saveToFile(xml.toString(), "dynamic_schema.drawio");
    }

    private static void addRootStart(StringBuilder xml) {
        xml.append("<mxfile host=\"Electron\" version=\"21.0.0\">");
        xml.append("<diagram name=\"DynamicSchema\">");
        xml.append("<mxGraphModel dx=\"1000\" dy=\"1000\" grid=\"1\" gridSize=\"10\" guides=\"1\" tooltips=\"1\" connect=\"1\" arrows=\"1\" fold=\"1\" page=\"1\">");
        xml.append("<root>");
        xml.append("<mxCell id=\"0\" />");
        xml.append("<mxCell id=\"1\" parent=\"0\" />");
    }

    private static void addTable(StringBuilder xml, DBEntity entity, String id, int x, int y, int width, int height) {
        StringBuilder style = new StringBuilder("shape=table;startSize=" + HEADER_HEIGHT + ";container=1;collapsible=0;childLayout=0;" +
                "fixedRows=1;rowLines=1;fontStyle=1;align=center;rounded=1;arcSize=12;whiteSpace=wrap;html=1;");

        if ("enum".equalsIgnoreCase(entity.type())) {
            style.append("fillColor=#fff2cc;strokeColor=#d6b656;fontColor=#000000;");
        }

        var enumPrefix = (entity.type().equals("enum") ? "enum - " : "");
        var header = entity.cyrillicName +  " (" + enumPrefix + entity.englishName + ")";

        xml.append(String.format("<mxCell id=\"%s\" value=\"%s\" style=\"%s\" vertex=\"1\" parent=\"1\">",
                id, header, style.toString()));
        // Use the dynamic 'y' parameter here instead of hardcoded 80
        xml.append(String.format("<mxGeometry x=\"%d\" y=\"%d\" width=\"%d\" height=\"%d\" as=\"geometry\" />",
                x, y, width, height));
        xml.append("</mxCell>");
    }

    private static void addRow(StringBuilder xml, DBField field, String entityId, int index, int width) {
        String label = field.type != null
                ? String.format("+ %s (%s): %s", field.cyrillicName, field.englishName, field.type)
                : String.format("+ %s (%s)", field.cyrillicName, field.englishName);
        String style = "shape=tableRow;horizontal=1;startSize=0;swimlaneHead=0;swimlaneBody=0;top=0;left=0;bottom=0;right=0;" +
                "collapsible=0;dropTarget=0;fillColor=none;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;" +
                "align=left;verticalAlign=middle;spacingLeft=10;whiteSpace=wrap;html=1;fontSize=11;";

        int yOffset = HEADER_HEIGHT + (index * ROW_HEIGHT);

        xml.append(String.format("<mxCell id=\"%s_row_%d\" value=\"%s\" style=\"%s\" vertex=\"1\" parent=\"%s\">",
                entityId, index, label, style, entityId));
        xml.append(String.format("<mxGeometry y=\"%d\" width=\"%d\" height=\"%d\" as=\"geometry\" />",
                yOffset, width, ROW_HEIGHT));
        xml.append("</mxCell>");
    }

    private static void addRootEnd(StringBuilder xml) {
        xml.append("</root></mxGraphModel></diagram></mxfile>");
    }

    private static int calculateWidth(DBEntity entity) {
        int maxChars = entity.englishName.length();
        for (DBField f : entity.fields) {
            String fullString = "+ " + f.cyrillicName + " (" + f.englishName + "): " + f.type;
            maxChars = Math.max(maxChars, fullString.length());
        }
        // Heuristic: ~6 pixels per char + padding.
        return Math.max(180, (maxChars * 6) + 40);
    }

    private static void saveToFile(String content, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(content);
            System.out.println("Diagram successfully exported to: " + filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
