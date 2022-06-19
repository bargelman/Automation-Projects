package pageObjects.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenJeansSelectPage {

    //    @FindBy(className = "C_vX7H2 dV6RFzr") <<NEED TO FIX>>
//    public WebElement scroll_Table;

    @FindBy(xpath = "//li[@class='_1l1OC_A']//li[10]//div[@class='_2WeosbA']")
    public WebElement btn_SuperSkinny;

    @FindBy(xpath = "//li[@class='_1l1OC_A']//li[11]//div[@class='_2WeosbA']")
    public WebElement btn_30_32;

    @FindBy(xpath = "//li[@class='_1l1OC_A']//li[1]//div[@class='_2WeosbA']")
    public WebElement btn_Black;

    @FindBy(xpath = "//li[@class='_1l1OC_A']//li[3]//div[@class='_2WeosbA']")
    public WebElement btn_Grey;

}
