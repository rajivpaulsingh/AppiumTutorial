import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class UIAutomatorTest extends Base {

    public static void main(String args[]) throws MalformedURLException {

        AndroidDriver<AndroidElement> driver = Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        driver.findElementByAndroidUIAutomator("attribute("value")");
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click(); //very important and unique for appium
        driver.findElementByAndroidUIAutomator("text(\"Animation\")").click();

        //Validate clickable features of all options
//        driver.findElementByAndroidUIAutomator("new UiSelector().property(value)");
        int clickableElements = driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size();
        System.out.println("The number of clickable elements are: " + clickableElements);
    }
}
