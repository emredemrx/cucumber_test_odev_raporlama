package org.test;

import com.codeborne.selenide.Selenide;
import org.common.PageManager;
import org.drivers.DriverFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import static org.drivers.DriverFactory.maximize;

public abstract class BaseTest {
    protected PageManager pageManager;
    protected SoftAssert softAssert;
    @BeforeClass
    public void setUp() {
        pageManager = new PageManager();
        softAssert = new SoftAssert();
    }
    @BeforeMethod
    public void openDriver() {
        Selenide.open();
        maximize();
    }
    @AfterClass
    public void tearDown() {
        DriverFactory.close();
    }



}
