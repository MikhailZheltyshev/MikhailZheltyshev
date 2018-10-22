package utils;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.AbstractMap;
import java.util.ArrayDeque;

import static com.codeborne.selenide.Selenide.$$;

public class DifferentElementsLogHelper {


    private ElementsCollection currentLog;

    private void updateLog() {
        currentLog = $$(".logs li");
    }

    public AbstractMap.SimpleEntry getLogRecord(int recordIndex){
        updateLog();
        if (recordIndex <= currentLog.size() && (recordIndex) >= 0){
            String[] lastLogRow = currentLog.get(recordIndex).getText().split(" ");
            return new AbstractMap.SimpleEntry<>(lastLogRow[1].replace(":", ""), lastLogRow[5]);
        } else {
            return new AbstractMap.SimpleEntry<>("","");
        }
    }
}
