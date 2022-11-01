package screens;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import utils.ui.UIHelpers;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainScreen extends BaseScreen {
    private final By searchBottomMenuButton = AppiumBy.id(ANDROID_BUNDLE + "nav_graph_search");
    private final By searchField = AppiumBy.id(ANDROID_BUNDLE + "search_src_text");
    private final By itemTitle = AppiumBy.id(ANDROID_BUNDLE + "item_title");
    private final By itemToggle = AppiumBy.id(ANDROID_BUNDLE + "item_toggle");
    private final By shoppingLIstBadge = AppiumBy.id(ANDROID_BUNDLE + "actionbar_shoppinglist_badge");
    private final By shoppingCart = AppiumBy.id(ANDROID_BUNDLE + "ingredients_header_instacart_image");


    public void openRecipe(String recipe) {
        $(searchBottomMenuButton).shouldBe(Condition.visible).click();
        $(searchField).sendKeys(recipe);
        $(searchField).click();
        Point location = $(searchField).getLocation();
        UIHelpers.tapAtPoint(new Point(location.x, location.y + 200));
        $(itemTitle).should(Condition.partialText(recipe.substring(0, 4))).click();
    }

    public void addLastItemToShoppingList() {
        ElementsCollection itemToggles = $$(itemToggle);
        itemToggles.get(itemToggles.size() - 1).shouldBe(Condition.visible).click();
    }

    public boolean shoppingListBadgeAppeared() {
        return $(shoppingLIstBadge).isDisplayed();
    }

    public void openShoppingCard() {
        $(shoppingCart).shouldBe(Condition.visible).click();
    }

    public String getLastItemContentDescription() {
        return $$(itemToggle).last().getAttribute("content-desc");
    }
}
