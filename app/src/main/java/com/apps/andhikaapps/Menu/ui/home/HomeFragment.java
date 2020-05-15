package com.apps.andhikaapps.Menu.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.apps.andhikaapps.Adapter.PagerAdapterHome;
import com.apps.andhikaapps.R;
import com.google.android.material.tabs.TabLayout;

/*
    Developed by Andhika Putra Bagaskara - 10117167 - IF5
    04 May 2020
 */

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_menu_home, container, false);

        final TabLayout tabLayout = root.findViewById(R.id.tab_layout);
        final ViewPager viewPager = root.findViewById(R.id.view_pager);
        //final TextView textView = root.findViewById(R.id.text_home);
        //final Button button = root.findViewById(R.id.button);

        // Memanggil dan Memasukan Value pada Class PagerAdapter(FragmentManager dan JumlahTab)
        assert getFragmentManager() != null;
        PagerAdapterHome pagerAdapterHome = new PagerAdapterHome(getFragmentManager(), tabLayout.getTabCount());

        // Memasang Adapter pada ViewPager
        viewPager.setAdapter(pagerAdapterHome);

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

        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Preferences preferences = new Preferences(getContext());
                preferences.setFirstTimeStatus(true);
                startActivity(new Intent(getActivity(), WelcomeActivity.class));
                getActivity().finish();
            }
        });*/
        return root;
    }
}
