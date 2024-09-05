package com.sysco.qe.function;

import com.sysco.qe.common.Constants;
import com.sysco.qe.page.LoginPage;
import com.sysco.qe.util.PropertyFileReader;

import java.io.IOException;

public class LoginFunction {

    static LoginPage loginPage = new LoginPage();
    static PropertyFileReader propertyFileReader = new PropertyFileReader();

    private LoginFunction(){}

    public static void openAmazonLogin(){
        loginPage.loadLoginPage(Constants.APP_URL);
        loginPage.navigateToLoginPage();
    }

    public static void loginToAmazon() throws IOException {
        String userEmail = propertyFileReader.getProperty("config","userEmail");
        String password = propertyFileReader.getProperty("config","password");
        loginPage.setEmail(userEmail);
        loginPage.setPassword(password);
        loginPage.clickLoginBtn();
    }

    public static void navigateToGoogle() throws IOException {
       loginPage.loadLoginPage("https://www.google.com/");
    }

    public static String getTxtInAccountLine(){
        return loginPage.getTxtInAccountLine();
    }

    public static void quitDriver(){
        loginPage.quitDriver();
    }

}
