package com.quantox.movies;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


import com.quantox.movies.Fragments.TopRatedFragment;
import com.quantox.movies.model.TabItem;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tabs)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupViewPager();


    }

    private void setupViewPager(){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),generateTabItems());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private TabItem[] generateTabItems(){
        TabItem[] tabItems = new TabItem[2];
        TabItem topRatedMovie = new TabItem();
        topRatedMovie.setFragment(TopRatedFragment.newInstance());
        topRatedMovie.setTitle(getString(R.string.top_rated_movies));

        TabItem upcomingMovies = new TabItem();
        upcomingMovies.setFragment(TopRatedFragment.newInstance());
        upcomingMovies.setTitle(getString(R.string.upcoming_movies));

        tabItems[0] = topRatedMovie;
        tabItems[1] = upcomingMovies;
        return tabItems;
    }
}
