package tests;

import utils.drivers.DriverFactory;
import utils.infrastructure.AppiumServer;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import com.codeborne.selenide.Selenide;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    void setUp() {
        AppiumServer.startServer();
        Selenide.closeWebDriver();
        Configuration.browserSize = null;
        Configuration.browser = DriverFactory.class.getName();
        Selenide.open();
    }

    @AfterEach
    public void closeApp() {
        driver = WebDriverRunner.getWebDriver();
        AppiumDriver appiumDriver = (AndroidDriver) driver;
        appiumDriver.quit();
        driver.quit();
        AppiumServer.stopServer();
    }
}
