package com.InnovaTechno.homemarket.Models;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("CardInfo")
public class CardInfo extends ParseObject {

    public static final String KEY_NUMBER =  "cardNumber";
    public static final String KEY_NAME =  "cardHolderName";
    public static final String KEY_DATE = "expDate";

    public String getNumber() {
        return getString(KEY_NUMBER);
    }

    public String getName(){
        return getString(KEY_NAME);
    }

    public String getDate(){
        return getString(KEY_DATE);
    }

    public void setNumber (String cardNumber) {
        put(KEY_NUMBER, cardNumber);
    }

    public void setName (String cardHolderName){
        put(KEY_NAME, cardHolderName);
    }

    public void setDate (String expDate){
        put(KEY_DATE, expDate);
    }

}
