package org.rptest.stepdefinitions;

import org.rptest.pages.LoginPage;

public class LoginStepsDef {
    private final LoginPage loginPage = new LoginPage();

    public void performLogin(String username, String password) {
        loginPage.getUserNameInput().setText(username);
        loginPage.getPasswordInput().setText(password);
        loginPage.getSubmitButton().click();
    }

    public boolean isLoggedInSuccessfully() {
        return loginPage.getFooterNotification().getText().contains(LoginPage.LoginRelatedNotification.SUCCESS_LOGIN.toString());
    }
}
