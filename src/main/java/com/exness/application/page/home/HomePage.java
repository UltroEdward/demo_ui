package com.exness.application.page.home;

import com.exness.core.shared.ui.base.page.BasePage;
import com.exness.core.shared.ui.selenium.elements.WebButton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[contains(@class, 'headerContainer')]//*[contains(@class, 'userEmail')]")
    public WebButton headerEmail;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderEmail() {
        headerEmail.waitForTextNotEmpty(10);
        return headerEmail.getText();
    }
}
