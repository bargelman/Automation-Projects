package pageObjects.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GenderNavbarPage {
    @FindBy(id = "men-floor")
    public WebElement men_Choice;

    @FindBy(id = "women-floor")
    public WebElement women_Choice;

    @FindBy(xpath = "//span[@class='_1z5n7CN']")
    public WebElement btn_MiniBag;

    @FindBy(xpath = "//span[@type='heartUnfilled']")
    public WebElement btn_MiniHeart;
}
