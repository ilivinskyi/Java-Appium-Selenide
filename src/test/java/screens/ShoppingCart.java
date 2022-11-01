package screens;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ShoppingCart extends BaseScreen {
    private final By alertCloseButton = AppiumBy.id(ANDROID_BUNDLE + "alert_close_button");
    private final By expandMenu = AppiumBy.id(ANDROID_BUNDLE + "expand_menu");
    private final By cartItemName = AppiumBy.id(ANDROID_BUNDLE + "expandable_text");
    private final By cartItemMenuRecipeButton = AppiumBy.xpath("//android.widget.TextView[@text=\"RECIPE\"]");


    public void closeAlertIfPresent() {
        try {
            $(alertCloseButton).click();
        } catch (NoSuchElementException e) {}
    }

    public void expandMenu() {
        $(expandMenu).click();
    }

    public List<String> getCartItemNames() {
        return $$(cartItemName).texts();
    }

    public void openRecipeDetailsFromCartItem() {
        $(cartItemMenuRecipeButton).click();
    }
}
