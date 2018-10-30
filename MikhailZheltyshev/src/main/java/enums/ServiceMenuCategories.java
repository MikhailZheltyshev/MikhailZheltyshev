package enums;

import java.util.ArrayList;
import java.util.List;

public enum ServiceMenuCategories {

    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX_TABLE("Complex Table"),
    SIMPLE_TABLE("Simple Table"),
    TABLE_WITH_PAGES("Table with pages"),
    DIFFERENT_ELEMENTS("Different elements");

    String displayName;

    ServiceMenuCategories(String name) {
        displayName = name;
    }

    public static List<String> getExpectedCategoriesList() {
        List<String> result = new ArrayList<>();
        for (ServiceMenuCategories category:ServiceMenuCategories.values()) {
            result.add(category.displayName);
        }
        return result;
    }
}
