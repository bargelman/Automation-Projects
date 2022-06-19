package sanity;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class AsosWeb extends CommonOps {

    @Test(priority = 0, description = "TEST01 - Verify Web Upload")
    @Description("This Test login and verifies the main page header")
    public void verifyWebUpload() {
//        WebFlows.logIn("bar.gelman@yahoo.com", "bB224466$$");
        Verifications.verifyTextInElement(webMain.txt_HeadFooterAbout, "ABOUT ASOS");
    }

    @Test(priority = 1, description = "TEST02 - verify Country")
    @Description("This Test verifies the country of buyer (using Sikuli)")
    public void verifyBuyerCountry() {
        Verifications.visualElement("IsraelIcon");
    }

    @Test(priority = 2, description = "TEST03 - Verify Visibility Of Elements")
    @Description("This Test verifies visibility Of Elements (using soft assertion)")
    public void verifyVisibilityOfElements() throws InterruptedException {
        Verifications.visibilityOfElements();
    }

    @Test(priority = 3, description = "TEST04 - Verify Page Name")
    @Description("This Test verifies current page header")
    public void verifyPageName() {
        WebFlows.goToMenJeansPage();
        Verifications.verifyTextInElement(mensJeansPage.header_title, "Men's Jeans");
    }

    @Test(priority = 4, description = "TEST05 - Verify Page Product Amount")
    @Description("This Test verifies amount of products in page")
    public void verifyPageProductAmount() {
        Verifications.verifyAmountOfProducts(mensJeansPage.amount_ProductsList, realAmountPage(mensJeansPage.txt_ProductsAmount));
    }

    @Test(priority = 5, description = "TEST06 - Verify Page Product Amount Filter")
    @Description("This Test verifies amount of products in page after filtering")
    public void verifyPageProductAmountFilter() throws InterruptedException {
        WebFlows.filterJeans();
        Verifications.verifyAmountOfProducts(mensJeansPage.amount_ProductsList, realAmountPage(mensJeansPage.txt_ProductsAmount));
    }

    @Test(priority = 6, description = "TEST07 - Verify Product Is In Bag")
    @Description("This Test verifies if the product is in bag")
    public void verifyProductIsInBag() throws InterruptedException {
        WebFlows.chooseProducts();
        UIActions.mouseHover(webGender.btn_MiniBag);
        Thread.sleep(1000);
        Verifications.verifyTextInElement(webGender.btn_MiniBag, bagItemCount(checkoutPage.txt_BagItemCount));
    }

    @Test(priority = 7, description = "TEST08 - Verify Deleted Item")
    @Description("This Test verifies if the product deleted from bag")
    public void verifyDeletedItem() {
        WebFlows.deleteItem();
        Verifications.verifyTextInElement(webGender.btn_MiniBag, bagItemCount(checkoutPage.txt_BagItemCount));
    }

    @Test(priority = 8, description = "TEST09 - Verify Selected Right Product", dataProvider = "data-provider-items", dataProviderClass = utilities.ManageDDT.class)
    @Description("This Test verifies if the right product selected (Using DDT)")
    public void verifySelectedRightItem(String itemDescription, String shouldExists) {
        String myBagUrl = driver.getCurrentUrl();
        if (!myBagUrl.equals("https://www.asos.com/bag?ctaref=mini%20bag")) {
            WebFlows.viewItemsOnBag();
        }
        WebFlows.searchAndVerifyItem(itemDescription, shouldExists);
    }

    @Test(priority = 9, description = "TEST10 - Verify Checkout")
    @Description("This Test verifies if the checkout performed")
    public void verifyCheckout() {
        WebFlows.performCheckout2();
        Verifications.verifyTextInElement(checkoutPage.txt_PageTitle, "CHECKOUT");
    }
}