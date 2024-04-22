package com.epam.factorymethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class MyFireFoxDriver implements DriverManager{
    @Override
    public WebDriver create() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions=new FirefoxOptions();
        firefoxOptions.addArguments("--remote-allow-origins=*");
        return new FirefoxDriver(firefoxOptions);
    }
}
