package base;

import org.openqa.selenium.WebDriver;


public class DriverFactory {


    //Private constructor so that the class cannot be instantiated from outside this class
    private DriverFactory() {

    }

    //static reference variable of the class to make it available globally;
    private static volatile DriverFactory driverFactoryInstance = null;

    //Declare a static method with return type as object of class which should check if class is already instantiated
    //once

    public static DriverFactory getInstance() {
        if (driverFactoryInstance == null) {
            synchronized (DriverFactory.class) {
                if (driverFactoryInstance == null) {
                    driverFactoryInstance = new DriverFactory();
                }
            }
        }
        return driverFactoryInstance;
    }

    //Factory design Pattern --> Define separate factory for creating objects and create objects by calling that methods;
    //ThreadLocal Webdriver for parallel execution;

    ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    //To get this threadLocal WebDriver for pageObjects

    public WebDriver getDriverThreadLocal() {
        return driverThreadLocal.get();
    }

    //To set threadLocal WebDriver
    public void setDriverThreadLocal(WebDriver setDriverThreadLocal) {
        driverThreadLocal.set(setDriverThreadLocal);
    }

    //To Quit and Remove threadLocal WebDriver for making it null for next thread

    public void closeBrowser() {
        driverThreadLocal.get().quit();
        driverThreadLocal.remove();
    }

}


