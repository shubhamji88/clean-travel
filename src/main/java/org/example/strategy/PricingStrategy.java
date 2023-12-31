package org.example.strategy;

import org.example.model.Activity;

/**
 * Interface for pricing strategies used to calculate the price of an activity for a passenger.
 */
public interface PricingStrategy {
    double calculatePrice(Activity activity);
}
