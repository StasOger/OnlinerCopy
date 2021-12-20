package com.example.demo.model.characteristicsAuto;

public enum GenerationCar {
    E_THIRD("e30"), E_THIRDYSIX("e36");

    private String id;
    GenerationCar(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}







