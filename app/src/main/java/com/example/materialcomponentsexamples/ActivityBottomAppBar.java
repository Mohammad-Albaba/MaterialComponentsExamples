package com.example.materialcomponentsexamples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ActivityBottomAppBar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_app_bar);

        Toolbar toolbar = findViewById(R.id.bottom_app_bar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                        case R.id.action_search:
                        Toast.makeText(ActivityBottomAppBar.this, "Search Clicked", Toast.LENGTH_SHORT).show();
                        break;
                        case R.id.action_about:
                        Toast.makeText(ActivityBottomAppBar.this, "About Clicked", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityBottomAppBar.this, "Home Clicked", Toast.LENGTH_SHORT).show();

            }
        });

    }

}