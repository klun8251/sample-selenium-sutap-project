package com.sysco.qe.page;

import com.sysco.qe.common.Constants;
import com.sysco.qe.util.DriverEnvironmentSetUpUtil;
import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;

public class LoginPage {

    By btnNavSignIn = By.id("nav-signin-tooltip");
    By txtEmail = By.id("ap_email");
    By btnContinue = By.id("continue");
    By txtPassword = By.id("ap_password");
    By btnSignIn = By.id("auth-signin-button");
    By accountLine1 = By.id("nav-link-accountList-nav-line-1");

    protected SyscoLabUI syscoLabUI;

    public void loadLoginPage(String url){
        if (Constants.RUN_REMOTELY) {
            syscoLabUI = new SyscoLabWUI(DriverEnvironmentSetUpUtil.setToRunRemotely());
        } else {
            syscoLabUI = new SyscoLabWUI("chrome");
        }
        SyscoLabUI.driver.manage().window().maximize();
        syscoLabUI.navigateTo(url);
    }

    public void navigateToLoginPage(){
        syscoLabUI.click(btnNavSignIn);
    }

    public void setEmail(String email){
        syscoLabUI.sendKeys(txtEmail,email);
        syscoLabUI.click(btnContinue);
    }

    public void setPassword(String password){
        syscoLabUI.sendKeys(txtPassword, password);
    }

    public void clickLoginBtn(){
        syscoLabUI.click(btnSignIn);
    }

    public String getTxtInAccountLine(){
        return syscoLabUI.getText(accountLine1);
    }

    public void quitDriver(){
        if (syscoLabUI.driver != null)
            syscoLabUI.quit();
    }

}
