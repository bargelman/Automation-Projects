package pageObjects.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SavedItemPage {

    @FindBy(xpath = "//button[@class='toBagButton_CrkG5 toBagButton_CwJ+u']")
    public WebElement btn_MoveToBag;
}
