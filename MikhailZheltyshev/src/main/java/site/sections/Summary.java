package site.sections;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.web.selenium.elements.complex.Selector;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import enums.jdi.Even;
import enums.jdi.Odds;
import org.openqa.selenium.support.FindBy;

public class Summary extends Section {
    //=======================================WEB-ELEMENTS AND CONSTANTS=================================================
    @FindBy(css = "#odds-selector p")
    Selector<Odds> odds;

    @FindBy(css = "#even-selector p")
    Selector<Even> even;

    @FindBy(id = "calculate-button")
    public IButton calculate;

    //================================================ACTIONS===========================================================

    public void select(int value) {
        if (value % 2 == 0) {
            odds.select(String.valueOf(value));
        } else {
            even.select(String.valueOf(value));
        }
    }
}
