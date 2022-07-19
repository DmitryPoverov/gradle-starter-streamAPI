package ru.clevertec.enums;

public enum Size {

    SMALL("S"),
    MEDIUM("M"),
    LARGE("L"),
    EXTRA_LARGE("XL");

    private String name;

    Size(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
