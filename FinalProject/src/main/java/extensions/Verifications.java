package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.testng.Assert;
import utilities.CommonOps;
import java.util.List;
import static org.testng.FileAssert.fail;

public class Verifications extends CommonOps {

    @Step("Verify Text In Element (WebElement, String)")
    public static void verifyTextInElement(WebElement element, String expected) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertEquals(element.getText(), expected);
    }
    @Step("Verify Text In Element Not Exist (WebElement, String)")
    public static void verifyTextInElementNotExist(WebElement element, String itemDescription) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertNotEquals(element.getText(), itemDescription);
    }

    @Step("Verify Text With Text")
    public static void verifyText(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }
    @Step("Verify Amount Of Products")
    public static void verifyAmountOfProducts(List<WebElement> products, String expected) {
        wait.until(ExpectedConditions.visibilityOf(products.get(products.size() - 1)));
        String productsAmount = Integer.toString(products.size());
        Assert.assertEquals(productsAmount, expected);
    }
    @Step("Visibility Of Elements")
    public static void visibilityOfElements() throws InterruptedException {
        for (int i = 1; i <= 12; i++) {
            WebElement navbarElements = driver.findElement(By.xpath("//div[@class='_8EFahPg']//div[2]//nav[1]//div[1]//div[1]//button[" + i + "]"));
            Thread.sleep(1000);
            softAssert.assertTrue(navbarElements.isEnabled());
        }
        softAssert.assertAll("Some Navbar elements are not displayed!! ");
    }
    @Step("Visual Element")
    public static void visualElement(String expectedImageName){
        Pattern countryFlagIcon = new Pattern(getData("ImageRepo") + expectedImageName + ".png").similar(0.50);
        try {
            screen.find(countryFlagIcon);
        } catch (FindFailed e) {
            System.out.println("Error Comparing Image File: " + e);
            fail("Error Comparing Image File: " + e);
        }
    }
}
