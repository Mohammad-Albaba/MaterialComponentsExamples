package com.example.materialcomponentsexamples;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class BottomSheetActivity extends AppCompatActivity implements OptionBottomSheetFragment.OnOptionSelectedListener {
    OptionBottomSheetFragment optionBottomSheetFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);
        optionBottomSheetFragment = new OptionBottomSheetFragment();


        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.bottom_sheet));
        bottomSheetBehavior.setPeekHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP , 60 ,getResources().getDisplayMetrics()));
        bottomSheetBehavior.setHideable(true);
        bottomSheetBehavior.setExpandedOffset(300);
        bottomSheetBehavior.setFitToContents(true);
        bottomSheetBehavior.setSkipCollapsed(true);
        bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState){
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        System.out.println("STATE_COLLAPSED");
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        System.out.println("STATE_EXPANDED");
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        System.out.println("STATE_DRAGGING");
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        System.out.println("STATE_SETTLING");
                        break;
                    case BottomSheetBehavior.STATE_HALF_EXPANDED:
                        System.out.println("STATE_HALF_EXPANDED");
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        System.out.println("STATE_HIDDEN");
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                System.out.println("slideOffset: " + slideOffset);
            }
        });
    }

    public void showModalBottomSheet(View view) {
        optionBottomSheetFragment.show(getSupportFragmentManager(), optionBottomSheetFragment.getTag());
    }

    @Override
    public void onOptionSelected(int id) {
        switch (id){
            case R.id.text_view_share :
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.text_view_edit :
                Toast.makeText(this, "Edit", Toast.LENGTH_SHORT).show();
                break;
        }
        optionBottomSheetFragment.dismiss();
    }
}