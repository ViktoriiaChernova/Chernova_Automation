package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class iOSSearchPageObject extends SearchPageObject
{
    static {
        SEARCH_INIT_ELEMENT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        SEARCH_INPUT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        SEARCH_CANCEL_BUTTON = "xpath://XCUIElementTypeStaticText[@name='Cancel']";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeStaticText[@name='{SUBSTRING}']";
        SEARCH_RESULT_ELEMENT = "xpath://XCUIElementTypeCell";
        SEARCH_EMPTY_RESULTS_ELEMENT = "xpath://XCUIElementTypeStaticText[@name='No results found']";
        SEARCH_ELEMENT_CONTAINS_TEXT = "xpath://XCUIElementTypeStaticText[@name='Appium']";
        SEARCH_CLEAR_QUERY = "xpath://XCUIElementTypeButton[@name='Clear text']";
    }
    public iOSSearchPageObject (AppiumDriver driver)
    {
        super(driver);
    }
}
