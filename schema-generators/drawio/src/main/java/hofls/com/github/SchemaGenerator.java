package hofls.com.github;

import java.io.FileWriter;

public class SchemaGenerator {

    public void generate() {
        String tableName = "UserAccount";
        String[][] columns = {
                {"id", "INT (PK)"},
                {"username", "VARCHAR(50)"},
                {"email", "VARCHAR(100)"},
                {"created_at", "TIMESTAMP"}
        };

        StringBuilder xml = new StringBuilder();
        xml.append("<mxfile host=\"Electron\" version=\"21.0.0\">");
        xml.append("<diagram name=\"FixedTable\">");
        xml.append("<mxGraphModel dx=\"1000\" dy=\"1000\" grid=\"1\" gridSize=\"10\" guides=\"1\" tooltips=\"1\" connect=\"1\" arrows=\"1\" fold=\"1\" page=\"1\">");
        xml.append("<root>");
        xml.append("<mxCell id=\"0\" />");
        xml.append("<mxCell id=\"1\" parent=\"0\" />");

        // 1. Table Container Style: added 'whiteSpace=wrap' and 'html=1'
        String tableStyle = "shape=table;startSize=30;container=1;collapsible=0;childLayout=0;fixedRows=1;rowLines=1;fontStyle=1;align=center;";
        xml.append(String.format("<mxCell id=\"table_1\" value=\"%s\" style=\"%s\" vertex=\"1\" parent=\"1\">", tableName, tableStyle));
        xml.append(String.format("<mxGeometry x=\"100\" y=\"100\" width=\"220\" height=\"%d\" as=\"geometry\" />", 30 + (columns.length * 30)));
        xml.append("</mxCell>");

        // 2. Generate Rows
        for (int i = 0; i < columns.length; i++) {
            String colText = columns[i][0] + " : " + columns[i][1];

            // Row Style: horizontal=1 ensures the text isn't vertical.
            // align=left + spacingLeft=10 makes it look like a real DB tool.
            String rowStyle = "shape=tableRow;horizontal=1;startSize=0;swimlaneHead=0;swimlaneBody=0;top=0;left=0;bottom=0;right=0;collapsible=0;dropTarget=0;fillColor=none;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;align=left;verticalAlign=middle;spacingLeft=10;whiteSpace=wrap;";

            xml.append(String.format("<mxCell id=\"row_%d\" value=\"%s\" style=\"%s\" vertex=\"1\" parent=\"table_1\">", i, colText, rowStyle));
            // y starts at 30 (below header) and increments by 30
            xml.append(String.format("<mxGeometry y=\"%d\" width=\"220\" height=\"30\" as=\"geometry\" />", 30 + (i * 30)));
            xml.append("</mxCell>");
        }

        xml.append("</root></mxGraphModel></diagram></mxfile>");

        try (FileWriter writer = new FileWriter("database_fixed.drawio")) {
            writer.write(xml.toString());
            System.out.println("Fixed diagram generated: database_fixed.drawio");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
