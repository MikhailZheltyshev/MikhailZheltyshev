package utils;

import com.epam.web.matcher.testng.Assert;
import jsonPojo.TestData;

import java.util.Arrays;
import java.util.List;

import static site.JdiExampleSite.metalAndColorsPage;

public class MetalAndColorPageResultsHandler {

    private static final String SUMMARY_ROW_MASK = "Summary: {SUMMARY}";
    private static final String ELEMENTS_ROW_MASK = "Elements: {ELEMENTS}";
    private static final String COLOR_ROW_MASK = "Color: {COLORS}";
    private static final String METAL_ROW_MASK = "Metal: {METALS}";
    private static final String VEGETABLES_ROW_MASK = "Vegetables: {VEGETABLES}";

    //==============================================ACTIONS=============================================================
    private static List<String> getActual() {
        return metalAndColorsPage.results.resultsList.getTextList();
    }

    private static List<String> getExpected(TestData data) {
        String summaryRow = SUMMARY_ROW_MASK.replace("{SUMMARY}",
                String.valueOf(data.getSummaryOdd() + data.getSummaryEven()));
        String elementsRow = ELEMENTS_ROW_MASK.replace("{ELEMENTS}",
                String.join(", ", data.getElements()));
        String vegetablesRow = VEGETABLES_ROW_MASK.replace("{VEGETABLES}",
                String.join(", ", data.getVegetables()));
        String colorRow = COLOR_ROW_MASK.replace("{COLORS}", data.getColor());
        String metalRow = METAL_ROW_MASK.replace("{METALS}", data.getMetal());
        return Arrays.asList(summaryRow, elementsRow, colorRow, metalRow, vegetablesRow);
    }

    public static void checkResult(TestData data) {
        Assert.assertEquals(getActual(), getExpected(data));
    }
}
