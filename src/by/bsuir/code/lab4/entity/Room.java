package by.bsuir.code.lab4.entity;

import java.io.Serializable;

public class Room implements Serializable {

    private int id;
    private boolean hidden;
    private String name;
    private String description;
    private int price;
    private int bedsCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBedsCount() {
        return bedsCount;
    }

    public void setBedsCount(int bedsCount) {
        this.bedsCount = bedsCount;
    }

    public Room() {
    }

    public Room(int id, boolean hidden, String name, String description, int price, int bedsCount) {
        this.id = id;
        this.hidden = hidden;
        this.name = name;
        this.description = description;
        this.price = price;
        this.bedsCount = bedsCount;
    }
}
