package org.usmanacademy.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.usmanacademy.AbsComponents.SearchFlightAvail;
import org.usmanacademy.AbsComponents.StrategyFactor;
import org.usmanacademy.PageComponents.FooterNavigation;
import org.usmanacademy.PageComponents.NavigationBar;

import java.util.HashMap;

public class TravelHomePage {

    WebDriver driver;
    By footerSectionElement = By.id("traveller-home");
    By navSectionElement = By.id("buttons");
    SearchFlightAvail searchFlightAvail;

    public TravelHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo(){
        driver.get("https://rahulshettyacademy.com/dropdownsPractise");
    }
    public FooterNavigation getFooterNav(){
        return new FooterNavigation(driver, footerSectionElement);
    }

    public NavigationBar getNavigationBar(){
        return new NavigationBar(driver, navSectionElement);
    }

    public void setBookingStrategy(String tripType) {
        StrategyFactor stFactor = new StrategyFactor(driver);
        this.searchFlightAvail = stFactor.strategyType(tripType);
    }

    public void checkAvailable(HashMap<String, String> selectCity) throws InterruptedException {
        searchFlightAvail.checkAvail(selectCity);
    }
}


