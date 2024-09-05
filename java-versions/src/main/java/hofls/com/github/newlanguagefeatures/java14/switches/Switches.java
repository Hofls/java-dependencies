package hofls.com.github.newlanguagefeatures.java14.switches;

public class Switches {

    /**
     * New and improved switch - no "break" necessary, works with strings, returns values
     * Old switch uses ":", new switch uses "->"
     */
    public int produceNumber(String text) {
        int result = switch (text) {
            case "a" -> 1;
            case "c", "d" -> {
                System.out.println("Multi line!");
                yield 3;
            }
            default -> 0;
        };
        return result;
    }

}
