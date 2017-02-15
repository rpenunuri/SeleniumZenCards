package com.rpenunuri.automation.tests;

import com.rpenunuri.automation.pages.epam.EpamHome;
import com.rpenunuri.automation.pages.jet.JetHome;
import com.rpenunuri.automation.pages.SeleniumPageFactory;
import com.rpenunuri.automation.pages.retailmenot.GiftCardZenHome;
import com.rpenunuri.automation.pages.toptal.ToptalHome;
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

    //region JET Methods
    protected JetHome asJetGuest() {
        goToJetSite();
        return page().jetHome();
    }

    private void goToJetSite() {
        navigateTo(getExecutionContext(), "https://jet.com/");
    }
    //endregion


    //region EPAM Methods
    protected EpamHome asEpamGuest() {
        goToEpamSite();
        return page().epamHome();
    }

    private void goToEpamSite() {
        navigateTo(getExecutionContext(), "http://www.epam.com/");
    }
    //endregion

    protected ToptalHome asToptalGuest() {
        goToToptalSite();
        return page().toptalHome();
    }

    protected GiftCardZenHome asZenConsumer() {
        goToGiftCardZenSite();
        return page().giftCardZenHome();
    }

    private void goToGiftCardZenSite() {
        navigateTo(getExecutionContext(), "https://giftcardzen.com/");
    }

    private void goToToptalSite() {
        navigateTo(getExecutionContext(), "http://www.toptal.com");
    }

    protected void navigateTo(ExecutionContext executionContext, String path) {
        executionContext.getWebDriver().navigate().to(path);
    }
}
