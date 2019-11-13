import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Miscellaneous extends Base {

    public static void main(String args[]) throws MalformedURLException {

        AndroidDriver<AndroidElement> driver = Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println(driver.currentActivity());
        System.out.println(driver.getContext());

        //Views - Native, Hybrid, Webview
        System.out.println(driver.getOrientation());
        System.out.println(driver.isDeviceLocked());
//        driver.hideKeyboard();

        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }
}