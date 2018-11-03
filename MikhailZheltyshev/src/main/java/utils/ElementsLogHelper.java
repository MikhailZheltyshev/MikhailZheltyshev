package utils;

import enums.DIfferentElementsPageCheckBoxes;
import enums.DifferentElementsPageDropDownItems;
import enums.DifferentElementsPageRadioButtons;

@SuppressWarnings("Duplicates")
public class ElementsLogHelper extends LogHelperBase {

    private final String CHECKBOX_RECORD_MASK = "{CHECKBOX_NAME}: condition changed to {STATE}";

    private final String METAL_RECORD_MASK = "metal: value changed to {METAL_NAME}";

    private final String COLOR_RECORD_MASK = "Colors: value changed to {COLOR_NAME}";

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
}
