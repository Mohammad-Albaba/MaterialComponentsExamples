package com.example.materialcomponentsexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CardViewActivity extends AppCompatActivity {
    boolean toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CardViewActivity.this, "Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.image_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toggle){
                    floatingActionButton.show();
                }else {
                    floatingActionButton.hide();
                }
                toggle = !toggle;
            }
        });
        ExtendedFloatingActionButton extendedFloatingActionButton = findViewById(R.id.fabextend);
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CardViewActivity.this, "extendedFloatingActionButton Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toggle){
                    extendedFloatingActionButton.shrink();
                }else {
                    extendedFloatingActionButton.extend();
                }
                toggle = !toggle;
            }
        });
    }
}