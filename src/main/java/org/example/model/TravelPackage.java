package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a travel package, which includes destinations, passengers, and related operations.
 */
@Getter
@Setter
public class TravelPackage {
    private String name;
    private int passengerCapacity;
    private List<Destination> destinations;
    private List<Passenger> passengers;

    /**
     * Constructs a travel package with the specified details.
     *
     * @param name              The name of the travel package.
     * @param passengerCapacity The passenger capacity of the travel package.
     */
    public TravelPackage(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.destinations = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    /**
     * Adds a passenger to the travel package if there is available capacity.
     *
     * @param passenger The passenger to add.
     * @return True if passenger added successfully
     */
    public boolean addPassenger(Passenger passenger) {
        if (passengers.size() < passengerCapacity) {
            return passengers.add(passenger);
        }
        return false;
    }

    /**
     * Adds list of passenger to the travel package if there is available capacity.
     *
     * @param passengers The passenger list to add.
     * @return True if passenger added successfully
     */
    public boolean addPassengers(List<Passenger> passengers) {
        if ((this.passengers.size() + passengers.size()) <= passengerCapacity) {
            return this.passengers.addAll(passengers);
        }
        return false;
    }

    /**
     * Adds a destination to the travel package.
     *
     * @param destination The destination to add.
     */
    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    public void printItinerary() {
        System.out.println("Travel Package Itinerary:");
        System.out.println("Package Name: " + name);
        System.out.println("Passenger Capacity: " + passengerCapacity);

        for (ItineraryComponent itineraryComponent : destinations) {
            itineraryComponent.print();
        }
    }

    public void printPassengerList() {
        System.out.println("Passenger List:");
        System.out.println("Package Name: " + name);
        System.out.println("Passenger Capacity: " + passengerCapacity);
        System.out.println("Number of Passengers: " + passengers.size());

        for (Passenger passenger : passengers) {
            System.out.println("   Name: " + passenger.getName() + ", Number: " + passenger.getPassengerNumber());
        }
    }

    public void printAvailableActivities() {
        System.out.println("Available Activities:");
        for (Destination destination : destinations) {
            for (ItineraryComponent activity : destination.getActivities()) {
                if (activity instanceof Activity a) {
                    if (a.hasSpaceAvailable()) {
                        System.out.println("  Activity: " + a.getName());
                        System.out.println("  Destination: " + a.getDestination().getName());
                        System.out.println("  Spaces Available: " + a.getAvailableSpaces());
                        System.out.println("---------------------");
                    }
                }
            }
        }
    }


}
