package com.example.Library.App.server.dto;

public class OrderDTO {
    private String name;
    private String adress;
    private float price;

    public OrderDTO() {
    }

    public OrderDTO(String name, String adress, float price) {
        this.name = name;
        this.adress = adress;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
