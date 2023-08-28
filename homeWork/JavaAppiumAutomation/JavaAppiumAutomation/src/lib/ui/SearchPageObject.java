package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

abstract public class SearchPageObject extends MainPageObject {

   protected static String
    SEARCH_INIT_ELEMENT,
    SEARCH_INPUT,
    SEARCH_CANCEL_BUTTON,
    SEARCH_RESULT_BY_SUBSTRING_TPL,
    SEARCH_RESULT_ELEMENT,
    SEARCH_EMPTY_RESULTS_ELEMENT,
    SEARCH_ELEMENT_CONTAINS_TEXT,
    SEARCH_CLEAR_QUERY;

    public SearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }
    /* TEMPLATES METHODS */
    private static  String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /* TEMPLATES METHODS */
    public  void initSearchInput()
    {
        this.waitForElementPresent(SEARCH_INIT_ELEMENT,"Cannot find search init element", 5);
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find and click search init element", 5);
    }

    public void waitForCancelButtonToAppear()
    {
        this.waitForElementPresent(SEARCH_CANCEL_BUTTON, "Cannot find search cancel button", 5);
    }

    public void waitForCancelButtonToDisappear()
    {
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON, "Search cancel button is still present", 5);
    }

    public void clickCancelSearch()
    {
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Cannot find and click search cancel button", 5);
    }
    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSendKeys(SEARCH_INPUT, search_line, "Cannot find and type into search input", 5);
    }

    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with substring " + substring);
    }

    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(search_result_xpath, "Cannot find and click search result with substring " + substring, 20);
    }

    public int getAmountOfFoundArticles()
    {
        this.waitForElementPresent(
                SEARCH_RESULT_ELEMENT,
                "Cannot find anything by the request",
                15
        );
        return this.getAmountOfElements(SEARCH_RESULT_ELEMENT);
    }

    public void waitForEmptyResultsLabel()
    {
        this.waitForElementPresent(SEARCH_EMPTY_RESULTS_ELEMENT, "Cannot find empty result element", 5 );
    }

    public void assertThereIsNoResultOfSearch()
    {
        this.assertElementNotPresent(SEARCH_RESULT_ELEMENT, "We supposed not to find any results");
        String search_result_locator = "//*[@resource-id='org.wikipedia:id/search_results_list']//*[@resource-id='org.wikipedia:id/page_list_item_title']";
    }

    public void assertElementContainsText(String expected_text)
    {
        this.assertElementHasText(SEARCH_ELEMENT_CONTAINS_TEXT, expected_text, "Element does not contain expected text");
    }

    public void clickClearQuery()
    {
        this.waitForElementAndClick(SEARCH_CLEAR_QUERY, "Cannot clear query", 5);
    }

    public void titleContainsWord(String expected_word)
    {
        this.checkElementHasWord(
                SEARCH_RESULT_ELEMENT, expected_word, "Element does not contain expected word " + expected_word);
    }
}
