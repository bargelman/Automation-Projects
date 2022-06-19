package pageObjects.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MensShirtFilterPage {
    @FindBy(xpath = "//div[@class='_1Ux1ru3 _1Ito59o']//li[7]/div[@class='_1O2ljAn']")
    public WebElement btn_Colour;

    @FindBy(xpath = "//div[@class='_1Ux1ru3 _1Ito59o']//li[11]/div[@class='_1O2ljAn']")
    public WebElement btn_Size;

    @FindBy(xpath = "//div[@class='_1Ux1ru3 _1Ito59o']//li[6]/div[@class='_1O2ljAn']")
    public WebElement btn_Brand;

    @FindBy(xpath = "//div[@class='_1Ux1ru3 _1Ito59o']")
    public WebElement btn_Delay;
}
