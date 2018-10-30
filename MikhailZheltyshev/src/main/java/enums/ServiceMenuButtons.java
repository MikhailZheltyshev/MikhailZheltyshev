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
}