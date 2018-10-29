package site.pages;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.complex.ICheckList;
import com.epam.jdi.uitests.core.interfaces.complex.IDropDown;
import com.epam.jdi.uitests.core.interfaces.complex.IDropList;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropList;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import enums.jdi.ColorsList;
import enums.jdi.MetalsList;
import enums.jdi.Nature;
import jsonPojo.DataSet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import site.sections.Results;
import site.sections.Summary;

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
            jroot = @JFindBy(css = ".dropdown.salad"),
            jlist = @JFindBy(tagName = "li"),
            jexpand = @JFindBy(css = ".caret"),
            jvalue = @JFindBy(tagName = "button")
    )
    public IDropList vegetables;

    @FindBy(css = "#elements-checklist p")
    public ICheckList<Nature> nature = new CheckList<Nature>() {
        @Override
        protected boolean isSelectedAction(WebElement el) {
            return el.findElement(By.tagName("input")).getAttribute("checked") != null;
        }
    };

    @JDropList(
            jroot = @JFindBy(xpath = ".form-group.salad"),
            jlist = @JFindBy(tagName = "li"),
            jvalue = @JFindBy(tagName = "button")
    )
    public IDropList saladDL;

    @FindBy(id = "submit-button")
    public IButton submitBtn;

    public String getExpectedResultText(DataSet dataSet){
        return "Summary: " + dataSet.getData_1().getSummary()[0] + dataSet.getData_1().getSummary()[1] + "\n" +
        "Color: " + dataSet.getData_1().getColor() + "\n" +
        "Metal: " + dataSet.getData_1().getMetals() + "\n" +
        "Vegetables: " + dataSet.getData_1().getVegetables()[0];
    }
}

