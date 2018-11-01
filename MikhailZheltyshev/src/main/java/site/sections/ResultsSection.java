package site.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import jsonPojo.TestData;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class ResultsSection extends Section {

    //=======================================WEB-ELEMENTS AND CONSTANTS=================================================
    @FindBy(css="li")
    private TextList resultsList;

    private final String SUMMARY_ROW_MASK = "Summary: {SUMMARY}";
    private final String ELEMENTS_ROW_MASK = "Elements:{ELEMENTS}";
    private final String COLOR_ROW_MASK = "Color: {COLORS}";
    private final String METAL_ROW_MASK = "Metal: {METALS}";
    private final String VEGETABLES_ROW_MASK = "Vegetables:{VEGETABLES}";

    //==============================================ACTIONS=============================================================
    public List<String> getActual() {
        return resultsList.getTextList();
    }

    public List<String> getExpected(TestData data) {
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
        String metalRow = METAL_ROW_MASK.replace("{METALS}", data.getMetal());
        return Arrays.asList(summaryRow, elementsRow, colorRow, metalRow, vegetablesRow);
    }
}
