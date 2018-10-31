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

    public static Users getUserByName(String displayName) {
        if (displayName.equals(PITER_CHAILOVSKII.displayName)) {
            return PITER_CHAILOVSKII;
        } else {
            throw new UnsupportedOperationException("Enum wasn't found!");
        }
    }
}
