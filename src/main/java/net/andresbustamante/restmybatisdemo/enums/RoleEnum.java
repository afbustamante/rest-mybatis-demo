package net.andresbustamante.restmybatisdemo.enums;

public enum RoleEnum {

    SALESMAN(1),
    SUPPORT(2),
    MANAGER(3);

    private final int id;

    RoleEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
