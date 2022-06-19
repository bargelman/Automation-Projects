package pageObjects.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainMensJeansPage {
    @FindBy(tagName = "h1")
    public WebElement header_title;

    @FindBy(className = "_2qG85dG")
    public List<WebElement> amount_ProductsList;

    @FindBy(xpath = "//p[@class='XmcWz6U']")
    public WebElement txt_ProductsAmount;

    @FindBy(xpath = "//article[@class='_2qG85dG'][7]")
    public WebElement btn_SelectJeans;

    @FindBy(xpath = "//article[@class='_2qG85dG'][8]/a[@class='_3TqU78D']/div[@class='_3WEsAhb']/div[@class='_3J74XsK']/div/h2")
    public WebElement txt_productSelected;
}
