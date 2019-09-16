package net.andresbustamante.restmybatisdemo.enums;

public enum GenderEnum {

    MALE(1),
    FEMALE(2);

    private int id;

    GenderEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static GenderEnum forId(int id) {
        for (GenderEnum gender : GenderEnum.values()) {
            if (gender.getId() == id) {
                return gender;
            }
        }
        return null;
    }
}
