package com.epam.drivers;
import com.epam.constants.Browers;
import com.epam.factorymethods.DriverManager;
import com.epam.factorymethods.MyChromeDriver;
import com.epam.factorymethods.MyEdgeDriver;
import com.epam.factorymethods.MyFireFoxDriver;
import com.epam.pages.BasePageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class DriverSingleton extends BasePageObject {


    private DriverSingleton()
    {

    }

    public static synchronized void setDriver(Browers browers)
    {
        switch (browers) {
            case CHROME -> {
                DriverManager driverManager = new MyChromeDriver();
                driver = driverManager.create();
            }
            case EDGE -> {
                DriverManager driverManager = new MyEdgeDriver();
                driver = driverManager.create();
            }
            case FIREFOX -> {
                DriverManager driverManager = new MyFireFoxDriver();
                driver = driverManager.create();
            }

        }
    }

    public static synchronized WebDriver getDriver()
    {
        setDriver(Browers.EDGE);
        return driver;
    }

}
