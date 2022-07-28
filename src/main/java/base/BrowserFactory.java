package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {

    //Create WebDriver Object for a given Browser;
    public WebDriver createBrowserInstance(String browser){
        WebDriver driver=null;

        if(browser.equalsIgnoreCase("chrome")){

            WebDriverManager.chromedriver().setup();
            System.setProperty("WebDriver.chrome.silenceOutput", "true");
            ChromeOptions chromeOptions=setChromeOptions();
            driver=new ChromeDriver(chromeOptions);

        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxOptions=setFirefoxOptions();
            driver=new FirefoxDriver(firefoxOptions);

        }else if(browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
        }

        return driver;
    }

    private ChromeOptions setChromeOptions(){
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("start-maximized");
        chromeOptions.getLogLevel();

        return chromeOptions;
    }

    private FirefoxOptions setFirefoxOptions(){
        FirefoxOptions firefoxOptions=new FirefoxOptions();
        return firefoxOptions;
    }
}
