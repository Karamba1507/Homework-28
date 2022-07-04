package com.company;

public enum City {

    BISHKEK("Bishkek!"),
    KANT("Kant!"),
    TOKMOK("Tokmok!"),
    KEMIN("Kemin!"),
    BALYKCHY("Balykchy!"),
    CHOLPON_ATA("Cholpon-Ata!"),
    KARAKOL("Karakol!");

    private String value;

    City(String value) {
        this.value=value;
    }

    public String getValue() {
        return value;
    }

}
