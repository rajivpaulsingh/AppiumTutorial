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
        amount1 = amount1.substring(1); //removing the $ from $120.00
        double price1 = Double.parseDouble(amount1);

        String amount2 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
        amount2 = amount2.substring(1); //removing the $ from $120.00
        double price2 = Double.parseDouble(amount2);

        double expectedTotalPrice = price1 + price2;
        System.out.println("Sum of the products is: " + expectedTotalPrice);

        String amount3 = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        amount3 = amount3.substring(1);
        double actualTotalPrice = Double.parseDouble(amount3);
        System.out.println("Total value of the products is: " + actualTotalPrice);

        Assert.assertEquals(expectedTotalPrice, actualTotalPrice);


//        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));
//
//
//        int product = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
//        for(int i = 0; i < product; i++) {
//
//            String text = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
//            if(text.equalsIgnoreCase("Jordan 6 Rings")) {
//
//                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
//                break;
//            }
//
//        }
//        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
//
//        String lastPageText = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
//        Assert.assertEquals("Jordan 6 Rings", lastPageText);

    }
}
