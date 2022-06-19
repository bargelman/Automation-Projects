package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;

public class UIActions extends CommonOps {

    @Step("Click on Element")
    public static void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    @Step("Update text Element")
    public static void updateText(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }
    @Step("Update text Element as Human")
    public static void updateSlowText(WebElement element, String text) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(element));
        for (char ch : text.toCharArray()) {
            Thread.sleep(500);
            element.sendKeys(ch + ""); // parsing char to String
        }
    }

    @Step("Update DropDown Element")
    public static void dropDownSelection(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Select dropDown = new Select(element);
        dropDown.selectByVisibleText(text);
    }
    @Step("Mouse Hover Element")
    public static void mouseHover(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        action.moveToElement(element).perform();
    }
    @Step("Scroll the Element")
    public static void elementScroll(WebElement element) {
        js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('css').scrollTop = 500");

        //js.executeScript("document.getElementById('id').scrollDown += 100");
    }
    @Step("Scroll the page")
    public static void pageScroll() {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,0)");
    }

}
