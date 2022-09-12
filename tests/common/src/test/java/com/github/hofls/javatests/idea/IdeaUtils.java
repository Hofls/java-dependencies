package com.github.hofls.javatests.idea;

import java.io.PrintWriter;

/**
 * "<Click to see difference>" doesnt appear for very big strings in IntelliJ IDEA
 * https://youtrack.jetbrains.com/issue/IDEA-142886
 * https://youtrack.jetbrains.com/issue/IDEA-193214
 * Temporary fix - write text to file, right click on it -> Compare with file in editor
 */
public class IdeaUtils {

    public static void toFile(String fileName, String content) throws Exception {
        String actualPath = "src/test/resources/idea/" + fileName;
        try (PrintWriter out = new PrintWriter(actualPath)) {
            out.print(content);
        }
    }

}
