package org.example.builder;

import lombok.RequiredArgsConstructor;
import org.example.config.Config;
import org.example.model.Activity;
import org.example.model.Destination;

/**
 * Builder class for creating destinations with associated activities.
 * Uses the Destination class to build a destination and add activities to it.
 */
@RequiredArgsConstructor
public class DestinationBuilder {
    private final Destination destination;

    /**
     * Adds a new activity to the destination.
     *
     * @param activity Activity to add
     * @return The DestinationBuilder instance for method chaining.
     */
    public DestinationBuilder addActivityLeaf(Activity activity) {
        destination.addActivity(activity);
        return this;
    }

    public DestinationBuilder addSightseeingTourActivity() {
        return addActivityLeaf(Config.CITY_A_SIGHTSEEING_TOUR);
    }

    public DestinationBuilder addMuseumVisitActivity() {
        return addActivityLeaf(Config.CITY_A_MUSEUM_VISIT);
    }

    public DestinationBuilder addScubaDivingActivity() {
        return addActivityLeaf(Config.ISLAND_B_SCUBA_DIVING);
    }

    public DestinationBuilder addBeachRelaxationActivity() {
        return addActivityLeaf(Config.ISLAND_B_BEACH_RELAXATION);
    }

    public DestinationBuilder addHikingExpeditionActivity() {
        return addActivityLeaf(Config.MOUNTAIN_RETREAT_HIKING_EXPEDITION);
    }

    public DestinationBuilder addCampfireNightActivity() {
        return addActivityLeaf(Config.MOUNTAIN_RETREAT_CAMPFIRE_NIGHT);
    }
}
