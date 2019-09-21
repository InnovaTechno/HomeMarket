package com.InnovaTechno.homemarket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.InnovaTechno.homemarket.fragments.CartFragment;
import com.InnovaTechno.homemarket.fragments.FavoritesFragment;
import com.InnovaTechno.homemarket.fragments.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final FragmentManager fragmentManager = getSupportFragmentManager();

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment ;
                switch (item.getItemId()) {
                    case R.id.action_home:fragment = new HomeFragment();
                        fragment = new HomeFragment();
                       // Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_favorites:
                        fragment = new FavoritesFragment();
                        // Toast.makeText(MainActivity.this, "Favorites", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_cart:
                        fragment = new CartFragment();
                        // Toast.makeText(MainActivity.this, "Cart", Toast.LENGTH_SHORT).show();
                    default:
                        //TODO: Swap fragment here
                        fragment = new HomeFragment();
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;


            }
        });
        // Set default selection
        bottomNavigationView.setSelectedItemId(R.id.action_home);

    }
}
