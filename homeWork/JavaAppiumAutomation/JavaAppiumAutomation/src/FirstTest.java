
import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MainPageObject;
import lib.ui.SearchPageObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FirstTest extends CoreTestCase {

    private MainPageObject MainPageObject;
    protected void setUp() throws Exception
    {
        super.setUp();
        MainPageObject = new MainPageObject(driver);
    }

    @Test
    public void testSearch()
    {

       SearchPageObject SearchPageObject = new SearchPageObject(driver);

       SearchPageObject.initSearchInput();
       SearchPageObject.typeSearchLine("Java");
       SearchPageObject.waitForSearchResult("Object-oriented programming language");

    }

    @Test
    public void testCancelSearch()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonToDisappear();

    }

    @Test
    public void testCompareArticleTitle()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        String description_title = ArticlePageObject.getArticleTitle();

       Assert.assertEquals(
                "Unexpected title!",
                "Object-oriented programming language",
                description_title
        );
    }

    @Test
    public void testSwipeArticle()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Appium");
        SearchPageObject.clickByArticleWithSubstring("Automation for Apps");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.swipeToFooter();
    }

    @Test
    public void testSaveFirstArticleToMyList()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();
        String name_of_folder = "Learning programming";
        ArticlePageObject.addArticleToMyList(name_of_folder);





        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close article, cannot click back button",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close article, cannot click back button",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.FrameLayout[@content-desc='Saved']"),
                "Cannot find button 'Saved'",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='" + name_of_folder +"']"),
                "Cannot find saved list",
                5
        );

        MainPageObject.swipeElementToLeft(
                By.xpath("//*[@text='Java (programming language)']"),
                "Cannot find saved article"
        );
        MainPageObject.waitForElementNotPresent(
                 By.xpath("//*[@text='Java (programming language)']"),
                 "Cannot delete saved article",
                 5
         );
    }

    @Test
    public void testAmountOfNotEmptySearch()
    {
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find search input",
                5
        );
        String search_line = "Linkin Park Discography";
        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                search_line,
                "Cannot send keys",
                5
        );

        String search_result_locator = "//*[@resource-id='org.wikipedia:id/search_results_list']//*[@resource-id='org.wikipedia:id/page_list_item_title']";
        MainPageObject.waitForElementPresent(
                By.xpath(search_result_locator),
                "Cannot find anything by the request" + search_line,
                15
        );
        int amount_of_search_results = MainPageObject.getAmountOfElements(
                By.xpath(search_result_locator)
        );

        Assert.assertTrue(
                "We found too few results!",
                amount_of_search_results > 0
        );

    }

    @Test
    public void testAmountOfEmptySearch()
    {
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find search input",
                5
        );

        String search_line = "fdhjfhfhhffh";
        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                search_line,
                "Cannot send keys",
                5
        );
        String search_result_locator = "//*[@resource-id='org.wikipedia:id/search_results_list']//*[@resource-id='org.wikipedia:id/page_list_item_title']";
        String empty_result_label = "//*[@text='No results']";

        MainPageObject.waitForElementPresent(
              By.xpath(empty_result_label),
                "Cannot find empty result label by the request" + search_line,
                15
        );

        MainPageObject.assertElementNotPresent(
                By.xpath(search_result_locator),
                "We've found some results by request " + search_line
        );
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
    public void testChangeScreenOrientationOnSearchResults()
    {
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find search input",
                5
        );
        String search_line = "Java";
        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                search_line,
                "Cannot send keys",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find 'Object-oriented programming language' topic searching by " + search_line,
                15
        );

        String title_before_rotation = MainPageObject.waitForElementAndGetAttribute(
                By.id("pcs-edit-section-title-description"),
                "text",
                "Cannot find title of article",
                15
        );

        driver.rotate(ScreenOrientation.LANDSCAPE);

        String title_after_rotation = MainPageObject.waitForElementAndGetAttribute(
                By.id("pcs-edit-section-title-description"),
                "text",
                "Cannot find title of article",
                15
        );

        Assert.assertEquals(
                "Article title have been changed after screen rotation",
                title_before_rotation,
                title_after_rotation
        );

        driver.rotate(ScreenOrientation.PORTRAIT);

        String title_after_second_rotation = MainPageObject.waitForElementAndGetAttribute(
                By.id("pcs-edit-section-title-description"),
                "text",
                "Cannot find title of article",
                15
        );

        Assert.assertEquals(
                "Article title have been changed after screen rotation",
                title_before_rotation,
                title_after_second_rotation
        );


    }

    @Test
    public void testCheckSearchArticleInBackground()
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

        MainPageObject.waitForElementPresent(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find search input",
                5
        );

        driver.runAppInBackground(2);

        MainPageObject.waitForElementPresent(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find article after returning from background",
                5
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
