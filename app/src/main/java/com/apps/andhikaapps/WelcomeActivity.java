package com.apps.andhikaapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.apps.andhikaapps.Menu.MenuActivity;
import com.apps.andhikaapps.Utils.Preferences;

import org.jetbrains.annotations.NotNull;

/*
    Developed by Andhika Putra Bagaskara - 10117167 - IF5
    02 May 2020
 */
public class WelcomeActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout layoutDots;
    private Button btnSkip, btnNext;
    public int[] layouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // mengecek launch activity - sebelum memanggil setContentView()
        if (Preferences.getFirstTimeStatus(getBaseContext())){
            goToHomeScreen();
            finish();
        }

        // membuat transparan notifikasi
        if (Build.VERSION.SDK_INT >= 21){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        setContentView(R.layout.activity_welcome);

        viewPager = findViewById(R.id.view_pager);
        layoutDots = findViewById(R.id.layoutDots);
        btnNext = findViewById(R.id.btn_next);
        btnSkip = findViewById(R.id.btn_skip);

        // layout xml slide 1 sampai 4
        layouts = new int[]{
          R.layout.slide1,
          R.layout.slide2,
          R.layout.slide3
        };

        // Tombol dots (lingkarang kecil untuk berpindah slide)
        addBottomDots(0);

        // Membuat transparan notofikasi
        changeStatusBarColor();

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter();
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerChangeListener);

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToHomeScreen();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mengecek page terakhir
                //jika activity home sudah tampil
                int current = getItem(+1);
                if (current < layouts.length){
                    viewPager.setCurrentItem(current);
                }else {
                    goToHomeScreen();
                }
            }
        });
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    private void goToHomeScreen() {
        Preferences.setFirstTimeStatus(true, getBaseContext());
        startActivity(new Intent(WelcomeActivity.this, MenuActivity.class));
        finish();
    }

    private void addBottomDots(int currentPage) {
        TextView[] dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        layoutDots.removeAllViews();
        for (int i = 0; i < dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(36);
            dots[i].setTextColor(colorsInactive[currentPage]);
            layoutDots.addView(dots[i]);
        }

        if (dots.length > 0){
            dots[currentPage].setTextColor(colorsActive[currentPage]);
        }
    }

    // Making notofication bar transparent
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    // View Pager Adapter
    public class ViewPagerAdapter extends PagerAdapter{

        ViewPagerAdapter(){
        }

        @NotNull
        @Override
        public Object instantiateItem(@NotNull ViewGroup container, int position){
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            assert layoutInflater != null;
            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, @NotNull Object object){
            View view = (View) object;
            container.removeView(view);
        }
    }

    // View Pager change listener
    ViewPager.OnPageChangeListener viewPagerChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);

            // mengubah button lanjut 'Lanjut' / 'Mulai'
            if (position == layouts.length-1){
                // last page. make button text to GOT IT
                btnNext.setText(getString(R.string.btn_start));
                btnSkip.setVisibility(View.GONE);
            }else {
                // Still pages are left
                btnNext.setText(getString(R.string.btn_next));
                btnSkip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

}
