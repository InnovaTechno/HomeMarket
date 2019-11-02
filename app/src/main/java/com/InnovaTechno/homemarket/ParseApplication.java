package com.InnovaTechno.homemarket;

import android.app.Application;


import com.InnovaTechno.homemarket.Categories.Models.Post;
import com.InnovaTechno.homemarket.Categories.Models.PostAMenagers;
import com.InnovaTechno.homemarket.Categories.Models.PostBAlcolisees;
import com.InnovaTechno.homemarket.Categories.Models.PostBoissons;
import com.InnovaTechno.homemarket.Categories.Models.PostPCosmetiques;
import com.InnovaTechno.homemarket.Categories.Models.PostPLaitiers;
import com.InnovaTechno.homemarket.Categories.Models.PostPains;
import com.InnovaTechno.homemarket.Categories.Models.PostSucreries;
import com.InnovaTechno.homemarket.Categories.Models.PostViandes;
import com.InnovaTechno.homemarket.Items_Detail.Details;
import com.InnovaTechno.homemarket.Items_Detail.RelatedItems;
import com.InnovaTechno.homemarket.Models.CardInfo;
import com.InnovaTechno.homemarket.Models.User;
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
        ParseObject.registerSubclass(PostPCosmetiques.class);
        ParseObject.registerSubclass(PostPains.class);
        ParseObject.registerSubclass(PostSucreries.class);
        ParseObject.registerSubclass(PostBAlcolisees.class);
        ParseObject.registerSubclass(PostAMenagers.class);
        ParseObject.registerSubclass(PostBoissons.class);
        ParseObject.registerSubclass(RelatedItems.class);
        ParseObject.registerSubclass(Details.class);
        ParseObject.registerSubclass(CardInfo.class);


        // set applicationId, and server server based on the values in the Heroku settings.
        // clientKey is not needed unless explicitly configured
        // any network interceptors must be added with the Configuration Builder given this syntax
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("homemarket") // should correspond to APP_ID env variable
                .clientKey("homemarket-app")  // set explicitly unless clientKey is explicitly configured on Parse server
                .server("http://homemarket.herokuapp.com/parse").build());
    }

}