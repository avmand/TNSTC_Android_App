package com.example.project1;
import android.content.Intent;
import android.os.Bundle;

import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Maps extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Button btnSubmit,btnGround,btnFirst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnSubmit=(Button)findViewById(R.id.BtnLayout);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent=new Intent(Maps.this,Maps_Tnstc_Layout.class);
                startActivity(myIntent);
            }
        });

        btnGround=(Button)findViewById(R.id.btnGround);
        btnGround.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent=new Intent(Maps.this,Maps_Tnstc_Ground.class);
                startActivity(myIntent);
            }
        });

        btnFirst=(Button)findViewById(R.id.btnFirst);
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent=new Intent(Maps.this,Maps_Tnstc_First.class);
                startActivity(myIntent);
            }
        });


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_home) {

        } else if (id == R.id.nav_about) {
            // Handle the camera action
            Intent myIntent=new Intent(Maps.this,AboutUs.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_map) {

        } else if (id == R.id.nav_directions) {
            Intent myIntent=new Intent(Maps.this,Directions.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_showtimings) {
            Intent myIntent=new Intent(Maps.this,ShowTimings.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_contactus) {
            Intent myIntent=new Intent(Maps.this,ContactUs.class);
            startActivity(myIntent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

