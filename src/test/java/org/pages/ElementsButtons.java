package org.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ElementsButtons extends BasePage {

    public SelenideElement buttonPath = $("#item-4");
    public SelenideElement clickMeButton = $x("//button[text()='Click Me']");
    public SelenideElement clickMessage = $("#dynamicClickMessage");

    public ElementsButtons(String pageUrl) {
        super(pageUrl);
    }

    public String getText (){
        return clickMessage.getText();
    }
}
