package org.usmanacademy.AbsComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.usmanacademy.PageComponents.MultiTrip;
import org.usmanacademy.PageComponents.RoundTrip;

public class StrategyFactor {

    WebDriver driver;
    By tripSectionElement = By.id("flightSearchContainer");

    public StrategyFactor(WebDriver driver){
        this.driver = driver;
    }

    public SearchFlightAvail strategyType(String tripType){
        if(tripType.equalsIgnoreCase("roundTrip")){
            return new RoundTrip(driver, tripSectionElement);
        }
        if(tripType.equalsIgnoreCase("multiTrip")){
            return new MultiTrip(driver, tripSectionElement);
        }
        else {
            return null;
        }
    }
}
