package Tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;
import org.openqa.selenium.By;

public class MyListTests extends CoreTestCase
{
    private static final String name_of_folder = "Learning programming";
    @Test
    public void testSaveFirstArticleToMyList()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();

        if(Platform.getInstance().isAndroid()){
            ArticlePageObject.addArticleToMyList(name_of_folder);
            ArticlePageObject.closeArticle();
            ArticlePageObject.closeArticle();
        } else {
            ArticlePageObject.addArticlesToMySaved();
            ArticlePageObject.closeArticle();
        }

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.clickSavedInMyList();

        MyListsPageObject MyListPageObject = MyListsPageObjectFactory.get(driver);
        if(Platform.getInstance().isiOS()){
            MyListPageObject.closeLogInWindow();
        }

        if (Platform.getInstance().isAndroid()){
            MyListPageObject.openFolderByName(name_of_folder);
        }

        MyListPageObject.swipeByArticleToDelete(article_title);

    }

    @Test
    public void testSaveTwoArticlesToMyList()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();

        if(Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticlesToMySaved();
            ArticlePageObject.closeArticle();
        }

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Appium");
        SearchPageObject.clickByArticleWithSubstring("Automation for Apps");

        if(Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToExistingList(name_of_folder);
        } else {
            ArticlePageObject.addArticlesToMySaved();
            ArticlePageObject.closeArticle();
            NavigationUI NavigationUI = NavigationUIFactory.get(driver);
            NavigationUI.clickSavedInMyList();
        }

        MyListsPageObject MyListPageObject = MyListsPageObjectFactory.get(driver);
        if(Platform.getInstance().isiOS()){
            MyListPageObject.closeLogInWindow();
        }

        MyListPageObject.swipeByArticleToDelete("Java (programming language)");
        SearchPageObject.clickByArticleWithSubstring("Automation for Apps");
        SearchPageObject.assertElementContainsText("Appium");
    }
}
