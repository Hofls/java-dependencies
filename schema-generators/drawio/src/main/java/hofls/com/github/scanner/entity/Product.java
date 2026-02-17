package hofls.com.github.scanner.entity;

/** The best products ever */
public class Product {
    /** Unique product */
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