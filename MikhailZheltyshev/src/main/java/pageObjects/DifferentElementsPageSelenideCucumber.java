package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.support.FindBy;
import utils.ElementsLogHelper;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static enums.DIfferentElementsPageCheckBoxes.getCheckBoxEnumByName;
import static enums.DifferentElementsPageDropDownItems.getDropDownEnumByName;
import static enums.DifferentElementsPageRadioButtons.getRadioButtonEnumByName;
import static org.testng.Assert.assertEquals;

public class DifferentElementsPageSelenideCucumber {

    public DifferentElementsPageSelenideCucumber() {
        page(this);
    }

    //============================================WEB-ELEMENTS AND CONSTANTS============================================

    @FindBy(css = ".label-checkbox input")
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
    @And("Interface on Different Elements Page contains all needed elements:")
    public void checkDifferentElementsPageContent(DataTable dataTable) {
        Map<String, Integer> expectedTable = dataTable.asMap(String.class, Integer.class);
        checkBoxElements.shouldHave(size(expectedTable.get("Checkboxes")));
        radioButtonElements.shouldHave(size(expectedTable.get("Radios")));
        colorsDropDownMenuElement.shouldBe(visible);
        buttonElements.shouldHave(size(expectedTable.get("Buttons")));
    }

    @And("The right section of the page is displayed")
    public void checkRightSectionExists() {
        rightSectionElement.exists();
    }

    @And("The left section of the page is displayed")
    public void checkLeftSectionExists() {
        leftSectionElement.exists();
    }

    @When("I set following checkboxes to (.+):")
    public void selectCheckBoxes(String targetState, List<String> checkboxes) {
        for (String checkbox : checkboxes) {
            selectCheckBox(Boolean.valueOf(targetState), checkbox);
        }
    }

    @Then("Setting of the following checkboxes to (.+) will be properly logged:")
    public void checkLoggingOfCheckBoxes(String expectedState, List<String> checkboxes) {
        for (int i = checkboxes.size() - 1; i >= 0; i--) {
            assertEquals(LOG_PARSER.getActualLogRecord(i),
                    LOG_PARSER.generateExpectedRecord(getCheckBoxEnumByName(checkboxes.get(checkboxes.size() - i - 1)),
                            Boolean.valueOf(expectedState)));
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

    private void selectCheckBox(boolean targetState, String checkbox) {
        for (SelenideElement element : checkBoxElements) {
            if (element.parent().getText().equals(getCheckBoxEnumByName(checkbox).displayName))
                element.setSelected(targetState);
        }
    }
}
