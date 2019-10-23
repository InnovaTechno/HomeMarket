package com.InnovaTechno.homemarket.Categories.Models;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;


@ParseClassName("PostAMenagers")
public class PostAMenagers extends ParseObject {

    public static final String KEY_NAME =  "name";
    public static final String KEY_IMAGE =  "productImage";
    public static final String KEY_DEVISE = "devise";
    public static final String KEY_PRICE = "price";



    public String getPrice() {
        return getString(KEY_PRICE);
    }

    public String getName(){
        return getString(KEY_NAME);
    }

    public void setName(String name) {
        put(KEY_NAME, name);
    }

    public ParseFile getImage (){
        return getParseFile(KEY_IMAGE);
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
}
