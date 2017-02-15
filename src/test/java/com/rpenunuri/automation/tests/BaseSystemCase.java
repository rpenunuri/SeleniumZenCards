package com.rpenunuri.automation.tests;

import com.rpenunuri.automation.pages.SeleniumPageFactory;
import com.rpenunuri.automation.pages.retailmenot.GiftCardZenHome;
import org.testng.annotations.*;

@Listeners(value = {TestListener.class})
public abstract class BaseSystemCase {

    private ExecutionContext _executionContext;
    private static final ThreadLocal<Integer> THREAD_INDEX = new InheritableThreadLocal<>();
    private static int _threadCounter = 0;

    @BeforeSuite
    public void beforeSuite() {

    }

    @BeforeClass
    public void beforeClass() {

    }

    @BeforeMethod
    public void beforeMethod() {
        setupExecutionContext();
        getExecutionContext().initializeWebDriver();
    }

    @AfterTest
    public void afterTest() {
        _executionContext.shutDown();
    }

    protected ExecutionContext getExecutionContext() {
        return _executionContext;
    }

    protected void setupExecutionContext() {
        if (THREAD_INDEX.get() == null) {
            synchronized (THREAD_INDEX) {
                THREAD_INDEX.set(_threadCounter++);
            }
        }
        _executionContext = new ExecutionContext(THREAD_INDEX.get());
    }

    public SeleniumPageFactory page() {
        return new SeleniumPageFactory(getExecutionContext().getWebDriver());
    }

    protected GiftCardZenHome asZenConsumer() {
        goToGiftCardZenSite();
        return page().giftCardZenHome();
    }

    private void goToGiftCardZenSite() {
        navigateTo(getExecutionContext(), "https://giftcardzen.com/");
    }

    protected void navigateTo(ExecutionContext executionContext, String path) {
        executionContext.getWebDriver().navigate().to(path);
    }
}
