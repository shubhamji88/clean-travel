package org.example.model;



import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class ActivityTest {

    private Activity activity;

    @Before
    public void setUp() {
        activity = new Activity("Test Activity", 50.0, 20, "Test Description");
    }

    @Test
    public void addPassenger_WhenSpaceAvailable_ShouldAddPassenger() {
        
        Passenger passenger = new Passenger("John Doe", 1, null, 100.0);

        
        boolean added = activity.addPassenger(passenger);

        
        assertTrue(added);
        assertEquals(1, activity.getEnrolledPassengers().size());
        assertTrue(activity.getEnrolledPassengers().contains(passenger));
    }

    @Test
    public void addPassenger_WhenNoSpaceAvailable_ShouldNotAddPassenger() {
        
        for (int i = 0; i < 20; i++) {
            activity.addPassenger(new Passenger("Passenger" + i, i + 1, null, 100.0));
        }

        
        boolean added = activity.addPassenger(new Passenger("Extra Passenger", 21, null, 100.0));

        
        assertFalse(added);
        assertEquals(20, activity.getEnrolledPassengers().size());
    }

    @Test
    public void setDestination_WhenNoExistingDestination_ShouldSetDestination() {
        
        Destination destination = new Destination("Test Destination");

        
        boolean setResult = activity.setDestination(destination);

        
        assertTrue(setResult);
        assertEquals(destination, activity.getDestination());
    }

    @Test
    public void setDestination_WhenExistingDestination_ShouldNotSetDestination() {
        
        Destination destination1 = new Destination("Destination 1");
        Destination destination2 = new Destination("Destination 2");
        activity.setDestination(destination1);

        
        boolean setResult = activity.setDestination(destination2);

        
        assertFalse(setResult);
        assertEquals(destination1, activity.getDestination());
    }

    @Test
    public void addPassenger_WithinCapacity_ShouldReturnTrue() {
        
        Passenger passenger = new Passenger("Test Passenger", 1, null, 0.0);
        Activity activity = new Activity("Test Activity", 50, 2, "Test Description");

        
        boolean result = activity.addPassenger(passenger);

        
        assertTrue(result);
        assertEquals(1, activity.getEnrolledPassengers().size());
    }

    @Test
    public void addPassenger_ExceedsCapacity_ShouldReturnFalse() {
        
        Passenger passenger1 = new Passenger("Test Passenger 1", 1, null, 0.0);
        Passenger passenger2 = new Passenger("Test Passenger 2", 2, null, 0.0);
        Activity activity = new Activity("Test Activity", 1, 1, "Test Description");

        
        boolean result1 = activity.addPassenger(passenger1);
        boolean result2 = activity.addPassenger(passenger2);

        
        assertTrue(result1);
        assertFalse(result2);
        assertEquals(1, activity.getEnrolledPassengers().size());
    }

}
