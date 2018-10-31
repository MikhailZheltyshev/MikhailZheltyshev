package site.pages;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.complex.ICheckList;
import com.epam.jdi.uitests.core.interfaces.complex.IDropDown;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import enums.jdi.ColorsList;
import enums.jdi.MetalsList;
import enums.jdi.Nature;
import jsonPojo.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import site.sections.Results;
import site.sections.Summary;

import java.util.List;

@JPage(url = "/metals-colors.html", title = "Metal and Colors")
public class MetalAndColorsPageJdi extends WebPage {
    //=======================================WEB-ELEMENTS AND CONSTANTS=================================================
    @FindBy(id = "summary-block")
    private Summary summary;

    @JDropdown(
            jroot = @JFindBy(css = ".colors"),
            jlist = @JFindBy(tagName = "li"),
            jvalue = @JFindBy(css = ".filter-option"))
    private IDropDown<ColorsList> colors;

    @JDropdown(
            jroot = @JFindBy(css = ".metals"),
            jlist = @JFindBy(tagName = "li"),
            jvalue = @JFindBy(css = ".filter-option"),
            jexpand = @JFindBy(css = ".caret"))
    public IDropDown<MetalsList> metals;

    @JDropdown(
            root = @FindBy(id = "salad-dropdown"),
            list = @FindBy(tagName = "li"),
            value = @FindBy(tagName = "button")
    )
    private IDropDown vegetables;

    @FindBy(css = "#elements-checklist p")
    private ICheckList<Nature> nature = new CheckList<Nature>() {
        @Override
        protected boolean isSelectedAction(WebElement el) {
            return el.findElement(By.tagName("input")).getAttribute("checked") != null;
        }
    };

    @FindBy(id = "submit-button")
    private IButton submitBtn;

    private final String DEFAULT_VEGETABLE_ITEM = "Vegetables";

    private final Results RESULT = new Results();

    //=================================================ACTIONS==========================================================
    public void selectVegetables(List<String> salad) {
        if (!salad.contains(DEFAULT_VEGETABLE_ITEM)) {
            vegetables.select(DEFAULT_VEGETABLE_ITEM);
        }
        for (String vegetable : salad) {
            if (vegetable.equals(DEFAULT_VEGETABLE_ITEM)) continue;
            vegetables.select(vegetable);
        }
    }

    public void selectSummary(int... summaryRadios) {
        for (int radio : summaryRadios)
            if (radio % 2 == 0) {
                summary.even.select(String.valueOf(radio));
            } else {
                summary.odds.select(String.valueOf(radio));
            }
    }

    public void selectElements(String... elements) {
        for (String elem : elements) {
            nature.select(elem);
        }
    }

    public void selectColor(String color) {
        colors.select(color);
    }

    public void selectMetal(String metal) {
        metals.select(metal);
    }

    public void clickSubmit() {
        submitBtn.click();
    }

    public List<String> getActualResult() {
        return RESULT.getActualResult();
    }

    public List<String> getExpectedResult(TestData data) {
        return RESULT.getExpectedResult(data);
    }
}


