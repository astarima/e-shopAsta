package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckOutPage extends BasePage {

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(@data-testid,'proceed-to-checkout')]")
    public WebElement checkOutBtn;
    @FindBy(css = ".col-span-1")
    public WebElement secureCheckOut;
    @FindBy(css = ".flex.flex-row.h-8 button")
    public List<WebElement> quantitySelector;
    @FindBy(css = "[type='number']")
    public WebElement quantityChangeField;
    @FindBy(xpath = "//*[contains(@data-testid,'cart-remove-button')]")
    public WebElement removeProductBtn;
    @FindBy(xpath = "//*[contains(@class,'pt-6 text-2xl')]")
    public WebElement cartEmpty;
    @FindBy(xpath = "//*[contains(@data-testid,'checkout-total')]")
    public WebElement priceChange;
    @FindBy(css = "[placeholder='Your email address']")
    public WebElement myEmail;
    @FindBy(css = "[placeholder='Your email address']")
    public WebElement myEmail2;
    @FindBy(css = "[placeholder='Your first name']")
    public WebElement myFirstName;
    @FindBy(css = "[placeholder='Your last name']")
    public WebElement myLastName;
    @FindBy(css = "[placeholder='Your address']")
    public WebElement myAddress;
    @FindBy(css = "[placeholder='App or suite']")
    public WebElement mySuit;
    @FindBy(css = "[placeholder='Your city']")
    public WebElement myCity;
    @FindBy(css = "[placeholder='Your region']")
    public WebElement myRegion;
    @FindBy(css = "[placeholder='Your post code']")
    public WebElement myPostCode;
    @FindBy(id = "mui-component-select-shippingAddress.country")
    public WebElement countryIcon;
    @FindBy(css = ".MuiMenuItem-root")
    public List<WebElement> myCountry;
    @FindBy(xpath = "//*[contains(@data-testid,'proceed-to-payment')]")
    public WebElement myPaymentBtn;
    @FindBy(xpath = "//*[(@class='mb-6 subtitle')]")
    public WebElement myPaymentInfo;
    @FindBy(id = "mui-4-helper-text")
    public WebElement emailWrongMsg;
    @FindBy(id = "mui-7-helper-text")
    public WebElement addressRequired;

    public void clickCheckOutBtn() {checkOutBtn.click();}
    public String getSecureCheckOutText() {return secureCheckOut.getText();}
    public void clickQuantitySelector(int i) {quantitySelector.get(--i).click();}
    public void clickQuantityChangeField() {
        quantityChangeField.click();
    }
    public void typeQuantity(String number) {
        quantityChangeField.sendKeys(Keys.chord(Keys.CONTROL, "a"), "5");
    }
    public void clickRemoveProductBtn() {removeProductBtn.click();}
    public String getCartEmptyText() {return cartEmpty.getText();}
    public String getPriceChangeText() {return priceChange.getText();}
    public void typeMyEmail() {myEmail.sendKeys("DemonAdams1978@mail.com");}
    public void typeMyEmail2() {myEmail2.sendKeys("DemonAdams1978mail.com");} // pataisyk i stingus visus, ir testus taip pat
    public void typeMyFirstName() {myFirstName.sendKeys("Demon");}
    public void typeMyLastName() {myLastName.sendKeys("Adams");}
    public void typeMyAddress() {myAddress.sendKeys("Vytauto g. 36, Nemunaitis");}
    public void typeMySuit() {mySuit.sendKeys("5");}
    public void typeMyCity() {myCity.sendKeys("Alytus");}
    public void typeMyRegion() {myRegion.sendKeys("Alytaus");}
    public void typeMyPostCode() {myPostCode.sendKeys("64205");}
    public void clickCountryIcon() {countryIcon.click();}
    public void clickMyCountry(int i) {myCountry.get(--i).click();}
    public void clickMyPaymentBtn() {
        myPaymentBtn.click();}
    public String getMyPaymentInfoText() {return myPaymentInfo.getText();}
    public String getEmailWrongMsgText() {return emailWrongMsg.getText();}
    public String getAddressRequiredText() {return addressRequired.getText();}
}












