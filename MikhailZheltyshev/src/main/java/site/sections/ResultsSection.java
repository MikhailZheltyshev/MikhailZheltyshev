package site.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

public class ResultsSection extends Section {

    //=======================================WEB-ELEMENTS AND CONSTANTS=================================================
    @FindBy(css="li")
    public TextList resultsList;
}
