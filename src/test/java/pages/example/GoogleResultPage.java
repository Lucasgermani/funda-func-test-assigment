package pages.example;

import core.selenium.base.Element;
import org.openqa.selenium.support.FindBy;

public class GoogleResultPage {

    @FindBy(id="resultStats")
    private Element resultStats;

    public boolean isAt(){
        return resultStats.isPresent();
    }
}
