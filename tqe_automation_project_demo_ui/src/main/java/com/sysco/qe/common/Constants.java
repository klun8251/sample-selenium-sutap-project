package com.sysco.qe.common;

public class Constants {

    public static final String TEST_ENV = System.getProperty("test.env", "QA");
    public static final String TEST_RELEASE = System.getProperty("test.release", "TQE-Demo-Release");
    public static final String TEST_PROJECT = System.getProperty("test.project", "TQE Automation Project Demo");
    public static final boolean RUN_REMOTELY = Boolean.parseBoolean(System.getProperty("run.remotely", "false"));

    public static final String APP_URL = System.getProperty("app.url", "https://www.amazon.com/");

    public static final boolean UPDATE_DASHBOARD = Boolean.parseBoolean(System.getProperty("update.dashboard", "true"));
    public static final boolean UPDATE_QMETRY = Boolean.parseBoolean(System.getProperty("update.qmetry", "false"));

    private Constants(){}

}