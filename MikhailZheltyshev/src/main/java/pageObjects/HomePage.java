package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePage {
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

    public void open(String Url, WebDriver driver) {
        driver.get(Url);
    }

    public void checkTitle(String expectedTitle, WebDriver driver) {
        assertEquals(driver.getTitle(), expectedTitle);
    }

    public void login(String login, String password) {
        profileButton.click();
        this.login.sendKeys(login);
        this.password.sendKeys(password);
        submit.click();
    }

    public void checkLoggedUserName(String expectedName) {
        assertTrue(loggedUserNameElement.isDisplayed());
        assertEquals(loggedUserNameElement.getText(), expectedName);
    }

    public void checkUpperToolbarButtons() {

        assertEquals(upperToolbarItems.size(), 4);
        for (WebElement item : upperToolbarItems) {
            assertTrue(item.isDisplayed());
        }

        assertEquals(upperToolbarItems.get(0).getText(), "HOME");
        assertEquals(upperToolbarItems.get(1).getText(), "CONTACT FORM");
        assertEquals(upperToolbarItems.get(2).getText(), "SERVICE");
        assertEquals(upperToolbarItems.get(3).getText(), "METALS & COLORS");
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
        assertEquals(mainHeaderText, "EPAM FRAMEWORK WISHES…");
        String mainSubHeaderText = mainSubHeader.getText();
        assertEquals(mainSubHeaderText, "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD" +
                " TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION" +
                " ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN" +
                " VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");
    }

    public void checkIframeIsDisplayed() {
        assertTrue(iFrameElement.isDisplayed());
    }

    public void checkEpamLogoInIframe(WebDriver driver) {
        driver.switchTo().frame("iframe");
        assertTrue(epamLogo.isDisplayed());
    }

    public void switchBackToOriginalWindow(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public void checkSubHeaderText() {
        String defaultHeaderText = defaultHeaderElement.getText();
        assertEquals(defaultHeaderText, "JDI GITHUB");
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

    public void close(WebDriver driver) {
        driver.close();
    }
}
