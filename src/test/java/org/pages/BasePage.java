package org.pages;

import com.codeborne.selenide.Selenide;
import org.common.PageFactory;
import org.common.PageManager;
import org.utils.PropertyManager;

public abstract class BasePage {
    protected String pageUrl;
    PropertyManager propertyManager=new PropertyManager();

    public BasePage(String pageUrl){
        this.pageUrl=pageUrl;
    }
    public void open() {
        String baseUrl = propertyManager.getProperty("APP_URL");
        String fullUrl = baseUrl + pageUrl;  // Tam URL oluşturma
        Selenide.open(fullUrl);
    }
}
