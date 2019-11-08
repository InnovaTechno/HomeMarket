package com.InnovaTechno.homemarket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.InnovaTechno.homemarket.Fragments.CartFragment;
import com.InnovaTechno.homemarket.Fragments.FavoritesFragment;
import com.InnovaTechno.homemarket.Fragments.HomeFragment;
import com.InnovaTechno.homemarket.Livraison.Livraison;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private DrawerLayout mdrawerLayout;
    private ActionBarDrawerToggle mtoggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final FragmentManager fragmentManager = getSupportFragmentManager();

        mdrawerLayout = findViewById(R.id.drawerLayout);
        mtoggle = new ActionBarDrawerToggle(this, mdrawerLayout,R.string.open,R.string.close);
        mdrawerLayout.addDrawerListener(mtoggle);
        mtoggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

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
                        // Toast.makeText(MainActivity.this, "SharedPreference", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_cart:
                        fragment = new CartFragment();
                        // Toast.makeText(MainActivity.this, "Cart", Toast.LENGTH_SHORT).show();
                    default:
                        //TODO: Swap fragment here
                        fragment = new CartFragment();
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;


            }
        });
        // Set default selection
        bottomNavigationView.setSelectedItemId(R.id.action_home);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if( mtoggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_profile:
               if (ParseUser.getCurrentUser() == null){
                Toast.makeText(this, "You haven't login yet.",
                         Toast.LENGTH_SHORT).show();
                } else{
                    Intent p = new Intent(this, Profile.class);
                    startActivity(p);
                }
                //Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_marketlist:
                //Toast.makeText(this, "MarketList", Toast.LENGTH_SHORT).show();
                Intent m = new Intent(this, MarketsActivity.class);
                startActivity(m);

                break;
            case R.id.nav_livraison:
                Toast.makeText(this, "Pick Up", Toast.LENGTH_SHORT).show();
                Intent l = new Intent(this, Livraison.class);
                startActivity(l);

                break;
            case R.id.nav_pickup:
                Toast.makeText(this, "MarketList", Toast.LENGTH_SHORT).show();

                break;

            case R.id.nav_logout:
                if (ParseUser.getCurrentUser() == null){
                    Toast.makeText(this, "You haven't login yet, please login to buy your items",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Successfully Log out", Toast.LENGTH_SHORT).show();
                ParseUser.logOut();
                // ParseUser currentUser = ParseUser.getCurrentUser(); // this will now be null
                Intent i = new Intent(this, WelcomeActivity.class);
                startActivity(i);
                finish();
                }
                break;

        }
        mdrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }



    @Override
    public void onBackPressed() {
        if (mdrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mdrawerLayout.closeDrawer(GravityCompat.START);
        } else {
        super.onBackPressed();
        }
    }
}
