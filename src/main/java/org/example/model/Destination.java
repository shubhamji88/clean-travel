package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a destination within a travel package.
 * Destinations have a name and a list of associated activities.
 */
@Getter
@Setter
public class Destination implements ItineraryComponent {
    private String name;
    private List<Activity> activities;

    /**
     * Constructs a destination with the specified name.
     *
     * @param name The name of the destination.
     */
    public Destination(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
    }

    /**
     * Adds an activity to the destination if it has not been associated with another destination.
     *
     * @param activity The activity to add.
     * @return True if the activity is added, false otherwise.
     */
    public boolean addActivity(Activity activity) {
        if (activity.setDestination(this)) {
            return activities.add(activity);
        }
        return false;
    }


    @Override
    public void print() {
        System.out.println("Destination: " + name);
        for (ItineraryComponent activity : activities) {
            activity.print();
        }
    }

    @Override
    public String toString() {
        return "Destination{" +
                "name='" + name + '\'' +
                '}';
    }
}
