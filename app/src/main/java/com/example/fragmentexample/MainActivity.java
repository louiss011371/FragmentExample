package com.example.fragmentexample;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    TextView currentUserName;
    TextView homepageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");

        drawer = findViewById(R.id.drawer_layout);


        setSupportActionBar(toolbar);
        NavigationView navigationView = findViewById(R.id.nav_view);

        homepageText = findViewById(R.id.homePage);
        navigationView.setNavigationItemSelectedListener(this);


        View inflatedView = getLayoutInflater().inflate(R.layout.nav_header, null);
        currentUserName = inflatedView.findViewById(R.id.user_name);

        Toast.makeText(getApplicationContext(), "CurrentUserName= " + currentUserName.getText(), Toast.LENGTH_LONG).show();


        drawer.bringToFront();
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


//======================================= default show the home fragment  ========================================================//
    }


//===============================================================================================================================//

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        switch (id) {

            case R.id.nav_home:
                Intent home = new Intent(MainActivity.this, MainActivity.class);
                startActivity(home);
                break;
            case R.id.nav_createNewItem:
                Intent createNew = new Intent(MainActivity.this, CreateNewItemActivity.class);
                startActivity(createNew);
                break;
            case R.id.nav_showAll:
                Intent showAll = new Intent(MainActivity.this, ShowAllItemActivity.class);
                startActivity(showAll);
                break;
            case R.id.nav_chat:
                Intent chat = new Intent(MainActivity.this, ChatActivity.class);
                startActivity(chat);
                break;
            // this is done, now let us go and intialise the home page.
            // after this lets start copying the above.
            // FOLLOW MEEEEE>>>
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;


    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }
}