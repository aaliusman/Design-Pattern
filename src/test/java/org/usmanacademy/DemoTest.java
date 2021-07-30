package org.usmanacademy;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.usmanacademy.PageObjects.TravelHomePage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class DemoTest extends BaseTest {
    WebDriver driver;
    TravelHomePage travelHomePage;

    @BeforeTest
    public void setUp() {
        driver = initializeDriver();
        travelHomePage = new TravelHomePage(driver);
        travelHomePage.goTo();
    }

    @Test
    public void flightTest() {
        System.out.println(travelHomePage.getFooterNav().getFlightAttribute());
        System.out.println(travelHomePage.getNavigationBar().getFlightAttribute());
        System.out.println(travelHomePage.getFooterNav().getLinksCount());
        System.out.println(travelHomePage.getNavigationBar().getLinksCount());
        System.out.println(travelHomePage.getNavigationBar().getPageTitle(driver));
        System.out.println(travelHomePage.getNavigationBar().getCurrentUrl(driver));
    }

    @Test(dataProvider = "getData")
    public void roundTrip(HashMap<String, String> selectCities) throws InterruptedException {
        travelHomePage.setBookingStrategy("roundTrip");
        travelHomePage.checkAvailable(selectCities);
    }

    @Test(dataProvider = "getData")
    public void multiCityTrip(HashMap<String, String> selectCities) throws InterruptedException {
        travelHomePage.setBookingStrategy("multiTrip");
        travelHomePage.checkAvailable(selectCities);
    }

    @DataProvider
    public Object[][] getData() throws IOException {

//        HashMap<String, String> selectCities = new HashMap<>();
//        selectCities.put("origin", "MAA");
//        selectCities.put("destination", "HYD");
//        selectCities.put("desti2", "GOI");
//        HashMap<String, String> selectCities2 = new HashMap<>();
//        selectCities2.put("origin", "AIP");
//        selectCities2.put("destination", "DEL");
//        selectCities2.put("desti2", "MAA");
//        List<HashMap<String, String>> list = new ArrayList<>();
//        list.add(selectCities);
//        list.add(selectCities2);

        // instead of all above code, we can simply use BaseTest class and call getJsonData method.

        List<HashMap<String, String>> list = getJsonData(
                "src/main/java/org/usmanacademy/dataLoads/reservationDetails.json");
        return new Object[][]{
                {list.get(0)}, {list.get(1)}
        };
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
