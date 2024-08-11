package hofls.com.github.errorprone;

public class Example {

    public void foo() {
        String str = null;
        str.length(); // This will cause a NullPointerException
    }

}
