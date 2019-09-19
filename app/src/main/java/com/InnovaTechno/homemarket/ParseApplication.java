package com.InnovaTechno.homemarket;

import android.app.Application;

import com.InnovaTechno.homemarket.Categories.Post;
import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(User.class);
        //ParseObject.registerSubclass(Post.class);
        // set applicationId, and server server based on the values in the Heroku settings.
        // clientKey is not needed unless explicitly configured
        // any network interceptors must be added with the Configuration Builder given this syntax
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("homemarket") // should correspond to APP_ID env variable
                .clientKey("homemarket-app")  // set explicitly unless clientKey is explicitly configured on Parse server
                .server("http://homemarket.herokuapp.com/parse").build());
    }

}