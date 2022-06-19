package pageObjects.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenProductMenuPage {
    @FindBy(xpath = "//div[@class='_2yreb5T _36PJqEn']//div[@class='_2u0LGMW']//ul[@class='_1WUweTj']//li[@class='_1g1PWkA _2SQx27S']//ul[@class='_1PXCics']//li//a[@class='_1cjL45H _2Y7IAa_ CLdGn9X _1XjY6Zd'][normalize-space()='Jeans']")
    public WebElement btn_Jeans;


    @FindBy(xpath = "//div[@class='_2yreb5T _36PJqEn']//div[@class='_2u0LGMW']//ul[@class='_1WUweTj']//li[@class='_1g1PWkA _2SQx27S']//ul[@class='_1PXCics']//li//a[@class='_1cjL45H _2Y7IAa_ CLdGn9X _1XjY6Zd'][normalize-space()='Shirts']")
    public WebElement btn_Shirt;
}

