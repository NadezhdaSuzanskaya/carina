package com.zebrunner.carina.demo;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.gui.components.compare.ModelSpecs;
import com.zebrunner.carina.demo.gui.components.header.LoginModal;
import com.zebrunner.carina.demo.gui.pages.common.CompareModelsPageBase;
import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.gui.pages.desktop.HomePage;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class LoginTest implements IAbstractTest {
    private HomePageBase homePageBase = null;
    private CompareModelsPageBase comparePage = null;
    private HomePage homePage=null;
    private List<ModelSpecs> specs = new ArrayList<>();
    //private static final Logger LOGGER = LogManager.getLogger(ExampleTest.class);
    @BeforeSuite
    public void startDriver() {
        // Open GSM Arena home page and verify page is opened
        homePageBase = initPage(getDriver(), HomePageBase.class);
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void LoginTest() {
        homePageBase = initPage(getDriver(),HomePageBase.class);
        homePageBase.open();
        homePage = new HomePage(getDriver());
      //  homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Login Modal screen isn't opened");
        Assert.assertFalse(homePage.checkTooltipPresent(), "Tooltip 'log in' is displayed");
        homePage.clickLoginIcon();
        Assert.assertTrue(homePage.checkTooltipPresent(), "Tooltip 'log in' isn't displayed");
    }
}
