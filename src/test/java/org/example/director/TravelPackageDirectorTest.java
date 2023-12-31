package org.example.director;


import org.example.model.TravelPackage;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class TravelPackageDirectorTest {

    @Test
    public void constructTravelPackage_ShouldCreateValidTravelPackage() {

        String packageName = "Test Package";
        int passengerCapacity = 50;

        
        TravelPackage travelPackage = TravelPackageDirector.constructTravelPackage(packageName, passengerCapacity);

        
        assertNotNull(travelPackage);
        assertEquals(packageName, travelPackage.getName());
        assertEquals(passengerCapacity, travelPackage.getPassengerCapacity());
        assertEquals(3, travelPackage.getDestinations().size());
    }
}