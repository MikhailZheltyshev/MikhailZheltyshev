package utils;

import com.codeborne.selenide.ElementsCollection;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

import static com.codeborne.selenide.Selenide.$$;

public class DifferentElementsLogHelper {

    ElementsCollection currentLog;

    private ArrayDeque<AbstractMap.SimpleEntry<String,String>> loggerStack = new ArrayDeque<>();

    private int previousLogSize = 0;

    private String elementName;
    private String elementStatus;
    private String[] lastLogRow;

    public void updateLog(){
            currentLog = $$(".logs li");
            int index = (currentLog.size() - previousLogSize) - 1;

            while (index >= 0){

                lastLogRow = currentLog.get(index).getText().split(" ");
                elementName = lastLogRow[1].replace(":","");
                elementStatus = lastLogRow[5];

                loggerStack.push(new AbstractMap.SimpleEntry<>(elementName,elementStatus));

                previousLogSize++;
                index--;
            }

    }

    public String getElementName() {
        return elementName;
    }

    public String getElementStatus() {
        return elementStatus;
    }
}
