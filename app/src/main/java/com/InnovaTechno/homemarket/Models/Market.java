package com.InnovaTechno.homemarket.Models;

public class Market {

    private String Namee;
    private int Thumbnail;

    public Market(String namee, int thumbnail) {
        Namee = namee;
        Thumbnail = thumbnail;
    }

    public String getNamee() {
        return Namee;
    }

    public int getThumbnail() {
        return Thumbnail;
    }


    public void setNamee(String namee) {
        Namee = namee;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}
