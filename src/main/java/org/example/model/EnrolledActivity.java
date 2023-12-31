package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents an enrolled activity for a passenger.
 * This store information about the activity and the price paid by the passenger.
 */
@Getter
@Setter
@AllArgsConstructor
public class EnrolledActivity {
    private Activity activity;
    private double pricePaid;

    @Override
    public String toString() {
        return "EnrolledActivity{" +
                "activity=" + activity +
                ", pricePaid=" + pricePaid +
                '}';
    }
}
