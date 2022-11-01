package utils.drivers;

import utils.infrastructure.SuiteConfiguration;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public abstract class DefaultDriverManager {

    abstract WebDriver createDriver();

    protected static UiAutomator2Options getAndroidCaps() {
        return new UiAutomator2Options()
                .setPlatformName(SuiteConfiguration.PLATFORM_NAME)
                .setPlatformVersion(SuiteConfiguration.PLATFORM_VERSION)
                .setDeviceName(SuiteConfiguration.DEVICE_NAME)
                .setAutomationName(SuiteConfiguration.AUTOMATION_NAME)
                .setAppPackage(SuiteConfiguration.PACKAGE_NAME)
                .setAppActivity(SuiteConfiguration.ACTIVITY_NAME)
                .setNewCommandTimeout(Duration.ofSeconds(30))
                .setAdbExecTimeout(Duration.ofSeconds(30));
    }
}
