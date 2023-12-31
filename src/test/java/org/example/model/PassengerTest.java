package org.example.model;


import org.example.strategy.PricingStrategy;




import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PassengerTest {

    @Test
    public void signUpForActivity_WithSufficientBalance_ShouldReturnTrue() {
        
        PricingStrategy pricingStrategy = mock(PricingStrategy.class);
        when(pricingStrategy.calculatePrice(Mockito.any())).thenReturn(30.0);

        Passenger passenger = new Passenger("Test Passenger", 1, pricingStrategy, 100.0);
        Activity activity = new Activity("Test Activity", 50.0, 20, "Test Description");

        
        boolean result = passenger.signUpForActivity(activity);

        
        assertTrue(result);
        assertEquals(1, passenger.getEnrolledActivities().size());
    }

    @Test
    public void signUpForActivity_WithInsufficientBalance_ShouldReturnFalse() {
        
        PricingStrategy pricingStrategy = mock(PricingStrategy.class);
        when(pricingStrategy.calculatePrice(Mockito.any())).thenReturn(120.0);

        Passenger passenger = new Passenger("Test Passenger", 1, pricingStrategy, 50.0);
        Activity activity = new Activity("Test Activity", 100.0, 20, "Test Description");

        
        boolean result = passenger.signUpForActivity(activity);

        
        assertFalse(result);
        assertEquals(0, passenger.getEnrolledActivities().size());
    }

    
}
