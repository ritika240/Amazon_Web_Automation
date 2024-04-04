package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
    private WebDriver driver;
    
    @FindBy (xpath="//a[@id='createAccountSubmit']")
    private WebElement btn_newCustomer;

    @FindBy(id = "ap_customer_name")
    private WebElement customerName;

    @FindBy(id = "ap_email")
    private WebElement email;

    @FindBy(id = "ap_password")
    private WebElement password;

    @FindBy(id = "ap_password_check")
    private WebElement confirmPassword;

    @FindBy(id = "continue")
    private WebElement verifymobile;
    
    
    @FindBy( xpath="//input[@id='ap_phone_number']")
    private WebElement txt_mobile;
    
    
    @FindBy(xpath="//a[@id='nav-hamburger-menu']")
    private WebElement navigation;
    
    @FindBy(xpath="//a[@class='hmenu-item'][normalize-space()='Sign Out']")
    private WebElement signout;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void signUpWithNewUser(String name, String userEmail,String mobile, String userPassword) {
        btn_newCustomer.click();
    	customerName.sendKeys(name);
        email.sendKeys(userEmail);
        txt_mobile.sendKeys(mobile);
        password.sendKeys(userPassword);
        verifymobile.click();
    }
    public void signout() {
    	navigation.click();
    	signout.click();
    }
    
    

}
