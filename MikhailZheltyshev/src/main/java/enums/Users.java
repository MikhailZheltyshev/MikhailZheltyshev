package enums;

public enum Users {

    PITER_CHAILOVSKII("epam", "1234");

    public String login;
    public String password;

    Users(String name, String pwd) {
        login = name;
        password = pwd;
    }
}
