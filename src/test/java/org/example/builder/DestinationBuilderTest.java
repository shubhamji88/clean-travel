package org.example.builder;

import org.example.model.Activity;
import org.example.model.Destination;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class DestinationBuilderTest {

    @Test
    public void addActivityLeaf_ShouldAddActivityToDestination() {
        
        Destination destination = new Destination("Test Destination");
        DestinationBuilder destinationBuilder = new DestinationBuilder(destination);

        
        destinationBuilder.addBeachRelaxationActivity();

        
        assertEquals(1, destination.getActivities().size());
        Activity addedActivity = destination.getActivities().get(0);
        assertNotNull(addedActivity);
        assertEquals("Beach Relaxation", addedActivity.getName());
        assertEquals(20.0, addedActivity.getCost(), 0.01);
        assertEquals(30, addedActivity.getCapacity());
        assertEquals("Enjoy the sandy beaches", addedActivity.getDescription());
    }

    

}
