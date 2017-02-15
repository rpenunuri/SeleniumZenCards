package com.rpenunuri.automation.pages;

import com.rpenunuri.automation.pages.retailmenot.GiftCardZenHome;
import com.rpenunuri.automation.pages.retailmenot.GiftCardZenSearchResults;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class SeleniumPageFactory extends PageFactory {
    private final WebDriver _webDriver;


    public SeleniumPageFactory(WebDriver webDriver) {
        _webDriver = webDriver;
    }

    public GiftCardZenHome giftCardZenHome() {
        return  initElements(_webDriver, GiftCardZenHome.class);
    }

    public GiftCardZenSearchResults giftCardZenSearchResults() {
        return initElements(_webDriver, GiftCardZenSearchResults.class);
    }
}
