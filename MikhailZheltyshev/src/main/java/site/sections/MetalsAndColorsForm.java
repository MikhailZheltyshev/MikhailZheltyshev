package site.sections;

import com.epam.jdi.uitests.core.interfaces.complex.ICheckList;
import com.epam.jdi.uitests.core.interfaces.complex.IDropDown;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import enums.jdi.ColorsList;
import enums.jdi.MetalsList;
import enums.jdi.Nature;
import jsonPojo.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MetalsAndColorsForm extends Form<TestData> {

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
    private IDropDown<MetalsList> metals;

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
    private Button submitBtn;

    private final String DEFAULT_VEGETABLE_ITEM = "Vegetables";

    //==============================================================ACTIONS==============================================
    @Override
    public void fill(TestData entity) {
        selectSummary(entity.getSummaryOdd(), entity.getSummaryEven());
        selectElements(entity.getElements());
        selectColor(entity.getColor());
        selectMetal(entity.getMetal());
        selectVegetables(entity.getVegetables());
    }

    private void selectVegetables(List<String> salad) {
        if (!salad.contains(DEFAULT_VEGETABLE_ITEM)) {
            vegetables.select(DEFAULT_VEGETABLE_ITEM);
        }
        for (String vegetable : salad) {
            if (vegetable.equals(DEFAULT_VEGETABLE_ITEM)) continue;
            vegetables.select(vegetable);
        }
    }

    private void selectSummary(int... summaryRadios) {
        for (int radio : summaryRadios)
            if (radio % 2 == 0) {
                summary.even.select(String.valueOf(radio));
            } else {
                summary.odds.select(String.valueOf(radio));
            }
    }

    private void selectElements(String... elements) {
        for (String elem : elements) {
            nature.select(elem);
        }
    }

    private void selectColor(String color) {
        colors.select(color);
    }

    private void selectMetal(String metal) {
        metals.select(metal);
    }

    public void submit() {
        submitBtn.click();
    }
}
