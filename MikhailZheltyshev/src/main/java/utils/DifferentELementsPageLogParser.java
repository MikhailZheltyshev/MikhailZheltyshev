package utils;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.AbstractMap;

import static com.codeborne.selenide.Selenide.$;

public class DifferentELementsPageLogParser {

    SelenideElement lastLoggerRecord = $(".logs li:first-child");

    private AbstractMap.SimpleEntry<String,String> loggedNameAndStatus;

    private String elementName;
    private String elementStatus;

    private String[] lastLogRow;

    public void parseLastLogRecord(){
        lastLogRow = lastLoggerRecord.getText().split(" ");
        elementName = lastLogRow[1].replace(":","");
        elementStatus = lastLogRow[5];
        loggedNameAndStatus = new AbstractMap.SimpleEntry<>(elementName,elementStatus);
    }

    public String getElementName() {
        return elementName;
    }

    public String getElementStatus() {
        return elementStatus;
    }
}
