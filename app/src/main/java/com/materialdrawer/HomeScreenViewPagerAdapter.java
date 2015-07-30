package com.materialdrawer;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Dhananjay on 03/07/2015.
 */

public class HomeScreenViewPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when LoginViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the LoginViewPagerAdapter is created


    // Build a Constructor and assign the passed Values to appropriate values in the class
    public HomeScreenViewPagerAdapter(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;

    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new Tab1();
                return fragment;
            case 1:
                fragment = new Tab2();
                return fragment;
            case 2:
                fragment = new Tab3();
                return fragment;

        }

        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }


    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}