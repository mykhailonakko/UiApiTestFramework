package org.rptest.uitests.bddtests.stepsdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.rptest.core.browser.actions.IBrowser;
import org.rptest.core.config.Property;
import org.rptest.stepdefinitions.LoginSteps;
import org.rptest.uitests.bddtests.BrowserHolder;

public class LoginStepsDef {
    IBrowser browser;
    LoginSteps loginSteps;

    public LoginStepsDef(BrowserHolder browserHolder) {
        this.browser = browserHolder.getBrowser();
        this.loginSteps = new LoginSteps(browser);
    }

    @Given("I am on Login page")
    public void iAmOnLoginPage() {
        browser.open(Property.COMMON_PROPERTY.baseUrl());
    }

    @When("I enter username {string} and password {string}")
    public void iEnterUsernameAndPassword(String username, String password) {
        loginSteps.performLogin(username, password);
    }

    @Then("I check login is not successful")
    public void iCheckLoginIsNotSuccessful() {
        Assert.assertFalse(loginSteps.isLoggedInSuccessfully());
    }
}
