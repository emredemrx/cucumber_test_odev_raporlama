package org.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.common.PageManager;
import org.test.BaseTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ElementsPageSteps extends BaseTest {
    PageManager pageManager = new PageManager();

    @Given("Open the web site")
    public void openTheWebSite() {
        pageManager.elementsButtons.open();
    }

    @When("Click on the button menu")
    public void clickOnTheButtonMenu() {
        pageManager.elementsButtons.buttonPath.click();
    }

    @And("Click on the clickMe")
    public void clickOnTheClickMe() {
        pageManager.elementsButtons.clickMeButton.click();
    }

    @Then("message is checked {string}")
    public void messageIsCheckedYouHaveDoneADynamicClick(String message) {
        String actualMessage = pageManager.elementsButtons.getText();
        assertThat(actualMessage).isEqualTo(message);
    }


}
