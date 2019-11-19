import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

//This needs to be manually imported, it does not comes in by default
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

public class Ecommerce_TC_04 extends Base2 {

    public static void main (String args[]) throws MalformedURLException, InterruptedException {

        AndroidDriver<AndroidElement> driver = Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("rajiv");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//*[@text='Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();

        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
        driver.findElement(By.xpath("//*[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
        driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();

        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(3000);

        String amount1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
        double price1 = getAmount(amount1);

        String amount2 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
        double price2 = getAmount(amount2);

        double expectedTotalPrice = price1 + price2;
        System.out.println("Sum of the products is: " + expectedTotalPrice);

        String amount3 = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        double actualTotalPrice = getAmount(amount3);
        System.out.println("Total value of the products is: " + actualTotalPrice);

        Assert.assertEquals(expectedTotalPrice, actualTotalPrice);

        //Mobile gestures - long press
        WebElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));
        WebElement termsAndConditions = driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));

        TouchAction t = new TouchAction(driver);
        t.tap(tapOptions().withElement(element(checkbox))).perform();
        t.longPress(longPressOptions().withElement(element(termsAndConditions)).withDuration(Duration.ofSeconds(2))).release().perform();

        //Close the popup
        driver.findElement(By.id("android:id/button1")).click();

        //Goto webview
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();

    }

    public static double getAmount(String value) {

        value = value.substring(1);
        double amount2value = Double.parseDouble(value);
        return amount2value;

    }
}
