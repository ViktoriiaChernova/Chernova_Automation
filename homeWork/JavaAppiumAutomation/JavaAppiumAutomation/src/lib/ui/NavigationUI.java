package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject{

    private static final String
    MY_SAVED_TITLES_BUTTON = "xpath://android.widget.FrameLayout[@content-desc='Saved']";

    public NavigationUI(AppiumDriver driver)
    {
        super(driver);
    }
    public void clickSavedInMyList()
    {
        this.waitForElementAndClick(
                MY_SAVED_TITLES_BUTTON,
                "Cannot find button 'Saved'",
                5
        );
    }


}
