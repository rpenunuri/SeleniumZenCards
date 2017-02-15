package com.rpenunuri.automation.tests.retailmenot;
import com.rpenunuri.automation.tests.BaseSystemCase;
import org.testng.annotations.Test;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;


public class ConsumerGiftCardSearchResults extends BaseSystemCase {

    @Test
    public void testCase() {
        String searchForMerchant = "Best Buy";
        Set<String> uniqueMerchantNames = asZenConsumer().searchMerchants(searchForMerchant).getUniqueMerchantNames();
        assertThat(uniqueMerchantNames, hasSize(1));
        assertThat(uniqueMerchantNames.iterator().next(), is(searchForMerchant));
    }
}
