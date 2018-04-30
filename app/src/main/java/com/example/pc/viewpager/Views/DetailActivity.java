package com.example.pc.viewpager.Views;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.example.pc.viewpager.Adapters.DetailAdapter;
import com.example.pc.viewpager.Adapters.DetailAdapter;
import com.example.pc.viewpager.R;
public class DetailActivity extends AppCompatActivity{
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        this.configureViewPager();
        this.configureViewPagerAndTabs();

        }




private void configureViewPager(){

        ViewPager pager = (ViewPager)findViewById(R.id.activity_main_viewpager);

        pager.setAdapter(new DetailAdapter(getSupportFragmentManager(), getResources().getIntArray(R.array.colorPagesViewPager)) {
        });
        }
private void configureViewPagerAndTabs(){

        ViewPager pager = (ViewPager)findViewById(R.id.activity_main_viewpager);
        pager.setAdapter(new DetailAdapter(getSupportFragmentManager(), getResources().getIntArray(R.array.colorPagesViewPager)));


        TabLayout tabs= (TabLayout)findViewById(R.id.activity_main_tabs);

        tabs.setupWithViewPager(pager);
        tabs.setTabMode(TabLayout.MODE_FIXED);
        }
        }