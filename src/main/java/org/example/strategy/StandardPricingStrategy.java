package org.example.strategy;

import org.example.config.Config;
import org.example.model.Activity;

/**
 * Pricing strategy for calculating the price of an activity for a passenger.
 * The StandardPricingStrategy uses the regular cost without any discount.
 */
public class StandardPricingStrategy implements PricingStrategy {
    private volatile static StandardPricingStrategy instance;

    private StandardPricingStrategy() {
    }

    public static StandardPricingStrategy getInstance() {
        if (instance == null) {
            synchronized (StandardPricingStrategy.class) {
                if (instance == null) {
                    instance = new StandardPricingStrategy();
                }
            }
        }
        return instance;
    }

    @Override
    public double calculatePrice(Activity activity) {
        return Config.STANDARD_PRICING_COST_MULTIPLIER * activity.getCost();
    }
}
