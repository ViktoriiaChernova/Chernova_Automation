
import lib.CoreTestCase;
import lib.ui.*;
import org.junit.Test;
import org.openqa.selenium.By;


import java.util.List;

public class FirstTest extends CoreTestCase {

    private MainPageObject MainPageObject;
    protected void setUp() throws Exception
    {
        super.setUp();
        MainPageObject = new MainPageObject(driver);
    }

    @Test
    public void testElementContaisText()
    {
        MainPageObject.assertElementHasText(
                By.xpath("//*[@class='android.widget.TextView']"),
                "Search Wikipedia",
                "Element does not contain expected text"

        );
    }

    @Test
    public void testSearchTitleAndCancelSearch()
    {
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find search input",
                5
        );

        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "apple",
                "Cannot send keys",
                5
        );
        MainPageObject.waitForElementPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_description'][@text='Fruit that grows on a tree']"),
                "Cannot find 'Fruit that grows on a tree'",
                15
        );
        MainPageObject.waitForElementPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_description'][@text='American multinational technology corporation']"),
                "Cannot find 'American multinational technology corporation'",
                15
        );
        MainPageObject.waitForElementAndClick(
                By.id("Clear query"),
                "Cannot clear query",
                5
        );
        MainPageObject.waitForElementNotPresent(
                By.xpath("//*[@text='American multinational technology corporation']"),
                "Search result is still present on the page",
                5
        );

    }

    @Test
    public void testSearchTitleContainsWord()
    {
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find search input",
                5
        );

        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "apple",
                "Cannot send keys",
                5
        );
        MainPageObject.checkElementHasWord(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title']"),
                "Apple",
                "Element does not contain expected word"
        );

    }



    @Test
    public void testSaveTwoArticlesToMyList() {
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find search input",
                5
        );

        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Java",
                "Cannot send keys",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find search input",
                5
        );
        MainPageObject.waitForElementPresent(
                By.id("pcs-edit-section-title-description"),
                "Cannot find article title description",
                15
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.TextView[@content-desc='Save']"),
                "Cannot find button 'Save'",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.Button[@text='ADD TO LIST']"),
                "Cannot find button 'ADD TO LIST'",
                5
        );

        String name_of_folder = "Learning programming";
        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                name_of_folder,
                "Cannot put text into articles folder input",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='OK']"),
                "Cannot find button 'OK'",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find search input",
                5
        );

        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Appium",
                "Cannot send keys",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='Automation for Apps']"),
                "Cannot choose 'Appium' article",
                5
        );

        MainPageObject.waitForElementPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_save']"),
                "Cannot find button 'Save'",
                10
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='Save']"),
                "Cannot find button 'Save'",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.Button[@text='ADD TO LIST']"),
                "Cannot find button 'ADD TO LIST'",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='" + name_of_folder +"']"),
                "Cannot find saved list",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/snackbar_action'][@text='VIEW LIST']"),
                "Cannot find saved list",
                5
        );

        MainPageObject.swipeElementToLeft(
                By.xpath("//*[@text='Java (programming language)']"),
                "Cannot find saved article"
        );

        MainPageObject.waitForElementNotPresent(
                By.xpath("//*[@text='Java (programming language']"),
                "Cannot delete saved article",
                5
        );

        MainPageObject.waitForElementPresent(
                By.xpath("//*[@text='Automation for Apps']"),
                "Cannot find 'Appium' article",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='Automation for Apps']"),
                "Cannot find 'Appium' article",
                1
        );
        MainPageObject.assertElementHasText(
                By.id("pcs-edit-section-title-description"),
                "Automation for Apps",
                "Cannot find 'Appium' article description"
        );

    }
    @Test
    public void testCheckArticleTitle()
    {
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find search input",
                5
        );

        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Java",
                "Cannot send keys",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find search input",
                5
        );

        MainPageObject.waitForElementAndGetAttribute(
                By.id("pcs-edit-section-title-description"),
                "text",
                "didn't find title",
                5
        );

        MainPageObject.assertElementPresent(
                By.id("pcs-edit-section-title-description"),
                "We didn't find results by request "
        );
    }




}
