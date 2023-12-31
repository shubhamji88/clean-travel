package org.example.strategy;

import org.example.config.Config;
import org.example.model.Activity;

/**
 * Pricing strategy for calculating the price of an activity for a passenger.
 * The GoldPricingStrategy offers a discount.
 */

public class GoldPricingStrategy implements PricingStrategy {

    private volatile static GoldPricingStrategy instance;

    private GoldPricingStrategy() {
    }

    public static GoldPricingStrategy getInstance() {
        if (instance == null) {
            synchronized (GoldPricingStrategy.class) {
                if (instance == null) {
                    instance = new GoldPricingStrategy();
                }
            }
        }
        return instance;
    }

    @Override
    public double calculatePrice(Activity activity) {
        return Config.GOLD_PRICING_COST_MULTIPLIER * activity.getCost();
    }
}
