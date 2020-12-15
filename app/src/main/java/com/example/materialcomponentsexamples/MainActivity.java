package com.example.materialcomponentsexamples;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // مكن نعمله من خلال xml زي مهو معمول
//        NestedScrollView nestedScrollView = findViewById(R.id.nested_scroll_view);
//        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) nestedScrollView.getLayoutParams();
//        ToolbarBehavior toolbarBehavior = new ToolbarBehavior();
//        layoutParams.setBehavior(toolbarBehavior);


        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_search:
                        Toast.makeText(MainActivity.this, "Search Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_about:
                        Toast.makeText(MainActivity.this, "About Clicked", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Home Clicked", Toast.LENGTH_SHORT).show();

            }
        });


        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        // لمن بدي أدخل الأيتم (العناصر) من كود الجافا وبستخدم أخر دالة وهي السبينيل اللي حدخل من خلالها العناوين والأيقونات
//        tabLayout.addTab(tabLayout.newTab().setText(R.string.calls).setIcon(R.drawable.ic_baseline_phone_24));
//        tabLayout.addTab(tabLayout.newTab().setText(R.string.messages).setIcon(R.drawable.ic_baseline_message_24));
//        tabLayout.addTab(tabLayout.newTab().setText(R.string.profile).setIcon(R.drawable.ic_baseline_person_24));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText(R.string.calls).setIcon(R.drawable.ic_baseline_phone_24);
        tabLayout.getTabAt(1).setText(R.string.messages).setIcon(R.drawable.ic_baseline_message_24);
        tabLayout.getTabAt(2).setText(R.string.profile).setIcon(R.drawable.ic_baseline_person_24);


//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//            viewPager.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                tabLayout.selectTab(tabLayout.getTabAt(position));
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
    }

    class MyPagerAdapter extends FragmentPagerAdapter{

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

//        Drawable drawable;
//        String title;
//        @Nullable
//        @Override
//        public CharSequence getPageTitle(int index) {
//            switch (index){
//                case 0:
//                    drawable = getResources().getDrawable(R.drawable.ic_baseline_phone_24);
//                    title = getResources().getString(R.string.calls);
//                    break;
//                case 1:
//                    drawable = getResources().getDrawable(R.drawable.ic_baseline_message_24);
//                    title = getResources().getString(R.string.messages);
//                    break;
//                case 2:
//                    drawable = getResources().getDrawable(R.drawable.ic_baseline_person_24);
//                    title = getResources().getString(R.string.profile);
//                    break;
//                default:
//                    throw new IllegalStateException("Unexpected value: " + index);
//            }
//            SpannableStringBuilder sb = new SpannableStringBuilder("  "+ title);
//            Drawable drawable = ContextCompat.getDrawable(MainActivity.this ,R.drawable.ic_baseline_phone_24);
//              drawable.setBounds(0, 0 , drawable.getIntrinsicWidth() , drawable.getIntrinsicHeight());
//            ImageSpan span = new ImageSpan(drawable , ImageSpan.ALIGN_BOTTOM);
//            sb.setSpan(span , 0 ,1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//            return sb;
//        }
    }
}