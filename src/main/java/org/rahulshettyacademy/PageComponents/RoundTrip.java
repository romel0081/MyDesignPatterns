package org.rahulshettyacademy.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.AbstractComponants.AbstractComponent;
import org.rahulshettyacademy.AbstractComponants.SearchFlightAvailability;

import java.util.HashMap;
import java.util.function.Consumer;

public class RoundTrip extends AbstractComponent implements SearchFlightAvailability {

    private By RoundTrip = By.id("ctl00_mainContent_rbtnl_Trip_1");
    private By From = By.id("ctl00_mainContent_ddl_originStation1_CTXTaction");
    private By To = By.id("ctl00_mainContent_ddl_destinationStation1_CTXTaction");
    private By CheckBoxForFamilyAndFriends = By.id("ctl00_mainContent_chk_friendsandfamily");
    private By SearchBtn = By.id("ctl00_mainContent_btn_FindFlights");

    public RoundTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvailability(HashMap<String,String> reservationDetails) {

        MakeStatementReady(s->selectOriginCity(reservationDetails.get("origin")));
        selectOriginCity(reservationDetails.get("origin"));
        selectDestinationCity(reservationDetails.get("destination"));

    }

    public void selectOriginCity(String origin){

        findElement(From).click();
        findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }

    public void selectDestinationCity(String destination){

        findElement(To).click();
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }

    public void MakeStatementReady(Consumer<RoundTrip> consumer){

        System.out.println("I am Round Trip");

        findElement(RoundTrip).click();

        findElement(CheckBoxForFamilyAndFriends).click();
        consumer.accept(this);
        findElement(SearchBtn).click();
        System.out.println("I am Done");

    }
}
