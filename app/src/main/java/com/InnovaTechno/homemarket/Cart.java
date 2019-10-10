package com.InnovaTechno.homemarket;

public class Cart {

    private String Name;
    private String Price;
    private String Devise;
    private int Thumbnail;

    public Cart(String name, String price, String devise, int thumbnail) {
        Name = name;
        Price = price;
        Devise = devise;
        Thumbnail = thumbnail;
    }

    public String getName() {
        return Name;
    }

    public String getPrice() {
        return Price;
    }

    public String getDevise() {
        return Devise;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public void setDevise(String devise) {
        Devise = devise;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}
