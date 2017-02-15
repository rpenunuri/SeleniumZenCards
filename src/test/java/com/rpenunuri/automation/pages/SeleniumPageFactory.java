package com.rpenunuri.automation.pages;

import com.rpenunuri.automation.pages.epam.EpamCareers;
import com.rpenunuri.automation.pages.epam.EpamHome;
import com.rpenunuri.automation.pages.jet.JetHome;
import com.rpenunuri.automation.pages.jet.JetSearchResults;
import com.rpenunuri.automation.pages.retailmenot.GiftCardZenHome;
import com.rpenunuri.automation.pages.retailmenot.GiftCardZenSearchResults;
import com.rpenunuri.automation.pages.toptal.ToptalHome;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class SeleniumPageFactory extends PageFactory {
    private final WebDriver _webDriver;


    public SeleniumPageFactory(WebDriver webDriver) {
        _webDriver = webDriver;
    }

    //region JET pages
    public JetHome jetHome() {
        return initElements(_webDriver, JetHome.class);
    }

    public JetSearchResults jetSearchResults() {
        return initElements(_webDriver, JetSearchResults.class);
    }
    //endregion

    //region EPAM pages
    public EpamHome epamHome() {
        return initElements(_webDriver, EpamHome.class);
    }

    public EpamCareers epamCareers() {
        return initElements(_webDriver, EpamCareers.class);
    }
    //endregion

    public ToptalHome toptalHome() {
        return initElements(_webDriver, ToptalHome.class);
    }

    public GiftCardZenHome giftCardZenHome() {
        return  initElements(_webDriver, GiftCardZenHome.class);
    }

    public GiftCardZenSearchResults giftCardZenSearchResults() {
        return initElements(_webDriver, GiftCardZenSearchResults.class);
    }
}
