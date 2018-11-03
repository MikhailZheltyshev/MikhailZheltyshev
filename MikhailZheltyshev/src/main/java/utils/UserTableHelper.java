package utils;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class UserTableHelper {

    private SelenideElement userTable = $("tbody");

    private SelenideElement getTableRowByFullName(String fullName) {
        return userTable.$(byText(fullName)).closest("tr");
    }

    public void selectVipCheckBox(String user) {
        getTableRowByFullName(user).$("input").click();
    }

}
