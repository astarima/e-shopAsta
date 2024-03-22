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
    void UserCanSeeCartSummaryOnTheCheckoutPage() throws InterruptedException {
        productPage = new ProductPage(driver);
        checkOutPage = new CheckOutPage(driver);
        homePage = new HomePage(driver);
        homePage.clickCategoryFilterBtn(1);
        homePage.clickProductNameLink();
        productPage.chooseStyleField(1);
        Thread.sleep(1000);
        productPage.chooseUnisexField();
        productPage.chooseColorField();
        productPage.chooseSizeField();
        Thread.sleep(2000);
        productPage.chooseQuantityField();
        productPage.chooseQuantityNumberField(4);
        productPage.clickSubmitBtn();
        Thread.sleep(2000);
        checkOutPage.clickCheckOutBtn();
        assertEquals("Secure checkout", checkOutPage.getSecureCheckOutText(), "Check out is empty");
    }

    @Test
    void userCanChangeProductQuantity() throws InterruptedException {

        checkOutPage = new CheckOutPage(driver);
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
        productPage.chooseQuantityNumberField(4);
        Thread.sleep(2000);
        productPage.clickSubmitBtn();
        Thread.sleep(2000);
        checkOutPage.clickCheckOutBtn();
        Thread.sleep(2000);
        checkOutPage.chooseQuantitySelector(1);
        Thread.sleep(2000);
        checkOutPage.chooseQuantityChangeField();
        checkOutPage.typeQuantity("5");
        Thread.sleep(5000);
        assertEquals("€86.56", checkOutPage.getPriceChangeText(), "Price not changed");
    }

    @Test
    void userCanDeleteProduct() throws InterruptedException {
        driver.manage().window().maximize();
        productPage = new ProductPage(driver);
        checkOutPage = new CheckOutPage(driver);
        homePage = new HomePage(driver);
        homePage.clickCategoryFilterBtn(1);
        homePage.clickProductNameLink();
        Thread.sleep(2000);
        productPage.chooseSizeField();
        Thread.sleep(2000);
        productPage.clickSubmitBtn();
        Thread.sleep(2000);
        checkOutPage.clickCheckOutBtn();
        Thread.sleep(3000);
        checkOutPage.clickRemoveProductBtn();
        assertEquals("Your cart is empty", checkOutPage.getCartEmptyText(), "Not removed");
    }

    @Test
    void userAddShippingInformation() throws InterruptedException {
        driver.manage().window().maximize();
        productPage = new ProductPage(driver);
        checkOutPage = new CheckOutPage(driver);
        homePage = new HomePage(driver);
        homePage.clickCategoryFilterBtn(1);
        homePage.clickProductNameLink();
        productPage.chooseSizeField();
        Thread.sleep(2000);
        productPage.clickSubmitBtn();
        Thread.sleep(2000);
        checkOutPage.clickCheckOutBtn();
        checkOutPage.typeMyEmail("DemonAdams1978@mail.com");
        checkOutPage.typeMyFirstName("Demon");
        checkOutPage.typeMyLastName("Adams");
        checkOutPage.typeMyAddress("Vytauto g. 36, Nemunaitis");
        checkOutPage.typeMySuit("5");
        checkOutPage.typeMyCity("Alytus");
        checkOutPage.typeMyRegion("Alytaus");
        checkOutPage.typeMyPostCode("64205");
        Thread.sleep(3000);
        checkOutPage.clickCountryIcon();
        checkOutPage.selectMyCountry(20);
        checkOutPage.clickMyPaymentBtn();
        Thread.sleep(7000);
        assertEquals("Your order", checkOutPage.getMyPaymentInfoText(), "Not send payment");
    }

    @Test
    void userAddShippingInformationWrongEmail() throws InterruptedException {
        driver.manage().window().maximize();
        productPage = new ProductPage(driver);
        checkOutPage = new CheckOutPage(driver);
        homePage = new HomePage(driver);
        homePage.clickCategoryFilterBtn(1);
        homePage.clickProductNameLink();
        productPage.chooseSizeField();
        Thread.sleep(2000);
        productPage.clickSubmitBtn();
        Thread.sleep(2000);
        checkOutPage.clickCheckOutBtn();
        checkOutPage.typeMyEmail("DemonAdams1978mail.com");
        checkOutPage.typeMyFirstName("Demon");
        checkOutPage.typeMyLastName("Adams");
        checkOutPage.typeMyAddress("Vytauto g. 36, Nemunaitis");
        checkOutPage.typeMySuit("5");
        checkOutPage.typeMyCity("Alytus");
        checkOutPage.typeMyRegion("Alytaus");
        checkOutPage.typeMyPostCode("64205");
        Thread.sleep(3000);
        checkOutPage.clickCountryIcon();
        checkOutPage.selectMyCountry(20);
        checkOutPage.clickMyPaymentBtn();
        assertEquals("Please enter a valid email address", checkOutPage.getFieldsRequiredText(3));
    }

    @Test
    void userFillOnlyMandatoryFields() throws InterruptedException {
        driver.manage().window().maximize();
        productPage = new ProductPage(driver);
        checkOutPage = new CheckOutPage(driver);
        homePage = new HomePage(driver);
        homePage.clickCategoryFilterBtn(1);
        homePage.clickProductNameLink();
        productPage.chooseSizeField();
        Thread.sleep(2000);
        productPage.clickSubmitBtn();
        Thread.sleep(2000);
        checkOutPage.clickCheckOutBtn();
        checkOutPage.typeMyEmail("DemonAdams1978@mail.com");
        checkOutPage.typeMyFirstName("Demon");
        checkOutPage.typeMyLastName("Adams");
        checkOutPage.typeMyAddress("Vytauto g. 36, Nemunaitis");
        checkOutPage.typeMyCity("Alytus");
        checkOutPage.typeMyPostCode("64205");
        Thread.sleep(3000);
        checkOutPage.clickCountryIcon();
        checkOutPage.selectMyCountry(20);
        checkOutPage.clickMyPaymentBtn();
        Thread.sleep(7000);
        assertEquals("Your order", checkOutPage.getMyPaymentInfoText(), "Not send payment");
    }

    @Test
    void mandatoryFieldsEmpty() throws InterruptedException {
        driver.manage().window().maximize();
        productPage = new ProductPage(driver);
        checkOutPage = new CheckOutPage(driver);
        homePage = new HomePage(driver);
        homePage.clickCategoryFilterBtn(1);
        homePage.clickProductNameLink();
        productPage.chooseSizeField();
        Thread.sleep(2000);
        productPage.clickSubmitBtn();
        Thread.sleep(2000);
        checkOutPage.clickCheckOutBtn();
        checkOutPage.typeMySuit("5");
        checkOutPage.typeMyRegion("Alytaus");
        Thread.sleep(3000);
        checkOutPage.clickMyPaymentBtn();
        Thread.sleep(2000);
        assertEquals("Email address is required", checkOutPage.getFieldsRequiredText(1));
        assertEquals("First name is required", checkOutPage.getFieldsRequiredText(2));
        assertEquals("Last name is required", checkOutPage.getFieldsRequiredText(3));
        assertEquals("Address is required", checkOutPage.getFieldsRequiredText(4));
        assertEquals("City is required", checkOutPage.getFieldsRequiredText(5));
        assertEquals("Post code is required", checkOutPage.getFieldsRequiredText(6));
    }
}