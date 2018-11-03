package enums;

public enum Urls {

    HOME_PAGE("Home Page", "https://epam.github.io/JDI/index.html"),
    JDI_GITHUB_PAGE("epam/JDI: JDI is the test Framework for UI test automation", "https://github.com/epam/JDI"),
    DIFFERENT_ELEMENTS_PAGE("Different Elements", "https://epam.github.io/JDI/different-elements.html"),
    DATES_PAGE("Dates", "https://epam.github.io/JDI/dates.html"),
    USER_TABLE_PAGE("User Table", "https://epam.github.io/JDI/user-table.html");


    public String title;
    public String url;

    Urls(String pageTitle, String link) {
        title = pageTitle;
        url = link;
    }

    public static Urls getPageEnumByName(String displayName) {
        if (displayName.equals(HOME_PAGE.title)) {
            return HOME_PAGE;
        }
        if (displayName.equals(JDI_GITHUB_PAGE.title)) {
            return JDI_GITHUB_PAGE;
        }
        if (displayName.equals(DIFFERENT_ELEMENTS_PAGE.title)) {
            return DIFFERENT_ELEMENTS_PAGE;
        }
        if (displayName.equals(DATES_PAGE.title)) {
            return DATES_PAGE;
        }
        if (displayName.equals(USER_TABLE_PAGE.title)) {
            return USER_TABLE_PAGE;
        } else {
            throw new UnsupportedOperationException("Enum wasn't found!");
        }
    }
}