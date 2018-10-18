package enums;

public enum Urls {

    MAIN_PAGE("https://epam.github.io/JDI/index.html"),
    JDI_GITHUB_PAGE("https://github.com/epam/JDI");


    public String url;

    Urls(String link) {
        url = link;
    }
}