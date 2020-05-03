package com.exness.core.shared.ui.selenium.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SeleniumUtils {

    private static final Logger LOG = LoggerFactory.getLogger(SeleniumUtils.class);

    private SeleniumUtils() {
    }

    public static void open(String url) {
        LOG.info(String.format("Selenium going to open [%s]", url));
        DriverFactory.getDriver().get(url);
    }

    public static void sleep(int mills) {
        try {
            LOG.debug(String.format("Going to sleep for %d, WARNING: try to avoid sleep with waiters", mills));
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
