package org.usmanacademy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;


public class LaunchChromeDriver {
    @Test
    public void testWithoutChromeDriver() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--headless");
        WebDriver driver = new ChromeDriver(co);
        driver.get("https://emicalculator.net/");
        Thread.sleep(5000);
        //svg xpath
        String varXpath= "//*[local-name()='svg']//*[name()='g' and @class='highcharts-series-group']//*[name()='rect']";

        //Need to get into paused into debugger mode. Open your developer tools, go to the
        //source tab and press fn+f8 it will pause the entire DOM.
        String textPath= "//*[local-name()='svg']//*[name()='g' and @class='highcharts-label highcharts-tooltip highcharts-color-undefined']//*[name()='text']";

        List<WebElement> verticalBars = driver.findElements(By.xpath(varXpath));
        System.out.println(verticalBars.size());

        Actions act = new Actions(driver);
        for(WebElement e: verticalBars){
            act.moveToElement(e).perform();
            Thread.sleep(100);
            String text = driver.findElement(By.xpath(textPath)).getText();
            System.out.println(text);

        }
        Thread.sleep(1500);
        String pieElement = "//*[local-name()='svg']//*[name()='g' and contains(@class, 'highcharts-series highcharts-series-0 highcharts-pie-series  highcharts-tracker')]//*[name()='path']";
         //contains(@class, 'no-gutter-left no-gutter-')
        //*[local-name()='svg']//*[name()='g' and contains(@class, 'highcharts-series highcharts-series-0 highcharts-pie-series  highcharts-tracker')]//*[name()='path']
        List<WebElement> pieChart = driver.findElements(By.xpath(pieElement));
        System.out.println(pieChart.size());
        for(WebElement e: pieChart){
            act.moveToElement(e).perform();
            Thread.sleep(500);
            String xpth = "//*[local-name()='svg']//*[name()='g' and contains(@class,'highcharts-label highcharts-tooltip')]//*[name()='text']";
            String getText = driver.findElement(By.xpath(xpth)).getText();
            System.out.println(getText);
        }
        driver.close();
    }
}
