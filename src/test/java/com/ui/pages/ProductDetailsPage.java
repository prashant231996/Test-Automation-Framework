package com.ui.pages;


import com.constants.Color;
import com.constants.Size;
import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage  extends BrowserUtility {

    private static final By SIZE_DROP_DOWN_LOCATOR=By.id("group_1");
    private static final By WHITE_COLOR_ITEM_LOCATOR=By.xpath("//*[starts-with(@id,color) and @title='White']");
    private static final By YELLOW_COLOR_ITEM_LOCATOR=By.xpath("//*[starts-with(@id,color) and @title='Yellow']");
    private static final By ORANGE_COLOR_ITEM_LOCATOR=By.xpath("//*[starts-with(@id,color) and @title='Orange']");
    private static final By ADD_TO_CART_BTN_LOCATOR=By.name("Submit");
    private static final By PROCEED_TO_CHECKOUT_BTN_LOCATOR=By.xpath("//a[@title='Proceed to checkout']");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public ProductDetailsPage changeSize(Size size)
    {
        selectDropDownOption(SIZE_DROP_DOWN_LOCATOR,size.toString());
        return new ProductDetailsPage(getDriver());
    }

    public ProductDetailsPage changeColor(Color color)
    {
        if (color == Color.White) {
            clickOn(WHITE_COLOR_ITEM_LOCATOR);
        }
        else if (color==Color.Yellow)
        {
            clickOn(YELLOW_COLOR_ITEM_LOCATOR);
        }
        else if (color==Color.Orange)
        {
            clickOn(ORANGE_COLOR_ITEM_LOCATOR);
        }
        return new ProductDetailsPage(getDriver());
    }

    public ProductDetailsPage addProductToCart()
    {
        clickOn(ADD_TO_CART_BTN_LOCATOR);
        return new ProductDetailsPage(getDriver());
    }

    public ShoppingCartPage proceedToCheckout()
    {
        clickOn(PROCEED_TO_CHECKOUT_BTN_LOCATOR);
        return new ShoppingCartPage(getDriver());
    }





}
