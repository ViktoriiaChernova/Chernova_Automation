package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class iOSArticlePageObject extends ArticlePageObject
{
    private static String name_of_folder = "Learning programming";
    static {
        TITLE = "xpath://XCUIElementTypeStaticText[@name='Java (programming language)']";
        FOOTER_ELEMENT = "xpath://XCUIElementTypeStaticText[@name='View article in browser']";
        SAVE_BUTTON = "xpath://XCUIElementTypeButton[@name='Save for later']";
        CANCEL_BUTTON = "xpath://XCUIElementTypeStaticText[@name='Cancel']";
      //  PAGE_SAVE_BUTTON = "xpath://*[@resource-id='org.wikipedia:id/page_save']";
       // NAME_OF_FOLDER = "xpath://*[@text='" + name_of_folder + "']";
       // SAVE_ADD_TO_MY_LIST_BUTTON = "xpath://android.widget.Button[@text='ADD TO LIST']";
       // MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input";
        //MY_LIST_OK_BUTTON = "xpath://*[@text='OK']";
        CLOSE_ARTICLE_BUTTON ="xpath://XCUIElementTypeButton[@name='Search']";
       // SNACKBAR_VIEW_LIST_BUTTON = "xpath://*[@resource-id='org.wikipedia:id/snackbar_action'][@text='VIEW LIST']";
    }

    public iOSArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
