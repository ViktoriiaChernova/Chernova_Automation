package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

public class iOSMyListsPageObject extends MyListsPageObject
{
    static{
        ARTICLE_BY_TITLE_TPL = "xpath://*[@name='{TITLE}']";
        CLOSE_BUTTON_LOG_IN_WINDOW = "xpath://XCUIElementTypeButton[@name='Close']";
    }
    public iOSMyListsPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
