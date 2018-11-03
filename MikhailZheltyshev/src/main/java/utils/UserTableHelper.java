package utils;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class UserTableHelper {

    private SelenideElement userTable = $("tbody");

    private SelenideElement lastOpenedDropList;

    private SelenideElement getTableRowByFullName(String fullName) {
        return userTable.$(byText(fullName)).closest("tr");
    }

    public void selectVipCheckBox(String user) {
        getTableRowByFullName(user).$("input").click();
    }

    public void openTypeDropDown(String user)  {
        getTableRowByFullName(user).$("select").click();
        lastOpenedDropList = getTableRowByFullName(user).$("select");
    }

    public List<String> getOpenedDropListContent() {
        return lastOpenedDropList.$$("option").texts();
    }

}
