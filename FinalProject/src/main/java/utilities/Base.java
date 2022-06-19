package utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import io.restassured.specification.RequestSpecification;

public class Base {
    // General
    protected static Actions action;
    protected static WebDriverWait wait;
    protected static SoftAssert softAssert;
    protected static JavascriptExecutor js;
    protected static Screen screen;

    //Web
    protected static WebDriver driver;

    //Mobile

    //Rest API
    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static JSONObject parameters = new JSONObject();
    protected static JsonPath jp;

    // Page Objects
    protected static pageObjects.web.LoginPage webLogin;
    protected static pageObjects.web.MainFooterPage webMain;
    protected static pageObjects.web.GenderNavbarPage webGender;
    protected static pageObjects.web.NavbarMenuPage webNavbar;
    protected static pageObjects.web.MenProductMenuPage webMenProducts;
    protected static pageObjects.web.MainMensJeansPage mensJeansPage;
    protected static pageObjects.web.MainMensShirtPage mensShirtPage;
    protected static pageObjects.web.MensJeansFilterPage mensJeansFilterPage;
    protected static pageObjects.web.MensShirtFilterPage mensShirtFilterPage;
    protected static pageObjects.web.MenJeansSelectPage menJeansSelectPage;
    protected static pageObjects.web.MenShirtSelectPage menShirtSelectPage;
    protected static pageObjects.web.AddToBagPage addToBagPage;
    protected static pageObjects.web.CheckoutPage checkoutPage;
    protected static pageObjects.web.ViewBagPage viewBagPage;
    protected static pageObjects.web.SavedItemPage savedItemPage;
}
