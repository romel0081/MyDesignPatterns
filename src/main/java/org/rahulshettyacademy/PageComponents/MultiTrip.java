package org.rahulshettyacademy.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.AbstractComponants.AbstractComponent;
import org.rahulshettyacademy.AbstractComponants.SearchFlightAvailability;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponent implements SearchFlightAvailability {

    private By MultiCityRadioBtn = By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By ModelAlert = By.id("MultiCityModelAlert");
    private By FirstFrom = By.id("ctl00_mainContent_ddl_originStation1_CTXTaction");
    private By FirstTo = By.id("ctl00_mainContent_ddl_destinationStation1_CTXTaction");
    private By SecondFrom = By.id("ctl00_mainContent_ddl_originStation2_CTXTaction");
    private By SecondTo = By.id("ctl00_mainContent_ddl_destinationStation2_CTXTaction");
    private By SearchBtn = By.id("ctl00_mainContent_btn_FindFlights");

    public MultiTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }


    @Override
    public void checkAvailability(HashMap<String,String> reservationDetails) {

        makeStatementReady(s->selectOriginCity(reservationDetails.get("origin")));
        selectDestinationCity(reservationDetails.get("destination"));
        selectDestinationCity_2(reservationDetails.get("destination2"));


    }

    public void selectOriginCity(String origin){

        findElement(FirstFrom).click();
        findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }

    public void selectDestinationCity(String destination){

        findElement(FirstTo).click();
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }


    public void selectDestinationCity_2(String destination2){

        findElement(SecondFrom).click();
        findElement(By.xpath("(//a[@value='"+destination2+"'])[3]")).click();
    }

    public void makeStatementReady(Consumer<MultiTrip> consumer){

        System.out.println("I am Multi Trip");
        findElement(MultiCityRadioBtn).click();
        findElement(ModelAlert).click();
        waitElementToDisapper(ModelAlert);
        consumer.accept(this);

        System.out.println("I am Done");
    }


//    @Override
//    public void checkAvailability(HashMap<String,String> reservationDetails) {
//
//    }
}
