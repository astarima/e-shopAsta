import Pages.CheckOutPage;
import Pages.HomePage;
import Pages.ProductPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckOutPageTest extends BaseTest {
    CheckOutPage checkOutPage;
    ProductPage productPage;
    HomePage homePage;

    @Test
    void checkOutTest() throws InterruptedException {
        driver.manage().window().maximize();
        productPage = new ProductPage(driver);
        checkOutPage = new CheckOutPage(driver);
        homePage = new HomePage(driver);
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
        Thread.sleep(2000);
        checkOutPage.clickCheckOutBtn();
        assertEquals("Secure checkout", checkOutPage.getSecureCheckOutText(), "Check out is empty");
    }

    @Test
    void changeProductQuantity() throws InterruptedException {
        driver.manage().window().maximize();
        checkOutPage = new CheckOutPage(driver);
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
        Thread.sleep(2000);
        productPage.clickSubmitBtn();
        Thread.sleep(2000);
        checkOutPage.clickCheckOutBtn();
        Thread.sleep(2000);
        checkOutPage.clickQuantitySelector(1);
        Thread.sleep(2000);
        checkOutPage.clickQuantityChangeField();
        checkOutPage.typeQuantity("5");
        Thread.sleep(5000);
        assertEquals("€86.56", checkOutPage.getPriceChangeText(), "Price not changed");
    }
    @Test
    void deleteProduct() throws InterruptedException {
        driver.manage().window().maximize();
        productPage = new ProductPage(driver);
        checkOutPage = new CheckOutPage(driver);
        homePage = new HomePage(driver);
        homePage.clickCategoryFilterBtn(1);
        homePage.clickProductNameLink();
        Thread.sleep(2000);
        productPage.clickSizeField();
        Thread.sleep(2000);
        productPage.clickSubmitBtn();
        Thread.sleep(2000);
        checkOutPage.clickCheckOutBtn();
        Thread.sleep(3000);
        checkOutPage.clickRemoveProductBtn();
        assertEquals("Your cart is empty", checkOutPage.getCartEmptyText(), "Not removed");
    }

    @Test
    void shippingInformation() throws InterruptedException {
        driver.manage().window().maximize();
        productPage = new ProductPage(driver);
        checkOutPage = new CheckOutPage(driver);
        homePage = new HomePage(driver);
        homePage.clickCategoryFilterBtn(1);
        homePage.clickProductNameLink();
        productPage.clickSizeField();
        Thread.sleep(2000);
        productPage.clickSubmitBtn();
        Thread.sleep(2000);
        checkOutPage.clickCheckOutBtn();
        checkOutPage.typeMyEmail();
        checkOutPage.typeMyFirstName();
        checkOutPage.typeMyLastName();
        checkOutPage.typeMyAddress();
        checkOutPage.typeMySuit();
        checkOutPage.typeMyCity();
        checkOutPage.typeMyRegion();
        checkOutPage.typeMyPostCode();
        Thread.sleep(3000);
        checkOutPage.clickCountryIcon();
        checkOutPage.clickMyCountry(20);
        checkOutPage.clickMyPaymentBtn();
        Thread.sleep(7000);
        assertEquals("Your order", checkOutPage.getMyPaymentInfoText(), "Not send payment");
    }

    @Test
    void shippingInformationWrongEmail() throws InterruptedException {
        driver.manage().window().maximize();
        productPage = new ProductPage(driver);
        checkOutPage = new CheckOutPage(driver);
        homePage = new HomePage(driver);
        homePage.clickCategoryFilterBtn(1);
        homePage.clickProductNameLink();
        productPage.clickSizeField();
        Thread.sleep(2000);
        productPage.clickSubmitBtn();
        Thread.sleep(2000);
        checkOutPage.clickCheckOutBtn();
        checkOutPage.typeMyEmail2();
        checkOutPage.typeMyFirstName();
        checkOutPage.typeMyLastName();
        checkOutPage.typeMyAddress();
        checkOutPage.typeMySuit();
        checkOutPage.typeMyCity();
        checkOutPage.typeMyRegion();
        checkOutPage.typeMyPostCode();
        Thread.sleep(3000);
        checkOutPage.clickCountryIcon();
        checkOutPage.clickMyCountry(20);
        checkOutPage.clickMyPaymentBtn();
        assertEquals("Please enter a valid email address", checkOutPage.getEmailWrongMsgText());
    }

    @Test
    void fillOnlyMandatoryFields() throws InterruptedException {
        driver.manage().window().maximize();
        productPage = new ProductPage(driver);
        checkOutPage = new CheckOutPage(driver);
        homePage = new HomePage(driver);
        homePage.clickCategoryFilterBtn(1);
        homePage.clickProductNameLink();
        productPage.clickSizeField();
        Thread.sleep(2000);
        productPage.clickSubmitBtn();
        Thread.sleep(2000);
        checkOutPage.clickCheckOutBtn();
        checkOutPage.typeMyEmail();
        checkOutPage.typeMyFirstName();
        checkOutPage.typeMyLastName();
        checkOutPage.typeMyAddress();
        checkOutPage.typeMyCity();
        checkOutPage.typeMyPostCode();
        Thread.sleep(3000);
        checkOutPage.clickCountryIcon();
        checkOutPage.clickMyCountry(20);
        checkOutPage.clickMyPaymentBtn();
        Thread.sleep(7000);
        assertEquals("Your order", checkOutPage.getMyPaymentInfoText(), "Not send payment");
    }

    @Test
    void mandatoryFieldEmpty() throws InterruptedException {
        driver.manage().window().maximize();
        productPage = new ProductPage(driver);
        checkOutPage = new CheckOutPage(driver);
        homePage = new HomePage(driver);
        homePage.clickCategoryFilterBtn(1);
        homePage.clickProductNameLink();
        productPage.clickSizeField();
        Thread.sleep(2000);
        productPage.clickSubmitBtn();
        Thread.sleep(2000);
        checkOutPage.clickCheckOutBtn();
        checkOutPage.typeMySuit();
        checkOutPage.typeMyRegion();
        Thread.sleep(3000);
        checkOutPage.clickMyPaymentBtn();
        assertEquals("Email address is required", checkOutPage.getEmailWrongMsgText());
        assertEquals("Address is required", checkOutPage.getAddressRequiredText());
    }
}