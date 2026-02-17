package hofls.com.github.scanner.enums;

/** User permission levels */
public enum EPermission {
    ADMIN("Full system access and configuration rights"),
    MODERATOR("Can manage content and users"),
    EDITOR("Can create and edit content only"),
    VIEWER("Read-only access to content");

    EPermission(String description) {
        this.description = description;
    }

    private String description;
}