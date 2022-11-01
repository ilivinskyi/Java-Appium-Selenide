package utils.drivers;

import utils.infrastructure.SuiteConfiguration;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;

public class AndroidDriverManager extends DefaultDriverManager {

    public WebDriver createDriver() {
        return new AndroidDriver(SuiteConfiguration.HUB_URL, getAndroidCaps());
    }

}