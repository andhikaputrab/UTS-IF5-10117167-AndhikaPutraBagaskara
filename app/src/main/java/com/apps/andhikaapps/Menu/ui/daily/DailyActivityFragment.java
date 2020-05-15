package com.apps.andhikaapps.Menu.ui.daily;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.apps.andhikaapps.Adapter.PagerAdapterDaily;
import com.apps.andhikaapps.R;
import com.google.android.material.tabs.TabLayout;

/*
    Developed by Andhika Putra Bagaskara - 10117167 - IF5
    07 May 2020
 */

public class DailyActivityFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DailyActivityViewModel dailyActivityViewModel = ViewModelProviders.of(this).get(DailyActivityViewModel.class);
        View root = inflater.inflate(R.layout.fragment_menu_daily, container, false);

        final TabLayout tabLayout = root.findViewById(R.id.tab_layout);
        final ViewPager viewPager= root.findViewById(R.id.view_pager);

        // Memanggil dan Memasukan Value pada Class PagerAdapter(FragmentManager dan JumlahTab)
        assert getFragmentManager() != null;
        PagerAdapterDaily pagerAdapterDaily = new PagerAdapterDaily(getFragmentManager(), tabLayout.getTabCount());

        // Memasang Adapter pada ViewPager
        viewPager.setAdapter(pagerAdapterDaily);

        /*
         Menambahkan Listener yang akan dipanggil kapan pun halaman berubah atau
         bergulir secara bertahap, sehingga posisi tab tetap singkron
         */
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        // Callback Interface dipanggil saat status pilihan tab berubah.
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        dailyActivityViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });
        return root;
    }
}
