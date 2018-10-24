package utils;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.DIfferentElementsPageCheckBoxes;
import enums.DIfferentElementsPageDropDownItems;
import enums.DIfferentElementsPageRadioButtons;
import enums.DatesPageSliderTypes;
import org.openqa.selenium.support.FindBy;

import java.util.AbstractMap;
import java.util.ArrayDeque;

import static com.codeborne.selenide.Selenide.$$;

public class ElementsLogHelper {


    private ElementsCollection currentLog;

    private void updateLog() {
        currentLog = $$(".logs li");
    }

    public AbstractMap.SimpleEntry getLogRecord(int recordIndex) {
        updateLog();
        if (recordIndex <= currentLog.size() && (recordIndex) >= 0) {
            String[] lastLogRow = currentLog.get(recordIndex).getText().split(" ");
            return new AbstractMap.SimpleEntry<>(lastLogRow[1].replace(":", ""), lastLogRow[5]);
        } else {
            return new AbstractMap.SimpleEntry<>("", "");
        }
    }

    public boolean getStateByRecord(int recordIndex, DIfferentElementsPageCheckBoxes checkBox, boolean isChecked) {
        updateLog();
        String[] lastLogRow = currentLog.get(recordIndex).getText().replaceAll(":", "").split(" ");

        return lastLogRow[1].equals(checkBox.displayName) && (Boolean.valueOf(lastLogRow[5]).equals(isChecked));
    }

    public boolean getStateByRecord(int recordIndex, DIfferentElementsPageRadioButtons radioButtonIsSetTo) {
        updateLog();
        String[] lastLogRow = currentLog.get(recordIndex).getText().replaceAll(":", "").split(" ");
        return lastLogRow[1].equals("metal") && (lastLogRow[5].equals(radioButtonIsSetTo.displayName));
    }

    public boolean getStateByRecord(int recordIndex, DIfferentElementsPageDropDownItems itemIsSetTo) {
        updateLog();
        String[] lastLogRow = currentLog.get(recordIndex).getText().replaceAll(":", "").split(" ");
        return lastLogRow[1].equals("Colors") && (lastLogRow[5].equals(itemIsSetTo.displayName));
    }

    public boolean getStateByRecord(int recordIndex, DatesPageSliderTypes sliderType, int expectedPosition) {
        updateLog();
        String[] lastLogRow = currentLog.get(recordIndex).getText().split(" ");
        String[] sliderAndPositionPair = (lastLogRow[1] + " " + lastLogRow[2]).split(":");
        return sliderAndPositionPair[0].equals(sliderType.displayName) && (Integer.parseInt(sliderAndPositionPair[1]) == expectedPosition);
    }

    public boolean getStateByRecordExperemental(int recordIndex, DatesPageSliderTypes sliderType, int expectedPosition) {
        updateLog();
        String[] lastLogRow = currentLog.get(recordIndex).getText().split(" ");
        String[] sliderAndPositionPair = (lastLogRow[1] + " " + lastLogRow[2]).split(":");
        if (!(sliderAndPositionPair[0].equals(sliderType.displayName) && (Integer.parseInt(sliderAndPositionPair[1]) == expectedPosition))){
            throw new AssertionError("Expected log: " + sliderType.displayName + " was set to " + expectedPosition + "\n" +
                    "Actual log: " + sliderAndPositionPair[0] + " was set to " + sliderAndPositionPair[1]);
        } else {
            return true;
        }
    }
}
