package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.DIfferentElementsPageCheckBoxes;
import enums.DIfferentElementsPageDropDownItems;
import enums.DIfferentElementsPageRadioButtons;
import org.openqa.selenium.support.FindBy;
import utils.ElementsLogHelper;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static enums.DIfferentElementsPageCheckBoxes.WATER;
import static enums.DIfferentElementsPageCheckBoxes.WIND;
import static enums.DIfferentElementsPageDropDownItems.YELLOW;
import static enums.DIfferentElementsPageRadioButtons.SELEN;
import static org.testng.Assert.assertEquals;

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
    SelenideElement leftSectionElement;

    @FindBy(css = "option")
    ElementsCollection dropDownMenuOptions;

    private final ElementsLogHelper LOG_PARSER = new ElementsLogHelper();

    //==================================================METHODS=========================================================
    public void selectSelenRadioButton() {
        radioButtonElements.find(text(SELEN.displayName)).click();
    }

    public void checkDifferentElementsPageContent() {
        checkBoxElements.shouldHave(size(4));
        radioButtonElements.shouldHave(size(4));
        colorsDropDownMenuElement.shouldBe(visible);
        buttonElements.shouldHave(size(2));
    }

    public void selectYellowFromDropDownMenu() {
        colorsDropDownMenu.click();
        dropDownMenuOptions.find(text(YELLOW.displayName)).click();
    }

    public void selectWaterAndWindCheckBoxes() {
        checkBoxElements.find(text(WATER.displayName)).click();
        checkBoxElements.find(text(WIND.displayName)).click();
    }

    public void unselectWaterAndWindCheckBoxes() {
        checkBoxElements.find(text(WATER.displayName)).click();
        checkBoxElements.find(text(WIND.displayName)).click();
    }

    public void checkRightSectionExists() {
        rightSectionElement.exists();
    }

    public void checkLeftSectionExists() {
        rightSectionElement.exists();
    }

    public void checkLoggingOfCheckBoxesChecked() {
        assertEquals(LOG_PARSER.getActualLogRecord(1, DIfferentElementsPageCheckBoxes.class),
                LOG_PARSER.generateExpectedRecord(WATER, true));
        assertEquals(LOG_PARSER.getActualLogRecord(0, DIfferentElementsPageCheckBoxes.class),
                LOG_PARSER.generateExpectedRecord(WIND, true));
    }

    public void checkLoggingOfRadioButtons() {
        assertEquals(LOG_PARSER.getActualLogRecord(0, DIfferentElementsPageRadioButtons.class),
                LOG_PARSER.generateExpectedRecord(SELEN));
    }

    public void checkLoggingOfDropDownMenu() {
        assertEquals(LOG_PARSER.getActualLogRecord(0, DIfferentElementsPageDropDownItems.class),
                LOG_PARSER.generateExpectedRecord(YELLOW));
    }

    public void checkLoggingOfCheckBoxesUnchecked() {
        assertEquals(LOG_PARSER.getActualLogRecord(1, DIfferentElementsPageCheckBoxes.class),
                LOG_PARSER.generateExpectedRecord(WATER, false));
        assertEquals(LOG_PARSER.getActualLogRecord(0, DIfferentElementsPageCheckBoxes.class),
                LOG_PARSER.generateExpectedRecord(WIND, false));
    }
}
