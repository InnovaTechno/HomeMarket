package com.InnovaTechno.homemarket;

import android.content.Context;
import android.content.SharedPreferences;

import com.InnovaTechno.homemarket.Categories.Models.Post;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SharedPreference {

    public static final String PREFS_NAME = "PRODUCT";
    public static final String FAVORITES = "Product_Favorite";

    public SharedPreference() {
    super();
}

    // This four methods are used for maintaining favorites.
    public void saveFavorites(Context context, List<Post> favorites) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(favorites);

        editor.putString(FAVORITES, jsonFavorites);

        editor.commit();
    }

    public void addFavorite(Context context, Post post) {
        List<Post> favorites = getFavorites(context);
        if (favorites == null)
            favorites = new ArrayList<Post>();
        favorites.add(post);
        saveFavorites(context, favorites);
    }

    public void removeFavorite(Context context, Post post) {
        ArrayList<Post> favorites = getFavorites(context);
        if (favorites != null) {
            favorites.remove(post);
            saveFavorites(context, favorites);
        }
    }

    public ArrayList<Post> getFavorites(Context context) {
        SharedPreferences settings;
        List<Post> favorites;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);

        if (settings.contains(FAVORITES)) {
            String jsonFavorites = settings.getString(FAVORITES, null);
            Gson gson = new Gson();
            Post[] favoriteItems = gson.fromJson(jsonFavorites,
                    Post[].class);

            favorites = Arrays.asList(favoriteItems);
            favorites = new ArrayList<Post>(favorites);
        } else
            return null;

        return (ArrayList<Post>) favorites;
    }
}
