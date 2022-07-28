package pagecomponents;

import abstractcomponents.AbstractComponents;
import annotations.Page;
import base.DriverFactory;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import reportgenerator.ExtentFactory;

import java.util.ArrayList;

@Page
public class CartPage extends AbstractComponents {

    //Constructor
    public CartPage(WebDriver driverThreadLocal, By header) {
        super(DriverFactory.getInstance().getDriverThreadLocal(), header);
    }

    //Locators
    By cartItem1=By.xpath("//td[normalize-space()='Fluffy Bunny']");

    By cartItem2=By.xpath("//td[normalize-space()='Funny Cow']");

    By cartItemQty=By.xpath("//input[@value='1']");

    By cartItem2Qty=By.xpath("//input[@value='2']");

    public void checkCart() throws InterruptedException {

        //Using ArrayList to store all the expected cart Items
        ArrayList<String> expectedCartItems = new ArrayList<String>();
        expectedCartItems.add("Fluffy Bunny");
        expectedCartItems.add("Funny Cow");

        //Using ArrayList to store all the actual cart Items
        ArrayList<String> actualCartItems = new ArrayList<String>();
        WebElement cart1=DriverFactory.getInstance().getDriverThreadLocal().findElement(cartItem1);
        Thread.sleep(3000);
        WebElement cart2=DriverFactory.getInstance().getDriverThreadLocal().findElement(cartItem2);
        Thread.sleep(3000);

        if(cart1.isDisplayed()){
            actualCartItems.add(cart1.getText());
        } if(cart2.isDisplayed()){
            actualCartItems.add(cart2.getText());
        }

            try{
                Assert.assertEquals(expectedCartItems,actualCartItems);
                ExtentFactory.getInstance().getExtent()
                        .log(Status.PASS,"Expected Cart Items and Actual Cart Items validated");
            }catch(Exception e){
                ExtentFactory.getInstance().getExtent()
                        .log(Status.FAIL,"Validation failed");
            }


    }
}
