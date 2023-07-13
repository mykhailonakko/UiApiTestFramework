package org.rptest.stepdefinitions;

import org.rptest.core.browser.actions.IBrowser;
import org.rptest.pages.LoginPage;

public class LoginStepsDef {
    private final LoginPage loginPage;
    public LoginStepsDef(IBrowser browser) {
        this.loginPage = new LoginPage(browser);
    }

    public void performLogin(String username, String password) {
        loginPage.getUserNameInput().setText(username);
        loginPage.getPasswordInput().setText(password);
        loginPage.getSubmitButton().click();
    }

    public boolean isLoggedInSuccessfully() {
        return loginPage.getFooterNotification().getText().contains(LoginPage.LoginRelatedNotification.SUCCESS_LOGIN.toString());
    }
}
