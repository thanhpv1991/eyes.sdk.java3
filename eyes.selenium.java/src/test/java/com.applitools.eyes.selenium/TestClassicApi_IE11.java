package com.applitools.eyes.selenium;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.model.Statement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

@RunWith(JUnit4.class)
public class TestClassicApi_IE11 extends TestClassicApi {

    @ClassRule
    public static final TestRule setTestSuitName = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            testSuitName = "Eyes Selenium SDK - Classic API";
            testedPageUrl = "http://applitools.github.io/demo/TestPages/FramesTestPage/";
            forceFullPageScreenshot = false;
        }
    };

    @Rule
    public final TestRule beforeTest = new TestWatcher() {
        @Override
        public Statement apply(Statement statement, Description description) {
            DesiredCapabilities ieCaps = DesiredCapabilities.internetExplorer();
            ieCaps.setCapability(CapabilityType.BROWSER_VERSION, "11");
            caps = ieCaps;
            return statement;
        }
    };
}
