package org.example.strategy;

import org.example.config.Config;
import org.example.model.Activity;

/**
 * Pricing strategy for calculating the price of an activity for a passenger.
 * The PremiumPricingStrategy offers no discount (free).
 */
public class PremiumPricingStrategy implements PricingStrategy {
    private volatile static PremiumPricingStrategy instance;

    private PremiumPricingStrategy() {
    }

    public static PremiumPricingStrategy getInstance() {
        if (instance == null) {
            synchronized (PremiumPricingStrategy.class) {
                if (instance == null) {
                    instance = new PremiumPricingStrategy();
                }
            }
        }
        return instance;
    }

    @Override
    public double calculatePrice(Activity activity) {
        return Config.PREMIUM_PRICING_COST_MULTIPLIER * activity.getCost();
    }
}
