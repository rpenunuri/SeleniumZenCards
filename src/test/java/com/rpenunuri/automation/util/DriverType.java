package com.rpenunuri.automation.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public enum DriverType {
    firefox {
        @Override
        public WebDriver createWebDriver() {
           FirefoxProfile firefoxProfile = new FirefoxProfile();
           //firefoxProfile.setPreference("extensions.firebug.currentVersion", "1.8.1");
           firefoxProfile.setEnableNativeEvents(false);
           return new FirefoxDriver(firefoxProfile);
        }

    },
    chrome {
        @Override
        public WebDriver createWebDriver() {
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
            return new ChromeDriver();
        }
    };

    public abstract WebDriver createWebDriver();
}
