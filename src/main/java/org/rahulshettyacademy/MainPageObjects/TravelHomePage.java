package org.rahulshettyacademy.MainPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.AbstractComponants.SearchFlightAvailability;
import org.rahulshettyacademy.AbstractComponants.StrategyFactor;
import org.rahulshettyacademy.PageComponents.FooterNavigationBar;
import org.rahulshettyacademy.PageComponents.HeaderNavigationBar;
import org.rahulshettyacademy.PageComponents.MultiTrip;

import java.util.HashMap;

public class TravelHomePage {

    private By sectionElement = By.id("traveller-home");
    private By headersSectionElement = By.id("buttons");
    private WebDriver driver;
    SearchFlightAvailability searchFlightAvailability;

    public TravelHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo(){
        driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
    }

    public HeaderNavigationBar getHeaderNavigationBar(){

        return new HeaderNavigationBar(driver, headersSectionElement);
    }

    public FooterNavigationBar getFooterNavigationBar(){

        return new  FooterNavigationBar(driver, sectionElement);

    }

    public void setBookingStrategy(String strategyType){

        StrategyFactor strategyFactor = new StrategyFactor(driver);

        searchFlightAvailability = strategyFactor.createStrategy(strategyType);

        this.searchFlightAvailability = searchFlightAvailability;

    }

    public void checkAvailability(HashMap<String,String> reservationDetails){

        searchFlightAvailability.checkAvailability(reservationDetails);
    }

    public String getTitle(){

        System.out.println("Hello World Good Morning");
        System.out.println("Some changes made to check Jenkins is working or not??");

        return driver.getTitle();
    }
}
