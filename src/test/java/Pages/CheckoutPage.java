package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@name='proceedToRetailCheckout']")
    private WebElement proceedToCheckoutButton;
    
    @FindBy(xpath="//a[contains(text(),'Edit address')]")
    private WebElement EditAddress;
    
    
    @FindBy(xpath="//input[@id='address-ui-widgets-enterAddressPostalCode']")
    private WebElement Pin;
    
    
    @FindBy(xpath="//body/div[8]/div[1]/div[1]/div[1]/form[1]/div[1]/span[3]/span[1]/span[1]/input[1]")
    private WebElement Btn_useThisAddress;
 

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void proceedToCheckout() {
        proceedToCheckoutButton.click();
    }
    
    public void changePin() {
    	EditAddress.click();
    	Pin.clear();
    	Pin.sendKeys("411008");
    	Btn_useThisAddress.click();

    	
    	
    }

}

