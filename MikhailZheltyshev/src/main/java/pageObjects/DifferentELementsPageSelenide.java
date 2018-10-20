package pageObjects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import utils.DifferentELementsPageLogParser;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.refresh;
import static org.testng.Assert.assertEquals;

public class DifferentELementsPageSelenide {

    //============================================WEB-ELEMENTS AND CONSTANTS============================================

    @FindBy(css = ".label-checkbox")
    ElementsCollection checkBoxElements;

    @FindBy(css = ".label-radio")
    ElementsCollection radioButtonElements;

    @FindBy(css = "select.uui-form-element")
    ElementsCollection colorsDropDownMenuElements;

    @FindBy(css= ".colors")
    SelenideElement colorsDropDownMenu;

    @FindBy(css = "[class = 'uui-button']")
    ElementsCollection buttonElements;

    @FindBy(css = ".right-fix-panel")
    SelenideElement rightSectionElement;

    @FindBy(css = "._mCS_1")
    SelenideElement legtSectionElement;

    private final List<String> CHECK_BOXES = Arrays.asList("Water", "Earth", "Wind", "Fire");
    private final List<String> RADIO_BUTTONS = Arrays.asList("Gold", "Silver", "Bronze", "Selen");
    private final List<String> DROP_DOWN_ITEMS = Arrays.asList("Yellow", "Blue", "Green", "Red");

    //==================================================METHODS=========================================================
    public void checkDifferentElementsPageContent(){
        checkBoxElements.shouldHave(CollectionCondition.size(4));
        radioButtonElements.shouldHave(CollectionCondition.size(4));
        colorsDropDownMenuElements.shouldHave(CollectionCondition.size(1));
        buttonElements.shouldHave(CollectionCondition.size(2));
    }

    public void checkRightSectionExists(){
        rightSectionElement.exists();
    }

    public void checkLeftSectionExists(){
        rightSectionElement.exists();
    }

    public void selectWaterAndWindCheckBoxes(){
        checkBoxElements.find(Condition.text(CHECK_BOXES.get(0))).click();
        checkBoxElements.find(Condition.text(CHECK_BOXES.get(2))).click();
    }

    public void checkLoggingOfCheckBoxes() {
        refresh();
        DifferentELementsPageLogParser logParser = new DifferentELementsPageLogParser();

        for (String item: CHECK_BOXES) {
            checkBoxElements.find(Condition.text(item)).click();
            logParser.parseLastLogRecord();
            assertEquals(logParser.getElementName(), item);
            assertEquals(logParser.getElementStatus(),"true");

            checkBoxElements.find(Condition.text(item)).click();
            logParser.parseLastLogRecord();
            assertEquals(logParser.getElementName(), item);
            assertEquals(logParser.getElementStatus(),"false");
        }
    }

    public void selectSelenRadioButton() {
        radioButtonElements.find(Condition.text(RADIO_BUTTONS.get(3))).click();
    }

    public void checkLoggingOfRadioButtons() {
        DifferentELementsPageLogParser logParser = new DifferentELementsPageLogParser();

        for (String item: RADIO_BUTTONS) {
            radioButtonElements.find(Condition.text(item)).click();
            logParser.parseLastLogRecord();
            assertEquals(logParser.getElementName(), "metal");
            assertEquals(logParser.getElementStatus(),item);

        }
    }

    public void selectYellowFromDropDownMenu() {
        colorsDropDownMenuElements.find(Condition.text(DROP_DOWN_ITEMS.get(0))).click();
    }

    public void checkLoggingOfDropDownMenu() {
        refresh();
        DifferentELementsPageLogParser logParser = new DifferentELementsPageLogParser();

        for (String item:DROP_DOWN_ITEMS) {
            colorsDropDownMenu.click();
            colorsDropDownMenuElements.find(Condition.text(item)).click();
            logParser.parseLastLogRecord();
            assertEquals(logParser.getElementName(), "Colors");
            assertEquals(logParser.getElementStatus(),item);
        }
    }

}
