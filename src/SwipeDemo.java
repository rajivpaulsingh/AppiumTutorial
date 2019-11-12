import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;


public class SwipeDemo extends Base {

    public static void main(String args[]) throws MalformedURLException {

        AndroidDriver<AndroidElement> driver = Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
        driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();

        driver.findElementByXPath("//*[@content-desc='9']").click();

        /*
        1. Long press on element
        2. Move to another elements
        3. Release
         */
        TouchAction t = new TouchAction(driver);
        WebElement from = driver.findElementByXPath("//*[@content-desc='15']");
        WebElement to = driver.findElementByXPath("//*[@content-desc='45']");

        t.longPress(longPressOptions().withElement(element(from)).withDuration(Duration.ofSeconds(2))).moveTo(element(to)).release().perform();

    }
}
