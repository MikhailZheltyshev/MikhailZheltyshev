package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.FindBy;
import utils.ElementsLogHelper;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static enums.DIfferentElementsPageCheckBoxes.getCheckBoxEnumByName;
import static enums.DifferentElementsPageDropDownItems.*;
import static enums.DifferentElementsPageRadioButtons.getRadioButtonEnumByName;
import static org.testng.Assert.assertEquals;

public class DifferentElementsPageSelenideCucumber {

    public DifferentElementsPageSelenideCucumber() {
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
    @Then("Interface on Different Elements Page contains all needed elements")
    public void checkDifferentElementsPageContent() {
        checkBoxElements.shouldHave(size(4));
        radioButtonElements.shouldHave(size(4));
        colorsDropDownMenuElement.shouldBe(visible);
        buttonElements.shouldHave(size(2));
    }

    @Then("The right section of the page is displayed")
    public void checkRightSectionExists() {
        rightSectionElement.exists();
    }

    @Then("The left section of the page is displayed")
    public void checkLeftSectionExists() {
        leftSectionElement.exists();
    }

    @When("I select checkboxes:")
    public void selectCheckBoxes(List<String> checkboxes) {
        for (String checkbox : checkboxes) {
            checkBoxElements.find(text(checkbox)).click();
        }
    }

    @When("I un-select checkboxes:")
    public void unselectCheckBoxes(List<String> checkboxes) {
        for (String checkbox : checkboxes) {
            checkBoxElements.find(text(checkbox)).click();
        }
    }

    @Then("Checking of following checkboxes will be properly logged:")
    public void checkLoggingOfCheckBoxesChecked(List<String> checkboxes) {
        for (int i = checkboxes.size() - 1; i >= 0; i--) {
            assertEquals(LOG_PARSER.getActualLogRecord(i),
                    LOG_PARSER.generateExpectedRecord(getCheckBoxEnumByName(checkboxes.get(checkboxes.size() - i - 1))
                            , true));
        }
    }

    @When("I select (.+) radio-button")
    public void selectRadioButton(String radioButton) {
        radioButtonElements.find(text(radioButton)).click();
    }

    @Then("Selecting of (.+) radio-button will be properly logged")
    public void checkLoggingOfRadioButtons(String radioButton) {
        assertEquals(LOG_PARSER.getActualLogRecord(0),
                LOG_PARSER.generateExpectedRecord(getRadioButtonEnumByName(radioButton)));
    }

    @When("I select (.+) item from the Colors Drop Down menu")
    public void selectItemFromDropDownMenu(String item) {
        colorsDropDownMenu.click();
        dropDownMenuOptions.find(text(item)).click();
    }

    @Then("Selecting of (.+) drop down menu item will be properly logged")
    public void checkLoggingOfDropDownMenu(String item) {
        assertEquals(LOG_PARSER.getActualLogRecord(0),
                LOG_PARSER.generateExpectedRecord(getDropDownEnumByName(item)));
    }

    @Then("Un-selecting of following checboxes will be properly logged:")
    public void checkLoggingOfCheckBoxesUnchecked(List<String> checkboxes) {
        for (int i = checkboxes.size() - 1; i >= 0; i--) {
            assertEquals(LOG_PARSER.getActualLogRecord(i),
                    LOG_PARSER.generateExpectedRecord(getCheckBoxEnumByName(checkboxes.get(checkboxes.size() - i - 1))
                            , false));
        }
    }
}
