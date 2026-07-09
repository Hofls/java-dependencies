package com.github.hofls.scanner.entity;

import com.github.hofls.scanner.enums.EPermission;
import com.github.hofls.scanner.enums.EStatus;

/** Extra account just in case */
public class UserAccount {
    /** Identifier */
    private int id;
    /** Full name */
    private String username;
    /** Current status */
    private EStatus status;
    /** Validated email address */
    private String email;
    /** Finalized creation date */
    private java.util.Date createdAt;
    /** Most important permission */
    private EPermission permission;
}