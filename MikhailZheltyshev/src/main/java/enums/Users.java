package enums;

public enum Users {

    PITER_CHAILOVSKII("epam", "1234", "PITER CHAILOVSKII");

    public String login;
    public String password;
    public String displayName;

    Users(String login, String password, String displayName) {
        this.login = login;
        this.password = password;
        this.displayName = displayName;
    }
}
