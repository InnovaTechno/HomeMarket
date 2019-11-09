package com.InnovaTechno.homemarket.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.InnovaTechno.homemarket.Models.Favorite;
import com.InnovaTechno.homemarket.R;
import com.InnovaTechno.homemarket.adapter.EmptyRecyclerView;

import java.util.List;

public class FavoritesFragment extends Fragment {
    public static final String TAG = "FavoritesFragment";
    TextView tvName;
    List<Favorite> favorites;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tvName = view.findViewById(R.id.tvName);
        // Replaced RecyclerView with EmptyRecyclerView
        EmptyRecyclerView rv_favorite = (EmptyRecyclerView)view.findViewById(R.id.rv_favorite);
        rv_favorite.setLayoutManager(new LinearLayoutManager(getContext()));

        // Fetch the empty view from the layout and set it on
        // the new recycler view
        View emptyView = v.findViewById(R.id.todo_list_empty_view);
        recyclerView.setEmptyView(emptyView);

        List<Favorite> favorites = // Fetch list of todos from the database
                TodoAdapter dataAdapter = new TodoAdapter(todos);
        rv_favorite.setAdapter(adapter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favorites, container, false);
    }





}

