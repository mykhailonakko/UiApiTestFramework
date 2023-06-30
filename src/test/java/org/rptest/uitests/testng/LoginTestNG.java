package org.rptest.uitests.testng;

import org.apache.commons.csv.CSVRecord;
import org.rptest.core.utilities.FileUtils;
import org.rptest.stepdefinitions.LoginStepsDef;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginTestNG extends BaseTestNG{
    @DataProvider(name = "credentialsProvider")
    public Iterator<Object[]> credentialsProvider() throws IOException {
        List<Object[]> data = new ArrayList<>();
        String filePath = "src/test/resources/testdata/InvalidCredentials.csv";
        List<CSVRecord> records = FileUtils.readCSV(filePath);
        for (CSVRecord record : records) {
            data.add(new Object[]{record.get("username"), record.get("password")});
        }
        return data.iterator();
    }

    @Test(dataProvider = "credentialsProvider")
    public void testLogin(String username, String password) {
        LoginStepsDef loginStepsDef = new LoginStepsDef();
        loginStepsDef.performLogin(username, password);
        Assert.assertFalse(loginStepsDef.isLoggedInSuccessfully());
    }
}
