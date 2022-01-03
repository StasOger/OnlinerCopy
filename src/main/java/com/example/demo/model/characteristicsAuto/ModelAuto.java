package com.example.demo.model.characteristicsAuto;

public enum ModelAuto {
    THIRD_SERIES("3-Series"), FIVE_SERIES("5-Series"), SIX_SERIES("6-Series"), SEVEN_SERIES("7-Series"), X_THIRD("X3"), X_FIVE("X5"), X_SIX("X6"), X_SEVEN("X7"),

    S60("S60"), S70("S70"), S80("S80"), XC90("XC90"),

    G12("12-ЗИМ"), G13("13-чайка"), G14("14-чайка"), M20("M20-Победа"), G21("21"), G24("24");

    private String id;

    ModelAuto(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
