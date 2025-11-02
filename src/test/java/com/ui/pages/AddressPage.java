package com.ui.pages;

import com.ui.pojo.AddressPOJO;
import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressPage extends BrowserUtility {

    private static final By COMPANY_TEXT_BOX_LOCATOR=By.id("company");
    private static final By ADDRESS1_TEXT_BOX_LOCATOR=By.id("address1");
    private static final By ADDRESS2_TEXT_BOX_LOCATOR=By.id("address2");
    private static final By CITY_TEXT_BOX_LOCATOR=By.id("city");
    private static final By POST_CODE_TEXT_BOX_LOCATOR=By.id("postcode");
    private static final By HOME_PHONE_TEXT_BOX_LOCATOR=By.id("phone");
    private static final By MOBILE_PHONE_TEXT_BOX_LOCATOR=By.id("phone_mobile");
    private static final By OTHER_INFORMATION_TEXT_BOX_LOCATOR=By.id("other");
    private static final By ADDRESS_ALIAS_TEXT_BOX_LOCATOR=By.id("alias");
    private static final By STATE_DROPDOWN_LOCATOR=By.id("id_state");
    private static final By SAVE_ADDRESS_BUTTON_LOCATOR=By.id("submitAddress");
    private static final By ADDRESS_HEADING=By.tagName("h3");

    public AddressPage(WebDriver driver) {
        super(driver);
    }

    public String saveAddress(AddressPOJO addressPOJO)
    {
        type(COMPANY_TEXT_BOX_LOCATOR,addressPOJO.getCompanyName());
        type(ADDRESS1_TEXT_BOX_LOCATOR,addressPOJO.getAddressLine1());
        type(ADDRESS2_TEXT_BOX_LOCATOR,addressPOJO.getAddressLine2());
        type(CITY_TEXT_BOX_LOCATOR,addressPOJO.getCity());
        type(POST_CODE_TEXT_BOX_LOCATOR, addressPOJO.getPostCode());
        type(HOME_PHONE_TEXT_BOX_LOCATOR,addressPOJO.getHomePhoneNo());
        type(MOBILE_PHONE_TEXT_BOX_LOCATOR, addressPOJO.getMobileNumber());
        type(OTHER_INFORMATION_TEXT_BOX_LOCATOR, addressPOJO.getOtherInformation());
        type(ADDRESS_ALIAS_TEXT_BOX_LOCATOR,addressPOJO.getAddressAlis());
        selectDropDownOption(STATE_DROPDOWN_LOCATOR,addressPOJO.getState());
        clickOn(SAVE_ADDRESS_BUTTON_LOCATOR);
        String newAddress=getVisibleText(ADDRESS_HEADING);
        return newAddress;

    }
}
