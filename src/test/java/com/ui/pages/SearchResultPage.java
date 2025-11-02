package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class SearchResultPage extends BrowserUtility {

    private static final By PRODUCT_LISTING_TITLE_LOCATOR=By.xpath("//span[contains(@class,'lighter')]");
    private static final By ALL_PRODUCT_LIST_NAME_LOCATOR=By.xpath("//h5[@itemprop='name']/a");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public String getSearchResultTitie()
    {
        return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
    }

    public boolean isSearchTermPresenntInProductList(String searchTerm)
    {
       List<String>keywords=Arrays.asList(searchTerm.toLowerCase().split("\\s"));
       List<String>productNameList=getALlVisibleText(ALL_PRODUCT_LIST_NAME_LOCATOR);
       boolean result=productNameList.stream()
               .anyMatch(name -> (keywords.stream().anyMatch(name.toLowerCase()::contains)));
       return result;
    }

    public ProductDetailsPage clickOnTheProductAt(int index)
    {
       clickOn(getAllElements(ALL_PRODUCT_LIST_NAME_LOCATOR).get(index));
       return new ProductDetailsPage(getDriver());
    }



}
