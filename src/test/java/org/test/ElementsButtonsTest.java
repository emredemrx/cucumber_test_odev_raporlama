package org.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ElementsButtonsTest extends BaseTest {
    @BeforeMethod
    public void before(){
        pageManager.elementsButtons.open();
    }
    @Test
    public void clickButton(){
        pageManager.elementsButtons.buttonPath.click();
        pageManager.elementsButtons.clickMeButton.click();
        assertThat(pageManager.elementsButtons.getText()).isEqualTo("You have done a dynamic click");
    }
}
