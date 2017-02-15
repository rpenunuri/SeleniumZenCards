package com.rpenunuri.automation.util;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

public class Condition {

    public static ExpectedCondition elementIsDisplayed(final String cssSelector) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver wd) {
                List<WebElement> elements = wd.findElements(By.cssSelector(cssSelector));
                return (!elements.isEmpty() && elements.get(0).isDisplayed());
            }
        };
    }

    public static ExpectedCondition elementContainsExpectedText(final String cssSelector, final String value) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wd) {
                WebElement element = wd.findElement(By.cssSelector(cssSelector));
                return element.getText().equals(value);
            }
        };
    }

}
