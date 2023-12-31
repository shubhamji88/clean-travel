package org.example.strategy;

import org.example.model.Activity;
import org.example.model.Passenger;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GoldPricingStrategyTest {

    @Test
    public void goldPricingStrategy_CalculatePrice_ShouldApplyDiscount() {
        
        GoldPricingStrategy goldPricingStrategy = GoldPricingStrategy.getInstance();
        Activity activity = new Activity("Test Activity", 100, 10, "Test Description");
        
        double calculatedPrice = goldPricingStrategy.calculatePrice(activity);

        
        assertEquals(90.0, calculatedPrice, 0.01);
    }
}
