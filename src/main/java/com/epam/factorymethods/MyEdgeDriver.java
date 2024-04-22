package com.epam.factorymethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class MyEdgeDriver implements DriverManager{
    @Override
    public WebDriver create() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions edgeOptions=new EdgeOptions();
        edgeOptions.addArguments("--remote-allow-origins=*");
        return new EdgeDriver(edgeOptions);
    }
}
