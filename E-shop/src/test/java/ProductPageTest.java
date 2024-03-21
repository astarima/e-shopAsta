import Pages.HomePage;
import Pages.ProductPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductPageTest extends BaseTest {
    HomePage homePage;
    ProductPage productPage;
    @Test
    void selectProductOptions() throws InterruptedException {
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        homePage.clickCategoryFilterBtn(1);
        homePage.clickProductNameLink();
        productPage.clickStyleField(1);
        Thread.sleep(1000);
        productPage.clickUnisexField();
        productPage.clickColorField();
        productPage.clickSizeField();
        productPage.clickQuantityField();
        productPage.clickQuantityNumberField(4);
        productPage.clickSubmitBtn();
        boolean isYourCartDisplayed = productPage.isYourCartEmpty();
        assertTrue(isYourCartDisplayed);
    }

    @Test
    void cantAddProductWithoutSelectedSize() throws InterruptedException {
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        homePage.clickCategoryFilterBtn(1);
        homePage.clickProductNameLink();
        productPage.clickStyleField(1);
        Thread.sleep(1000);
        productPage.clickUnisexField();
        productPage.clickColorField();
        productPage.clickQuantityField();
        productPage.clickQuantityNumberField(4);
        productPage.clickSubmitBtn();
        assertEquals("Color", productPage.getSelectSizeText());
    }

}


