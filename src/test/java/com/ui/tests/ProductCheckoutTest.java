package com.ui.tests;

import static com.constants.Size.*;
import static com.constants.Color.*;
import com.ui.pages.ProductDetailsPage;
import com.ui.pages.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductCheckoutTest extends TestBase {

    private SearchResultPage searchResultPage;
    private ProductDetailsPage productDetailsPage;

    private static final String search_Term="Printed Summer Dress";
    @BeforeMethod(description = "Valid user should get login to the application")
    public void setUp()
    {
        searchResultPage=homePage.goToLoginPage().doLoginWith("testpm@gmail.com","testpm").searchProduct(search_Term);
    }

    @Test(description = "Verify logged in user able to checkout product",groups={"e2e","sanity"})
    public void checkoutTest()
    {
        Assert.assertEquals(searchResultPage.clickOnTheProductAt(1).changeSize(L).changeColor(White).addProductToCart().proceedToCheckout().goToConfirmAdddressPage().goToShipmentPage()
                .goToPaymentPage().makePaymentByWire(),"Your order on My Shop is complete.");
    }

}
