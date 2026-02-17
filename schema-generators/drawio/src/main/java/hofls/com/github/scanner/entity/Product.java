package hofls.com.github.scanner.entity;

public class Product {
    /** Unique product SKU */
    private String sku;
    /** Display name */
    private String name;
    /** Description of the item */
    private String description;
    /** Current price in cents to avoid floating point errors */
    private long priceInCents;
    /** Availability status */
    private boolean isActive;
}