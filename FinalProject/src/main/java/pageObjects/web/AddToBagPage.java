package pageObjects.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToBagPage {
    @FindBy(tagName = "h1")
    public WebElement txt_HeaderProductSelected;

    @FindBy(id = "main-size-select-0")
    public WebElement btn_Select;

    @FindBy(id = "product-add-button")
    public WebElement btn_Add;

    @FindBy(xpath = "//button[@class='i5hAj _5AuCN']//span[@class='_1zDr2']")
    public WebElement btn_heart;


}
