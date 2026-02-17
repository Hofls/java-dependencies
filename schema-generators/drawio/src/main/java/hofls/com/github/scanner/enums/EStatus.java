package hofls.com.github.scanner.enums;

/** Pretty special status */
public enum EStatus {
    ONLINE("Was seen not more than 15 minutes ago"),
    OFFLINE("Not on the network");

    EStatus(String title) {
        this.title = title;
    }

    private String title;
}
