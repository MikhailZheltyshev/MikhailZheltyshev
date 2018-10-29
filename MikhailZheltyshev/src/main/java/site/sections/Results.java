package site.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

public class Results extends Section {

    @FindBy(css = ".summ-res")
    public Text summary;
    @FindBy(css = ".col-res")
    public Text colors;
    @FindBy(css = ".met-res")
    public Text metals;
    @FindBy(css = ".sal-res")
    public Text salad;

}
