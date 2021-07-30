package org.usmanacademy.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.usmanacademy.AbsComponents.AbstractComponent;

public class NavigationBar extends AbstractComponent {

//    By flights = By.cssSelector("[title='Flights']");
    By flights = By.xpath("//a[@title='Flights']");
    By links = By.tagName("a");
    By hotels = By.xpath("//a[@title='Hotels']/span[2]");

    public NavigationBar(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    public String getFlightAttribute(){
        return findElement(flights).getAttribute("class");
    }

    public int getLinksCount() {
        return findElements(links).size();
    }

    public String getPageTitle(WebDriver driver){
        System.out.println("Hello Jfrog");
        return driver.getTitle();
    }

    public String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }
}
