package org.steps;

import com.codeborne.selenide.Condition;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.common.PageManager;
import org.test.BaseTest;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AddRecordPageSteps extends BaseTest {
    PageManager pageManager = new PageManager();

    @Given("Open the web tables site")
    public void openTheWebTablesSite() {
        pageManager.addRecord.open();

    }
    @When("Click on the Add Button")
    public void clickOnTheAddButton() {
        pageManager.addRecord.addButton.click();
        assertThat(pageManager.addRecord.submitButton.isDisplayed()).isTrue();
    }
    @And("The personnel information is filled in {string} and {string} and {string} and {string} and {string} and {string}")
    public void thePersonnelInformationIsFilledInAndAndAndAndAnd(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) {
        pageManager.addRecord.dataAdd(arg0,arg1,arg2,arg3,arg4,arg5);

    }
    @Then("click on the submit button")
    public void clickOnTheSubmitButton() {
        assertThat(pageManager.addRecord.submitButton.isDisplayed()).isTrue();
        pageManager.addRecord.submitButton.click();
    }


    @When("Click on the update button")
    public void clickOnTheUpdateButton() {
        pageManager.addRecord.updateButton.click();
    }

    @And("The namespace is updated {string}")
    public void theNamespaceIsUpdated(String arg0) {
        pageManager.addRecord.firstNameInput.clear();
        pageManager.addRecord.firstNameInput.setValue(arg0);
    }

    @And("The user saves the changes")
    public void theUserSavesTheChanges() {
        pageManager.addRecord.submitButton.click();
    }

    @Then("The user should see the updated record with {string} in the table.")
    public void theUserShouldSeeTheUpdatedRecordWithInTheTable(String arg0) {
        assertThat(pageManager.addRecord.getNameText()).isEqualTo(arg0);
    }

}
