package com.example.insurancedemo2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Switch;

import com.example.insurancedemo2.ui.home.HomeFragment;
import com.example.insurancedemo2.ui.office.OfficeFragment;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        toolbar=(Toolbar) findViewById(R.id.main_activity_toolbar);
        setSupportActionBar(toolbar);

        drawerLayout=(DrawerLayout) findViewById(R.id.main_activity_drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        navigationView=(NavigationView) findViewById(R.id.main_activity_navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Default Fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_activity_linearlayout, new HomeFragment())
                .commit();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull @org.jetbrains.annotations.NotNull MenuItem item) {


        if (item.getItemId()==R.id.nav_home){
            FragmentManager manager= getSupportFragmentManager();
            FragmentTransaction transaction=manager.beginTransaction();

            HomeFragment homeFragment= new HomeFragment();
            transaction.replace(R.id.main_activity_linearlayout,homeFragment);
            transaction.commit();
        }
        if (item.getItemId()==R.id.nav_bilicl_office){

            FragmentManager manager= getSupportFragmentManager();
            FragmentTransaction transaction=manager.beginTransaction();

            OfficeFragment officeFragment= new OfficeFragment();
            transaction.replace(R.id.main_activity_linearlayout,officeFragment);
            transaction.commit();

        }
        if (item.getItemId()==R.id.nav_bilicl_website){}
        if (item.getItemId()==R.id.nav_social_facebook){}
        if (item.getItemId()==R.id.nav_social_linkedin){}
        if (item.getItemId()==R.id.nav_social_mastodon){}
        if (item.getItemId()==R.id.nav_social_twitter){}



        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }
}