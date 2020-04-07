package hofls.com.github.annotation;

public class SketchyClass {

    private int intValue;

    @NotEvil(comment = "Deus wult")
    private long longValue;

    private String stringValue;

    public SketchyClass(int intValue, long longValue, String stringValue) {
        this.intValue = intValue;
        this.longValue = longValue;
        this.stringValue = stringValue;
    }
}
