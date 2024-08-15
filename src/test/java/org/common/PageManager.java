package org.common;

import org.drivers.DriverFactory;
import org.pages.AddRecord;
import org.pages.ElementsButtons;

public class PageManager {
    public AddRecord addRecord;
    public ElementsButtons elementsButtons;


    public PageManager(){
        DriverFactory.setupDriver();
        elementsButtons = PageFactory.buildElementsButtonsPage();
        addRecord = PageFactory.buildAddRecordTest();
    }
}
