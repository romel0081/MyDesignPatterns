package org.rahulshettyacademy.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.AbstractComponants.AbstractComponent;

public class HeaderNavigationBar extends AbstractComponent {

    private WebDriver driver;
    private By flights = By.cssSelector("[title='Flights']");
    private By headerLinks = By.cssSelector("a");

    public HeaderNavigationBar(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    public String getFlightAttribute(){
       return findElement(flights).getAttribute("class");
    }

    public int getHeaderLinkCount(){
       return findElements(headerLinks).size();
    }
}
