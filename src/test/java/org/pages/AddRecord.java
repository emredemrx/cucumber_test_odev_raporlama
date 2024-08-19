package org.pages;

import com.codeborne.selenide.SelenideElement;
import org.bouncycastle.pqc.crypto.newhope.NHSecretKeyProcessor;

import static com.codeborne.selenide.Selenide.$;

public class AddRecord extends BasePage {

    public SelenideElement addButton = $("#addNewRecordButton");
    public SelenideElement firstNameInput = $("#firstName");
    public SelenideElement lastNameInput = $("#lastName");
    public SelenideElement userEmailInput = $("#userEmail");
    public SelenideElement ageInput = $("#age");
    public SelenideElement salaryInput = $("#salary");
    public SelenideElement departmentInput = $("#department");
    public SelenideElement submitButton = $("#submit");
    public SelenideElement updateButton = $(".rt-tbody > div:nth-of-type(4) .mr-2");

    public SelenideElement departmentText = $(".rt-tbody > div:nth-of-type(4) div:nth-of-type(6)");
    public SelenideElement salaryText = $(".rt-tbody > div:nth-of-type(4) div:nth-of-type(5)");
    public SelenideElement nameText = $(".rt-tbody > div:nth-of-type(4) > .rt-tr > div:nth-of-type(1)");


    public AddRecord(String pageUrl) {
        super(pageUrl);
    }
    public void dataAdd(String firstName, String lastName,String userEmail,String age,String salary,String department){
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastName);
        userEmailInput.setValue(userEmail);
        ageInput.setValue(age);
        salaryInput.setValue(salary);
        departmentInput.setValue(department);
        //submitButton.click();
    }
    public String getNameText (){
        return nameText.getText();
    }
    public String getdepartmentText (){
        return departmentText.getText();
    }
    public String getsalaryText (){
        return salaryText.getText();
    }
}
