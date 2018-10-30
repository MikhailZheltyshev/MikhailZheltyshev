package enums;

public enum UserTableUsers {
    ROMAN(1, "Roman", "Lorem ipsum"),
    SERGEY_IVAN(2, "Sergey Ivan", "Lorem ipsum"),
    VLADZIMIR(3, "Vladzimir", "Lorem ipsum"),
    HELEN_BENNET(4, "Helen Bennet", "Lorem ipsum \n" + "some description"),
    YOSHI_TANNAMURI(5, "Yoshi Tannamuri", "Lorem ipsum \n" + "some description"),
    GIOVANNI_ROVELLI(6, "Giovanni Rovelli", "Lorem ipsum \n" + "some description");

    int number;
    String displayName;
    String description;

    UserTableUsers(int num, String name, String descriptionText) {
        number = num;
        displayName = name;
        description = descriptionText;
    }
}
