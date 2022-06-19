package pageObjects.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ViewBagPage {
    @FindBy(xpath = "//ul[@class='bag-items']/li")
    public List<WebElement> list_ItemsOfBag;

    @FindBy(xpath = "//p[@class='bag-item-name']/a")
    public WebElement txt_FirstItemOnBag;

    @FindBy(xpath = "//div[@class='bag-total-holder bag-title-holder bag-title-holder--total']//p[@class='bag-total-button-holder']")
    public WebElement btn_Checkout;

}
