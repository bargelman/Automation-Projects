package pageObjects.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainMensShirtPage {
    @FindBy(xpath = "(//div[@class='_3pQmLlY']//section[@class='_3YREj-P'])//article[2]")
    public WebElement btn_SelectShirt;
}
