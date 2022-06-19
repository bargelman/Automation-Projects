package pageObjects.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MensJeansFilterPage {

    @FindBy(xpath = "//div[@class='_1Ux1ru3 _1Ito59o']//li[8]/div[@class='_1O2ljAn']")
    public WebElement btn_ProductFit;

    @FindBy(xpath = "//div[@class='_1Ux1ru3 _1Ito59o']//li[10]/div[@class='_1O2ljAn']")
    public WebElement btn_Size;

    @FindBy(xpath = "//div[@class='_1Ux1ru3 _1Ito59o']//li[6]/div[@class='_1O2ljAn']")
    public WebElement btn_Colour;
}
