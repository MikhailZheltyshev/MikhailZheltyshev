package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.page;
import static enums.Urls.DIFFERENT_ELEMENTS_PAGE;
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

    public void checkUserTablePageIsOpenned() {
        assertEquals(WebDriverRunner.url(), USER_TABLE_PAGE.url);
    }

    public void checkNumberOfNumberTypeDropDowns() {
        userTableDropDowns.shouldHave(size(6));
    }

    public void checkNumberOfDescriptionImages() {
        descriptionImages.shouldHave(size(6));
    }

    public void checkNumberOfDescriptionTexts() {
        descriptionTexts.shouldHave(size(6));
    }

    public void checkNumberOfCheckBoxes() {
        descriptionCheckBoxes.shouldHave(size(6));
    }
}