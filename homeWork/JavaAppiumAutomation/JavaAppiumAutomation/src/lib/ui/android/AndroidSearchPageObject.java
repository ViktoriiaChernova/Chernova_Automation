package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class AndroidSearchPageObject extends SearchPageObject
{
    static {
        SEARCH_INIT_ELEMENT = "xpath://*[contains(@text,'Search Wikipedia')]";
                SEARCH_INPUT = "xpath://*[contains(@text,'Search Wikipedia')]";
                SEARCH_CANCEL_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
                SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@text='{SUBSTRING}']";
                SEARCH_RESULT_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']//*[@resource-id='org.wikipedia:id/page_list_item_title']";
                SEARCH_EMPTY_RESULTS_ELEMENT = "xpath://*[@text='No results']";
                SEARCH_ELEMENT_CONTAINS_TEXT = "xpath://*[@class='android.widget.TextView']";
                SEARCH_CLEAR_QUERY = "id:org.wikipedia:id/search_close_btn";
    }
    public AndroidSearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
