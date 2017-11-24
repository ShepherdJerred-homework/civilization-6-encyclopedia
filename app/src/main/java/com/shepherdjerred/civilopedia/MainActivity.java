package com.shepherdjerred.civilopedia;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.ads.MobileAds;
import com.shepherdjerred.civilopedia.civitem.CivItem;
import com.shepherdjerred.civilopedia.civitem.CivItemDetailsFragment;
import com.shepherdjerred.civilopedia.civitem.CivItemListFragment;
import com.shepherdjerred.civilopedia.civitem.building.Building;
import com.shepherdjerred.civilopedia.civitem.building.BuildingDetailsFragment;
import com.shepherdjerred.civilopedia.civitem.citystate.CityState;
import com.shepherdjerred.civilopedia.civitem.citystate.CityStateDetailsFragment;
import com.shepherdjerred.civilopedia.civitem.civilization.Civilization;
import com.shepherdjerred.civilopedia.civitem.civilization.CivilizationDetailsFragment;
import com.shepherdjerred.civilopedia.civitem.leader.Leader;
import com.shepherdjerred.civilopedia.civitem.leader.LeaderDetailsFragment;
import com.shepherdjerred.civilopedia.storage.Datastore;
import com.shepherdjerred.civilopedia.storage.sqlite.SqliteDatastore;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        CivItemListFragment.OnListFragmentInteractionListener,
        CivItemDetailsFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        MobileAds.initialize(this, "ca-app-pub-8402769089231334~8559189179");

//        AdView mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        Datastore datastore = new SqliteDatastore(getApplicationContext());
        ArrayList<? extends CivItem> civItems = null;

        switch (id) {
            case R.id.nav_home:
                break;
            case R.id.nav_buildings:
                civItems = datastore.getBuildings();
                break;
            case R.id.nav_civilizations:
                civItems = datastore.getCivilizations();
                break;
            case R.id.nav_leaders:
                civItems = datastore.getLeaders();
                break;
            case R.id.nav_city_states:
                civItems = datastore.getCityStates();
                break;
        }

        if (civItems != null) {
            Fragment fragment = CivItemListFragment.newInstance(civItems);
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, fragment)
                    .addToBackStack(null)
                    .commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onListFragmentInteraction(CivItem item) {
        Fragment fragment = null;

        if (item instanceof Building) {
            fragment = BuildingDetailsFragment.newInstance((Building) item);
        } else if (item instanceof Civilization) {
            fragment = CivilizationDetailsFragment.newInstance((Civilization) item);
        } else if (item instanceof Leader) {
            fragment = LeaderDetailsFragment.newInstance((Leader) item);
        } else if (item instanceof CityState) {
            fragment = CityStateDetailsFragment.newInstance((CityState) item);
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, fragment)
                    .addToBackStack(null)
                    .commit();
        }
    }

    @Override
    public void onCivItemDetailsFragmentInteraction(Uri uri) {

    }
}
