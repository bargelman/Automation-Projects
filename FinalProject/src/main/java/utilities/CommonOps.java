package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;

public class CommonOps extends Base {

    @BeforeClass
    public void startSession() {
        softAssert = new SoftAssert();
        screen = new Screen();

        if (getData("PlatformName").equalsIgnoreCase("web"))
            initBrowser(getData("BrowserName"));
//        else if (getData("PlatformName").equalsIgnoreCase("mobile"))
//            initMobile();
        else if (getData("PlatformName").equalsIgnoreCase("api"))
            initAPI();
        else
            throw new RuntimeException("Invalid platform name");
    }

    @AfterClass
    public void closeSession() throws InterruptedException {
        if (!getData("PlatformName").equalsIgnoreCase("api")){
            Thread.sleep(3000);
            driver.quit();
        }
    }

    @BeforeMethod
    public void recordingTest(Method method) { // (Method method) => gives us the name of current Test
        if (!getData("PlatformName").equalsIgnoreCase("api")) {
            try {
                MonteScreenRecorder.startRecord(method.getName()); // Creating avi (video) file with the name of current Test
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void initBrowser(String browserType) {
        if (browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver = initFirefoxDriver();
        else if (browserType.equalsIgnoreCase("ie"))
            driver = initIEDriver();
        else if (browserType.equalsIgnoreCase("safari"))
            driver = initSafari();
        else
            throw new RuntimeException("Invalid Browser type");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(getData("Timeout"))));
        wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(getData("Timeout"))));
        action = new Actions(driver);
        driver.get(getData("url"));
        ManagePages.initWebPage();
    }

    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver initIEDriver() {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    public static WebDriver initSafari() {
        WebDriverManager.safaridriver().setup();
        WebDriver driver = new SafariDriver();
        return driver;
    }

    public static void initAPI() {
        RestAssured.baseURI = getData("urlAPI");
        httpRequest = RestAssured.given().auth().preemptive().basic(getData("UserName"), getData("Password"));
    }

    public static String realAmountPage(WebElement element) {
        String[] arrAmount = element.getText().split(" ");
        return arrAmount[2];
    }

    public static String bagItemCount(WebElement element) {
        String[] arrCount = element.getText().split(" ");
        return arrCount[0];
    }

    public static String getData(String tagXml) { // Config Files (xml)
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./Configuration/DataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        } catch (Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        assert doc != null;
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(tagXml).item(0).getTextContent();
    }
}
