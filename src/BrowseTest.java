import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class BrowseTest extends BaseChrome {

    public static void main (String args[]) throws MalformedURLException {

        AndroidDriver<AndroidElement> driver = Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://google.com");
        driver.findElementByName("q").sendKeys("selenium");
        driver.findElementByXPath("//*[@id=\'tsf\']/div[2]/div[1]/div[1]/button[2]/div/span/svg").click();

    }
}
