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
import static enums.DIfferentElementsPageCheckBoxes.*;
import static enums.DIfferentElementsPageDropDownItems.YELLOW;
import static enums.DIfferentElementsPageRadioButtons.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DifferentELementsPageSelenide {

    //============================================WEB-ELEMENTS AND CONSTANTS============================================

    @FindBy(css = ".label-checkbox")
    ElementsCollection checkBoxElements;

    @FindBy(css = ".label-radio")
    ElementsCollection radioButtonElements;

    @FindBy(css = "select.uui-form-element")
    SelenideElement colorsDropDownMenuElement;

    @FindBy(css = ".colors")
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

    DifferentElementsLogHelper logParser = new DifferentElementsLogHelper();

    //==================================================METHODS=========================================================
    public void checkDifferentElementsPageContent() {
        checkBoxElements.shouldHave(size(4));
        radioButtonElements.shouldHave(size(4));
        colorsDropDownMenuElement.shouldBe(visible);
        buttonElements.shouldHave(size(2));
    }

    public void checkRightSectionExists() {
        rightSectionElement.exists();
    }

    public void checkLeftSectionExists() {
        rightSectionElement.exists();
    }

    public void selectWaterAndWindCheckBoxes() {
        checkBoxElements.find(text(WATER.displayName)).click();
        checkBoxElements.find(text(WIND.displayName)).click();
    }

    public void checkLoggingOfCheckBoxesChecked() {
        assertEquals(logParser.getLogRecord(1).getKey(), WATER.displayName);
        assertEquals(logParser.getLogRecord(1).getValue(), "true");
        assertEquals(logParser.getLogRecord(0).getKey(), WIND.displayName);
        assertEquals(logParser.getLogRecord(0).getValue(), "true");
    }

    public void selectSelenRadioButton() {
        radioButtonElements.find(text(SELEN.displayName)).click();
    }

    public void checkLoggingOfRadioButtons() {
        assertEquals(logParser.getLogRecord(0).getKey(), "metal");
        assertEquals(logParser.getLogRecord(0).getValue(), SELEN.displayName);
    }

    public void selectYellowFromDropDownMenu() {
        colorsDropDownMenu.click();
        dropDownMenuOptions.find(text(YELLOW.displayName)).click();
    }

    public void checkLoggingOfDropDownMenu() {
        assertEquals(logParser.getLogRecord(0).getKey(), "Colors");
        assertEquals(logParser.getLogRecord(0).getValue(), YELLOW.displayName);
    }

    public void unselectWaterAndWindCheckBoxes() {
        checkBoxElements.find(text(WATER.displayName)).click();
        checkBoxElements.find(text(WIND.displayName)).click();
    }

    public void checkLoggingOfCheckBoxesUnchecked() {
        assertEquals(logParser.getLogRecord(1).getKey(), WATER.displayName);
        assertEquals(logParser.getLogRecord(1).getValue(), "false");
        assertEquals(logParser.getLogRecord(0).getKey(), WIND.displayName);
        assertEquals(logParser.getLogRecord(0).getValue(), "false");
    }
}
