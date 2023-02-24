package com.serenitydojo.fruitmarket;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Percentage;
import org.junit.Before;
import org.junit.Test;

import static com.serenitydojo.fruitmarket.Fruit.*;

public class ShoppingCartTest {
    Catalog catalog;
    ShoppingCart shoppingCart;

    @Before
    public void beforeMethod() {
        catalog = new Catalog()
                .setPriceOf(Apple).to(2.0)
                .setPriceOf(Pear).to(1.0)
                .setPriceOf(Banana).to(2.0)
                .setPriceOf(Mango).to(3.0);
        shoppingCart = new ShoppingCart(catalog);
    }

    @Test
    public void shouldStartWithNoItems() {
        Catalog catalog = new Catalog();
        ShoppingCart shoppingCart = new ShoppingCart(catalog);
        Assertions.assertThat(shoppingCart.getItems()).isEmpty();
    }

    @Test
    public void shouldContainAddedItems() {
        shoppingCart
                .add(2.00).kilosOf(Apple)
                .add(4.99).kilosOf(Banana);
        Assertions.assertThat(shoppingCart.getItems()).hasSize(2);
    }

    @Test
    public void shouldBeAbleToAddItemsAndGetTheTotalCost() {
        //You can add items to your shopping cart, which should keep a running total.
        shoppingCart
                .add(2.00).kilosOf(Apple)
                .add(4.99).kilosOf(Banana);
        Assertions.assertThat(shoppingCart.getTotalPrice()).isCloseTo(14.0, Percentage.withPercentage(1));
    }

    @Test
    public void shouldBeAbleToAddItemsAndGetTheTotalCostOfItem() {
        //You can add items to your shopping cart, which should keep a running total.
        shoppingCart
                .add(2.00).kilosOf(Apple);
        ShoppingCartItem apple = shoppingCart.getItems().get(0);
        Assertions.assertThat(apple.getTotalCost()).isCloseTo(4.0, Percentage.withPercentage(1));
        Assertions.assertThat(apple.getFruit()).isEqualTo(Apple);
        Assertions.assertThat(apple.getQuantity()).isEqualTo(2.00);
    }

    @Test
    public void shouldBeAbleToAddItemsToShoppingCartGetDiscountForMoreThanFiveKiloForItem() {
        //When you buy 5 kilos or more of any fruit, you get a 10% discount.
        shoppingCart
                .add(20.00).kilosOf(Pear);
        Assertions.assertThat(shoppingCart.getTotalPrice()).isCloseTo(18, Percentage.withPercentage(1));
    }

    @Test
    public void shouldBeAbleToAddItemsToShoppingCartGetDiscountForMoreThanFiveKiloItems() {
        //When you buy 5 kilos or more of any fruit, you get a 10% discount.
        shoppingCart
                .add(6.00).kilosOf(Apple)
                .add(6.00).kilosOf(Banana)
                .add(2.00).kilosOf(Pear);
        Assertions.assertThat(shoppingCart.getTotalPrice()).isCloseTo(23.6, Percentage.withPercentage(1));
    }
}
