package org.example.builder;

import org.example.builder.DestinationBuilder;
import org.example.builder.TravelPackageBuilder;
import org.example.model.Destination;
import org.example.model.TravelPackage;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class TravelPackageBuilderTest {

    @Test
    public void buildDestination_ShouldAddDestinationToTravelPackage() {
        
        String packageName = "Test Package";
        TravelPackage travelPackage = new TravelPackage(packageName, 50);
        TravelPackageBuilder travelPackageBuilder = new TravelPackageBuilder(packageName, travelPackage);

        
        DestinationBuilder destinationBuilder = travelPackageBuilder.buildDestination("Test Destination");

        
        assertEquals(1, travelPackage.getDestinations().size());
        Destination addedDestination = travelPackage.getDestinations().get(0);
        assertNotNull(addedDestination);
        assertEquals("Test Destination", addedDestination.getName());
    }

    

}
