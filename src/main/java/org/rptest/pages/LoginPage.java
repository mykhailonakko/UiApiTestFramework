package org.rptest.pages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.rptest.core.browser.actions.IBrowser;
import org.rptest.core.elements.UiElement;

@Getter
public class LoginPage {
    private final IBrowser browser;
    private final UiElement userNameInput;
    private final UiElement passwordInput;
    private final UiElement submitButton;
    private final UiElement footerNotification;

    public LoginPage(IBrowser browser) {
        this.browser = browser;
        userNameInput = browser.findElement("//input[@name='login']");
        passwordInput = browser.findElement("//input[@name='password']");
        submitButton = browser.findElement("//button[@type='submit']");
        footerNotification = browser.findElement("//div[contains(@class,'notificationItem')]");
    }

    @AllArgsConstructor
    public enum LoginRelatedNotification {
        SUCCESS_LOGIN("Signed in successfully"),
        ERROR_LOGIN_BAD_CREDENTIALS("Bad credentials"),
        LOGGED_OUT("You have been logged out");

        private final String notificationContent;

        @Override
        public String toString() {
            return notificationContent;
        }
    }
}
