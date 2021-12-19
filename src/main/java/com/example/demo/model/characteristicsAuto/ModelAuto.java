package com.example.demo.model.characteristicsAuto;

public enum ModelAuto {
    THIRD_SERIES("3-Series"), FIVE_SERIES("5-Series"), SEVEN_SERIES("7-Series"),
    S60("S60"), S70("S70"), G21("21"), G24("24");

    private String id;

    ModelAuto(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
