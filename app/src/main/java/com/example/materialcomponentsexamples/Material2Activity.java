package com.example.materialcomponentsexamples;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Material2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material2);

        ViewPager viewPager  =findViewById(R.id.viewpager);
        viewPager.setAdapter(new Material2Activity.MyPagerAdapter(getSupportFragmentManager()));

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        BadgeDrawable badgeDrawable =bottomNavigationView.getOrCreateBadge(R.id.calls);
        badgeDrawable.setBackgroundColor(Color.YELLOW);
        badgeDrawable.setNumber(10);
        badgeDrawable.setBadgeTextColor(Color.BLACK);
        badgeDrawable.setBadgeGravity(BadgeDrawable.TOP_END);
        badgeDrawable.setVerticalOffset(20);
        badgeDrawable.setHorizontalOffset(-20);
        badgeDrawable.setVisible(true);
//        bottomNavigationView.removeBadge(R.id.calls);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.calls :
                        viewPager.setCurrentItem(0);
                        break;
                        case R.id.messages :
                        viewPager.setCurrentItem(1);
                        break;
                        case R.id.profile :
                        viewPager.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0 :
                        bottomNavigationView.setSelectedItemId(R.id.calls);
                        break;
                    case 1 :
                        bottomNavigationView.setSelectedItemId(R.id.messages);
                        break;
                    case 2 :
                        bottomNavigationView.setSelectedItemId(R.id.profile);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0 :
                    return new CallsFragment();
                case 1 :
                    return new MessagesFragment();
                case 2 :
                    return new ProfileFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
}}