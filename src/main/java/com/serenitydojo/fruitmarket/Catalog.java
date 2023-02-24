package com.serenitydojo.fruitmarket;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

public class Catalog {
    private final EnumMap<Fruit, Double> catalogOfFruits = new EnumMap<>(Fruit.class);

    public PriceSetter setPriceOf(Fruit fruit) {
        return new PriceSetter(this, fruit);
    }

    public Double getPriceOf(Fruit fruit) {
        return catalogOfFruits.get(fruit);
    }

    public List<String> getAvailableFruit() {
        return catalogOfFruits.keySet().stream()
                .map(Enum::name).sorted().collect(Collectors.toList());
    }

    public class PriceSetter {
        private final Catalog catalog;
        private final Fruit fruit;

        public PriceSetter(Catalog catalog, Fruit fruit) {
            this.catalog = catalog;
            this.fruit = fruit;
        }

        public Catalog to(Double price) {
            catalogOfFruits.put(fruit, price);
            return catalog;
        }
    }
}
