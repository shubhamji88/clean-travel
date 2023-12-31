package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an activity within a travel package.
 * Activities have a name, description, cost, capacity, associated destination, and enrolled passengers.
 */
@Getter
@Setter
public class Activity implements ItineraryComponent {
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private Destination destination;
    private List<Passenger> enrolledPassengers;

    /**
     * Constructs an activity with the specified details.
     *
     * @param name        The name of the activity.
     * @param cost        The cost of the activity.
     * @param capacity    The capacity of the activity.
     * @param description The description of the activity.
     */
    public Activity(String name, double cost, int capacity, String description) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.enrolledPassengers = new ArrayList<>();
    }

    /**
     * Sets the destination for current activity
     *
     * @param destination Destination object that belongs where this activity is available
     * @return True if there is no other destination already present
     */
    public Boolean setDestination(Destination destination) {
        if (this.destination == null) {
            this.destination = destination;
            return true;
        }
        return false;
    }

    /**
     * Adds passenger to current activity if capacity is not full
     *
     * @param passenger passenger that needs to be added
     * @return True if passenger is added successfully
     */
    public boolean addPassenger(Passenger passenger) {
        if (enrolledPassengers.size() < capacity) {
            enrolledPassengers.add(passenger);
            return true;
        }
        return false;
    }


    @Override
    public void print() {
        System.out.println("Activity: " + name);
        System.out.println("Cost: $" + cost);
        System.out.println("Capacity: " + capacity + " participants");
        System.out.println("Description: " + description);
        System.out.println("---------------------");
    }

    public boolean hasSpaceAvailable() {
        return enrolledPassengers.size() < capacity;
    }

    public int getAvailableSpaces() {
        return capacity - enrolledPassengers.size();
    }

    @Override
    public String toString() {
        return "Activity{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", destination=" + destination +
                '}';
    }
}

