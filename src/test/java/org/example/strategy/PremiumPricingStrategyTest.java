package org.example.strategy;

import org.example.model.Activity;
import org.example.model.Passenger;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PremiumPricingStrategyTest {

    @Test
    public void premiumPricingStrategy_CalculatePrice_ShouldReturnZero() {
        
        PremiumPricingStrategy premiumPricingStrategy = PremiumPricingStrategy.getInstance();
        Activity activity = new Activity("Test Activity", 100, 10, "Test Description");

        double calculatedPrice = premiumPricingStrategy.calculatePrice(activity);

        
        assertEquals(0.0, calculatedPrice, 0.01);
    }
}
