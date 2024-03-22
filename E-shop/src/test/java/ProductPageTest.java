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
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        homePage.clickCategoryFilterBtn(1);
        homePage.clickProductNameLink();
        productPage.chooseStyleField(1);
        Thread.sleep(1000);
        productPage.chooseUnisexField();
        productPage.chooseColorField();
        productPage.chooseSizeField();
        Thread.sleep(2000);
        productPage.chooseQuantityField();
        Thread.sleep(2000);
        productPage.chooseQuantityNumberField(4);
        productPage.clickSubmitBtn();
        assertTrue(productPage.isYourCartEmpty());
    }

    @Test
    void cantAddProductWithoutSelectedSize() throws InterruptedException {
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        homePage.clickCategoryFilterBtn(1);
        homePage.clickProductNameLink();
        productPage.chooseStyleField(1);
        Thread.sleep(1000);
        productPage.chooseUnisexField();
        productPage.chooseColorField();
        Thread.sleep(2000);
        productPage.chooseQuantityField();
        Thread.sleep(2000);
        productPage.chooseQuantityNumberField(4);
        productPage.clickSubmitBtn();
        assertEquals("Select size", productPage.getSelectSizeText(3));
    }

}


