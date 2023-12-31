package org.example.model;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TravelPackageTest {

    @Test
    public void addPassenger_WithinCapacity_ShouldAddPassenger() {

        TravelPackage travelPackage = new TravelPackage("Test Package", 3);
        Passenger passenger = Mockito.mock(Passenger.class);

        
        travelPackage.addPassenger(passenger);

        
        assertEquals(1, travelPackage.getPassengers().size());
        assertTrue(travelPackage.getPassengers().contains(passenger));
    }

    @Test
    public void addPassenger_ExceedsCapacity_ShouldNotAddPassenger() {
        
        TravelPackage travelPackage = new TravelPackage("Test Package", 1);
        Passenger passenger1 = Mockito.mock(Passenger.class);
        Passenger passenger2 = Mockito.mock(Passenger.class);

        
        travelPackage.addPassenger(passenger1);
        travelPackage.addPassenger(passenger2);

        
        assertEquals(1, travelPackage.getPassengers().size());
        assertTrue(travelPackage.getPassengers().contains(passenger1));
    }

    @Test
    public void addPassengers_WithinCapacity_ShouldAddPassengers() {
        
        TravelPackage travelPackage = new TravelPackage("Test Package", 3);
        Passenger passenger1 = Mockito.mock(Passenger.class);
        Passenger passenger2 = Mockito.mock(Passenger.class);

        List<Passenger> passengers = Arrays.asList(passenger1, passenger2);

        
        boolean result = travelPackage.addPassengers(passengers);

        
        assertTrue(result);
        assertEquals(2, travelPackage.getPassengers().size());
        assertTrue(travelPackage.getPassengers().contains(passenger1));
        assertTrue(travelPackage.getPassengers().contains(passenger2));
    }

    @Test
    public void addPassengers_ExceedsCapacity_ShouldNotAddPassengers() {
        
        TravelPackage travelPackage = new TravelPackage("Test Package", 2);
        Passenger passenger1 = Mockito.mock(Passenger.class);
        Passenger passenger2 = Mockito.mock(Passenger.class);
        Passenger passenger3 = Mockito.mock(Passenger.class);

        List<Passenger> passengers = Arrays.asList(passenger1, passenger2, passenger3);

        
        boolean result = travelPackage.addPassengers(passengers);

        
        assertFalse(result);
        assertEquals(0, travelPackage.getPassengers().size());
    }

    
}