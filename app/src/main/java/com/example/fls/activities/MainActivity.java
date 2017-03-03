package com.example.fls.activities;


import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.fls.R;
import com.example.fls.fragments.HomePage;
import com.example.fls.fragments.ProductCategory;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Trang Chủ");
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.open, R.string.close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.content_main, new HomePage()).commit();

        View header = navigationView.getHeaderView(0);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
            xfragmentTransaction.replace(R.id.content_main,new HomePage()).commit();
            setTitle("Trang Chủ");
        } else if (id == R.id.nav_user) {
           /* if (!sessionManager.isLoggedIn()) {
                Intent intent = new Intent(getApplication(), Login_Activity.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(getApplication(), UserManager_Activity.class);
                startActivity(intent);
            }*/

        } else if (id == R.id.nav_cate) {
           FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
            xfragmentTransaction.replace(R.id.content_main,new ProductCategory()).commit();
            setTitle("Danh Mục");
        } else if (id == R.id.nav_setting) {
        /*    Intent intent = new Intent(getApplication(), Setting_Activity.class);
            startActivity(intent);*/
        }else if(id == R.id.nav_news){
          /*  FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
            xfragmentTransaction.replace(R.id.content_main,new News_Fragment()).commit();
            setTitle("Tin Tức");*/
        }else if (id == R.id.nav_support) {
           /* FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
            xfragmentTransaction.replace(R.id.content_main,new Support_Fragment()).commit();
            setTitle("Hỗ Trợ Và Liên Hệ");*/
        }else if (id == R.id.nav_about_us) {
         /*   FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
            xfragmentTransaction.replace(R.id.content_main,new Aboutus_Fragment()).commit();
            setTitle("Về Chúng Tôi");*/
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
