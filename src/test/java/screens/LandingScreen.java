package screens;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import javafx.scene.control.skin.TextInputControlSkin;
import org.openqa.selenium.By;
import utils.ui.UIHelpers;

import static com.codeborne.selenide.Selenide.$;

public class LandingScreen extends BaseScreen {
    private final By skipView = AppiumBy.id(ANDROID_BUNDLE + "skip_view");
    private final By closeButton = AppiumBy.id(ANDROID_BUNDLE + "closeButton");
    private final By wizardImageView = AppiumBy.id(ANDROID_BUNDLE + "imageView");
    public void skipToTry() {
        $(skipView).click();
        UIHelpers.swipeElementAndroid($(wizardImageView), TextInputControlSkin.Direction.LEFT);
        UIHelpers.swipeElementAndroid($(wizardImageView), TextInputControlSkin.Direction.LEFT);
        $(wizardImageView).shouldBe(Condition.visible);
        $(closeButton).click();
    }
}
