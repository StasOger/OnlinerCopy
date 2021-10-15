package com.example.demo.model.characteristicsAuto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
