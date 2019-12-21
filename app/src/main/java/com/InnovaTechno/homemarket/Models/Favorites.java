package com.InnovaTechno.homemarket.Models;


import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("Favorites")
public class Favorites extends ParseObject {
    public static final String KEY_NAME =  "name";
    public static final String KEY_USER = "user";
    public static final String KEY_PRODUCT= "Product";
    public static final String KEY_IMAGE =  "productImage";
    public static final String KEY_DEVISE = "devise";
    public static final String KEY_PRICE = "price2";

    public String getPrice() {
        return getString(KEY_PRICE);
    }

    public String getName(){
        return getString(KEY_NAME);
    }

    public void setUser(ParseUser user){put(KEY_USER,user);}

    public ParseUser getUser(){return getParseUser(KEY_USER);}

    public ParseFile getImage (){
        return getParseFile(KEY_IMAGE);
    }

    public void setName(String name) {
        put(KEY_NAME, name);
    }

    public void setImage (ParseFile parseFile){
        put(KEY_IMAGE, parseFile);
    }

    public String getDevise () {
        return getString(KEY_DEVISE);
    }

    public void setDevise (String devise){
        put(KEY_DEVISE, devise);
    }

    public void setProduct(ParseObject product){put(KEY_PRODUCT,product);}

    public ParseObject getProduct(){return getParseObject(KEY_PRODUCT);}
}




