package org.usmanacademy.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.usmanacademy.AbsComponents.AbstractComponent;
import org.usmanacademy.AbsComponents.SearchFlightAvail;

import java.util.HashMap;
import java.util.function.Consumer;

public class RoundTrip extends AbstractComponent implements SearchFlightAvail {
    private By roundRadio = By.id("ctl00_mainContent_rbtnl_Trip_1");
    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By selectDate = By.xpath("//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[1]/td[2]/a");
    private By search = By.id("ctl00_mainContent_btn_FindFlights");

    public RoundTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvail(HashMap<String, String> selectCity) throws InterruptedException {

        makeStateReady(ms-> selectOriginCity(selectCity.get("origin")));
        destinationCity(selectCity.get("destination"));
        waitUntilVisible(selectDate);
        findElement(selectDate).click();
        Thread.sleep(1000);
        waitUntilVisible(search);
        findElement(search).click();
    }

    public void selectOriginCity(String origin){
        waitUntilVisible(from);
        findElement(from).click();
        findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }

    public void destinationCity(String destination) throws InterruptedException {
        waitUntilVisible(to);
        findElement(to).click();
        Thread.sleep(1000);
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }

    private void makeStateReady(Consumer<RoundTrip> consumer){
        System.out.println("I'm inside round trip");
        findElement(roundRadio).click();
        consumer.accept(this);
    }
}
