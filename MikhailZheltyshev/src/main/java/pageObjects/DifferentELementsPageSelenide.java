package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import utils.ElementsLogHelper;

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

    private final ElementsLogHelper LOG_PARSER = new ElementsLogHelper();

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
        assertTrue(LOG_PARSER.getStateByRecord(1, WATER, true));
        assertTrue(LOG_PARSER.getStateByRecord(0, WIND, true));
    }

    public void selectSelenRadioButton() {
        radioButtonElements.find(text(SELEN.displayName)).click();
    }

    public void checkLoggingOfRadioButtons() {
        assertTrue(LOG_PARSER.getStateByRecord(0, SELEN));
    }

    public void selectYellowFromDropDownMenu() {
        colorsDropDownMenu.click();
        dropDownMenuOptions.find(text(YELLOW.displayName)).click();
    }

    public void checkLoggingOfDropDownMenu() {
        assertTrue(LOG_PARSER.getStateByRecord(0, YELLOW));
    }

    public void unselectWaterAndWindCheckBoxes() {
        checkBoxElements.find(text(WATER.displayName)).click();
        checkBoxElements.find(text(WIND.displayName)).click();
    }

    public void checkLoggingOfCheckBoxesUnchecked() {
        assertTrue(LOG_PARSER.getStateByRecord(1, WATER, false));
        assertTrue(LOG_PARSER.getStateByRecord(0, WIND, false));
    }
}
