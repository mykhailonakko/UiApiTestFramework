package org.rptest.uitests.junittests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.rptest.stepdefinitions.LoginSteps;


class SecondaryLoginJUnitTest extends BaseJUnitTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/testdata/InvalidCredentials.csv", numLinesToSkip = 1)
    void testLogin(String username, String password) {
        LoginSteps loginStepsDef = new LoginSteps(browser);
        loginStepsDef.performLogin(username, password);
        Assertions.assertFalse(loginStepsDef.isLoggedInSuccessfully());
    }
}
