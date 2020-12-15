package com.example.materialcomponentsexamples;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class OptionBottomSheetFragment extends BottomSheetDialogFragment {

    interface OnOptionSelectedListener{
        void onOptionSelected(int id);
    }
    private OnOptionSelectedListener onOptionSelectedListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnOptionSelectedListener){
            onOptionSelectedListener = (OnOptionSelectedListener) context;
        }else {
            new RuntimeException("You must implement OnOptionSelectedListener ");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(getContext()).inflate(R.layout.fragment_options , null , false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOptionSelectedListener.onOptionSelected(v.getId());
            }
        };
        view.findViewById(R.id.text_view_share).setOnClickListener(onClickListener);
        view.findViewById(R.id.text_view_edit).setOnClickListener(onClickListener);
    }
}