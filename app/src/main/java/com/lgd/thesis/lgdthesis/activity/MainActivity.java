package com.lgd.thesis.lgdthesis.activity;

import android.databinding.DataBindingUtil;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.jakewharton.rxbinding.support.design.widget.RxNavigationView;
import com.lgd.thesis.lgdthesis.R;
import com.lgd.thesis.lgdthesis.adapter.MyFragmentAdapter;
import com.lgd.thesis.lgdthesis.databinding.ActivityMainBinding;
import com.lgd.thesis.lgdthesis.databinding.NavDrawerHeaderBinding;
import com.lgd.thesis.lgdthesis.fragment.FindFragment;
import com.lgd.thesis.lgdthesis.fragment.HomeFragment;
import com.lgd.thesis.lgdthesis.rx.RxActionBarDrawerToggle;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mBinding;
    private NavigationView mNavigationView;
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private MyFragmentAdapter myFragmentAdapter;
    private HomeFragment homeFragment;
    private FindFragment findFragment;
    private CompositeSubscription mSubscription = new CompositeSubscription();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mNavigationView = mBinding.navigationView;
        mToolbar = mBinding.toolbar;
        mDrawerLayout = mBinding.drawerLayout;
        myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager());

        setUpNavigationView();
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        NavDrawerHeaderBinding navHeaderBinding = NavDrawerHeaderBinding.inflate(LayoutInflater
                .from(this), mNavigationView, false);
        View headerView = navHeaderBinding.getRoot();
        mNavigationView.addHeaderView(headerView);

//        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, HomeFragment.newInstance()).commit();
        initFragment();


        Observable<Boolean> observable = RxActionBarDrawerToggle.drawerOpen(this, mDrawerLayout, mToolbar);
        Subscription subscription = observable.subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean aBoolean) {
                notifyDrawerStatus(aBoolean);
            }
        });
        mSubscription.add(subscription);

    }

    public void initFragment(){
        homeFragment = new HomeFragment();
        findFragment = new FindFragment();
        myFragmentAdapter.addFragment(homeFragment);
        myFragmentAdapter.addFragment(findFragment);
        mBinding.viewpagerMain.setAdapter(myFragmentAdapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
            return;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tool_bar_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    private void notifyDrawerStatus(boolean isOpen) {
        if (isOpen) {
        }
    }

    private void setUpNavigationView() {
        mNavigationView.setItemIconTintList(null);

        Observable<MenuItem> observable = RxNavigationView.itemSelections(mNavigationView);
        Subscription subscription = observable.subscribe(new Action1<MenuItem>() {
            @Override
            public void call(MenuItem menuItem) {
                onNavigationMenuItemSelected(menuItem);
            }
        });
        mSubscription.add(subscription);
    }

    private void onNavigationMenuItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_rate_us:
                Log.d("TAG","nav_rate_us");
                break;
            case R.id.nav_share_weather:
                Log.d("TAG","nav_rate_us");

                break;
            case R.id.nav_share_lifely:
                Log.d("TAG","nav_rate_us");

                break;
            case R.id.nav_about:
                Log.d("TAG","nav_rate_us");

                break;
            case R.id.nav_feedback:
                Log.d("TAG","nav_rate_us");

                break;
        }
    }
}
