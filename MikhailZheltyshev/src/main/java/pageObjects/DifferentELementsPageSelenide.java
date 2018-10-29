package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.DIfferentElementsPageCheckBoxes;
import enums.DIfferentElementsPageDropDownItems;
import enums.DIfferentElementsPageRadioButtons;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import utils.ElementsLogHelper;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static enums.DIfferentElementsPageCheckBoxes.*;
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
    @Step("Select Selen Radio Button")
    public void selectSelenRadioButton() {
        radioButtonElements.find(text(SELEN.displayName)).click();
    }

    @Step("Check interface on Different elements page, it contains all needed elements")
    public void checkDifferentElementsPageContent() {
        checkBoxElements.shouldHave(size(4));
        radioButtonElements.shouldHave(size(4));
        colorsDropDownMenuElement.shouldBe(visible);
        buttonElements.shouldHave(size(2));
    }

    @Step("Select \"Yellow\" drop down item")
    public void selectYellowFromDropDownMenu() {
        colorsDropDownMenu.click();
        dropDownMenuOptions.find(text(YELLOW.displayName)).click();
    }

    @Step("Select \"Water\" and \"Wind\" checkboxes")
    public void selectWaterAndWindCheckBoxes() {
        checkBoxElements.find(text(WATER.displayName)).click();
        checkBoxElements.find(text(WIND.displayName)).click();
    }

    @Step("Select \"Earth\" and \"Fair\" checkboxes to simulate test failure")
    public void selectEartAndFireCheckBoxes() {
        checkBoxElements.find(text(FIRE.displayName)).click();
        checkBoxElements.find(text(EARTH.displayName)).click();
    }

    @Step("Unselect \"Water\" and \"Wind\" checkboxes")
    public void unselectWaterAndWindCheckBoxes() {
        checkBoxElements.find(text(WATER.displayName)).click();
        checkBoxElements.find(text(WIND.displayName)).click();
    }

    @Step("Assert that there is Right Section")
    public void checkRightSectionExists() {
        rightSectionElement.exists();
    }

    @Step("Assert that there is Left Section")
    public void checkLeftSectionExists() {
        leftSectionElement.exists();
    }

    @Step("Assert logging of checking \"Water\" and \"Wind\" is correct")
    public void checkLoggingOfCheckBoxesChecked() {
        assertEquals(LOG_PARSER.getActualLogRecord(1, DIfferentElementsPageCheckBoxes.class),
                LOG_PARSER.generateExpectedRecord(WATER, true));
        assertEquals(LOG_PARSER.getActualLogRecord(0, DIfferentElementsPageCheckBoxes.class),
                LOG_PARSER.generateExpectedRecord(WIND, true));
    }

    @Step("Assert logging of setting \"Selen\" radio button is correct")
    public void checkLoggingOfRadioButtons() {
        assertEquals(LOG_PARSER.getActualLogRecord(0, DIfferentElementsPageRadioButtons.class),
                LOG_PARSER.generateExpectedRecord(SELEN));
    }

    @Step("Assert logging of drop down is correct")
    public void checkLoggingOfDropDownMenu() {
        assertEquals(LOG_PARSER.getActualLogRecord(0, DIfferentElementsPageDropDownItems.class),
                LOG_PARSER.generateExpectedRecord(YELLOW));
    }

    @Step("Assert logging of unchecking \"Water\" and \"Wind\" is correct")
    public void checkLoggingOfCheckBoxesUnchecked() {
        assertEquals(LOG_PARSER.getActualLogRecord(1, DIfferentElementsPageCheckBoxes.class),
                LOG_PARSER.generateExpectedRecord(WATER, false));
        assertEquals(LOG_PARSER.getActualLogRecord(0, DIfferentElementsPageCheckBoxes.class),
                LOG_PARSER.generateExpectedRecord(WIND, false));
    }
}
