package com.epam.testcases;

import com.epam.drivers.DriverSingleton;
import com.epam.pages.BasePageObject;
import com.epam.pages.WikipediaPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestWikipedia extends BasePageObject {

    @DataProvider(name = "CountryAndCapital")
    public static Object[][] getCountryAndCapital() {
        return new Object[][]{
                {"India", "New Delhi"},
                {"England", "London"},
                {"France", "berlin"}
        };
    }

    @BeforeMethod
    public void setup() {
        driver = DriverSingleton.getDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(dataProvider = "CountryAndCapital")
    public void testCountryAndCapital(String country, String expectedCapital) {
        WikipediaPage wikipediaPage = new WikipediaPage(driver);
        wikipediaPage.navigateToMainPage();
        wikipediaPage.searchForCountry(country);
        String actualCapital = wikipediaPage.getCapitalText();
        Assert.assertEquals(actualCapital, expectedCapital, "Capital does not match for country: " + country);
    }
}
