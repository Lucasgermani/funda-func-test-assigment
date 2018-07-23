package pages;

import core.selenium.base.Element;
import org.openqa.selenium.support.FindBy;

public class ResultsPage extends AbstractPage {

    @FindBy(xpath = "//div[@class = 'search-output-result-count']/span")
    private Element resultCount;

    public boolean isAt(){
        return resultCount.isPresent();
    }

    public String getSearchUrl(){
        return getDriver().getCurrentUrl();
    }
}
