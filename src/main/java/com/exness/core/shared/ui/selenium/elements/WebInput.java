package com.exness.core.shared.ui.selenium.elements;

import org.openqa.selenium.WebElement;


public class WebInput extends WebBaseElement {

    public WebInput(WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public void sendKeys(CharSequence... keys) {
        super.clear();
        super.sendKeys(keys);
    }

    public void appendKeys(CharSequence... keys) {
        super.sendKeys(keys);
    }
}
