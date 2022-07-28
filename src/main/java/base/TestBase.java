package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.*;
import reportgenerator.ExtentManager;
import util.ReadConfigProperties;

import java.time.Duration;

public class TestBase {
    BrowserFactory browserFactory = new BrowserFactory();
    public static ExtentReports extentReports;
    public static ExtentTest logger;


    @BeforeMethod
    @Parameters({"browser"})
    public void launchBrowser(String browser) throws Exception {

        String url = ReadConfigProperties.getPropertyValueByKey("url");

        DriverFactory.getInstance().setDriverThreadLocal(browserFactory.createBrowserInstance(browser));
        DriverFactory.getInstance().getDriverThreadLocal().manage().window().maximize();
        DriverFactory.getInstance().getDriverThreadLocal().get(url);
        DriverFactory.getInstance().getDriverThreadLocal().manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        extentReports = ExtentManager.getExtentReport();

    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.getInstance().closeBrowser();
        extentReports.flush();
    }

}

