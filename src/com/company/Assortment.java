package com.company;

public enum Assortment {

    MEAT("Meat"),
    DRIED_FRUITS("Dried fruits"),
    SEED("Seed"),
    FLOUR("Flour"),
    FABRICS("Fabrics"),
    PAINT("Paint");

    private String value;

    Assortment(String value) {
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
