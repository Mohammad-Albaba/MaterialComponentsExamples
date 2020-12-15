package com.example.materialcomponentsexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

public class Try extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try);

        TextView textView = findViewById(R.id.textView);
        textView.setText("Google");

        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("Google");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.BLUE );
        ForegroundColorSpan foregroundColorSpan1 = new ForegroundColorSpan(Color.YELLOW );
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(Color.GRAY );
        ForegroundColorSpan foregroundColorSpan3 = new ForegroundColorSpan(Color.GREEN );

        spannableStringBuilder.setSpan(foregroundColorSpan ,0 ,1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.setSpan(foregroundColorSpan1 ,1 ,2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.setSpan(foregroundColorSpan2 ,2,3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.setSpan(foregroundColorSpan3 ,4 ,5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableStringBuilder);
    }
}