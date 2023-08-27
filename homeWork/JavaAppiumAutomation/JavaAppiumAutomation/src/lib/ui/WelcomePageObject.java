package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class WelcomePageObject extends MainPageObject
{
    private static final String
    STEP_START = "id:The free encyclopedia",
    STEP_NEW_WAYS_TO_EXPLORE_TEXT = "id:New ways to explore",
    STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK = "xpath://*[@name='Add or edit preferred languages']",
    STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK = "xpath://*[@name='Learn more about data collected']",
    NEXT_LINK = "xpath://*[@name='Next']",
    GET_STARTED_BUTTON = "xpath://*[@name='Get started']",
    SKIP_IOS = "xpath://XCUIElementTypeStaticText[@name='Skip']",
    SKIP_ANDROID = "xpath://*[contains(@text,'SKIP')]";


    public WelcomePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void waitForLearnMoreLink()
    {
        this.waitForElementPresent(STEP_START, "Cannot find 'The free encyclopedia'", 20);
    }

    public void clickNextButton()
    {
        this.waitForElementAndClick(NEXT_LINK, "Cannot find 'Next'", 10);
    }

    public void clickGetStartedButton()
    {
        this.waitForElementAndClick(GET_STARTED_BUTTON, "Cannot find 'Get started'", 10);
    }

    public void waitNewWaysToExploreText()
    {
        this.waitForElementPresent(STEP_NEW_WAYS_TO_EXPLORE_TEXT, "Cannot find 'New ways to explore'", 10);
    }

    public void waitForAddOrEditPreferredLangText()
    {
        this.waitForElementPresent(STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK, "Cannot find 'Add or edit preferred languages'", 10);
    }

    public void waitForLearnMoreAboutDataCollectedText()
    {
        this.waitForElementPresent(STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK, "Cannot find 'Learn more about data collected'", 10);
    }

    public void clickSkipIOS()
    {
        this.waitForElementAndClick(SKIP_IOS, "Cannot find and click skip button", 10);
    }

    public void clickSkipAndroid()
    {
        this.waitForElementAndClick(SKIP_ANDROID, "Cannot find and click skip button", 10);
    }

}

