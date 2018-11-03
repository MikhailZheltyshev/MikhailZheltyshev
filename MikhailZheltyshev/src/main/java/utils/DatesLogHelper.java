package utils;

import enums.DatesPageSliderTypes;

public class DatesLogHelper extends LogHelperBase {

    private final String SLIDER_RECORD_MASK = "{SLIDER_NAME}:{SLIDER_POSITION} link clicked";

    public String generateExpectedRecord(DatesPageSliderTypes slider, int expectedPosition) {
        return SLIDER_RECORD_MASK.replace("{SLIDER_NAME}", slider.displayName)
                .replace("{SLIDER_POSITION}", String.valueOf(expectedPosition));
    }
}
