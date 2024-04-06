package com.bb.food.ui.favorite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.bb.food.R;
import com.bb.food.fragments.FragmentAdapter;
import com.google.android.material.tabs.TabLayout;

public class FavoriteFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    FragmentAdapter fragmentAdapter;
    private FragmentActivity fav_fragment_activity;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_favorite, container, false);
        tabLayout =  root.findViewById(R.id.fav_tab_layout);
        viewPager2 = root.findViewById(R.id.fav_viewpage2);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentAdapter = new FragmentAdapter(fragmentManager, getLifecycle());

        viewPager2.setAdapter(fragmentAdapter);
        tabLayout.addTab(tabLayout.newTab().setText("tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("tab 2"));
        tabLayout.addTab(tabLayout.newTab().setText("tab 3"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                // sync tablayout and viewpage2
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}