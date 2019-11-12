package com.InnovaTechno.homemarket.Models;

public class Category {

    private String Title;
    private int Thumbnail;



    public Category(String title, int thumbnail) {
        Title = title;
        Thumbnail = thumbnail;
    }

    public String getTitle() {
        return Title;
    }

    public int getThumbnail() {
        return Thumbnail;
    }


    public void setTitle(String title) {
        Title = title;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}
