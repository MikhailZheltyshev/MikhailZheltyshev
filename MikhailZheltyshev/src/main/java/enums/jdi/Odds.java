package enums.jdi;

public enum Odds {
    ONE("1"), THREE("3"), FIVE("5"), SEVEN("7");

    public String value;

    Odds(String value) {
        this.value = value;
    }
}
