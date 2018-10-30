package enums;

public enum Urls {

    HOME_PAGE("https://epam.github.io/JDI/index.html"),
    JDI_GITHUB_PAGE("https://github.com/epam/JDI"),
    DIFFERENT_ELEMENTS_PAGE("https://epam.github.io/JDI/different-elements.html"),
    DATES_PAGE("https://epam.github.io/JDI/dates.html"),
    USER_TABLE_PAGE("https://epam.github.io/JDI/user-table.html");


    public String url;

    Urls(String link) {
        url = link;
    }
}