import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.PublicKey;
import java.util.List;

public class Page
{
    WebDriver driver;

    @FindBy(xpath = "//input[@unbxdattr='sq']")
    public WebElement SearchTextBox;
    @FindBy(xpath = "//li[@unbxdattr='autosuggest']")
    public List<WebElement> AutosuggestValue;
    @FindBy(xpath = "//ul[@role='menubar']//li[@class='navigation-level-one']")
    public List<WebElement> PdpListone;
    @FindBy(xpath = "//div[@class='breadcrum-container']")
    public WebElement pdpOneValue;
    @FindBy(xpath = "//a[@data-title='Girl']")
    public WebElement hederValueGirl;
    @FindBy(xpath = "//ol[@role='menubar']//li[3]//a[text()='Dresses & Rompers']")
    public WebElement secondPdpvalue;
    @FindBy(xpath="//ol[@role='menubar']//li")
    public List<WebElement> pdpSecondList;
    @FindBy(xpath = "//div[@class='product-grid-block-container']//li")
    public List<WebElement> pdpSecondListValue;
    @FindBy(xpath = "//ol[@role='menubar']//li")
    public List<WebElement> pdpThirdlist;
    @FindBy(xpath = "//div[@class='product-grid-block-container']//li")
    public List<WebElement> pdpThirdlistThirdvalue;
    @FindBy(xpath = "//span[@class='sort-item-selected']")
    public WebElement sortDropDown;
    @FindBy(xpath = "//span[@class='sort-title' and text()='Price: Low to High']")
    public WebElement priceLowtoHigh;
    @FindBy(xpath = "//span[@class='text-price offer-price']")
    public List<WebElement> priceList;

    public Page (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }





}
