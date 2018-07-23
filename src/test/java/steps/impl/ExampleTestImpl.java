package steps.impl;

import com.thoughtworks.gauge.Step;
import core.selenium.factory.api.ElementFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import pages.FundaHomePage;
import pages.example.GoogleHomePage;
import pages.example.GoogleResultPage;
import steps.AbstractStep;

public class ExampleTestImpl extends AbstractStep {

    final static Logger logger = LogManager.getLogger(ExampleTestImpl.class);

    @Step("Given I'm acessing google homepage")
    public void givenAcessingGoogleHomePage() {
        Assert.assertTrue("Should be at Google HomePage", googleHomePage().isAt());
    }

    @Step("When I search for <searchInput>")
    public void whenSearchFor(String searchInput) {
        googleHomePage().searchFor(searchInput);
    }

    @Step("Then should led me to result page")
    public void ThenShouldRedirectToResultPage() {
        Assert.assertTrue("Should be at Google Results Page", googleResultPage().isAt());
    }

    @Step("Then should be at funda homepage")
    public void assertThatIsAtFundaHomePage() {
        Assert.assertTrue("Should be at Funda Home Page", fundaHomePage().isAt());
        fundaHomePage().inputLocation("Eindhoven");
    }


    private GoogleHomePage googleHomePage() {
        return ElementFactory.initElements(getDriver(), GoogleHomePage.class);
    }

    private GoogleResultPage googleResultPage() {
        return ElementFactory.initElements(getDriver(), GoogleResultPage.class);
    }

    private FundaHomePage fundaHomePage() {
        return ElementFactory.initElements(getDriver(), FundaHomePage.class);
    }
}
