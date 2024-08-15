package org.common;

import org.pages.AddRecord;
import org.pages.ElementsButtons;

public class PageFactory {
    public static AddRecord buildAddRecordTest() {
        return new AddRecord("/webtables");
    }

    public static ElementsButtons buildElementsButtonsPage() {
        return new ElementsButtons("/elements");
    }
}
