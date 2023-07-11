package org.rptest.uitests.bddtests.stepsdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.rptest.core.browser.actions.IBrowser;
import org.rptest.core.browser.driver.Driver;
import org.rptest.core.browser.driver.DriverFactory;
import org.rptest.core.config.Property;
import org.rptest.stepdefinitions.LoginSteps;

public class LoginStepsDef {
    Driver driver;
    IBrowser browser;
    LoginSteps loginSteps;

//    private final BrowserHolder browserHolder;
//    private final LoginSteps loginSteps;

//    public LoginStepsDef(BrowserHolder browserHolder) {
//        this.browserHolder = browserHolder;
//        loginSteps = new LoginSteps(browserHolder.getBrowser());
//    }


    @Given("I am on Login page")
    public void iAmOnLoginPage() {
        driver = new DriverFactory().getDriver();
        driver.initiateDriver();
        browser = driver.getBrowser();
        browser.open(Property.COMMON_PROPERTY.baseUrl());
        loginSteps = new LoginSteps(browser);
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
