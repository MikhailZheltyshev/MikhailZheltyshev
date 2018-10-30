package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.DIfferentElementsPageCheckBoxes;
import enums.DifferentElementsPageDropDownItems;
import enums.DifferentElementsPageRadioButtons;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import utils.ElementsLogHelper;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static org.testng.Assert.assertEquals;

public class DifferentElementsPageSelenide {

    //============================================WEB-ELEMENTS AND CONSTANTS============================================

    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkBoxElements;

    @FindBy(css = ".label-radio")
    private ElementsCollection radioButtonElements;

    @FindBy(css = "select.uui-form-element")
    private SelenideElement colorsDropDownMenuElement;

    @FindBy(css = ".colors")
    private SelenideElement colorsDropDownMenu;

    @FindBy(css = "[class = 'uui-button']")
    private ElementsCollection buttonElements;

    @FindBy(css = ".right-fix-panel")
    private SelenideElement rightSectionElement;

    @FindBy(css = "._mCS_1")
    private SelenideElement leftSectionElement;

    @FindBy(css = "option")
    private ElementsCollection dropDownMenuOptions;

    private final ElementsLogHelper LOG_PARSER = new ElementsLogHelper();

    //==================================================METHODS=========================================================
    @Step("Check interface on Different elements page, it contains all needed elements")
    public void checkDifferentElementsPageContent() {
        checkBoxElements.shouldHave(size(4));
        radioButtonElements.shouldHave(size(4));
        colorsDropDownMenuElement.shouldBe(visible);
        buttonElements.shouldHave(size(2));
    }

    @Step("Select {0} and {1} checkboxes")
    public void selectCheckBoxes(DIfferentElementsPageCheckBoxes... checkboxes) {
        for (DIfferentElementsPageCheckBoxes checkbox : checkboxes) {
            checkBoxElements.find(text(checkbox.displayName)).click();
        }
    }

    @Step("Unselect {0} and {1} checkboxes")
    public void unselectCheckBoxes(DIfferentElementsPageCheckBoxes... checkboxes) {
        for (DIfferentElementsPageCheckBoxes checkbox : checkboxes) {
            checkBoxElements.find(text(checkbox.displayName)).click();
        }
    }

    @Step("Assert logging of checking {0} and {1} is correct")
    public void checkLoggingOfCheckBoxesChecked(DIfferentElementsPageCheckBoxes... checkboxes) {
        for (int i = checkboxes.length - 1; i >= 0; i--) {
            assertEquals(LOG_PARSER.getActualLogRecord(i),
                    LOG_PARSER.generateExpectedRecord(checkboxes[checkboxes.length - i - 1], true));
        }
    }

    @Step("Select {0} Radio Button")
    public void selectRadioButton(DifferentElementsPageRadioButtons radioButton) {
        radioButtonElements.find(text(radioButton.displayName)).click();
    }

    @Step("Assert logging of setting {0} radio button is correct")
    public void checkLoggingOfRadioButtons(DifferentElementsPageRadioButtons radioButton) {
        assertEquals(LOG_PARSER.getActualLogRecord(0),
                LOG_PARSER.generateExpectedRecord(radioButton));
    }

    @Step("Select {0} drop down item")
    public void selectItemFromDropDownMenu(DifferentElementsPageDropDownItems item) {
        colorsDropDownMenu.click();
        dropDownMenuOptions.find(text(item.displayName)).click();
    }

    @Step("Assert that there is Right Section")
    public void checkRightSectionExists() {
        rightSectionElement.exists();
    }

    @Step("Assert that there is Left Section")
    public void checkLeftSectionExists() {
        leftSectionElement.exists();
    }


    @Step("Assert logging of drop down is correct")
    public void checkLoggingOfDropDownMenu(DifferentElementsPageDropDownItems item) {
        assertEquals(LOG_PARSER.getActualLogRecord(0),
                LOG_PARSER.generateExpectedRecord(item));
    }

    @Step("Assert logging of unchecking {0} and {1} is correct")
    public void checkLoggingOfCheckBoxesUnchecked(DIfferentElementsPageCheckBoxes... checkboxes) {
        for (int i = checkboxes.length - 1; i >= 0; i--) {
            assertEquals(LOG_PARSER.getActualLogRecord(i),
                    LOG_PARSER.generateExpectedRecord(checkboxes[checkboxes.length - i - 1], false));
        }
    }
}
