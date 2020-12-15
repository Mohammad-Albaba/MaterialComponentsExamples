package com.example.materialcomponentsexamples;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;


public class DrawerActivity extends AppCompatActivity {

        ActionBarDrawerToggle actionBarDrawerToggle;
        NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar1);
        FrameLayout frameLayout = findViewById(R.id.container);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this , drawerLayout , toolbar, R.string.open , R.string.close){
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                int slide = (int) (drawerView.getWidth() * slideOffset);
                frameLayout.setTranslationX(slide);
            }
        };
        actionBarDrawerToggle.syncState();

        navigationView = findViewById(R.id.nav_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case  R.id.calls :
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new CallsFragment()).commit();
                         break;
                    case  R.id.messages :
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new MessagesFragment()).commit();
                        break;
                        case  R.id.profile :
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new ProfileFragment()).commit();
                        break;

                }
                navigationView.setCheckedItem(item.getItemId());
                drawerLayout.closeDrawers();
                return true;
            }
        });
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new CallsFragment()).commit();
        navigationView.getMenu().getItem(0).setChecked(true);

    }
}