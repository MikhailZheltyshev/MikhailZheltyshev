package enums;

public enum DIfferentElementsPageRadioButtons {
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    public String displayName;

    DIfferentElementsPageRadioButtons(String name){
        displayName = name;
    }

    public static DIfferentElementsPageRadioButtons getRadioButtonEnumByName(String displayName) {
        if (displayName.equals(GOLD.displayName)) {
            return GOLD;
        } else if (displayName.equals(SILVER.displayName)) {
            return SILVER;
        } else if (displayName.equals(BRONZE.displayName)) {
            return BRONZE;
        } else if (displayName.equals(SELEN.displayName)) {
            return SELEN;
        } else {
            throw new UnsupportedOperationException("Enum wasn't found!");
        }
    }
}
