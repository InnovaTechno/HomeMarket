package com.InnovaTechno.homemarket;

import android.app.Application;


import com.InnovaTechno.homemarket.Categories.Post.Post;
import com.InnovaTechno.homemarket.Categories.Post.PostAMenagers;
import com.InnovaTechno.homemarket.Categories.Post.PostBAlcolisees;
import com.InnovaTechno.homemarket.Categories.Post.PostBoissons;
import com.InnovaTechno.homemarket.Categories.Post.PostPLaitiers;
import com.InnovaTechno.homemarket.Categories.Post.PostPains;
import com.InnovaTechno.homemarket.Categories.Post.PostSucreries;
import com.InnovaTechno.homemarket.Categories.Post.PostViandes;
import com.InnovaTechno.homemarket.New_Products.NewProducts;
import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(User.class);
        ParseObject.registerSubclass(Post.class);
        ParseObject.registerSubclass(NewProducts.class);
        ParseObject.registerSubclass(PostViandes.class);
        ParseObject.registerSubclass(PostPLaitiers.class);
        ParseObject.registerSubclass(PostBoissons.class);
        ParseObject.registerSubclass(PostPains.class);
        ParseObject.registerSubclass(PostSucreries.class);
        ParseObject.registerSubclass(PostBAlcolisees.class);
        ParseObject.registerSubclass(PostAMenagers.class);

        // set applicationId, and server server based on the values in the Heroku settings.
        // clientKey is not needed unless explicitly configured
        // any network interceptors must be added with the Configuration Builder given this syntax
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("homemarket") // should correspond to APP_ID env variable
                .clientKey("homemarket-app")  // set explicitly unless clientKey is explicitly configured on Parse server
                .server("http://homemarket.herokuapp.com/parse").build());
    }

}