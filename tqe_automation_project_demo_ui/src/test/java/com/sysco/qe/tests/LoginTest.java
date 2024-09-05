package com.sysco.qe.tests;

import com.sysco.qe.function.LoginFunction;
import com.sysco.qe.util.TestBase;
import com.sysco.qe.util.TestFeatures;
import com.sysco.qe.util.TestModules;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends TestBase {

    @BeforeClass(alwaysRun = true)
    public void init(ITestContext iTestContext){
        //set QCenter feature and module data
        iTestContext.setAttribute("feature", TestModules.LOGIN + "-" + TestFeatures.VALID_LOGIN);

        //open the browser and load the login page
        LoginFunction.openAmazonLogin();
    }

    @Ignore
    @Test(description = "TQE-TC-0001 - Test valid user login")
    public void testValidUserLogin() throws IOException {
        LoginFunction.loginToAmazon();
        softAssert.assertEquals(LoginFunction.getTxtInAccountLine(),"Hello, Tuda5860","Account Line Message Miss-matched");
        softAssert.assertAll();
    }

    @Test(description = "TQE-TC-0001 - Test valid user login")
    public void testloginGoogle() throws IOException {
        LoginFunction.navigateToGoogle();
    }

}
