package org.rahulshettyacademy;

import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.MainPageObjects.TravelHomePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DemoTest  extends BaseTest {

    WebDriver driver;
    TravelHomePage travelHomePage;

    @BeforeTest
    public void setUp() {

        driver = initializeDriver();
        travelHomePage = new TravelHomePage(driver);
    }


    @Test(dataProvider = "getData")
    public void flightTest(HashMap<String, String> reservationDetails) {


        travelHomePage.goTo();
        System.out.println(travelHomePage.getFooterNavigationBar().getFlightAttribute());
        System.out.println(travelHomePage.getHeaderNavigationBar().getFlightAttribute());
        System.out.println(travelHomePage.getFooterNavigationBar().getFooterLinkCount());
        System.out.println(travelHomePage.getHeaderNavigationBar().getHeaderLinkCount());
        travelHomePage.setBookingStrategy("multitrip");
        travelHomePage.checkAvailability(reservationDetails);
        travelHomePage.getTitle();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @DataProvider
    public Object[][] getData() throws IOException {


        List<HashMap<String, String>> list = getJsonData (System.getProperty("user.dir")+ "//src//test//java//org//rahulshettyacademy//DataLoads//reservationdetails.json");

            return new Object[][]{
                    {list.get(0)}, {list.get(1)}
            };
        }


    }








// List<HashMap<String, String>> list = getjsonData (System.getProperty("user.dir")+ "//src//test//java//org//rahulshettyacademy//DataLoads//reservationdetails.json");



