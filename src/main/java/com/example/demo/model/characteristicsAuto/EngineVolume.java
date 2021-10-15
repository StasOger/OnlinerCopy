package com.example.demo.model.characteristicsAuto;

public enum EngineVolume {

    TWO_ZERO(2.0d),
    TWO_ONE(2.1d),
    TWO_TWO(2.2d),
    TWO_THREE(2.3d),
    TWO_FOUR(2.4d),
    TWO_FIFE(2.5d),
    TWO_SIX(2.6d),
    TWO_SEVEN(2.7d),
    TWO_EIGHT(2.8d),
    TWO_NINE(2.9d),
    THREE_ZERO(3.0d),
    THREE_ONE(3.1d),
    THREE_TWO(3.2d),
    THREE_THREE(3.3d),
    THREE_FOUR(3.4d),
    THREE_FIFE(3.5d),
    THREE_SIX(3.6d),
    THREE_SEVEN(3.7d),
    THREE_EIGHT(3.8d),
    THREE_NINE(3.9d),
    FOUR_ZERO(4.0d),
    FOUR_ONE(4.1d),
    FOUR_TWO(4.2d),
    FOUR_THREE(4.3d),
    FOUR_FOUR(4.4d),
    FOUR_FIFE(4.5d),
    FOUR_SIX(4.6d),
    FOUR_SEVEN(4.7d),
    FOUR_EIGHT(4.8d),
    FOUR_NINE(4.9d),
    FIFE_NINE(5.0d);


    private double value;

    EngineVolume(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

}
