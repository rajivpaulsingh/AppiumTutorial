import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

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
        Thread.sleep(5000);

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

    }

    public static double getAmount(String value) {

        value = value.substring(1);
        double amount2value = Double.parseDouble(value);
        return amount2value;

    }
}
