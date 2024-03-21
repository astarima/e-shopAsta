package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".MuiInputBase-root")
    public List<WebElement> styleField;
    @FindBy(css = ".MuiMenuItem-root")
    public WebElement unisexField;
    @FindBy(css = "[title='Sport Grey']")
    public WebElement colorField;
    @FindBy(css = "#product-sizes:last-child")
    public WebElement sizeField;
    @FindBy(css = "#mui-component-select-quantity")
    public WebElement quantityField;
    @FindBy(css = ".MuiMenuItem-root")
    public List<WebElement> quantityNumberField;
    @FindBy(css = "[type='submit']")
    public WebElement submitBtn;
    @FindBy(css = ".MuiDivider-root")
    public WebElement yourCart;
    @FindBy(css = ".inline")
    public WebElement selectSize;

    public void clickStyleField(int i) {styleField.get(--i).click();}
    public void clickUnisexField() {unisexField.click();}
    public void clickColorField() {colorField.click();}
    public void clickSizeField() {sizeField.click();}
    public void clickQuantityField() {quantityField.click();}
    public void clickQuantityNumberField(int i) {quantityNumberField.get(i).click();}
    public void clickSubmitBtn() {submitBtn.click();}
    public boolean isYourCartEmpty() {return yourCart.isDisplayed();}
    public String getSelectSizeText() {return selectSize.getText();}

}











