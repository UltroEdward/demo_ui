package com.exness.core.shared.ui.selenium.elements;


import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebButton extends WebBaseElement {

    private static final Logger LOG = LoggerFactory.getLogger(WebButton.class);

    public WebButton(WebElement wrappedElement) {
        super(wrappedElement);
    }

}

