package org.rptest.pages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.rptest.core.elements.UiElement;
import org.rptest.core.elements.UiElementFactory;

@Getter
public class LoginPage {
    private final UiElement userNameInput = UiElementFactory.findElementByXpath("//input[@name='login']");
    private final UiElement passwordInput = UiElementFactory.findElementByXpath("//input[@name='password']");
    private final UiElement submitButton = UiElementFactory.findElementByXpath("//button[@type='submit']");
    private final UiElement footerNotification = UiElementFactory.findElementByXpath("//div[contains(@class,'notificationItem')]");

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
