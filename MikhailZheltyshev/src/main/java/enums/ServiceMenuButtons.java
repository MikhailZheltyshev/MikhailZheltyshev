package enums;

public enum ServiceMenuButtons {

    SUPPORT("SUPPORT"),
    DATES("DATES"),
    COMPLEX_TABLE("COMPLEX TABLE"),
    SIMPLE_TABLE("SIMPLE TABLE"),
    USER_TABLE("USER TABLE"),
    TABLES_WITH_PAGES("TABLES WITH PAGES"),
    DIFFERENT_ELEMENTS("DIFFERENT ELEMENTS");

    public String name;

    ServiceMenuButtons(String name) {
        this.name = name;
    }

    public static ServiceMenuButtons getButtonByName(String displayName) {
        if (displayName.toUpperCase().equals(SUPPORT.name)) {
            return SUPPORT;
        }
        if (displayName.toUpperCase().equals(DATES.name)) {
            return DATES;
        }
        if (displayName.toUpperCase().equals(COMPLEX_TABLE.name)) {
            return COMPLEX_TABLE;
        }
        if (displayName.toUpperCase().equals(SIMPLE_TABLE.name)) {
            return SIMPLE_TABLE;
        }
        if (displayName.toUpperCase().equals(USER_TABLE.name)) {
            return USER_TABLE;
        }
        if (displayName.toUpperCase().equals(TABLES_WITH_PAGES.name)) {
            return TABLES_WITH_PAGES;
        }
        if (displayName.toUpperCase().equals(DIFFERENT_ELEMENTS.name)) {
            return DIFFERENT_ELEMENTS;
        } else {
            throw new UnsupportedOperationException("Enum wasn't found!");
        }
    }
}