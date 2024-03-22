import Pages.HomePage;
import Pages.ProductPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShopTest extends BaseTest {
    HomePage homePage;
    ProductPage productPage;

    @Test
    void filterByCategory() {
        homePage = new HomePage(driver);
        homePage.clickCategoryFilterBtn(1);
        assertEquals("Showing 7 of 7 items", homePage.getShowItemsText(), "Not selected");
        homePage.clickCategoryFilterBtn(5);
        assertEquals("Showing 2 of 2 items", homePage.getShowItemsText(), "Not selected");
    }

    @Test
    void filterByType() {
        homePage = new HomePage(driver);
        homePage.clickTypeFilterBtn(1);
        homePage.clickTypeFilterBtn(2);
        assertEquals("Showing 8 of 8 items", homePage.getShowItemsText(), "Not selected");
    }

    @Test
    void loadMoreProducts() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.clickLoadMoreBtn(3);
        Thread.sleep(2000);
        assertEquals("Showing 24 of 26 items", homePage.getShowItemsText(), "Not selected");

    }

    @Test
    void reduceExtendFilterList() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.clickExpandIcon(1);
        Thread.sleep(1000);
        homePage.clickExpandIcon(2);
        boolean isFilterListEmpty = homePage.isFiltersListDisplayed();
        assertFalse(isFilterListEmpty);
        homePage.clickExpandIcon(1);
        Thread.sleep(1000);
        homePage.clickExpandIcon(2);
        assertEquals(19, homePage.getProductsListCount(), "List not expand");

    }

    @Test
    void navigateToProductList() throws InterruptedException {
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        homePage.clickCategoryFilterBtn(1);
        Thread.sleep(2000);
        homePage.clickProductNameLink();
        assertEquals("Buy now", homePage.getBuyNowFieldText(), "Not navigate");
    }

}
