package com.serenitydojo.fruitmarket;

public class ShoppingCartItem {
    private final Fruit fruit;
    private final Double quantity;
    private final Double totalPrice;

    public ShoppingCartItem(Fruit fruit, Double quantity, Double totalPrice) {
        this.fruit = fruit;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public Double getQuantity() {
        return quantity;
    }

    public Double getTotalCost() {
        return totalPrice;
    }
}
