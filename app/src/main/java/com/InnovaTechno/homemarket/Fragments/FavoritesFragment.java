package com.InnovaTechno.homemarket.Fragments;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.InnovaTechno.homemarket.Models.Favorites;
import com.InnovaTechno.homemarket.R;
import com.InnovaTechno.homemarket.RecyclerViewMarket;
import com.InnovaTechno.homemarket.adapter.FavoriteAdapter;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

public class FavoritesFragment extends Fragment {
    public static final String TAG = "FavoritesFragment";
    TextView tvName;
    FavoriteAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favorites, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tvName = view.findViewById(R.id.tvName);
        RecyclerView rv_favorites = view.findViewById(R.id.rv_favorites);


        List<Favorites> mFavorites = new ArrayList<>();
        adapter = new FavoriteAdapter(getContext(), mFavorites);
        rv_favorites.setLayoutManager(new LinearLayoutManager(getContext()) );
        rv_favorites.setAdapter(adapter);

        ParseQuery<Favorites> query= ParseQuery.getQuery(Favorites.class);
        query.include(Favorites.KEY_PRODUCT);
        query.whereEqualTo(Favorites.KEY_USER, ParseUser.getCurrentUser());
        query.findInBackground(new FindCallback<Favorites>() {
            @Override
            public void done(List<Favorites> objects, ParseException e) {
                if(e!=null){
                    Log.d("ViewFavorites","Erreur : "+e.getMessage());
                    e.printStackTrace();
                    return;
                }
                Log.d("ViewFavorites","Favorites fetched with "+ objects.size()+" row(s)");
                adapter.AddAllToList(objects);
            }
        });


    }







}

