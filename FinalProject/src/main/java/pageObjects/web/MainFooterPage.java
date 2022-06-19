package pageObjects.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainFooterPage {
    @FindBy(xpath = "//h2[normalize-space()='About ASOS']")
    public WebElement txt_HeadFooterAbout;
}
