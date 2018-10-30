package utils;

import com.codeborne.selenide.ElementsCollection;
import enums.DIfferentElementsPageCheckBoxes;
import enums.DifferentElementsPageDropDownItems;
import enums.DifferentElementsPageRadioButtons;
import enums.DatesPageSliderTypes;

import static com.codeborne.selenide.Selenide.$$;

@SuppressWarnings("Duplicates")
public class ElementsLogHelper {

    private final String CHECKBOX_RECORD_MASK = "{CHECKBOX_NAME}: condition changed to {STATE}";

    private final String METAL_RECORD_MASK = "metal: value changed to {METAL_NAME}";

    private final String COLOR_RECORD_MASK = "Colors: value changed to {COLOR_NAME}";

    private final String SLIDER_RECORD_MASK = "{SLIDER_NAME}:{SLIDER_POSITION} link clicked";

    private ElementsCollection currentLog;

    private void updateLog() {
        currentLog = $$(".logs li");
    }

    public String getActualLogRecord(int recordIndex) {
        updateLog();
        return currentLog.get(recordIndex).getText().split(" ", 2)[1];
    }

    public String generateExpectedRecord(DIfferentElementsPageCheckBoxes expectedCheckBox, boolean state) {
        return CHECKBOX_RECORD_MASK.replace("{CHECKBOX_NAME}", expectedCheckBox.displayName)
                .replace("{STATE}", String.valueOf(state));
    }

    public String generateExpectedRecord(DifferentElementsPageRadioButtons expectedRadioButton) {
        return METAL_RECORD_MASK.replace("{METAL_NAME}", expectedRadioButton.displayName);
    }

    public String generateExpectedRecord(DifferentElementsPageDropDownItems expectedDropDownItem) {
        return COLOR_RECORD_MASK.replace("{COLOR_NAME}", expectedDropDownItem.displayName);
    }

    public String generateExpectedRecord(DatesPageSliderTypes slider, int expectedPosition) {
        return SLIDER_RECORD_MASK.replace("{SLIDER_NAME}", slider.displayName)
                .replace("{SLIDER_POSITION}", String.valueOf(expectedPosition));
    }
}
