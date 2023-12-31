package org.example.config;

import org.example.model.Activity;
import org.example.model.Passenger;
import org.example.strategy.GoldPricingStrategy;
import org.example.strategy.PremiumPricingStrategy;
import org.example.strategy.StandardPricingStrategy;

import java.util.Arrays;
import java.util.List;

public class Config {
    public static final double GOLD_PRICING_COST_MULTIPLIER = 0.9;
    public static final double PREMIUM_PRICING_COST_MULTIPLIER = 0;
    public static final double STANDARD_PRICING_COST_MULTIPLIER = 1;
    public static final Activity CITY_A_SIGHTSEEING_TOUR = new Activity("Sightseeing Tour", 50, 20, "Explore the city");
    public static final Activity CITY_A_MUSEUM_VISIT = new Activity("Museum Visit", 30, 15, "Visit famous museums");
    public static final Activity ISLAND_B_SCUBA_DIVING = new Activity("Scuba Diving", 100, 10, "Underwater adventure");
    public static final Activity ISLAND_B_BEACH_RELAXATION = new Activity("Beach Relaxation", 20, 30, "Enjoy the sandy beaches");
    public static final Activity MOUNTAIN_RETREAT_HIKING_EXPEDITION = new Activity("Hiking Expedition", 80, 15, "Explore scenic trails");
    public static final Activity MOUNTAIN_RETREAT_CAMPFIRE_NIGHT = new Activity("Campfire Night", 40, 25, "Enjoy a cozy night by the fire");
    public static final Passenger STANDARD_PASSENGER = new Passenger("John Doe", 1, GoldPricingStrategy.getInstance(), 100.0);
    public static final Passenger GOLD_PASSENGER = new Passenger("Jane Smith", 2, PremiumPricingStrategy.getInstance(), 200.0);
    public static final Passenger PREMIUM_PASSENGER = new Passenger("Alice Johnson", 3, StandardPricingStrategy.getInstance(), 210.0);
    public static final Passenger ANOTHER_STANDARD_PASSENGER = new Passenger("Bob Johnson", 4, StandardPricingStrategy.getInstance(), 50.0);
    public static final Passenger ANOTHER_GOLD_PASSENGER = new Passenger("Eva Brown", 5, GoldPricingStrategy.getInstance(), 150.0);
    private Config() {
    }

    public static List<Passenger> getDemoPassengers() {
        return Arrays.asList(STANDARD_PASSENGER, GOLD_PASSENGER, PREMIUM_PASSENGER, ANOTHER_STANDARD_PASSENGER, ANOTHER_GOLD_PASSENGER);
    }
}
