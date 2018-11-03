package utils;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class LogHelperBase {

    private ElementsCollection currentLog;

    private void updateLog() {
        currentLog = $$(".logs li");
    }

    public String getActualLogRecord(int recordIndex) {
        updateLog();
        return currentLog.get(recordIndex).getText().split(" ", 2)[1];
    }
}
