package com.github.hofls.redis.pubsub.purchase;

public class Purchase {
    public int id;
    public int price;

    public Purchase() {
    }

    public Purchase(int id, int price) {
        this.id = id;
        this.price = price;
    }

    @Override
    public String toString() {
        return " id " + id + "; price " + price;
    }
}
