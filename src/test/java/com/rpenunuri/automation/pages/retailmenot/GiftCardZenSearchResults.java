package com.rpenunuri.automation.pages.retailmenot;

import com.rpenunuri.automation.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Raul on 2/14/2017.
 */
public class GiftCardZenSearchResults extends BasePage {

    @Override
    protected ExpectedCondition readyCondition() {
        return ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cards"));
    }

    public GiftCardZenSearchResults(WebDriver webDriver) {
        super(webDriver);
    }

    public int getAmountOfResults() {
        waitUntil(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner")));
        return getRowsCountFromTable("#card-list tbody tr");
    }

    public Set<String> getUniqueMerchantNames() {
        Set<String> listOfMerchantNames = new HashSet<String>();
        List<WebElement> merchantNames = findElements("#card-list tbody tr .merchant-col");

        for(WebElement merchant : merchantNames) {
            listOfMerchantNames.add(merchant.getText());
        }
        return  listOfMerchantNames;
    }
}
