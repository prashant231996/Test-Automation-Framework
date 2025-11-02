package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BrowserUtility {

    private static final By PROCEED_TO_CHECKOUT_BTN=By.xpath("//*[contains(@class,'cart_navigation')]//a[@title='Proceed to checkout']");

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public ConfirmAddressPage goToConfirmAdddressPage()
    {
        clickOn(PROCEED_TO_CHECKOUT_BTN);
        return new ConfirmAddressPage(getDriver());
    }

}
