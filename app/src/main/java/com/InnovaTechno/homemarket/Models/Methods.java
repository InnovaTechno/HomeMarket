package com.InnovaTechno.homemarket.Models;

public class Methods {
    int image;
    String cardName;
    int expDate;

    public Methods(int image, String cardName, int expDate) {
        this.image = image;
        this.cardName = cardName;
        this.expDate = expDate;
    }

    public int getImage() {
        return image;
    }

    public String getCardName() {
        return cardName;
    }

    public int getExpDate() {
        return expDate;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public void setExpDate(int expDate) {
        this.expDate = expDate;
    }
}
