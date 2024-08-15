package org.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AddRecordTest extends BaseTest {
    @BeforeMethod
    public void before(){
        pageManager.addRecord.open();
    }
    @Test
    public void clickButton(){
        pageManager.addRecord.addButton.click();
        pageManager.addRecord.dataAdd("Emre","Demir","emre@test.com","45","14545","IK");
        pageManager.addRecord.submitButton.click();
        pageManager.addRecord.updateButton.click();
        pageManager.addRecord.salaryInput.clear();
        pageManager.addRecord.salaryInput.setValue("45000");
        pageManager.addRecord.departmentInput.clear();
        pageManager.addRecord.departmentInput.setValue("IT");
        pageManager.addRecord.submitButton.click();
        assertThat(pageManager.addRecord.getsalaryText()).isEqualTo("45000");
        assertThat(pageManager.addRecord.getdepartmentText()).isEqualTo("IT");
    }
}
