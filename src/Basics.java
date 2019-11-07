import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Basics extends Base {

    public static void main(String args[]) throws MalformedURLException {

        AndroidDriver<AndroidElement> driver = Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //xpath, id, className, androidUIAutomator
        /*
         *  //tagName[@attribute='value']
         */

        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
        driver.findElementById("android:id/checkbox").click();
        driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();

        //Enter details in the pop-up edit field
        driver.findElementByClassName("android.widget.EditText").sendKeys("rajiv");
        //driver.findElementById("android:id/button1").click();

        driver.findElementsByClassName("android.widget.Button").get(1).click(); // to handle duplicate instances


    }
}
