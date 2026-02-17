package hofls.com.github.scanner.entity;

import hofls.com.github.scanner.enums.EStatus;

/** Extra account just in case */
public class UserAccount {
    /** Identifier */
    private int id;
    /** Full name */
    private String username;
    /** Validated email address */
    private String email;
    /** Finalized creation date */
    private java.util.Date createdAt;
    /** Current status */
    private EStatus status;
}