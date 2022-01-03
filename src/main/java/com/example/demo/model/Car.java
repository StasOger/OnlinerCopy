package com.example.demo.model;

import com.example.demo.model.characteristicsAuto.BodyCar;
import com.example.demo.model.characteristicsAuto.Color;
import com.example.demo.model.characteristicsAuto.EngineVolume;
import com.example.demo.model.characteristicsAuto.TypeEngine;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String brand;

    private String modelAuto;

    private String generationCar;

    private Color color;

    private EngineVolume engineVolume;

    private BodyCar bodyCar;

    private TypeEngine typeEngine;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(length = 100000)
    private byte[] photo;



    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelAuto() { return modelAuto; }

    public void setModelAuto (String modelAuto) {
        this.modelAuto = modelAuto;
    }

    public String getGenerationCar() { return generationCar; }

    public void setGenerationCar (String generationCar) {this.generationCar = generationCar;}

    public EngineVolume getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(EngineVolume engineVolume) {
        this.engineVolume = engineVolume;
    }

    public BodyCar getBodyCar() { return bodyCar; }

    public void setBodyCar(BodyCar bodyCar) { this.bodyCar = bodyCar; }

    public TypeEngine getTypeEngine() {return typeEngine;}

    public void setTypeEngine(TypeEngine typeEngine) {this.typeEngine = typeEngine;}

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", modelAuto='" + modelAuto  +
                ", generationCar='" + generationCar  +
                ", color=" + color +
                ", engineVolume=" + engineVolume +
                ", bodyCar=" + bodyCar +
                '}';
    }
}








