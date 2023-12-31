package org.example.builder;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.model.Destination;
import org.example.model.TravelPackage;

/**
 * Builder class for creating travel packages with destinations and activities.
 * Uses the TravelPackage and Destination classes to build a travel package.
 */
@RequiredArgsConstructor
@Getter
public class TravelPackageBuilder {
    private final String name;
    private final TravelPackage travelPackage;

    /**
     * Builds a new destination and adds it to the travel package.
     *
     * @param name The name of the destination.
     * @return The DestinationBuilder instance for method chaining.
     */
    public DestinationBuilder buildDestination(String name) {
        Destination destination = new Destination(name);
        travelPackage.addDestination(destination);
        return new DestinationBuilder(destination);
    }
}
