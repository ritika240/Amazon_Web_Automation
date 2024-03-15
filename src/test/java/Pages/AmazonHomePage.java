package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {
    private WebDriver driver;

    @FindBy(xpath = "//a[@id='nav-link-accountList']")
    private WebElement signInLink;

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openAmazon() {
        driver.get("https://www.amazon.in/?ref_=icp_country_from_us");
    }

    public void clickSignIn() {
        signInLink.click();
    }

}
