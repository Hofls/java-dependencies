package hofls.com.github.scanner.entity;

/** Long lasting session */
public class UserSession {
    /** Unique session token */
    private String sessionToken;
    /** Foreign key to UserAccount id */
    private int userId;
    /** IP address of the user */
    private String ipAddress;
    /** When the session was initiated */
    private java.util.Date loginTime;
    /** When the session will expire */
    private java.util.Date expiryDate;
}