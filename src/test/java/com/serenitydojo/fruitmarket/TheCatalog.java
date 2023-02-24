package com.serenitydojo.fruitmarket;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.serenitydojo.fruitmarket.Fruit.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TheCatalog {
    Catalog catalog = new Catalog();

    @Before
    public void beforeMethod() {

        catalog
                .setPriceOf(Apple).to(1.00)
                .setPriceOf(Banana).to(1.00)
                .setPriceOf(Orange).to(1.00)
                .setPriceOf(Pear).to(2.00)
                .setPriceOf(Mango).to(4.00)
                .setPriceOf(Lemon).to(2.00);
    }

    @Test
    public void shouldBeAbleToUpdateTheCurrentPriceOfAFruit() {
        // You can update the catalog with the current market price of a fruit
        // The Catalog should report the price of a given type of fruit
        Catalog catalog = new Catalog();
        catalog.setPriceOf(Apple).to(4.00);
        assertThat(catalog.getPriceOf(Apple)).isEqualTo(4.00);
    }

    @Test
    public void shouldBeAbleToUpdateTheCurrentPriceOfAFruits() {
        // You can update the catalog with the current market price of a fruit
        // The Catalog should report the price of a given type of fruit
        assertThat(catalog.getPriceOf(Apple)).isEqualTo(1.00);
        assertThat(catalog.getPriceOf(Mango)).isEqualTo(4.00);
    }


    @Test
    public void shouldBeAbleToListCurrentlyAvailableFruit() {
        //The Catalog should list the names of the currently available fruit in alphabetical order
        List<String> availableFruits = catalog.getAvailableFruit();
        assertThat(availableFruits).containsExactly("Apple", "Banana", "Lemon", "Mango", "Orange", "Pear");
    }

    @Test
    public void shouldBeAbleToGetExceptionIfCurrentlyNotAvailableFruit() {
        //The Catalog should throw a FruitUnavailableException if the fruit is not currently available
        Catalog catalog = new Catalog();
        catalog.setPriceOf(Apple).to(1.75);
        List<String> availableFruits = catalog.getAvailableFruit();
        System.out.println(availableFruits);

        try {
            catalog.getPriceOf(Pear);
        } catch (FruitUnavailableException e) {
            assertThat(e.getMessage()).contains("Pear currently unavailable");
        }

    }
}
