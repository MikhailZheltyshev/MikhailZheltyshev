package site.pages;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.complex.ICheckList;
import com.epam.jdi.uitests.core.interfaces.complex.IDropDown;
import com.epam.jdi.uitests.core.interfaces.complex.IDropList;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.DropList;
import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropList;
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

import java.util.Arrays;
import java.util.List;

@JPage(url = "/metals-colors.html", title = "Metal and Colors")
public class MetalAndColorsPageJdi extends WebPage {

    @FindBy(id = "summary-block")
    public Summary summary;

    @FindBy(css = ".results")
    public Results results;

    @FindBy(css = ".results li")
    public TextList resultsList;

    @JDropdown(
            jroot = @JFindBy(css = ".colors"),
            jlist = @JFindBy(tagName = "li"),
            jvalue = @JFindBy(css = ".filter-option"))
    public IDropDown<ColorsList> colors;

    @JDropdown(
            jroot = @JFindBy(css = ".metals"),
            jlist = @JFindBy(tagName = "li"),
            jvalue = @JFindBy(css = ".filter-option"),
            jexpand = @JFindBy(css = ".caret"))
    public IDropDown<MetalsList> metals;

    @JDropList(
            jroot = @JFindBy(css = ".form-group.salad"),
            jlist = @JFindBy(tagName = "li"),
            jexpand = @JFindBy(css = ".caret"),
            jvalue = @JFindBy(tagName = "button")
    )
    public IDropList vegetables;

    @JDropList(
            root = @FindBy(id = "salad-dropdown"),
            list = @FindBy(tagName = "li"),
            value = @FindBy(tagName = "button")
    )
    public IDropList saladDL;

    @JDropdown(
            root = @FindBy(id = "salad-dropdown"),
            list = @FindBy(tagName = "li"),
            value = @FindBy(tagName = "button")
    )
    public IDropDown vegetablesL;

    @FindBy(css = ".form-group.salad")
    public DropList salad;

    @JFindBy(id = "salad-dropdown")
    public IButton button;

    @FindBy(css = "#elements-checklist p")
    public ICheckList<Nature> nature = new CheckList<Nature>() {
        @Override
        protected boolean isSelectedAction(WebElement el) {
            return el.findElement(By.tagName("input")).getAttribute("checked") != null;
        }
    };

    @FindBy(id = "submit-button")
    public IButton submitBtn;

    public String getExpectedResultText(TestData data) {
        String summaryRow = "Summary: " + data.getSummary()[0] + data.getSummary()[1];
        String colorRow = "Color: " + data.getColor();
        String metalRow = "Metal: " + data.getMetals();
        String vegetableRow = "Vegetables: " + data.getVegetables()[0];
        return summaryRow +
                colorRow +
                metalRow +
                vegetableRow;
    }

    public List<String> getExpectedResultTextList(TestData data) {
        String summaryRow = "Summary: " + (data.getSummary()[0] + data.getSummary()[1]);
        StringBuilder elementsRow = new StringBuilder("Elements:");
        for (String veg : data.getElements()) {
            elementsRow.append(" ").append(veg).append(",");
        }
        elementsRow = new StringBuilder(elementsRow.substring(0, elementsRow.length() - 1));
        String colorRow = "Color: " + data.getColor();
        String metalRow = "Metal: " + data.getMetals();
        String vegetableRow = "Vegetables: " + "Vegetables";
        return Arrays.asList(summaryRow, elementsRow.toString(), colorRow, metalRow, vegetableRow);
    }
}

