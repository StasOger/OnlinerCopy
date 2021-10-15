package com.example.demo.model;

import com.example.demo.model.characteristicsAuto.Color;
import com.example.demo.model.characteristicsAuto.EngineVolume;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String brand;

    private Color color;

    private EngineVolume engineVolume;

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

    public EngineVolume getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(EngineVolume engineVolume) {
        this.engineVolume = engineVolume;
    }

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
                ", color=" + color +
                ", engineVolume=" + engineVolume +
                '}';
    }
}








