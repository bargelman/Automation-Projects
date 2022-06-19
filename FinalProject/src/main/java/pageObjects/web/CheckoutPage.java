package pageObjects.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage {
    @FindBy(xpath = "//a[@class='_1TlOB9h _2tvh469 _3olGy8t']")
    public WebElement btn_Checkout;

    @FindBy(xpath = "//a[@class='_1TlOB9h _2tvh469 _12h15d-']")
    public WebElement btn_ViewBag;

    @FindBy(xpath = "//div[@class='_1tPq-2-']/span[2]")
    public WebElement txt_BagItemCount;

    @FindBy(xpath = "//div[@class='_1gkALRF']/ul/li[1]//div[1]//div[2]//button[1]")
    public WebElement btn_DeleteItem; //Delete first item (li[1])

    @FindBy(xpath = "//h2[@class='title']")
    public WebElement txt_PageTitle;
}
