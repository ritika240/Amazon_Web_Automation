package Pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchResultsPage {
    private WebDriver driver;
    
    @FindBy(xpath = "//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_3']//div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']//span[1]")
    private WebElement pickThirdItem;
    
    @FindBy(xpath="//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_5']//div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']//span[1]")
    private WebElement pickFifthItem;



    @FindBy(xpath = "//select[@id='s-result-sort-select']")
    private WebElement sortByOption;


    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchInput;

    @FindBy(xpath = "//input[@value='Go']")
    private WebElement searchButton;
    
    
    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public WebElement getSortDropDown() {
        return sortByOption;
    }

    public void selectOptionFromDropDown(String optionText) {
        Select select = new Select(sortByOption);
        select.selectByVisibleText(optionText);
    }

    public void searchForProduct(String productName) {
        searchInput.sendKeys(productName);
        searchButton.click();

    }
    
    
    public void selectThirdItem() {
    	pickThirdItem.click();
    	
    }
    public void selectFifthItem() {
    	pickFifthItem.click();
    	
    }



 
    
    }


























//@FindBy(xpath = "//span[normalize-space()='Sort by:'")
//private WebElement sortByOption;
//public void sortBy(String option) {
//sortByOption.click();
//													 
//driver.findElement(By.xpath("//span[contains(text(),'" + option +"']")).click();
//}
//public void sortBy(String option) {
//sortByOption.click();
//													 
//driver.findElement(By.xpath("//span[normalize-space()='" + option +"']")).click();
//}