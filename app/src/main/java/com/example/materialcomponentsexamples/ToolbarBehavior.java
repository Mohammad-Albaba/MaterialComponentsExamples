package com.example.materialcomponentsexamples;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;

public class ToolbarBehavior extends CoordinatorLayout.Behavior<NestedScrollView> {

    public ToolbarBehavior() {
        super();
    }

    public ToolbarBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull NestedScrollView child, @NonNull View dependency) {
        return dependency instanceof Toolbar;
    }

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull NestedScrollView child, @NonNull View dependency) {
        if (dependency instanceof Toolbar) {
            CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
            TypedArray typedArray = child.getContext().obtainStyledAttributes(new int[]{R.attr.actionBarSize});
            int toolbarSizeInPixel = typedArray.getDimensionPixelSize(0, 0);
            params.setMargins(0, toolbarSizeInPixel, 0, 0);
            child.setLayoutParams(params);
        }
        return super.onDependentViewChanged(parent, child, dependency);
    }
}

