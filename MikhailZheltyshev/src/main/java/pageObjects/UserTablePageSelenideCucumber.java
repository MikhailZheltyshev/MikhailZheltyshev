package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.page;
import static enums.Urls.USER_TABLE_PAGE;
import static org.testng.Assert.assertEquals;

public class UserTablePageSelenideCucumber {

    public UserTablePageSelenideCucumber(){
        page(this);
    }

    //==================================================WEB-ELEMENTS====================================================
    @FindBy(css = "tbody")
    private ElementsCollection userTable;

    @FindBy(css="#user-table select")
    private ElementsCollection userTableDropDowns;

    @FindBy(css="#user-table a")
    private ElementsCollection usersNames;

    @FindBy(css = "#user-table img")
    private ElementsCollection descriptionImages;

    @FindBy(css = "#user-table span")
    private ElementsCollection descriptionTexts;

    @FindBy(css = "#user-table span")
    private ElementsCollection descriptionImagesTexts;

    @FindBy(css = "#user-table input")
    private ElementsCollection descriptionCheckBoxes;

    //======================================================METHODS=====================================================

    @Then("\"User Table\" page is opened")
    public void checkUserTablePageIsOpenned() {
        assertEquals(WebDriverRunner.url(), USER_TABLE_PAGE.url);
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

    @And("(\\d) checkboxes are displayed on Users Table on User Table Page")
    public void checkNumberOfCheckBoxes(int count) {
        descriptionCheckBoxes.shouldHave(size(count));
    }

    @And("(\\d) User names are displayed on Users Table on User Table Page")
    public void checkNumberOfUserNames(int count) {
        descriptionCheckBoxes.shouldHave(size(count));
    }
}