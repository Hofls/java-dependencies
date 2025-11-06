package hofls.com.github.other;

import java.util.List;
import java.util.Map;

public class DataStructure {

    public static class User {
        private Long id;
        private String name;
        private Address address;
        private List<Order> orders;
    }

    public static class Address {
        private String street;
        private String city;
        private Country country;
    }

    public static class Country {
        private String name;
        private String code;
    }

    public static class Order {
        private String orderId;
        private List<Item> items;
    }

    public static class Item {
        private String name;
        private double price;
    }

    public static class Config {
        private int timeout;
        private boolean debug;
        private Map<String, String> metadata;
    }

    public static class ResultDTO {
        private boolean success;
        private String message;
        private Summary summary;
    }

    public static class Summary {
        private int totalOrders;
        private double totalAmount;
    }

}
