package steps.impl;

import bo.RangeFromLocationEnum;
import bo.SearchCriteria;
import bo.SearchTypeEnum;
import br.SearchCriteriaURLBuilder;
import com.thoughtworks.gauge.Step;
import core.selenium.factory.api.ElementFactory;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import pages.FundaHomePage;
import pages.ResultsPage;
import steps.AbstractStep;
import utils.DataStoreHelper;

public class FundaHomePageStepImpl extends AbstractStep {

    private static final String CRITERIA = "CRITERIA";
    private SearchCriteriaURLBuilder urlBuilder = new SearchCriteriaURLBuilder();


    @Step("Given I am at funda homepage")
    public void givenIAmAtFundaHomePage() {
        if(fundaHomePage().isAt()){
            getDriver().get("https://www.funda.nl/");
        }
        Assert.assertTrue("Should be at Funda Home Page", fundaHomePage().isAt());
    }

    @Step("Than default active tab at search component should be Koop")
    public void defaultActiveTabShouldBeKoop() {
        Assert.assertTrue("Default active tab at search component should be Koop", fundaHomePage().isKoopTabSelected());
    }

    @Step("Search in <searchType> for location = <location>")
    public void searchForLocation(SearchTypeEnum searchType, String location) {
        Assert.assertFalse("For search for location in Europe Tab, should search for country",
                searchType == SearchTypeEnum.EUROPE);

        SearchCriteria criteria =  new SearchCriteria(searchType, location);

        fundaHomePage().search(criteria);
        DataStoreHelper.getScenarioDataStore().put(CRITERIA, criteria);
    }

    @Step("Search in <searchType> for location  = <location> and minimum price of <minimumPrice>")
    public void searchForLocationAndMinimumPrice(SearchTypeEnum searchType, String location, int minimumPrice) {
        Assert.assertFalse("For search for location in Europe Tab, should search for country",
                searchType == SearchTypeEnum.EUROPE);

        SearchCriteria criteria =  new SearchCriteria(searchType, location);
        criteria.setMinimumPrice(minimumPrice);

        fundaHomePage().search(criteria);
        DataStoreHelper.getScenarioDataStore().put(CRITERIA, criteria);
    }


    @Step("Search in <searchType> for location  = <location> and maximum price of <maximumPrice>")
    public void searchForLocationAndMaximumPrice(SearchTypeEnum searchType, String location, int maximumPrice) {
        Assert.assertFalse("For search for location in Europe Tab, should search for country",
                searchType == SearchTypeEnum.EUROPE);

        SearchCriteria criteria =  new SearchCriteria(searchType, location);
        criteria.setMinimumPrice(maximumPrice);

        fundaHomePage().search(criteria);
        DataStoreHelper.getScenarioDataStore().put(CRITERIA, criteria);
    }

    @Step("Search in <searchType> for location  = <location> and minimum price of <minimumPrice> and maximum price of <maximumPrice>")
    public void searchForLocationAndMinimumAndMaximumPrice(SearchTypeEnum searchType, String location, int minimumPrice, int maximumPrice) {
        Assert.assertFalse("For search for location in Europe Tab, should search for country",
                searchType == SearchTypeEnum.EUROPE);

        SearchCriteria criteria =  new SearchCriteria(searchType, location);
        criteria.setMinimumPrice(minimumPrice);
        criteria.setMaximumPrice(maximumPrice);

        fundaHomePage().search(criteria);
        DataStoreHelper.getScenarioDataStore().put(CRITERIA, criteria);
    }

    @Step("Search in <searchType> for location  = <location> and range of <range>")
    public void searchForLocationAndMinimumAndMaximumPrice(SearchTypeEnum searchType, String location, RangeFromLocationEnum range) {
        Assert.assertFalse("For search for location in Europe Tab, should search for country",
                searchType == SearchTypeEnum.EUROPE);

        SearchCriteria criteria =  new SearchCriteria(searchType, location);
        criteria.setRangeFromLocation(range);

        fundaHomePage().search(criteria);
        DataStoreHelper.getScenarioDataStore().put(CRITERIA, criteria);
    }

    @Step("Search in <searchType> for location  = <location> and minimum price of <minimumPrice> " +
            "and maximum price of <maximumPrice> and in a range of <range>")
    public void searchForLocationAndMinimumAndMaximumPriceAndRange(SearchTypeEnum searchType, String location,
                                                           int minimumPrice, int maximumPrice, RangeFromLocationEnum range) {

        Assert.assertFalse("For search for location in Europe Tab, should search for country",
                searchType == SearchTypeEnum.EUROPE);

        SearchCriteria criteria = new SearchCriteria(searchType, location);
        criteria.setMinimumPrice(minimumPrice);
        criteria.setMaximumPrice(maximumPrice);
        criteria.setRangeFromLocation(range);

        fundaHomePage().search(criteria);
        DataStoreHelper.getScenarioDataStore().put(CRITERIA, criteria);
    }

    @Step("Validate Search URL based on search criteria")
    public void validateSearchUrl() {
        Assert.assertTrue("Should be at Results Page", resultsPage().isAt());

        SearchCriteria criteria = (SearchCriteria) DataStoreHelper.getScenarioDataStore().get(CRITERIA);

        String expectedURL = SearchCriteriaURLBuilder.build(criteria);
        String currentSearchURL = resultsPage().getSearchUrl();

        Assert.assertTrue(String.format("Results Page URL should contains '%s', but is actually = '%s'", expectedURL, currentSearchURL),
                StringUtils.contains(currentSearchURL, expectedURL));
    }

    private FundaHomePage fundaHomePage() {
        return ElementFactory.initElements(getDriver(), FundaHomePage.class);
    }

    private ResultsPage resultsPage() {
        return ElementFactory.initElements(getDriver(), ResultsPage.class);
    }
}
