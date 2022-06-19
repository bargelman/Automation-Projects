package pageObjects.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavbarMenuPage {

    @FindBy( xpath = "//div[@class='_8EFahPg']//div[2]//nav[1]//div[1]//div[1]//button[1]")
    public WebElement btn_Sale;

    @FindBy( xpath = "//div[@class='_8EFahPg']//div[2]//nav[1]//div[1]//div[1]//button[2]")
    public WebElement btn_New_In;

    @FindBy( xpath = "//div[@class='_8EFahPg']//div[2]//nav[1]//div[1]//div[1]//button[3]")
    public WebElement btn_Clothing;

    @FindBy( xpath = "//div[@class='_8EFahPg']//div[2]//nav[1]//div[1]//div[1]//button[4]")
    public WebElement btn_Shoes;

    @FindBy( xpath = "//div[@class='_8EFahPg']//div[2]//nav[1]//div[1]//div[1]//button[5]")
    public WebElement btn_Sportswear;

    @FindBy( xpath = "//div[@class='_8EFahPg']//div[2]//nav[1]//div[1]//div[1]//button[6]")
    public WebElement btn_Accessories;

    @FindBy( xpath = "//div[@class='_8EFahPg']//div[2]//nav[1]//div[1]//div[1]//button[7]")
    public WebElement btn_Trending_Now;

    @FindBy( xpath = "//div[@class='_8EFahPg']//div[2]//nav[1]//div[1]//div[1]//button[8]")
    public WebElement btn_Topman;

    @FindBy( xpath = "//div[@class='_8EFahPg']//div[2]//nav[1]//div[1]//div[1]//button[9]")
    public WebElement btn_Face_Body;

    @FindBy( xpath = "//div[@class='_8EFahPg']//div[2]//nav[1]//div[1]//div[1]//button[10]")
    public WebElement btn_Brands;

    @FindBy( xpath = "//div[@class='_8EFahPg']//div[2]//nav[1]//div[1]//div[1]//button[11]")
    public WebElement btn_Outlet;

    @FindBy( xpath = "//div[@class='_8EFahPg']//div[2]//nav[1]//div[1]//div[1]//button[12]")
    public WebElement btn_Marketplace;
}
