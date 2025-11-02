package com.ui.tests;

import com.ui.listners.TestListner;
import com.ui.pages.MyAccountPage;
import com.ui.pages.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListner.class})
public class SearchProductTest extends TestBase{

    private MyAccountPage myAccountPage;
    private SearchResultPage searchResultPage;
    private static final String search_Term="Printed Summer Dress";

    @BeforeMethod(description = "Valid user should get login to the application")
    public void setUp()
    {
        myAccountPage=homePage.goToLoginPage().doLoginWith("testpm@gmail.com","testpm");
    }

    @Test(description = "Verify logger in user able to search product and correct product search results are - displayed"
    ,groups = {"e2e","smoke","sanity"})
    public void verifyProductSearchTest()
    {
        searchResultPage=myAccountPage.searchProduct(search_Term);
        Assert.assertEquals(searchResultPage.getSearchResultTitie(),search_Term);
        Assert.assertTrue(searchResultPage.isSearchTermPresenntInProductList(search_Term));
    }


}
