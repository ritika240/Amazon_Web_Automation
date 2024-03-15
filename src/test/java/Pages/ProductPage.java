package Pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
    private WebDriver driver;
    
    

//    @FindBy(xpath="//input[@id='add-to-cart-button']")
    @FindBy(id="add-to-cart-button")
    private WebElement addToCart;
    
    @FindBy(xpath="//span[@id='a-autoid-0-announce']")
    private WebElement quantity;
    
    
    @FindBy(xpath="//a[@href='/cart?ref_=sw_gtc']")
    private WebElement goToCart;
    
    @FindBy(xpath="//body[1]/div[2]/div[1]/div[5]/div[3]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[3]/div[10]/div[2]/span[1]/a[1]/div[1]/div[1]/div[1]/span[1]/div[1]/span[2]")
    private WebElement pin;
    
    @FindBy(xpath="//input[@id='GLUXZipUpdateInput']")
    private WebElement PinChange;
    
    @FindBy(xpath="//body/div[8]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/div[1]/div[2]/span[1]/span[1]/input[1]")
    private WebElement btnApply;
    

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addProduct() throws InterruptedException {
    	
    	Thread.sleep(4000);
        addToCart.click();
    }
    
    public WebElement getSortDropDown() {
        return quantity;
    }

    public void selectQuatityFromDropDown(String optionText) {
        Select select = new Select(quantity);
        select.selectByVisibleText(optionText);
    }
    public void clickGoToCart() {
    	goToCart.click();
    }
    
    public void changePin() {
    	pin.click();
    	PinChange.clear();
    	PinChange.sendKeys("411039");
    	btnApply.click();
    	
    	
    }
    
    
    
    
    
}

