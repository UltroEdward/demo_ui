package com.exness.example.ui.test.Login;

import com.exness.application.page.auth.LoginPage;
import com.exness.application.page.home.HomePage;
import com.exness.core.shared.configuration.Config;
import com.exness.core.shared.ui.base.test.BaseUITest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseUITest {

    private static final String USERNAME = Config.getProperty("ui.username");
    private static final String PASSWORD = Config.getProperty("ui.password");
    private static final String DEFAULT_ERROR_MESSAGE = "No such login or password. Please check correctness and try again";

    @DataProvider
    public static Object[][] wrongCredentials() {
        return new Object[][]{
                {USERNAME, "WRONGPASSWORD1!!", DEFAULT_ERROR_MESSAGE},
                {"wrong@wrong.com", PASSWORD, DEFAULT_ERROR_MESSAGE},
                {"wrong@wrong.com", "WRONGPASSWORD1!!", DEFAULT_ERROR_MESSAGE}
        };
    }

    @Test(description = "User can not login with wrong credentials", dataProvider = "wrongCredentials")
    public void wrongCredentials(String username, String password, String expectedError) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        assertThat(loginPage.getErrorMessage()).isEqualToIgnoringCase(expectedError);
    }

    @Test(description = "User can  login with correct credentials")
    public void correctCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(USERNAME, PASSWORD);

        HomePage homePage = new HomePage(driver);
        assertThat(homePage.getHeaderEmail()).isEqualToIgnoringCase(USERNAME);
    }
}
