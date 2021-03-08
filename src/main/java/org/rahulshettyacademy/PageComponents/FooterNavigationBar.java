package org.rahulshettyacademy.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.AbstractComponants.AbstractComponent;

public class FooterNavigationBar extends AbstractComponent {
    private WebDriver driver;

    private By flights = By.cssSelector("[title='Flights']");
    private By footerLinks = By.cssSelector("a");

    public FooterNavigationBar(WebDriver driver, By sectionElement) {
        super(driver,sectionElement);

        // when you inherit parent class you should invoke parent class constructor
        // in your own child constructor.

    }

    // Method to handle flights
    // When Selenium executes any method in this class scope of selenium
    // should be in the footer only


    public String getFlightAttribute(){

      return findElement(flights).getAttribute("class");

       //driver.findElement(flights).click();
   }

   public int getFooterLinkCount(){
     return  findElements(footerLinks).size();
   }
}



