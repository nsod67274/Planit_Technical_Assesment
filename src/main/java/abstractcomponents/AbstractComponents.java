package abstractcomponents;

import base.DriverFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reportgenerator.ExtentFactory;

import java.time.Duration;
import java.util.List;

abstract public class AbstractComponents {

    WebElement element;

    public AbstractComponents(WebDriver driver, By element){
        driver= DriverFactory.getInstance().getDriverThreadLocal();
        this.element=driver.findElement(element);
    }

    public WebElement findElement(By findElement){
        ExtentFactory.getInstance().getExtent()
                .log(Status.INFO,"This findElement is searching a specific " +
                        "section on the HomePage, for example the header section, side bar section and footer section ");
        return element.findElement(findElement);
    }

    public List<WebElement> findElements(By findElement) {
        return element.findElements(findElement);

    }

    public void refresh(){
        DriverFactory.getInstance().getDriverThreadLocal().navigate().refresh();
        ExtentFactory.getInstance().getExtent()
                .log(Status.INFO,"The current web page on display has been refreshed ");
    }

    public String getTitle(){
        String title =DriverFactory.getInstance().getDriverThreadLocal().getTitle();
        ExtentFactory.getInstance().getExtent()
                .log(Status.INFO,"The title of the page is: "+ title);
        return title;

    }
    public String getURL(){
        String URL=DriverFactory.getInstance().getDriverThreadLocal().getCurrentUrl();
        ExtentFactory.getInstance().getExtent()
                .log(Status.INFO,"The current URL is: "+ URL);
        return URL;
    }

    public void navigateBrowserBack() {
        DriverFactory.getInstance().getDriverThreadLocal().navigate().back();
        ExtentFactory.getInstance().getExtent()
                .log(Status.INFO,"Browser navigated back");
    }

    public void navigateBrowserForward() {
        DriverFactory.getInstance().getDriverThreadLocal().navigate().forward();
        ExtentFactory.getInstance().getExtent()
                .log(Status.INFO, "Browser navigated forward");
    }

    public void sendKeys(By element, String fieldName, String valueToBeSent){
        try{
            findElement(element).sendKeys(valueToBeSent);
            //Log success message in extent report
            ExtentFactory.getInstance().getExtent()
                    .log(Status.PASS, fieldName+"==> Entered Value as: "+valueToBeSent);
        }catch(Exception e){
            //Log Failure message in extent report
            ExtentFactory.getInstance().getExtent()
                    .log(Status.FAIL, fieldName+" ==> is Failed due to exception: "+e);
        }
    }

    //Overloading sendKeys with various wait strategies for finding webElements that arr otherwise difficult to capture

    public void sendKeys(By element, String fieldName, String valueToBeSent, long timeOut) {
        try {
            new WebDriverWait(DriverFactory.getInstance().getDriverThreadLocal(), Duration.ofSeconds(timeOut))
                    .ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(element)).sendKeys(valueToBeSent);
            ExtentFactory.getInstance().getExtent()
                    .log(Status.PASS, fieldName + "==> The value entered is: " + valueToBeSent);

        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent()
                    .log(Status.FAIL, fieldName + " ==> The value couldn't be entered, and the error is due to: " + e);

        }
    }

    public void sendKeys(By element, String fieldName, String valueToBeSent, long timeOut1, long timeOut2){
        try{
            new WebDriverWait(DriverFactory.getInstance().getDriverThreadLocal(), Duration.ofSeconds(timeOut1))
                    .ignoring(ElementNotInteractableException.class)
                    .pollingEvery(Duration.ofSeconds(timeOut2))
                    .until(ExpectedConditions.elementToBeClickable(element)).sendKeys(valueToBeSent);

            ExtentFactory.getInstance().getExtent()
                    .log(Status.PASS, fieldName + "==> Entered Value as: " + valueToBeSent);

        }catch(Exception e){
            ExtentFactory.getInstance().getExtent()
                    .log(Status.FAIL, fieldName + " ==> is Failed due to exception: " + e);
        }

    }

    public void click(By element, String fieldName) {
        try {
            findElement(element).click();
            //log success message in extent report
            ExtentFactory.getInstance().getExtent()
                    .log(Status.PASS, fieldName+"==> Clicked Successfully! ");
        } catch (Exception e) {
            //log failure in extent
            ExtentFactory.getInstance().getExtent()
                    .log(Status.FAIL, "Unable to click on field: " +fieldName +" due to exception: "+e);
        }
    }

    public void click(By element, String fieldName, long timeOut){
        try{
            new WebDriverWait(DriverFactory.getInstance().getDriverThreadLocal(), Duration.ofSeconds(timeOut))
                    .ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(element)).click();
            ExtentFactory.getInstance().getExtent()
                    .log(Status.PASS, fieldName + "==> The button/link clicked successfully");

        }catch(Exception e){
            ExtentFactory.getInstance().getExtent()
                    .log(Status.FAIL, fieldName + " ==> The button/click failed due to exception: " + e);
        }
    }

    public void click(By element, String fieldName, long timeOut1, long timeOut2) {
        try {
            new WebDriverWait(DriverFactory.getInstance().getDriverThreadLocal(), Duration.ofSeconds(timeOut1))
                    .ignoring(StaleElementReferenceException.class)
                    .pollingEvery(Duration.ofSeconds(timeOut2))
                    .until(ExpectedConditions.elementToBeClickable(element)).click();
            ExtentFactory.getInstance().getExtent()
                    .log(Status.PASS, fieldName + "==> clicked successfully");

        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent()
                    .log(Status.FAIL, fieldName + " ==> is Failed due to exception: " + e);
        }
    }

    public void isDisplayed(By element, String fieldName){
        try{
            findElement(element).isDisplayed();
            ExtentFactory.getInstance().getExtent().log(Status.PASS,"Message is displayed");
        }catch(Exception e){
            ExtentFactory.getInstance().getExtent().log(Status.FAIL,"Message not displayed");
        }
    }

}
