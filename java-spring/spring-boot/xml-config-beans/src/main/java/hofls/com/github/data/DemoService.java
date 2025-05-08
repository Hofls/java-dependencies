package hofls.com.github.data;

public class DemoService {

    private final DemoSource demoSource;

    public DemoService(DemoSource demoSource) {
        this.demoSource = demoSource;
    }

    public void printMessage() {
        System.out.println(demoSource.getMessage());
    }

}
