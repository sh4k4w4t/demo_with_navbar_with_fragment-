package com.example.insurancedemo2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=(Toolbar) findViewById(R.id.main_activity_toolbar);
        setSupportActionBar(toolbar);

        drawerLayout=(DrawerLayout) findViewById(R.id.main_activity_drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView=(NavigationView) findViewById(R.id.main_activity_navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull @org.jetbrains.annotations.NotNull MenuItem item) {

        if (item.getItemId()==R.id.nav_home){}
        if (item.getItemId()==R.id.nav_bilicl_office){}
        if (item.getItemId()==R.id.nav_bilicl_website){}
        if (item.getItemId()==R.id.nav_social_facebook){}
        if (item.getItemId()==R.id.nav_social_linkedin){}
        if (item.getItemId()==R.id.nav_social_mastodon){}
        if (item.getItemId()==R.id.nav_social_twitter){}

        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }
}