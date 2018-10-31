package site.pages;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.complex.ICheckList;
import com.epam.jdi.uitests.core.interfaces.complex.IDropDown;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
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

import java.util.Arrays;
import java.util.List;

@JPage(url = "/metals-colors.html", title = "Metal and Colors")
public class MetalAndColorsPageJdi extends WebPage {
    //=======================================WEB-ELEMENTS AND CONSTANTS=================================================
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

    @JDropdown(
            root = @FindBy(id = "salad-dropdown"),
            list = @FindBy(tagName = "li"),
            value = @FindBy(tagName = "button")
    )
    public IDropDown vegetables;

    @FindBy(css = "#elements-checklist p")
    public ICheckList<Nature> nature = new CheckList<Nature>() {
        @Override
        protected boolean isSelectedAction(WebElement el) {
            return el.findElement(By.tagName("input")).getAttribute("checked") != null;
        }
    };

    @FindBy(id = "submit-button")
    public IButton submitBtn;

    private final String DEFAULT_VEGETABLE_ITEM = "Vegetables";

    private final String SUMMARY_ROW_MASK = "Summary: {SUMMARY}";
    private final String ELEMENTS_ROW_MASK = "Elements:{ELEMENTS}";
    private final String COLOR_ROW_MASK = "Color: {COLORS}";
    private final String METAL_ROW_MASK = "Metal: {METALS}";
    private final String VEGETABLES_ROW_MASK = "Vegetables:{VEGETABLES}";

    //=================================================ACTIONS==========================================================
    public List<String> getExpectedResultTextList(TestData data) {
        String summaryRow = SUMMARY_ROW_MASK.replace("{SUMMARY}",
                String.valueOf(data.getSummaryOdd() + data.getSummaryEven()));

        StringBuilder elemBuilder = new StringBuilder();
        for (String elem : data.getElements()) {
            elemBuilder.append(" ").append(elem).append(",");
        }

        StringBuilder vegBuilder = new StringBuilder();
        for (String veg : data.getVegetables()) {
            vegBuilder.append(" ").append(veg).append(",");
        }
        String elementsRow = ELEMENTS_ROW_MASK.replace("{ELEMENTS}",
                elemBuilder.substring(0, elemBuilder.length() - 1));
        String vegetablesRow = VEGETABLES_ROW_MASK.replace("{VEGETABLES}",
                vegBuilder.substring(0, vegBuilder.length() - 1));

        String colorRow = COLOR_ROW_MASK.replace("{COLORS}", data.getColor());
        String metalRow = METAL_ROW_MASK.replace("{METALS}", data.getMetals());
        return Arrays.asList(summaryRow, elementsRow, colorRow, metalRow, vegetablesRow);
    }

    public void selectVegetables(String... salad) {
        vegetables.select(DEFAULT_VEGETABLE_ITEM);
        for (String vegetable : salad) {
            vegetables.select(vegetable);
        }
    }
}

