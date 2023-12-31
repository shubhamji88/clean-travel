package org.example;

import org.example.config.Config;
import org.example.director.TravelPackageDirector;
import org.example.model.Destination;
import org.example.model.Passenger;
import org.example.model.TravelPackage;
import org.example.strategy.PremiumPricingStrategy;

import java.util.List;

import static org.example.config.Config.*;

public class AdventureTravelPackageApp {
    public static void main(String[] args) {
        // Travel package using the director
        TravelPackage travelPackage = TravelPackageDirector.constructTravelPackage("Adventure Package", 50);

        // Create passengers
        List<Passenger> passengers = Config.getDemoPassengers();

        // Add passengers to the travel package
        travelPackage.addPassengers(passengers);

        // Sign up passengers for activities
        signUpPassengersForActivities();


        // Printing itinerary of the travel package
        System.out.println("===============Print Itinerary=====================");
        travelPackage.printItinerary();

        // Printing passenger list of the travel package
        System.out.println("=================Print Passenger List===================");
        travelPackage.printPassengerList();

        // Printing details of activities with available spaces
        System.out.println("=================Print Available Activities===================");
        travelPackage.printAvailableActivities();

        // Printing details available for passenger
        System.out.println("================Print Standard Passenger====================");
        System.out.println(STANDARD_PASSENGER);

        // Upgrading standard passenger to premium
        STANDARD_PASSENGER.setPricingStrategy(PremiumPricingStrategy.getInstance());
        System.out.println("================Print Upgraded Standard Passenger====================");
        System.out.println(STANDARD_PASSENGER);
    }

    private static void signUpPassengersForActivities() {
        STANDARD_PASSENGER.signUpForActivity(CITY_A_SIGHTSEEING_TOUR);
        GOLD_PASSENGER.signUpForActivity(CITY_A_MUSEUM_VISIT);
        PREMIUM_PASSENGER.signUpForActivity(ISLAND_B_SCUBA_DIVING);
        ANOTHER_STANDARD_PASSENGER.signUpForActivity(ISLAND_B_BEACH_RELAXATION);
        ANOTHER_GOLD_PASSENGER.signUpForActivity(MOUNTAIN_RETREAT_HIKING_EXPEDITION);
    }
}

