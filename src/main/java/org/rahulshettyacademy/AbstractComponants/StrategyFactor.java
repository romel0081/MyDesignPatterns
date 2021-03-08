package org.rahulshettyacademy.AbstractComponants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.PageComponents.MultiTrip;
import org.rahulshettyacademy.PageComponents.RoundTrip;

public class StrategyFactor {

    WebDriver driver;

    private By sectionElement = By.id("flightSearchContainer");

    public StrategyFactor(WebDriver driver) {
        this.driver = driver;
    }

    public SearchFlightAvailability createStrategy(String strategyType) {

        if (strategyType.equalsIgnoreCase("multitrip")) {

            return new MultiTrip(driver, sectionElement);
        }
        if (strategyType.equalsIgnoreCase("roundtrip")) {

            return new RoundTrip(driver, sectionElement);
        }
        return null;
    }
}
