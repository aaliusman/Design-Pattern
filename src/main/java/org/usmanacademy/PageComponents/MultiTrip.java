package org.usmanacademy.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.usmanacademy.AbsComponents.AbstractComponent;
import org.usmanacademy.AbsComponents.SearchFlightAvail;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponent implements SearchFlightAvail {
    private By modalPopup = By.id("MultiCityModelAlert");
    private By multiCityRadio = By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By selectDate = By.xpath("//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[1]/td[2]/a");
    private By search = By.id("ctl00_mainContent_btn_FindFlights");
    private By destination2 = By.id("ctl00_mainContent_ddl_originStation2_CTXT");


    public MultiTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvail(HashMap<String, String> selectCity) throws InterruptedException {

        makeStateReady(ms->selectOriginCity(selectCity.get("origin")));
        destinationCity(selectCity.get("destination"));
        destinationCity2(selectCity.get("desti2"));
        Thread.sleep(1000);
        findElement(search).click();
    }

    public void selectOriginCity(String origin){
        findElement(from).click();
        findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }

    public void destinationCity(String destination) throws InterruptedException {
        waitUntilVisible(to);
        findElement(to).click();
        Thread.sleep(1000);
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }

    public void destinationCity2(String destination) throws InterruptedException {
        waitUntilVisible(destination2);
        findElement(destination2).click();
        Thread.sleep(1000);
        findElement(By.xpath("(//a[@value='"+destination+"'])[3]")).click();
    }

    private void makeStateReady(Consumer<MultiTrip> consumer) {
        // write all prerequisite/common code and then execute your actual
        // function, you can also add tearDown method in the end.
        System.out.println("I am inside MultiTrip");
        findElement(multiCityRadio).click();
        findElement(modalPopup).click();
        consumer.accept(this);
    }
}
