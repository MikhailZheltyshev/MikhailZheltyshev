package utils;

import com.codeborne.selenide.ElementsCollection;
import enums.DIfferentElementsPageCheckBoxes;
import enums.DifferentElementsPageDropDownItems;
import enums.DifferentElementsPageRadioButtons;
import enums.DatesPageSliderTypes;

import static com.codeborne.selenide.Selenide.$$;

public class ElementsLogHelper {

    private ElementsCollection currentLog;

    private void updateLog() {
        currentLog = $$(".logs li");
    }

    public String getActualLogRecord(int recordIndex, Class elementType) {
        updateLog();
        String[] lastLogRow;
        if (elementType == DIfferentElementsPageCheckBoxes.class) {
            lastLogRow = currentLog.get(recordIndex).getText().replaceAll(":", "").split(" ");
            return lastLogRow[1] + ": condition changed to " + lastLogRow[5];
        } else if (elementType == DifferentElementsPageRadioButtons.class) {
            lastLogRow = currentLog.get(recordIndex).getText().replaceAll(":", "").split(" ");
            return "metal: value changed to " + lastLogRow[5];
        } else if (elementType == DifferentElementsPageDropDownItems.class) {
            lastLogRow = currentLog.get(recordIndex).getText().replaceAll(":", "").split(" ");
            return "Colors: value changed to " + lastLogRow[5];
        } else if (elementType == DatesPageSliderTypes.class) {
            lastLogRow = currentLog.get(recordIndex).getText().split(" ");
            String[] sliderAndPositionPair = (lastLogRow[1] + " " + lastLogRow[2]).split(":");
            return sliderAndPositionPair[0] + ":" + sliderAndPositionPair[1] + " link clicked";
        }
        throw new UnsupportedOperationException("Element type is not supported");
    }

    public String generateExpectedRecord(DIfferentElementsPageCheckBoxes expectedCheckBox, boolean state) {
        return expectedCheckBox.displayName + ": condition changed to " + state;
    }

    public String generateExpectedRecord(DifferentElementsPageRadioButtons expectedRadioButton) {
        return "metal: value changed to " + expectedRadioButton.displayName;
    }

    public String generateExpectedRecord(DifferentElementsPageDropDownItems expectedDropDownItem) {
        return "Colors: value changed to " + expectedDropDownItem.displayName;
    }

    public String generateExpectedRecord(DatesPageSliderTypes slider, int expectedPosition) {
        return slider.displayName + ":" + expectedPosition + " link clicked";
    }
}
