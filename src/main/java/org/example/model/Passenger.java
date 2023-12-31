package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.example.strategy.PricingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a passenger within a travel package.
 */
@Getter
@Setter
public class Passenger {
    private String name;
    private int passengerNumber;
    private PricingStrategy pricingStrategy;
    private double balance;
    private List<EnrolledActivity> enrolledActivities = new ArrayList<>();

    /**
     * Constructs a passenger with the specified details.
     *
     * @param name            The name of the passenger.
     * @param passengerNumber The passenger number.
     * @param passengerType   The pricing strategy for the passenger.
     * @param balance         The balance or funds available for activities.
     */
    public Passenger(String name, int passengerNumber, PricingStrategy passengerType, double balance) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.pricingStrategy = passengerType;
        this.balance = balance;
    }

    /**
     * Signs up the passenger for a specific activity, deducting the appropriate cost from the balance.
     * This also calls activity to register the current passenger
     *
     * @param activity The activity to sign up for.
     * @return True if the signup is successful, false otherwise.
     */
    public boolean signUpForActivity(Activity activity) {
        double pricePaid = pricingStrategy.calculatePrice(activity);
        if ((balance - pricePaid) >= 0 && activity.addPassenger(this)) {
            balance -= pricePaid;
            enrolledActivities.add(new EnrolledActivity(activity, pricePaid));
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", number=" + passengerNumber +
                ", pricingStrategy=" + pricingStrategy.getClass().getSimpleName() +
                ", balance=" + balance +
                ", enrolledActivities=" + enrolledActivities +
                '}';
    }
}
