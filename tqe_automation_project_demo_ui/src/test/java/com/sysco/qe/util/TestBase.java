package com.sysco.qe.util;

import com.sysco.qe.common.Constants;
import com.sysco.qe.function.LoginFunction;
import com.syscolab.qe.core.reporting.*;
import com.syscolab.qe.core.util.qcenter.QCenterUtil;
import org.json.JSONException;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

/**
 * This base class set up QCenter related Constants and update the QCenter release
 */
@Listeners(SyscoLabListener.class)
public class TestBase {

    public SoftAssert softAssert;
    private SyscoLabListener testListeners;
    protected SyscoLabQCenter syscoLabQCenter;

    /**
     * This method will send the Q Center parameters to generate the project and release in the given Env
     * @throws JSONException
     */
    @BeforeSuite
    public void createBuild() throws JSONException {
        QCenterUtil.generateBuild(Constants.TEST_PROJECT,Constants.TEST_ENV,Constants.TEST_RELEASE);
    }

    @BeforeClass(alwaysRun = true)
    public void init() {
        testListeners = new SyscoLabListener();
        syscoLabQCenter = new SyscoLabQCenter();
    }

    @BeforeMethod(alwaysRun = true)
    public void initSoftAssert() {
        softAssert = new SoftAssert();
    }

    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        System.out.println("Test Running " + this.getClass().toString());
    }

    /**
     * This method will add the Test case in given build under module-feature
     * @param iTestContext
     */
    @AfterClass(alwaysRun = true)
    public void cleanUp(ITestContext iTestContext) {
        try {
            LoginFunction.quitDriver();

            syscoLabQCenter.setProjectName(Constants.TEST_PROJECT);
            syscoLabQCenter.setEnvironment(Constants.TEST_ENV);
            syscoLabQCenter.setRelease(Constants.TEST_RELEASE);
            syscoLabQCenter.setModule(iTestContext.getAttribute("feature").toString());
            syscoLabQCenter.setFeature(iTestContext.getAttribute("feature").toString());
            syscoLabQCenter.setClassName(iTestContext.getClass().getName());

            if (Constants.UPDATE_DASHBOARD)
                SyscoLabReporting.generateJsonFile(SyscoLabListener.getResults(), syscoLabQCenter);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}