package org.example.strategy;

import org.example.model.Activity;
import org.example.model.Passenger;
import org.example.strategy.StandardPricingStrategy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StandardPricingStrategyTest {

    @Test
    public void standardPricingStrategy_CalculatePrice_ShouldNotApplyDiscount() {
        
        StandardPricingStrategy standardPricingStrategy = StandardPricingStrategy.getInstance();
        Activity activity = new Activity("Test Activity", 100, 10, "Test Description");

        double calculatedPrice = standardPricingStrategy.calculatePrice(activity);

        
        assertEquals(100.0, calculatedPrice, 0.01);
    }
}
