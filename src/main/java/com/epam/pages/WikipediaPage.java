package com.epam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;

import static com.epam.constants.WikipediaConstants.WIKIPEDIAURL;

public class WikipediaPage extends BasePageObject{



    @FindBy(id = "searchInput")
    private WebElement searchBox;
    @FindBy(css = ".cdx-search-input__end-button")
    private WebElement searchButton;
    @FindBy(xpath = "//tr[th[contains(text(), 'Capital')]]/td/a")
    private WebElement capitalElement;

    @FindBy(id = "vector-main-menu-dropdown-checkbox")
    private WebElement tabElement;

    public WikipediaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToMainPage() {
        driver.get(WIKIPEDIAURL);
    }

    public void searchForCountry(String country) {
        explicitWait(searchBox);
        searchBox.sendKeys(country);
        tabElement.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        searchButton.click();
    }

    public String getCapitalText() {

        return capitalElement.getText();
    }

}
