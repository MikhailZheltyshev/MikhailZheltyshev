package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import utils.DifferentElementsLogHelper;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class DifferentELementsPageSelenide {

    //============================================WEB-ELEMENTS AND CONSTANTS============================================

    @FindBy(css = ".label-checkbox")
    ElementsCollection checkBoxElements;

    @FindBy(css = ".label-radio")
    ElementsCollection radioButtonElements;

    @FindBy(css = "select.uui-form-element")
    SelenideElement colorsDropDownMenuElement;

    @FindBy(css= ".colors")
    SelenideElement colorsDropDownMenu;

    @FindBy(css = "[class = 'uui-button']")
    ElementsCollection buttonElements;

    @FindBy(css = ".right-fix-panel")
    SelenideElement rightSectionElement;

    @FindBy(css = "._mCS_1")
    SelenideElement legtSectionElement;

    @FindBy(css = "option")
    ElementsCollection dropDownMenuOptions;

    private final List<String> CHECK_BOXES = Arrays.asList("Water", "Earth", "Wind", "Fire");
    private final List<String> RADIO_BUTTONS = Arrays.asList("Gold", "Silver", "Bronze", "Selen");
    private final List<String> DROP_DOWN_ITEMS = Arrays.asList("Yellow", "Blue", "Green", "Red");

    //==================================================METHODS=========================================================
    public void checkDifferentElementsPageContent(){
        checkBoxElements.shouldHave(size(4));
        radioButtonElements.shouldHave(size(4));
        colorsDropDownMenuElement.shouldBe(visible);
        buttonElements.shouldHave(size(2));
    }

    public void checkRightSectionExists(){
        rightSectionElement.exists();
    }

    public void checkLeftSectionExists(){
        rightSectionElement.exists();
    }

    public void selectWaterAndWindCheckBoxes(){
        checkBoxElements.find(text(CHECK_BOXES.get(0))).click();
        checkBoxElements.find(text(CHECK_BOXES.get(2))).click();
    }

    public void checkWaterAndWindLoggedAsActivated(){
        DifferentElementsLogHelper logParser;
    }

//    public void checkLoggingOfCheckBoxes() {
//        refresh();
//        DifferentElementsLogHelper logParser = new DifferentElementsLogHelper();
//
//        for (String item: CHECK_BOXES) {
//            checkBoxElements.find(Condition.text(item)).click();
//            logParser.parseLastLogRecord();
//            assertEquals(logParser.getElementName(), item);
//            assertEquals(logParser.getElementStatus(),"true");
//
//            checkBoxElements.find(Condition.text(item)).click();
//            logParser.parseLastLogRecord();
//            assertEquals(logParser.getElementName(), item);
//            assertEquals(logParser.getElementStatus(),"false");
//        }
//    }

    public void selectSelenRadioButton() {
        radioButtonElements.find(text(RADIO_BUTTONS.get(3))).click();
    }

//    public void checkLoggingOfRadioButtons() {
//        DifferentElementsLogHelper logParser = new DifferentElementsLogHelper();
//
//        for (String item: RADIO_BUTTONS) {
//            radioButtonElements.find(Condition.text(item)).click();
//            logParser.parseLastLogRecord();
//            assertEquals(logParser.getElementName(), "metal");
//            assertEquals(logParser.getElementStatus(),item);
//
//        }
//    }

    public void selectYellowFromDropDownMenu() {
        colorsDropDownMenu.click();
        dropDownMenuOptions.find(text(DROP_DOWN_ITEMS.get(0))).click();
    }

//    public void checkLoggingOfDropDownMenu() {
//        refresh();
//        DifferentElementsLogHelper logParser = new DifferentElementsLogHelper();
//
//        for (String item:DROP_DOWN_ITEMS) {
//            colorsDropDownMenu.click();
//            colorsDropDownMenuElements.find(Condition.text(item)).click();
//            logParser.parseLastLogRecord();
//            assertEquals(logParser.getElementName(), "Colors");
//            assertEquals(logParser.getElementStatus(),item);
//        }
//    }

}
