package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.logging.XMLFormatter;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".MuiRadio-root")
    public List<WebElement> categoryFilterBtn;
    @FindBy(css = ".text-base ")
    public WebElement showItems;
    @FindBy(css = "[type='checkbox']")
    public List<WebElement> typeFilterBtn;
    @FindBy(css = ".MuiButton-root")
    public List<WebElement> loadMoreBtn;
    @FindBy(css = ".MuiAccordionSummary-expandIconWrapper")
    public List<WebElement> expandIcon;
    @FindBy(css = ".MuiPaper-root")
    public List<WebElement> filtersList;
    @FindBy(css = ".MuiFormControlLabel-root")
    public List<WebElement> productsList;
    @FindBy(xpath = "//a[contains(@aria-label, 'Cool')]")
    public WebElement productNameLink;
    @FindBy(xpath = "//*[contains(@data-testid,'buy-now')]")
    public WebElement buyNowField;

    public void clickCategoryFilterBtn(int i) {
        categoryFilterBtn.get(--i).click();
    }
    public String getShowItemsText() {
        return showItems.getText();
    }
    public void clickTypeFilterBtn(int i) {
        typeFilterBtn.get(--i).click();
    }
    public void clickLoadMoreBtn(int i) {
        loadMoreBtn.get(--i).click();
    }
    public void clickExpandIcon(int i) {
        expandIcon.get(--i).click();
    }
    public boolean isFiltersListDisplayed() {
        return filtersList.isEmpty();
    }
    public int getProductsListCount(int i) {
        return productsList.size();
    }
    public void clickProductNameLink() {
        productNameLink.click();
    }
    public String getBuyNowFieldText() {
        return buyNowField.getText();
    }


}








