package com.exness.core.shared.ui.selenium.util;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            driver.set(getLocalDriver(DriverManagerType.CHROME));
        }
        return driver.get();
    }

    public static void releaseDriver() {
        WebDriver driverToDestroy = driver.get();
        driverToDestroy.quit();
        driver.remove();
    }

    private static WebDriver getLocalDriver(DriverManagerType driverType) {
        WebDriverManager.getInstance(driverType).setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }

}
