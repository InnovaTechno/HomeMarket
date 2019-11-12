package com.InnovaTechno.homemarket.New_Products;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;

@ParseClassName("NewProducts")
public class NewProducts extends ParseObject {

    public static final String KEY_NAME =  "name";
    public static final String KEY_IMAGE =  "newProductImage";
    public static final String KEY_CREATED_AT  =  "createdAt";

    public String getName(){
        return getString(KEY_NAME);
    }

    public void setName(String name) {
        put(KEY_NAME, name);
    }

    public ParseFile getImage(){
        return  getParseFile(KEY_IMAGE);
    }

    public void setImage (ParseFile parseFile){
        put(KEY_IMAGE, parseFile);
    }


}