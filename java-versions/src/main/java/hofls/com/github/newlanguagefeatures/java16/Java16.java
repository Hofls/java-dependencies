package hofls.com.github.newlanguagefeatures.java16;

import java.util.Arrays;

public class Java16 {

    // Records (immutable object with equals, hashCode and toString)
    record Point(int x, int y) { }

    public static void recordExample() {
        Point p1 = new Point(10, 20);
        System.out.println(p1.x);
        System.out.println(p1); // Point[x=10, y=20]
    }

    // Streams - toList()
    public static void toList() {
        Arrays.asList("1", "2", "3").stream().map(Integer::parseInt).toList();
    }

}
