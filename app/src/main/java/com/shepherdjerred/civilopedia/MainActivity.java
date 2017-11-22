package com.shepherdjerred.civilopedia;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.shepherdjerred.civilopedia.activities.building.BuildingListActivity;
import com.shepherdjerred.civilopedia.activities.citystate.CityStateListActivity;
import com.shepherdjerred.civilopedia.activities.civic.CivicListActivity;
import com.shepherdjerred.civilopedia.activities.civilization.CivilizationListActivity;
import com.shepherdjerred.civilopedia.activities.district.DistrictListActivity;
import com.shepherdjerred.civilopedia.activities.feature.FeatureListActivity;
import com.shepherdjerred.civilopedia.activities.government.GovernmentListActivity;
import com.shepherdjerred.civilopedia.activities.greatperson.GreatPersonListActivity;
import com.shepherdjerred.civilopedia.activities.improvement.ImprovementListActivity;
import com.shepherdjerred.civilopedia.activities.leader.LeaderListActivity;
import com.shepherdjerred.civilopedia.activities.policy.PolicyListActivity;
import com.shepherdjerred.civilopedia.activities.project.ProjectListActivity;
import com.shepherdjerred.civilopedia.activities.religion.ReligionListActivity;
import com.shepherdjerred.civilopedia.activities.resource.ResourceListActivity;
import com.shepherdjerred.civilopedia.activities.route.RouteListActivity;
import com.shepherdjerred.civilopedia.activities.terrain.TerrainListActivity;
import com.shepherdjerred.civilopedia.activities.unit.UnitListActivity;
import com.shepherdjerred.civilopedia.activities.unitpromotion.UnitPromotionListActivity;
import com.shepherdjerred.civilopedia.activities.wonder.WonderListActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

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
        AdView mAdView = findViewById(R.id.main_ad);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Intent intent = null;

        if (id == R.id.nav_civilizations) {
            intent = new Intent(this, CivilizationListActivity.class);
        } else if (id == R.id.nav_leaders) {
            intent = new Intent(this, LeaderListActivity.class);
        } else if (id == R.id.nav_city_states) {
            intent = new Intent(this, CityStateListActivity.class);
        } else if (id == R.id.nav_districts) {
            intent = new Intent(this, DistrictListActivity.class);
        } else if (id == R.id.nav_buildings) {
            intent = new Intent(this, BuildingListActivity.class);
        } else if (id == R.id.nav_wonders) {
            intent = new Intent(this, WonderListActivity.class);
        } else if (id == R.id.nav_projects) {
            intent = new Intent(this, ProjectListActivity.class);
        } else if (id == R.id.nav_units) {
            intent = new Intent(this, UnitListActivity.class);
        } else if (id == R.id.nav_unit_promotions) {
            intent = new Intent(this, UnitPromotionListActivity.class);
        } else if (id == R.id.nav_great_people) {
            intent = new Intent(this, GreatPersonListActivity.class);
        } else if (id == R.id.nav_technologies) {
            intent = new Intent(this, TerrainListActivity.class);
        } else if (id == R.id.nav_civics) {
            intent = new Intent(this, CivicListActivity.class);
        } else if (id == R.id.nav_governments) {
            intent = new Intent(this, GovernmentListActivity.class);
        } else if (id == R.id.nav_policies) {
            intent = new Intent(this, PolicyListActivity.class);
        } else if (id == R.id.nav_religion) {
            intent = new Intent(this, ReligionListActivity.class);
        } else if (id == R.id.nav_terrain) {
            intent = new Intent(this, TerrainListActivity.class);
        } else if (id == R.id.nav_features) {
            intent = new Intent(this, FeatureListActivity.class);
        } else if (id == R.id.nav_resources) {
            intent = new Intent(this, ResourceListActivity.class);
        } else if (id == R.id.nav_improvements) {
            intent = new Intent(this, ImprovementListActivity.class);
        } else if (id == R.id.nav_routes) {
            intent = new Intent(this, RouteListActivity.class);
        }

        if (intent != null) {
            startActivity(intent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
