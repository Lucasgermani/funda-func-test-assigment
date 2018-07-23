package pages;

import bo.RangeFromLocationEnum;
import bo.SearchCriteria;
import bo.SearchTypeEnum;
import core.selenium.base.Element;
import core.selenium.base.ElementExpectations;
import core.selenium.base.StaleElementUtils;
import core.selenium.components.Select;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FundaHomePage extends AbstractPage {

    @FindBy(xpath = "//form[@class = 'search-block__form']")
    private Element searchForm;

    @FindBy(xpath = "//a[@href='/koop/' and @class='search-block__navigation-item']")
    private Element koopTabIdentifier;

    @FindBy(xpath = "//a[@href='/huur/' and @class='search-block__navigation-item']")
    private Element huurTabIdentifier;

    @FindBy(xpath = "//a[@href='/nieuwbouw/' and @class='search-block__navigation-item']")
    private Element nieuwbouwTabIdentifier;

    @FindBy(xpath = "//a[@href='/recreatie/' and @class='search-block__navigation-item']")
    private Element recreatieTabIdentifier;

    @FindBy(xpath = "//a[@href='/europe/' and @class='search-block__navigation-item']")
    private Element europeTabIdentifier;

    @FindBy(name = "filter_location")
    private Element locationInput;

    @FindBy(id = "Straal")
    private Select rangeFromLocationSelect;

    @FindBy(id = "range-filter-selector-select-filter_koopprijsvan")
    private Select minimumValueSelect;

    @FindBy(id = "range-filter-selector-select-filter_koopprijstot")
    private Select maximumValueSelect;

    @FindBy(id = "Land")
    private Select countrySelect;

    @FindBy(xpath = "//button[@type = 'submit']")
    private Element searchBtn;

    public void inputLocation(String location){
        locationInput.type(location);
    }

    public boolean isAt(){
        return searchForm.isPresent();
    }

    public boolean isKoopTabSelected(){
        return tabIsSelected(koopTabIdentifier);
    }

    public void search(SearchCriteria search){
        selectTab(search.getSearchType());

        switch (search.getSearchType()) {
            case KOOP:
                searchKoop(search);
                break;
            case HUUR:
                searchHuur(search);
                break;
            case NIEUWBOUW:
                searchNieuwbouw(search);
                break;
            case RECREATIE:
                searchRecreatie(search);
                break;
            case EUROPE:
                searchEurope(search);
                break;
        }
        searchBtn.click();
    }

    private void searchKoop(SearchCriteria search){
        locationInput.type(search.getLocation());

        if(search.getRangeFromLocation() !=  null){
            selectRange(search.getRangeFromLocation());
        }
        if(search.getMinimumPrice()>0){
            selectMinimumValue(search.getMinimumPrice());
        }
        if(search.getMaximumPrice()>0){
            selectMaximumValue(search.getMaximumPrice());
        }
    }

    private void searchHuur(SearchCriteria search){
        locationInput.type(search.getLocation());

        if(search.getRangeFromLocation() !=  null){
            selectRange(search.getRangeFromLocation());
        }
        if(search.getMinimumPrice()>0){
            selectMinimumValue(search.getMinimumPrice());
        }
        if(search.getMaximumPrice()>0){
            selectMaximumValue(search.getMaximumPrice());
        }
    }

    private void searchNieuwbouw(SearchCriteria search){
        locationInput.type(search.getLocation());

        if(search.getRangeFromLocation() !=  null){
            selectRange(search.getRangeFromLocation());
        }
    }

    private void searchRecreatie(SearchCriteria search){
        locationInput.type(search.getLocation());

        if(search.getRangeFromLocation() !=  null){
            selectRange(search.getRangeFromLocation());
        }
    }

    private void searchEurope(SearchCriteria search){
        countrySelect.selectByValue(search.getCountry().getValue());
    }

    /**
     * Resusable method to identify if a tab is active on the search component
     * @param tabElement
     * @return TRUE if tab is selected
     */
    public boolean tabIsSelected(Element tabElement){
        //backwards search for the first li, if /li[@class='is-active'] than koop is selected
        Element tabIdLi = (Element) tabElement.findElement(By.xpath("/ancestor::li"));
        String tabClass = tabIdLi.getAttribute("class");
        if(tabClass == null && StringUtils.equals(tabClass, "is-active")){
            return false;
        }
        return true;
    }

    private void selectTab(SearchTypeEnum searchType){
        switch (searchType) {
            case KOOP:
                koopTabIdentifier.click();
                koopTabIdentifier.customWaitForCondition(5000, 500)
                        .until(ElementExpectations.elementIsPresent(locationInput));
                break;
            case HUUR:
                huurTabIdentifier.click();
                huurTabIdentifier.customWaitForCondition(5000, 500)
                        .until(ElementExpectations.elementIsPresent(locationInput));
                break;
            case NIEUWBOUW:
                nieuwbouwTabIdentifier.click();
                nieuwbouwTabIdentifier.customWaitForCondition(5000, 500)
                        .until(ElementExpectations.elementIsPresent(locationInput));
                break;
            case RECREATIE:
                recreatieTabIdentifier.click();
                recreatieTabIdentifier.customWaitForCondition(5000, 500)
                        .until(ElementExpectations.elementIsPresent(locationInput));
                break;
            case EUROPE:
                europeTabIdentifier.click();
                europeTabIdentifier.customWaitForCondition(5000, 500)
                        .until(ElementExpectations.elementIsPresent(countrySelect));
                break;
        }
    }

    private void selectRange(RangeFromLocationEnum range){
        rangeFromLocationSelect.selectByValue(range.getValue());
    }

    //@TODO implement custom select for funda's homepage
    private void selectMinimumValue(int minimumValue){
        minimumValueSelect.selectByValue(String.valueOf(minimumValue));
    }
    private void selectMaximumValue(int maximumValue){
        maximumValueSelect.selectByValue(String.valueOf(maximumValue));
    }
}
