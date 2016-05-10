package com.google.samples.quickstart.signin.drawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.samples.quickstart.signin.R;
import com.google.samples.quickstart.signin.login.ChooserActivity;
import com.google.samples.quickstart.signin.login.FormActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DrawerActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private Toolbar toolbar;
    private ListView menuListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Menu");
        setSupportActionBar(toolbar);

        setupDrawerLayout();
        setupDrawerSource();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Setup the layout of the navigation drawer
     */
    private void setupDrawerLayout() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

    }

    /**
     * Setup the source of the navigation drawer
     */
    private void setupDrawerSource() {
        menuListView = (ListView) findViewById(R.id.list_view);

        List<String> values = new ArrayList<>(Arrays.asList(
                getString(R.string.dashboard),
                getString(R.string.access_google_form_activity)));

        DrawerAdapter adapter = new DrawerAdapter(values);
        menuListView.setAdapter(adapter);
        menuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                drawer.closeDrawer(menuListView);
                String titleClicked = (String) parent.getAdapter().getItem(position);

                if (getString(R.string.dashboard).equalsIgnoreCase(titleClicked)){
                    Intent intent = new Intent(DrawerActivity.this, ChooserActivity.class);
                    startActivity(intent);
                }else if (getString(R.string.access_google_form_activity).equalsIgnoreCase(titleClicked)){
                    Intent intent = new Intent(DrawerActivity.this, FormActivity.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(DrawerActivity.this, ChooserActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}
