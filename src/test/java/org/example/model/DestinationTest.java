package org.example.model;


import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class DestinationTest {

    private Destination destination;

    @Before
    public void setUp() {
        destination = new Destination("Test Destination");
    }

    @Test
    public void addActivity_WhenExistingDestination_ShouldAddActivity() {
        
        Activity activity1 = new Activity("Activity 1", 30.0, 15, "Description 1");
        Activity activity2 = new Activity("Activity 2", 40.0, 25, "Description 2");
        destination.addActivity(activity1);

        
        destination.addActivity(activity2);

        
        assertEquals(2, destination.getActivities().size());
        assertTrue(destination.getActivities().contains(activity2));
        assertTrue(destination.getActivities().contains(activity1));
        assertEquals(destination, activity1.getDestination());
        assertEquals(destination, activity2.getDestination());
    }
    @Test
    public void addActivity_WhenSameActivityAddedToDifferentDestinations_ShouldFail() {
        
        Destination destination1 = new Destination("City A");
        Destination destination2 = new Destination("City B");

        Activity activity = new Activity("Sightseeing Tour", 50, 20, "Explore the city");

        
        boolean addedToDestination1 = destination1.addActivity(activity);
        boolean addedToDestination2 = destination2.addActivity(activity);

        
        assertTrue(addedToDestination1);
        assertFalse(addedToDestination2);
    }
    

}
