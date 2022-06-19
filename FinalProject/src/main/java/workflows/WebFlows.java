package workflows;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class WebFlows extends CommonOps {
    @Step("Business Flow: Login")
    public static void logIn(String email, String password) {
        UIActions.updateText(webLogin.txt_emailAddress, email);
        UIActions.updateText(webLogin.txt_password, password);
        UIActions.click(webLogin.btn_signIn);
    }

    @Step("Business Flow: Go To Mens Jeans Page")
    public static void goToMenJeansPage() {
        UIActions.click(webGender.men_Choice);
        UIActions.mouseHover(webNavbar.btn_Clothing);
        UIActions.mouseHover(webMenProducts.btn_Jeans);
        UIActions.click(webMenProducts.btn_Jeans);
    }

    @Step("Business Flow: Go To Mens Shirt Page")
    public static void goToMenShirtPage() {
        UIActions.mouseHover(webNavbar.btn_Clothing);
        UIActions.mouseHover(webMenProducts.btn_Shirt);
        UIActions.click(webMenProducts.btn_Shirt);
    }

    @Step("Business Flow: Filter Jeans")
    public static void filterJeans() throws InterruptedException {
        UIActions.click(mensJeansFilterPage.btn_ProductFit);
//        UIActions.elementScroll(mensJeansPage.scroll_Table); <<NEED TO FIX>>
        UIActions.click(menJeansSelectPage.btn_SuperSkinny);
        Thread.sleep(1000); // <<NEED TO FIX>>
        UIActions.click(mensJeansFilterPage.btn_Size);
        UIActions.click(menJeansSelectPage.btn_30_32);
        Thread.sleep(1000); // <<NEED TO FIX>>
        UIActions.click(mensJeansFilterPage.btn_Colour);
        UIActions.click(menJeansSelectPage.btn_Black);
        UIActions.click(menJeansSelectPage.btn_Grey);
        Thread.sleep(1000); // <<NEED TO FIX>>
    }

    @Step("Business Flow: Filter Shirt")
    public static void filterShirt() throws InterruptedException {
        UIActions.click(mensShirtFilterPage.btn_Colour);
        UIActions.click(menShirtSelectPage.btn_White);
        Thread.sleep(1000); // <<NEED TO FIX>>
        UIActions.click(mensShirtFilterPage.btn_Size);
        UIActions.click(menShirtSelectPage.btn_M);
        Thread.sleep(1000); // <<NEED TO FIX>>
        UIActions.click(mensShirtFilterPage.btn_Brand);
        UIActions.click(menShirtSelectPage.btn_Levis);
        Thread.sleep(1000); // <<NEED TO FIX>>
        UIActions.click(mensShirtFilterPage.btn_Delay);

    }

    @Step("Business Flow: Add To Bag")
    public static void addToBagProduct(String size) throws InterruptedException {
        UIActions.dropDownSelection(addToBagPage.btn_Select, size);
        Thread.sleep(1000);
        UIActions.click(addToBagPage.btn_heart);
        UIActions.click(webGender.btn_MiniHeart);
        UIActions.click(savedItemPage.btn_MoveToBag);
        Thread.sleep(3000);
    }
    @Step("Business Flow: Choose Products To Buy")
    public static void chooseProducts() throws InterruptedException {
        UIActions.click(mensJeansPage.btn_SelectJeans);
        WebFlows.addToBagProduct("W30 L32");
        UIActions.pageScroll();
        Thread.sleep(3000);
        WebFlows.goToMenShirtPage();
        WebFlows.filterShirt();
        UIActions.click(mensShirtPage.btn_SelectShirt);
        WebFlows.addToBagProduct("M - 96 CM - 101 CM");
        UIActions.pageScroll();
    }

    @Step("Business Flow: Delete Item")
    public static void deleteItem() {
        UIActions.click(checkoutPage.btn_DeleteItem);
    }

    @Step("Business Flow: Checkout from Checkout page")
    public static void performCheckout() {
        UIActions.mouseHover(webGender.btn_MiniBag);
        UIActions.click(checkoutPage.btn_Checkout);
    }

    @Step("Business Flow: Checkout from My Bag page")
    public static void performCheckout2() {
        UIActions.click(viewBagPage.btn_Checkout);
    }

    @Step("Business Flow: View Bag ")
    public static void viewItemsOnBag() {
        UIActions.mouseHover(webGender.btn_MiniBag);
        UIActions.click(checkoutPage.btn_ViewBag);
    }

    @Step("Business Flow: Search And Verify Item")
    public static void searchAndVerifyItem(String itemDescription, String shouldExists) {

        if (shouldExists.equalsIgnoreCase("exist"))
            Verifications.verifyTextInElement(viewBagPage.txt_FirstItemOnBag, itemDescription);
        else if (shouldExists.equalsIgnoreCase("not-exist"))
            Verifications.verifyTextInElementNotExist(viewBagPage.txt_FirstItemOnBag, itemDescription);
        else
            throw new RuntimeException("Invalid Expected Output in Data Driven Testing:: Should be exist or not-exist");

    }
}
