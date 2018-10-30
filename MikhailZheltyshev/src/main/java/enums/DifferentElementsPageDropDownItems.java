package enums;

public enum DifferentElementsPageDropDownItems {
    YELLOW("Yellow"),
    BLUE("Blue"),
    GREEN("Green"),
    RED("Red");

    public String displayName;

    DifferentElementsPageDropDownItems(String name){
        displayName = name;
    }

    public static DifferentElementsPageDropDownItems getDropDownEnumByName(String displayName) {
        if (displayName.equals(YELLOW.displayName)) {
            return YELLOW;
        } else if (displayName.equals(BLUE.displayName)) {
            return BLUE;
        } else if (displayName.equals(GREEN.displayName)) {
            return GREEN;
        } else if (displayName.equals(RED.displayName)) {
            return RED;
        } else {
            throw new UnsupportedOperationException("Enum wasn't found!");
        }
    }

    @Override
    public String toString() {
        return displayName;
    }
}
