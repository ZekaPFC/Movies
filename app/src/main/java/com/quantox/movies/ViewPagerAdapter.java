package com.quantox.movies;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.quantox.movies.model.TabItem;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private TabItem[] tabItems;

    public ViewPagerAdapter(FragmentManager fm,TabItem[] tabItems) {
        super(fm);
        this.tabItems = tabItems;
    }

    @Override
    public Fragment getItem(int i) {
        return tabItems[i].getFragment();
    }

    @Override
    public int getCount() {
        return tabItems.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabItems[position].getTitle();
    }
}
