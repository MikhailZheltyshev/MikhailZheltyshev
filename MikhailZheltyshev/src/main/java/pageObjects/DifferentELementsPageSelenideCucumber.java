package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.DIfferentElementsPageCheckBoxes;
import enums.DIfferentElementsPageDropDownItems;
import enums.DIfferentElementsPageRadioButtons;
import org.openqa.selenium.support.FindBy;
import utils.ElementsLogHelper;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static enums.DIfferentElementsPageCheckBoxes.getCheckBoxEnumByName;
import static enums.DIfferentElementsPageDropDownItems.getDropDownEnumByName;
import static enums.DIfferentElementsPageRadioButtons.getRadioButtonEnumByName;
import static org.testng.Assert.assertEquals;

public class DifferentELementsPageSelenideCucumber {

    public DifferentELementsPageSelenideCucumber(){
        page(this);
    }

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
    @When("I select (.+) radio-button")
    public void selectSelenRadioButton(String radioButtonName) {
        radioButtonElements.find(text(radioButtonName)).click();
    }

    @Then("Interface on Different Elements Page contains all needed elements")
    public void checkDifferentElementsPageContent() {
        checkBoxElements.shouldHave(size(4));
        radioButtonElements.shouldHave(size(4));
        colorsDropDownMenuElement.shouldBe(visible);
        buttonElements.shouldHave(size(2));
    }

    @When("I select (.+) item from the Colors Drop Down menu")
    public void selectYellowFromDropDownMenu(String dropDownItemName) {
        colorsDropDownMenu.click();
        dropDownMenuOptions.find(text(dropDownItemName)).click();
    }

    @When("I select (.+) and (.+) checkboxes")
    public void selectWaterAndWindCheckBoxes(String firstCheckBox, String secondCheckbox) {
        checkBoxElements.find(text(firstCheckBox)).click();
        checkBoxElements.find(text(secondCheckbox)).click();
    }

    @When("I un-select (.+) and (.+) checkboxes")
    public void unselectWaterAndWindCheckBoxes(String firstCheckBox, String secondCheckBox) {
        checkBoxElements.find(text(firstCheckBox)).click();
        checkBoxElements.find(text(secondCheckBox)).click();
    }

    @Then("The right section of the page is displayed")
    public void checkRightSectionExists() {
        rightSectionElement.exists();
    }

    @Then("The left section of the page is displayed")
    public void checkLeftSectionExists() {
        rightSectionElement.exists();
    }

    @Then("Checking of (.+) and (.+) will be properly logged")
    public void checkLoggingOfCheckBoxesChecked(String firstCheckBoxName, String secondCheckBoxName) {
        assertEquals(LOG_PARSER.getActualLogRecord(1, DIfferentElementsPageCheckBoxes.class),
                LOG_PARSER.generateExpectedRecord(getCheckBoxEnumByName(firstCheckBoxName), true));
        assertEquals(LOG_PARSER.getActualLogRecord(0, DIfferentElementsPageCheckBoxes.class),
                LOG_PARSER.generateExpectedRecord(getCheckBoxEnumByName(secondCheckBoxName), true));
    }

    @Then("Selecting of (.+) radio-button will be properly logged")
    public void checkLoggingOfRadioButtons(String radioButtonName) {
        assertEquals(LOG_PARSER.getActualLogRecord(0, DIfferentElementsPageRadioButtons.class),
                LOG_PARSER.generateExpectedRecord(getRadioButtonEnumByName(radioButtonName)));
    }

    @Then("Selecting of (.+) drop down menu item will be properly logged")
    public void checkLoggingOfDropDownMenu(String dropDownItemName) {
        assertEquals(LOG_PARSER.getActualLogRecord(0, DIfferentElementsPageDropDownItems.class),
                LOG_PARSER.generateExpectedRecord(getDropDownEnumByName(dropDownItemName)));
    }

    @Then("Un-selecting of (.+) and (.+) checboxes will be properly logged")
    public void checkLoggingOfCheckBoxesUnchecked(String firstChecBox, String secondCheckBox) {
        assertEquals(LOG_PARSER.getActualLogRecord(1, DIfferentElementsPageCheckBoxes.class),
                LOG_PARSER.generateExpectedRecord(getCheckBoxEnumByName(firstChecBox), false));
        assertEquals(LOG_PARSER.getActualLogRecord(0, DIfferentElementsPageCheckBoxes.class),
                LOG_PARSER.generateExpectedRecord(getCheckBoxEnumByName(secondCheckBox), false));
    }
}
