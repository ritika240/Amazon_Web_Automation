package StepDefinition;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.AmazonHomePage;
import Pages.CheckoutPage;
//import Pages.Hooks;
import Pages.ProductPage;
import Pages.ProductPage;
import Pages.SearchResultsPage;
import Pages.SignInPage;
import Pages.SignUpPage;
import Pages.takeScreenShot;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class Steps {
    private WebDriver driver;
    private AmazonHomePage amazonHomePage;
    private SignUpPage signUpPage;
    private SearchResultsPage searchResultsPage;
    private ProductPage productPage;
    private CheckoutPage checkoutPage;
    private SignInPage signInPage;
    private takeScreenShot ts;

    
    
    @Given("open the chrome driver")
    public void open_the_chrome_driver() {
    	
    		System.out.println("webbrowser is open");
    		
    		String projectPath= System.getProperty("user.dir");
    	      System.setProperty("webdriver.chrome.webdriver", projectPath+"/src/test/resources/drivers/chromedriver");
    	      driver=new ChromeDriver();
    	    
    	     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    	     driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
    	     
    	     driver.manage().window().maximize();

    		System.out.println("webbrowser is open");
    } 


    @Given("user opens the Amazon website")
    public void openAmazonWebsite() throws IOException {
        this.amazonHomePage = new AmazonHomePage(driver);
        this.ts=new takeScreenShot(driver);
        amazonHomePage.openAmazon();
        ts.takeScreenshot();

        
        String title=driver.getTitle();
        System.out.println(title);
        
        String expected_title="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
//     Assert.assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", title);
     
     if(title.equals(expected_title)) {
    	 System.out.println("Test passed");
    	 
     }else {
    	 System.out.println("Test failed");
    	 
     }
       
    }

//    @When("user signs up with a new account")
//    public void signUpWithNewUser() {
//        amazonHomePage.clickSignIn();
//        this.signUpPage = new SignUpPage(driver);
//
//        signUpPage.signUpWithNewUser("sonali garad", "ritigarad@gmail.com","9623070065", "ritika@0065");
//        signUpPage.signout();
//    }

    @And("user logs in and searches for HP laptop")
    public void loginAndSearch() {
        this.signInPage = new SignInPage(driver);
        this.searchResultsPage = new SearchResultsPage(driver);
        this.ts=new takeScreenShot(driver);



    	amazonHomePage.clickSignIn();
        ts.takeScreenshot();

        signInPage.login("ritikagarad2404@gmail.com", "ritika@0065");
        ts.takeScreenshot();

        searchResultsPage.searchForProduct("Hp laptop");
        ts.takeScreenshot();

        
        
    }

    @And("user clicks on 'sort by' option and selects one option")
    public void sortByOption() {
        this.searchResultsPage = new SearchResultsPage(driver);
        this.ts=new takeScreenShot(driver);
        searchResultsPage.selectOptionFromDropDown("Price: Low to High");
        ts.takeScreenshot();
        WebElement sort=driver.findElement(By.xpath("//span[contains(text(),'Price: Low to High')]"));
        String expected="Price: Low to High";
        String sortText=sort.getText();
        Assert.assertEquals(expected, sortText);

    }
   
   

    @And("user opens the 1st link in a new tab")
    public void openThirdLinkInNewTab() throws InterruptedException {

        this.searchResultsPage = new SearchResultsPage(driver);
        this.ts=new takeScreenShot(driver);

        searchResultsPage.selectThirdItem();
        ts.takeScreenshot();

        Thread.sleep(4000);
        
    }


    @And("user goes back to the parent window and opens the 5th link")
    public void goBackAndOpenFifthLink() throws InterruptedException {
        this.ts=new takeScreenShot(driver);
        searchResultsPage.selectFifthItem();

        
    	Set<String>windowhandels=driver.getWindowHandles();
        System.out.println(windowhandels);
        
        Iterator<String>iterator=windowhandels.iterator();
        String parentwindow=iterator.next();
        String childWindow=iterator.next();
        String childWindow1=iterator.next();
       
    	driver.switchTo().window(parentwindow);
    	

        Thread.sleep(4000);
      driver.switchTo().window(childWindow1);
      Thread.sleep(4000);
        ts.takeScreenshot();

    	
    }

    @And("user adds the product into the cart")
    public void addToCart() throws InterruptedException {
        this.productPage = new ProductPage(driver);
        this.ts=new takeScreenShot(driver);
        
//        verify product is in stock or not
        WebElement inStock=driver.findElement(By.xpath("//div[@id='availability']"));
        
        String actualStockvalue=inStock.getText();
        System.out.println(actualStockvalue);
        String expectedValue="In stock";
        
        if(actualStockvalue.equals(expectedValue)|| actualStockvalue.equals("Only 2 left in stock.")) {
        	System.out.println("The product is in stock");

        }
        else {
        	System.out.println("The product is outof stock");
        	
        }
        
//        change pin
        productPage.changePin();
        
        
        Thread.sleep(1000);
//        verify change reflecting or not
        WebElement pin=driver.findElement(By.xpath("//span[@id='glow-ingress-line2']"));
        
        String pinText=pin.getText();
        System.out.println(pinText);
        String expectedPin="411039";
        
        if(pinText.equals(expectedPin)) {
        	System.out.println("Pin changed");
        	
        } else {
        	System.out.println("Pin not changed");

        }
//      verify discount
        
        WebElement discount =driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[5]/div[3]/div[4]/div[13]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[3]/td[2]/span[1]"));
        String DiscountSummary=discount.getText();
        
        System.out.println("You Save:"+DiscountSummary);

        
        
        productPage.addProduct();

         ts.takeScreenshot();

    }
    


    @And("user verifies product details and price")
    public void verifyProductDetailsAndPrice() {
        this.ts=new takeScreenShot(driver);
        this.productPage = new ProductPage(driver);
        productPage.clickGoToCart();
    	String expectedProductName = "(Refurbished) HP Notebook 240 G6 6th Gen Intel Core i3 Business HD Laptop (8 GB DDR4 RAM/256 GB SSD/14\" (35.6 cm) HD/Windows 10 Pro/MS Offic…";
        String expectedProductPrice = "  15,999.00";

        WebElement actualProductNameElement = driver.findElement(By.xpath("//div[@id='sc-active-cart']//span[@class='a-size-base-plus a-color-base sc-product-title sc-grid-item-product-title']//span[2]"));
        WebElement actualProductPriceElement = driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-activecart']//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']"));

        String actualProductName = actualProductNameElement.getText();
        System.out.println(actualProductName);
        String actualProductPrice = actualProductPriceElement.getText();

      Assert.assertEquals(expectedProductName, actualProductName); 
      Assert.assertEquals(expectedProductPrice, actualProductPrice);  

        
    }

    @Then("user goes to the checkout screen")
    public void goToCheckoutScreen() {
        this.checkoutPage = new CheckoutPage(driver);

        checkoutPage.proceedToCheckout();
        
//        checkoutPage.changePin();
    }
}
