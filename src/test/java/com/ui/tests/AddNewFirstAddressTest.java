package com.ui.tests;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.utility.FakeAddressUtility.getFakeAddress;

public class AddNewFirstAddressTest extends TestBase{

    private MyAccountPage myAccountPage;
    private AddressPage addressPage;
    private AddressPOJO addressPOJO;

    @BeforeMethod(description = "Valid user should get login to the application")
    public void setUp()
    {
        myAccountPage=homePage.goToLoginPage().doLoginWith("testpm@gmail.com","testpm");
        addressPOJO=getFakeAddress();
    }


    @Test
    public void addNewAddressTest()
    {
        addressPage = myAccountPage.gotToAddAdrressPage();
        String newAddress = addressPage.saveAddress(addressPOJO);
        Assert.assertEquals(newAddress, addressPOJO.getAddressAlis().toUpperCase());
    }

}
