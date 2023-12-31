# Travel Package Management System

## Overview

The Travel Package Management System is a Java-based application designed to manage travel packages, allowing users to book and manage travel itineraries.
## Project Structure

The project is organized into several packages, each serving a specific purpose:

1. builder: Contains builder classes responsible for constructing complex objects like TravelPackage and Destination.

2. director: Holds the TravelPackageDirector class, which facilitates the construction of complete travel packages.

3. model: Includes classes representing the core entities of the system, such as Activity, Destination, EnrolledActivity, Passenger, and TravelPackage.

4. strategy: Houses different pricing strategy implementations used for calculating activity prices based on the type of passenger.

5. config: Contains all the constants and demo activites, passenger to run the program

## Design Patterns Used

### 1. Builder Pattern

The Builder Pattern is employed in the construction of complex objects (`TravelPackage` and `Destination`). 

### 2. Strategy Pattern

The Strategy Pattern is utilized for pricing strategies, allowing the system to calculate prices dynamically based on the passenger type. Different pricing strategies (`StandardPricingStrategy`, `PremiumPricingStrategy`, and `GoldPricingStrategy`) implement the common PricingStrategy interface.

### 3. Composite Pattern

The Composite Pattern is implicitly applied through the `ItineraryComponent` interface. Both `Activity` and `Destination` implement this interface, enabling a unified approach to printing the itinerary. 
Here, `Destination` is the composite and `Activity` is leaf

### 4. Singleton Pattern

The **Singleton Pattern** is employed in the pricing strategy implementations (`StandardPricingStrategy`, `PremiumPricingStrategy`, and `GoldPricingStrategy`). It ensures that a class has only one instance and provides a global point of access to it. The pattern is implemented using the double-checked locking mechanism to achieve thread safety and lazy initialization.

### High-Level Design (HLD)

![hld](https://github.com/shubhamji88/clean-travel/assets/56815364/071dec9c-53e1-4a0d-80e2-391bc6467edc)


### Low-Level Design (LLD)

![lld drawio (2)](https://github.com/shubhamji88/clean-travel/assets/56815364/e580e95d-2950-4c2a-8bd3-62b100d5b695)

