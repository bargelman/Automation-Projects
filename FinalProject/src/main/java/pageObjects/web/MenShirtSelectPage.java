package pageObjects.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenShirtSelectPage {
    @FindBy(xpath = "//li[@class='_1l1OC_A']//li[15]//div[@class='_2WeosbA']")
    public WebElement btn_Red;

    @FindBy(xpath = "//li[@class='_1l1OC_A']//li[15]//div[@class='_2WeosbA']")
    public WebElement btn_White;

    @FindBy(xpath = "//li[@class='_1l1OC_A']//li[4]//div[@class='_2WeosbA']")
    public WebElement btn_M;

    @FindBy(xpath = "//li[@class='_1l1OC_A']//li[21]//div[@class='_2WeosbA']")
    public WebElement btn_Levis;
}
