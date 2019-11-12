import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

//This needs to be manually imported, it does not comes in by default
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

public class Gestures extends Base {

    public static void main(String args[]) throws MalformedURLException {

        AndroidDriver<AndroidElement> driver = Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();

        //Tap
        TouchAction t = new TouchAction(driver);
        WebElement expandList = driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
        t.tap(tapOptions().withElement(element(expandList))).perform();

        WebElement customAdapter = driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']");
        t.tap(tapOptions().withElement(element(customAdapter))).perform();

        WebElement peopleNames = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
        t.longPress(longPressOptions().withElement(element(peopleNames)).withDuration(Duration.ofSeconds(2))).release().perform();

        System.out.println(driver.findElementById("android:id/title").isDisplayed());

    }
}
