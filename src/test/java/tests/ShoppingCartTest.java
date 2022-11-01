package tests;

import screens.LandingScreen;
import screens.MainScreen;
import screens.ShoppingCart;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShoppingCartTest extends BaseTest {
    LandingScreen landingScreen = new LandingScreen();
    MainScreen mainScreen = new MainScreen();
    ShoppingCart shoppingCart = new ShoppingCart();

    @Test
    public void testAddingItemToShoppingCart() {
        landingScreen.skipToTry();
        mainScreen.openRecipe("Tiramisu");
        String lastItemName = mainScreen.getLastItemContentDescription();
        mainScreen.addLastItemToShoppingList();
        assertTrue(mainScreen.shoppingListBadgeAppeared());

        mainScreen.openShoppingCard();
        shoppingCart.closeAlertIfPresent();
        String itemNameInCart = shoppingCart.getCartItemNames().get(0);
        assertTrue(lastItemName.contains(itemNameInCart));

        shoppingCart.expandMenu();
        shoppingCart.openRecipeDetailsFromCartItem();

        String lastItemDescriptionAfterCart = mainScreen.getLastItemContentDescription();
        assertTrue(lastItemDescriptionAfterCart.contains("Remove"));
    }
}