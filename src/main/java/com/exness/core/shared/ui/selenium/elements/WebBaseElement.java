package com.exness.core.shared.ui.selenium.elements;

import com.exness.core.shared.exceptions.UIException;
import com.exness.core.shared.ui.selenium.util.SeleniumUtils;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;


public class WebBaseElement extends TypifiedElement {

    private static final Logger LOG = LoggerFactory.getLogger(WebBaseElement.class);

    public WebBaseElement(WebElement wrappedElement) {
        super(wrappedElement);
    }

    public void waitForTextNotEmpty(int seconds) {
        long end = System.currentTimeMillis() + seconds * 1000;
        while (System.currentTimeMillis() < end) {
            try {
                if (!this.getText().isEmpty()) {
                    return;
                } else {
                    LOG.debug(String.format("Element's text is empty, wait time left %d", end - System.currentTimeMillis()));
                    SeleniumUtils.sleep(100);
                }
            } catch (WebDriverException ignored) {
                // ignore any errors
            }
        }

        throw new UIException("WebElement is empty");
    }

}
