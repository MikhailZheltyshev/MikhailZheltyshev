package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.support.FindBy;
import utils.UserTableHelper;
import utils.UserTableLogHelper;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.page;
import static enums.Urls.getPageEnumByName;
import static org.testng.Assert.assertEquals;

public class UserTablePageSelenideCucumber {

    public UserTablePageSelenideCucumber() {
        page(this);
    }

    //==================================================WEB-ELEMENTS====================================================
    @FindBy(css = "tbody")
    private ElementsCollection userTable;

    @FindBy(css = "tbody td:nth-child(1)")
    private ElementsCollection userNumbers;

    @FindBy(css = "#user-table select")
    private ElementsCollection userTableDropDowns;

    @FindBy(css = "#user-table a")
    private ElementsCollection usersNames;

    @FindBy(css = "#user-table img")
    private ElementsCollection descriptionImages;

    @FindBy(css = "#user-table span")
    private ElementsCollection descriptionTexts;

    @FindBy(css = "#user-table span")
    private ElementsCollection descriptionImagesTexts;

    @FindBy(css = "#user-table input")
    private ElementsCollection descriptionCheckBoxes;

    private final UserTableHelper TABLE_HELPER = new UserTableHelper();
    private final UserTableLogHelper LOG_PARSER = new UserTableLogHelper();

    //======================================================METHODS=====================================================

    @Then("\"(.+)\" page is opened")
    public void checkPageIsOpened(String pageName) {
        assertEquals(WebDriverRunner.url(), getPageEnumByName(pageName).url);
    }

    @And("(\\d+) NumberType Dropdowns are displayed on Users Table on User Table Page")
    public void checkNumberOfNumberTypeDropDowns(int count) {
        userTableDropDowns.shouldHave(size(count));
    }

    @And("(\\d+) Description images are displayed on Users Table on User Table Page")
    public void checkNumberOfDescriptionImages(int count) {
        descriptionImages.shouldHave(size(count));
    }

    @And("(\\d+) Description texts under images are displayed on Users Table on User Table Page")
    public void checkNumberOfDescriptionTexts(int count) {
        descriptionTexts.shouldHave(size(count));
    }

    @And("(\\d+) checkboxes are displayed on Users Table on User Table Page")
    public void checkNumberOfCheckBoxes(int count) {
        descriptionCheckBoxes.shouldHave(size(count));
    }

    @And("(\\d+) User names are displayed on Users Table on User Table Page")
    public void checkNumberOfUserNames(int count) {
        descriptionCheckBoxes.shouldHave(size(count));
    }

    @And("User table contains following values:")
    public void checkUserTable(DataTable dataTable) {
        List<Map<String, String>> expectedTable = dataTable.asMaps(String.class, String.class);
        for (int i = 0; i < expectedTable.size(); i++) {
            assertEquals(userNumbers.get(i).getText(), expectedTable.get(i).get("Number"));
            assertEquals(usersNames.get(i).getText(), expectedTable.get(i).get("User"));
            assertEquals(descriptionTexts.get(i).getText().replace("\n", " "),
                    expectedTable.get(i).get("Description"));
        }
    }

    @When("I select 'vip' checkbox for \"(.+)\"")
    public void selectVipCheckBoxFor(String fullName) {
        TABLE_HELPER.selectVipCheckBox(fullName);
    }

    @Then("(\\d+) log row has \"(.+)\" text in log section")
    public void checkLogRow(int rowIndex, String expectedText) {
        assertEquals(LOG_PARSER.getActualLogRecord(rowIndex - 1), expectedText);
    }

    @When("I click on dropdown in column Type for user (.+)")
    public void clickOnTypeDropDownFor(String fullName) {
        TABLE_HELPER.openTypeDropDown(fullName);
    }

    @Then("droplist contains values:")
    public void checkDropDownContent(DataTable expectedDropDownContent) {
        assertEquals(TABLE_HELPER.getOpenedDropListContent(),
                expectedDropDownContent.asList());
    }
}