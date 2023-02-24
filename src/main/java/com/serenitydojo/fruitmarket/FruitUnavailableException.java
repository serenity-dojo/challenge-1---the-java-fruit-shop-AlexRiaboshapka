package com.serenitydojo.fruitmarket;

public class FruitUnavailableException extends RuntimeException {
    public FruitUnavailableException(Fruit fruit) {
        super(fruit + " currently unavailable");
    }
}
