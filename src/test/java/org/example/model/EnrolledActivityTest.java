package org.example.model;

import org.example.model.Activity;
import org.example.model.EnrolledActivity;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class EnrolledActivityTest {

    @Test
    public void toString_ShouldReturnFormattedString() {
        
        Activity activity = new Activity("Test Activity", 50.0, 20, "Test Description");
        EnrolledActivity enrolledActivity = new EnrolledActivity(activity, 40.0);

        
        String result = enrolledActivity.toString();

        
        assertNotNull(result);
        assertTrue(result.contains("activity=" + activity.toString()));
        assertTrue(result.contains("pricePaid=40.0"));
    }

    

}
