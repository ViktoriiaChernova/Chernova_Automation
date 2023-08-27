package Tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;
import org.openqa.selenium.By;

public class SearchTests extends CoreTestCase {
    @Test
    public void testSearch()
    {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");

    }
    @Test
    public void testCancelSearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonToDisappear();

    }
    @Test
    public void testAmountOfNotEmptySearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "Linkin Park Discography";
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();

        assertTrue(
                "We found too few results!",
                amount_of_search_results > 0
        );

    }
    @Test
    public void testAmountOfEmptySearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "fdhjfhfhhffh";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResultsLabel();
        SearchPageObject.assertThereIsNoResultOfSearch();
    }
    @Test
    public void testElementContainsText()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        String expected_text = "Search Wikipedia";
        SearchPageObject.assertElementContainsText(expected_text);
    }
    @Test
    public void testSearchTitleAndCancelSearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "apple";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForSearchResult("Fruit that grows on a tree");
        SearchPageObject.waitForSearchResult("American multinational technology corporation");
        SearchPageObject.clickClearQuery();
        SearchPageObject.assertThereIsNoResultOfSearch();
    }

    @Test
    public void testSearchTitleContainsWord()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "apple";
        SearchPageObject.typeSearchLine(search_line);
        String expected_word = "Apple";
        SearchPageObject.titleContainsWord(expected_word);
    }
}
