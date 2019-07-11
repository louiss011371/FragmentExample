package com.example.fragmentexample;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class ShowAllItemActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    TextView showAll;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_item);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");

        showAll = findViewById(R.id.showAllPage);

        drawer = findViewById(R.id.drawer_layout);
        setSupportActionBar(toolbar);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
                Intent home = new Intent(ShowAllItemActivity.this, HomeActivity.class);
                startActivity(home);
                break;
            case R.id.nav_createNewItem:
                Intent createNew = new Intent(ShowAllItemActivity.this, CreateNewItemActivity.class);
                startActivity(createNew);
                break;
            case R.id.nav_showAll:
                Intent showAll = new Intent(ShowAllItemActivity.this, ShowAllItemActivity.class);
                startActivity(showAll);
                break;
            case R.id.nav_chat:
                Intent chat = new Intent(ShowAllItemActivity.this, ChatActivity.class);
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