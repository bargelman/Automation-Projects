package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.web.MenJeansSelectPage;


public class ManagePages extends Base { // Manage page objects
    public static void initWebPage(){
        webLogin = PageFactory.initElements(driver, pageObjects.web.LoginPage.class);
        webMain = PageFactory.initElements(driver, pageObjects.web.MainFooterPage.class);
        webGender = PageFactory.initElements(driver, pageObjects.web.GenderNavbarPage.class);
        webNavbar = PageFactory.initElements(driver, pageObjects.web.NavbarMenuPage.class);
        webMenProducts = PageFactory.initElements(driver, pageObjects.web.MenProductMenuPage.class);
        mensJeansPage = PageFactory.initElements(driver, pageObjects.web.MainMensJeansPage.class);
        mensShirtPage = PageFactory.initElements(driver, pageObjects.web.MainMensShirtPage.class);
        mensJeansFilterPage = PageFactory.initElements(driver, pageObjects.web.MensJeansFilterPage.class);
        mensShirtFilterPage = PageFactory.initElements(driver, pageObjects.web.MensShirtFilterPage.class);
        menJeansSelectPage = PageFactory.initElements(driver, pageObjects.web.MenJeansSelectPage.class);
        menShirtSelectPage = PageFactory.initElements(driver, pageObjects.web.MenShirtSelectPage.class);
        addToBagPage = PageFactory.initElements(driver, pageObjects.web.AddToBagPage.class);
        checkoutPage = PageFactory.initElements(driver, pageObjects.web.CheckoutPage.class);
        viewBagPage = PageFactory.initElements(driver, pageObjects.web.ViewBagPage.class);
        savedItemPage = PageFactory.initElements(driver, pageObjects.web.SavedItemPage.class);
    }
}
