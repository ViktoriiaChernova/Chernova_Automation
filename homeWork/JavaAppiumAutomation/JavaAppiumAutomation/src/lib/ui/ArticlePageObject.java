package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends  MainPageObject
{
    private static final String
    TITLE = "pcs-edit-section-title-description",
    FOOTER_ELEMENT = "//*[@text='View article in browser']",
    SAVE_BUTTON = "//android.widget.TextView[@content-desc='Save']",
    SAVE_ADD_TO_MY_LIST_BUTTON = "//android.widget.Button[@text='ADD TO LIST']",
    MY_LIST_NAME_INPUT = "org.wikipedia:id/text_input",
    MY_LIST_OK_BUTTON = "//*[@text='OK']",
    CLOSE_ARTICLE_BUTTON ="//android.widget.ImageButton[@content-desc='Navigate up']",
    SNACKBAR_VIEW_LIST_BUTTON = "//*[@resource-id='org.wikipedia:id/snackbar_action'][@text='VIEW LIST']";




    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
       return  this.waitForElementPresent(By.id(TITLE), "Cannot find article title on page", 10 );
    }

    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void swipeToFooter()
    {
        this.swipeUpToFindElement(
                By.xpath(FOOTER_ELEMENT),
                "Cannot find the end of article",
                20
        );
    }

    public void addArticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(
                By.xpath(SAVE_BUTTON),
                "Cannot find button 'Save'",
                5
        );

        this.waitForElementAndClick(
                By.xpath(SAVE_ADD_TO_MY_LIST_BUTTON),
                "Cannot find button 'ADD TO LIST'",
                5
        );

        this.waitForElementAndSendKeys(
                By.id(MY_LIST_NAME_INPUT),
                name_of_folder,
                "Cannot put text into articles folder input",
                5
        );

        this.waitForElementAndClick(
                By.xpath(MY_LIST_OK_BUTTON),
                "Cannot find button 'OK'",
                5
        );
    }

    public void addArticleToExistingList(String name_of_folder) {

        this.waitForElementPresent(
                  By.xpath("//*[@resource-id='org.wikipedia:id/page_save']"),
                "Cannot find button 'Save'",
                10
        );
        this.waitForElementAndClick(
                By.xpath(SAVE_BUTTON),
                "Cannot find button 'Save'",
                5
        );

        this.waitForElementAndClick(
                By.xpath(SAVE_ADD_TO_MY_LIST_BUTTON),
                "Cannot find button 'ADD TO LIST'",
                5
        );

        this.waitForElementAndClick(
                By.xpath("//*[@text='" + name_of_folder + "']"),
                "Cannot find saved list",
                5
        );

        this.waitForElementAndClick(
                By.xpath(SNACKBAR_VIEW_LIST_BUTTON),
                "Cannot find saved list",
                5
        );
    }

    public void closeArticle()
    {
        this.waitForElementAndClick(
                By.xpath(CLOSE_ARTICLE_BUTTON),
                "Cannot close article, cannot click back button",
                5
        );
    }
}
