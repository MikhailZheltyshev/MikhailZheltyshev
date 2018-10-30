package enums;

public enum DIfferentElementsPageCheckBoxes {
    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    public final String displayName;

    DIfferentElementsPageCheckBoxes(String name) {
        displayName = name;
    }

    public static DIfferentElementsPageCheckBoxes getCheckBoxEnumByName(String displayName) {
        if (displayName.equals(WATER.displayName)) {
            return WATER;
        } else if (displayName.equals(EARTH.displayName)) {
            return EARTH;
        } else if (displayName.equals(WIND.displayName)) {
            return WIND;
        } else if (displayName.equals(FIRE.displayName)) {
            return FIRE;
        } else {
            throw new UnsupportedOperationException("Enum wasn't found!");
        }
    }

    @Override
    public String toString() {
        return displayName;
    }
}
