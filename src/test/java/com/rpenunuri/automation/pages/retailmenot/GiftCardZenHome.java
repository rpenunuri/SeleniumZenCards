package com.rpenunuri.automation.pages.retailmenot;

import com.gargoylesoftware.htmlunit.Page;
import com.rpenunuri.automation.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GiftCardZenHome extends BasePage {

    @Override
    protected ExpectedCondition readyCondition() {
        return ExpectedConditions.titleContains("Giftcard Zen");
    }

    public GiftCardZenHome(WebDriver webDriver) {
        super(webDriver);
    }

    public GiftCardZenSearchResults searchMerchants(String searchCriteria) {
        sendKeys("#query", searchCriteria + Keys.RETURN);
        return page().giftCardZenSearchResults();
    }

    public int getAmountOfResults() {
        waitUntil(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner")));
        return getRowsCountFromTable("#card-list tbody tr");
    }

    public Boolean isModalVisble() {
        return is(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#modal")));
    }
}
