package com.exness.application.page.auth;

import com.exness.core.shared.ui.base.page.BasePage;
import com.exness.core.shared.ui.selenium.elements.WebButton;
import com.exness.core.shared.ui.selenium.elements.WebInput;
import com.exness.core.shared.ui.selenium.elements.WebLabel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//*[@id='email']|//*[@id='login']")
    private WebInput login;
    @FindBy(id = "password")
    private WebInput password;
    @FindBy(xpath = "//button[@type='submit']")
    private WebButton submit;

    @FindBy(xpath = "//*[contains(@class, 'errorMessage')]|//*[contains(@class, 'backend-error')]")
    private WebLabel errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setCredentials(String username, String password) {
        this.login.sendKeys(username);
        this.password.sendKeys(password);
    }

    public void login(String username, String password) {
        setCredentials(username, password);
        submit.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
