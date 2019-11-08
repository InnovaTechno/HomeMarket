package com.InnovaTechno.homemarket.Models;

class Methods2 {
    int image;
    String name;
    int phoneNumber;

    public Methods2(int image, String name, int phoneNumber) {
        this.image = image;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
