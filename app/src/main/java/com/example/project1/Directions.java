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
import android.widget.Spinner;

public class Directions extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Spinner spinner1, spinner2;
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directions);

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        btnSubmit=(Button)findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String item1=spinner1.toString();
                String item2=spinner2.toString();
                if((String.valueOf(spinner1.getSelectedItem()).equals("Toll Gate"))&&(String.valueOf(spinner2.getSelectedItem()).equals("Planetarium")))
                {
                    Intent myIntent=new Intent(Directions.this,directions_toll_planetarium.class);
                    startActivity(myIntent);
                }
                else
                if((String.valueOf(spinner1.getSelectedItem()).equals("Toll Gate"))&&(String.valueOf(spinner2.getSelectedItem()).equals("Nuclear")))
                {
                    Intent myIntent=new Intent(Directions.this,directions_toll_nuclear.class);
                    startActivity(myIntent);
                }
                else
                if((String.valueOf(spinner1.getSelectedItem()).equals("Toll Gate"))&&(String.valueOf(spinner2.getSelectedItem()).equals("DRDO")))
                {
                    Intent myIntent=new Intent(Directions.this,directions_toll_drdo.class);
                    startActivity(myIntent);
                }
                else
                if((String.valueOf(spinner1.getSelectedItem()).equals("Toll Gate"))&&(String.valueOf(spinner2.getSelectedItem()).equals("Periyar Gallery")))
                {
                    Intent myIntent=new Intent(Directions.this,directions_toll_periyar.class);
                    startActivity(myIntent);
                }
            }
        });





        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
            Intent myIntent=new Intent(Directions.this,MainActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_about) {
            // Handle the camera action
            Intent myIntent=new Intent(Directions.this,AboutUs.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_map) {
            Intent myIntent=new Intent(Directions.this,Maps.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_directions) {

        } else if (id == R.id.nav_showtimings) {
            Intent myIntent=new Intent(Directions.this,ShowTimings.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_contactus) {
            Intent myIntent=new Intent(Directions.this,ContactUs.class);
            startActivity(myIntent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}


