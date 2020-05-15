package com.apps.andhikaapps.Menu.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.apps.andhikaapps.Adapter.PagerAdapterProfile;
import com.apps.andhikaapps.R;
import com.google.android.material.tabs.TabLayout;

/*
    Developed by Andhika Putra Bagaskara - 10117167 - IF5
    15 May 2020
 */

public class MyProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View root = inflater.inflate(R.layout.fragment_menu_my_profile, container, false);

        final TabLayout tabLayout = root.findViewById(R.id.tab_layout);
        final ViewPager viewPager = root.findViewById(R.id.view_pager);
        //final Button button = root.findViewById(R.id.button);

        // Memanggil dan Memasukan Value pada Class PagerAdapter(FragmentManager dan JumlahTab)
        assert getFragmentManager() != null;
        PagerAdapterProfile pagerAdapterProfile = new PagerAdapterProfile(getFragmentManager(), tabLayout.getTabCount());

        // Memasang Adapter pada ViewPager
        viewPager.setAdapter(pagerAdapterProfile);

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

        return root;
    }



}
