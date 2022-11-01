package utils.drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import javax.annotation.Nonnull;

public class DriverFactory implements WebDriverProvider {
    public static WebDriver driver;

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        driver = new AndroidDriverManager().createDriver();
        return driver;
    }
}

