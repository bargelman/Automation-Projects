package pageObjects.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(id = "EmailAddress")
    public WebElement txt_emailAddress;

    @FindBy(id = "Password")
    public WebElement txt_password;

    @FindBy(id = "signin")
    public WebElement btn_signIn;
}
