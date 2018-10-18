package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePage {

    //==========================================WEB-ELEMENTS AND CONSTANTS==============================================
    @FindBy(css = ".profile-photo")
    private WebElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private WebElement login;

    @FindBy(css = "[id = 'Password']")
    private WebElement password;

    @FindBy(css = ".login [type = 'submit']")
    private WebElement submit;

    @FindBy(css = ".profile-photo span")
    private WebElement loggedUserNameElement;

    @FindBy(css = ".m-l8 > li")
    private List<WebElement> upperToolbarItems;

    @FindBy(css = ".benefit-icon")
    private List<WebElement> benefitIconElements;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> textsUnderIconsElements;

    @FindBy(css = "h3.main-title.text-center")
    private WebElement mainHeaderElement;

    @FindBy(css = ".main-txt.text-center")
    private WebElement mainSubHeader;

    @FindBy(css = "iframe")
    private WebElement iFrameElement;

    @FindBy(css = "img[id='epam_logo']")
    private WebElement epamLogo;

    @FindBy(css = "[class='text-center']")
    private WebElement defaultHeaderElement;

    @FindBy(css = "[class='text-center'] a")
    private WebElement linkToJdiGitHub;

    @FindBy(css = ".uui-side-bar")
    private WebElement navSideBarElement;

    @FindBy(css = "footer")
    private WebElement footerElement;

    private final List<String> EXPECTED_UPPER_BUTTONS_TEXTS = Arrays.asList(
            "HOME",
            "CONTACT FORM",
            "SERVICE",
            "METALS & COLORS"
    );

    private final String EXPECTED_MAIN_HEADER_TEXT = "EPAM FRAMEWORK WISHES…";

    private final String EXPECTED_SUB_HEADER_TEXT = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
            "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD " +
            "EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT " +
            "IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";

    private final String EXPECTED_DEFAULT_HEADER_TEXT = "JDI GITHUB";

    //==================================================METHODS=========================================================
    //==================================================actions=========================================================
    public void open(String Url, WebDriver driver) {
        driver.get(Url);
    }

    public void login(String name, String pwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(pwd);
        submit.click();
    }

    public void switchBackToOriginalWindow(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    //==================================================checks==========================================================
    public void checkTitle(String expectedTitle, WebDriver driver) {
        assertEquals(driver.getTitle(), expectedTitle);
    }

    public void checkLoggedUserName(String expectedName) {
        assertTrue(loggedUserNameElement.isDisplayed());
        assertEquals(loggedUserNameElement.getText(), expectedName);
    }

    public void checkUpperToolbarButtons() {

        assertEquals(upperToolbarItems.size(), 4);
        for (WebElement item : upperToolbarItems) {
            assertTrue(item.isDisplayed());
            assertTrue(EXPECTED_UPPER_BUTTONS_TEXTS.contains(item.getText()));
        }
    }

    public void checkBenefitIcons() {
        assertEquals(benefitIconElements.size(), 4);
        for (WebElement icon : benefitIconElements) {
            assertTrue(icon.isDisplayed());
        }
    }

    public void checkBenefitTexts() {
        assertEquals(textsUnderIconsElements.size(), 4);
        assertEquals(textsUnderIconsElements.get(0).getText(), "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        assertEquals(textsUnderIconsElements.get(1).getText(), "To be flexible and\n" +
                "customizable");
        assertEquals(textsUnderIconsElements.get(2).getText(), "To be multiplatform");
        assertEquals(textsUnderIconsElements.get(3).getText(), "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");
    }

    public void checkMainHeaderText() {
        String mainHeaderText = mainHeaderElement.getText();
        assertEquals(mainHeaderText, EXPECTED_MAIN_HEADER_TEXT);
        String mainSubHeaderText = mainSubHeader.getText();
        assertEquals(mainSubHeaderText, EXPECTED_SUB_HEADER_TEXT);
    }

    public void checkIframeIsDisplayed() {
        assertTrue(iFrameElement.isDisplayed());
    }

    public void checkEpamLogoInIframe(WebDriver driver) {
        driver.switchTo().frame("iframe");
        assertTrue(epamLogo.isDisplayed());
    }

    public void checkSubHeaderText() {
        String defaultHeaderText = defaultHeaderElement.getText();
        assertEquals(defaultHeaderText, EXPECTED_DEFAULT_HEADER_TEXT);
    }

    public void checkJdiLink(String expectedUrl) {
        assertTrue(linkToJdiGitHub.isDisplayed());
        assertEquals(linkToJdiGitHub.getAttribute("href"), expectedUrl);
    }

    public void checkLeftSideBarIsDisplayed() {
        assertTrue(navSideBarElement.isDisplayed());
    }

    public void checkFooterIsDisplayed() {
        assertTrue(footerElement.isDisplayed());
    }
}
