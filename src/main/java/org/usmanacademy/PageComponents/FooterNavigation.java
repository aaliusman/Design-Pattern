package org.usmanacademy.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.usmanacademy.AbsComponents.AbstractComponent;

public class FooterNavigation extends AbstractComponent {
    //method to handle flights
    //when selenium execute any method in this class, it should focus only footer.

    By flights = By.cssSelector("[title='Flights']");;
    By links = By.tagName("a");

    public FooterNavigation(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
        //When you inherit parent class - you should invoke parent class constructor
        //in your own child class.
    }

    public String getFlightAttribute() {
       return findElement(flights).getAttribute("class");
    }

    public int getLinksCount() {
        return findElements(links).size();
    }
}
