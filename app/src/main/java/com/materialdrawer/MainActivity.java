package com.materialdrawer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    ViewPager mViewPager;
    HomeScreenViewPagerAdapter mHomeScreenViewPagerAdapter;
    TabLayout mSlidingTabLayout;
    CharSequence tabTitles[];
    int mNumberOfTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.mipmap.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        tabTitles = getResources().getStringArray(R.array.TabsNamesArray);
        mNumberOfTabs = tabTitles.length;
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

            mHomeScreenViewPagerAdapter = new HomeScreenViewPagerAdapter(getSupportFragmentManager(),tabTitles,mNumberOfTabs);

            mViewPager = (ViewPager) findViewById(R.id.pager);
            mViewPager.setAdapter(mHomeScreenViewPagerAdapter);

            // Assiging the Sliding Tab Layout View
            mSlidingTabLayout = (TabLayout) findViewById(R.id.tabs);
            mSlidingTabLayout.setupWithViewPager(mViewPager);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"This is a snackbar",Snackbar.LENGTH_SHORT)
                        .setAction("Action",null).show();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample_actions, menu);
        return true;
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);

                        Toast.makeText(MainActivity.this,"Menu : "+menuItem.getTitle(),Toast.LENGTH_SHORT).show();

                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }
}
