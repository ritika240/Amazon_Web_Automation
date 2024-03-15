package Pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    private WebDriver driver;

    @FindBy(id = "ap_email")
    private WebElement emailInput;
    
    @FindBy(id="continue")
    private WebElement btn_continue;

    @FindBy(id = "ap_password")
    private WebElement passwordInput;

    @FindBy(id = "signInSubmit")
    private WebElement signInButton;
    
    @FindBy(id="")
    private WebElement allOption;
    
    
    @FindBy(id="")
    private WebElement signOutOption;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String email, String password) {
        emailInput.sendKeys(email);
        btn_continue.click();
        passwordInput.sendKeys(password);
        signInButton.click();
    }
    
    
    public void verifySucessfulSignIn() {
    	
    }
    
    
    
}
