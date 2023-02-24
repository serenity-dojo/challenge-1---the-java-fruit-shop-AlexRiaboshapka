package com.serenitydojo.fruitmarket;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final Catalog catalog;
    private final List<ShoppingCartItem> items;

    public ShoppingCart(Catalog catalog) {
        this.catalog = catalog;
        this.items = new ArrayList<>();
    }


    public ItemsAdder add(double quantity) {
        return new ItemsAdder(this, quantity);
    }

    public List<ShoppingCartItem> getItems() {
        return items;
    }

    public Double getTotalPrice() {
        return items.stream().mapToDouble(ShoppingCartItem::getTotalCost).sum();
    }

    public class ItemsAdder {
        private final ShoppingCart shoppingCart;
        private final double quantity;

        public ItemsAdder(ShoppingCart shoppingCart, double quantity) {

            this.shoppingCart = shoppingCart;
            this.quantity = quantity;
        }

        public ShoppingCart kilosOf(Fruit fruit) {
            double totalPrice;
            if (quantity >= 5.00) {
                totalPrice = quantity * catalog.getPriceOf(fruit) * 0.9;
            } else {
                totalPrice = quantity * catalog.getPriceOf(fruit);
            }
            ShoppingCartItem shoppingCartItem = new ShoppingCartItem(fruit, quantity, totalPrice);
            items.add(shoppingCartItem);
            return shoppingCart;
        }
    }
}
