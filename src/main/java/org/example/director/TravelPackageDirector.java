package org.example.director;

import org.example.builder.TravelPackageBuilder;
import org.example.model.TravelPackage;

/**
 * Director class for constructing a predefined travel package.
 * Uses the TravelPackageBuilder to create a travel package with specific destinations and activities.
 */
public class TravelPackageDirector {
    /**
     * Constructs a predefined travel package with specified destinations and activities.
     *
     * @param name              The name of the travel package.
     * @param passengerCapacity The passenger capacity of the travel package.
     * @return The constructed TravelPackage instance.
     */
    public static TravelPackage constructTravelPackage(String name, int passengerCapacity) {
        TravelPackageBuilder builder = new TravelPackageBuilder(name, new TravelPackage(name, passengerCapacity));

        builder.buildDestination("Asia")
                .addSightseeingTourActivity()
                .addMuseumVisitActivity();

        builder.buildDestination("Europe")
                .addScubaDivingActivity()
                .addBeachRelaxationActivity();

        builder.buildDestination("Australia")
                .addHikingExpeditionActivity()
                .addCampfireNightActivity();


        return builder.getTravelPackage();
    }
}


