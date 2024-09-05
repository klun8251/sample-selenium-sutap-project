package com.sysco.qe.util;

import com.syscolab.qe.core.ui.SyscoLabCapabilityUtil;
import com.syscolab.qe.core.ui.common.SyscoLabBrowserTypes;
import org.openqa.selenium.Capabilities;
//import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

/*
* This util class set up the required driver environments
*/
public class DriverEnvironmentSetUpUtil {
    DriverEnvironmentSetUpUtil() {
    }

    public static Capabilities setToRunRemotely() {
        DesiredCapabilities capabilities;
        System.setProperty("hub.url", "http://localhost:4444/wd/hub");
        capabilities = SyscoLabCapabilityUtil.getPCCapabilities("MAC", "chrome");
        capabilities.setBrowserName(SyscoLabBrowserTypes.CHROME);
        return capabilities;
    }

}
