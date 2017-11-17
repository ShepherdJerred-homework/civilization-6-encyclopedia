package com.shepherdjerred.civilopedia;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shepherdjerred.civilopedia.object.Building;

import java.util.ArrayList;
import java.util.List;

/**
 * An activity representing a list of Buildings. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link BuildingDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class BuildingListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        if (findViewById(R.id.building_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }

        View recyclerView = findViewById(R.id.building_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {

        List<Building> buildings = new ArrayList<>();
        CivilopediaDatabase civilopediaDatabase = new CivilopediaDatabase(getApplicationContext());
        SQLiteDatabase sqLiteDatabase = civilopediaDatabase.getReadableDatabase();

        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM Buildings WHERE IsWonder == 0", null);
        if (c.moveToFirst()) {
            do {
                String buildingType = c.getString(0);
                String name = c.getString(1);
                String prereqTech = c.getString(2);
                String prereqCivic = c.getString(3);
                int cost = c.getInt(4);
                int maxPlayerInstances = c.getInt(5);
                int maxWorldInstances = c.getInt(6);
                boolean capital = c.getInt(7) != 0;
                String prereqDistrict = c.getString(8);
                String adjacentDistrict = c.getString(9);
                String description = c.getString(10);
                boolean requiresPlacement = c.getInt(11) != 0;
                boolean requiresRiver = c.getInt(12) != 0;
                int outerDefenseHitPoints = c.getInt(13);
                int housing = c.getInt(14);
                int entertainment = c.getInt(15);
                String adjacentResource = c.getString(16);
                boolean coast = c.getInt(17) != 0;
                boolean enabledByReligion = c.getInt(18) != 0;
                boolean allowsHolyCity = c.getInt(19) != 0;
                String purchaseYield = c.getString(20);
                boolean mustPurchase = c.getInt(21) != 0;
                int maintenance = c.getInt(22);
                boolean isWonder = c.getInt(23) != 0;
                String traitType = c.getString(24);
                int outerDefenseStrength = c.getInt(25);
                int citizenSlots = c.getInt(25);
                boolean mustBeLake = c.getInt(27) != 0;
                boolean mustNotBeLake = c.getInt(28) != 0;
                int regionalRange = c.getInt(29);
                boolean adjacentToMountain = c.getInt(30) != 0;
                String obsoleteEra = c.getString(31);
                boolean requiresReligion = c.getInt(32) != 0;
                int grantFortification = c.getInt(33);
                int defenseModifier = c.getInt(34);
                boolean internalOnly = c.getInt(35) != 0;
                boolean requiresAdjacentRiver = c.getInt(36) != 0;
                String quote = c.getString(37);
                String quoteAudio = c.getString(38);
                boolean mustBeAdjacentLand = c.getInt(39) != 0;
                boolean adjacentCapital = c.getInt(40) != 0;
                String adjacentImprovement = c.getString(41);
                String cityAdjacentTerrain = c.getString(42);
                boolean unlockGovernmentPolicy = c.getInt(43) != 0;
                String governmentTierRequirement = c.getString(44);

                Building building = new Building(buildingType, name, prereqTech, prereqCivic, cost, maxPlayerInstances, maxWorldInstances,
                        capital, prereqDistrict, adjacentDistrict, description, requiresPlacement, requiresRiver, outerDefenseHitPoints,
                        housing, entertainment, adjacentResource, coast, enabledByReligion, allowsHolyCity, purchaseYield, mustPurchase,
                        maintenance, isWonder, traitType, outerDefenseStrength, citizenSlots, mustBeLake, mustNotBeLake, regionalRange,
                        adjacentToMountain, obsoleteEra, requiresReligion, grantFortification, defenseModifier, internalOnly, requiresAdjacentRiver,
                        quote, quoteAudio, mustBeAdjacentLand, adjacentCapital, adjacentImprovement, cityAdjacentTerrain, unlockGovernmentPolicy,
                        governmentTierRequirement);
                buildings.add(building);

            } while (c.moveToNext());
        }
        c.close();
        sqLiteDatabase.close();

        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(this, buildings, mTwoPane));
    }

    public static class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final BuildingListActivity mParentActivity;
        private final List<Building> mValues;
        private final boolean mTwoPane;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Building item = (Building) view.getTag();
                if (mTwoPane) {
                    Bundle arguments = new Bundle();
                    arguments.putString(BuildingDetailFragment.ARG_ITEM, item.getName());
                    BuildingDetailFragment fragment = new BuildingDetailFragment();
                    fragment.setArguments(arguments);
                    mParentActivity.getSupportFragmentManager().beginTransaction()
                            .replace(R.id.building_detail_container, fragment)
                            .commit();
                } else {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, BuildingDetailActivity.class);
                    intent.putExtra(BuildingDetailFragment.ARG_ITEM, item);

                    context.startActivity(intent);
                }
            }
        };

        SimpleItemRecyclerViewAdapter(BuildingListActivity parent,
                                      List<Building> items,
                                      boolean twoPane) {
            mValues = items;
            mParentActivity = parent;
            mTwoPane = twoPane;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.building_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mIdView.setText(mValues.get(position).getName());

            holder.itemView.setTag(mValues.get(position));
            holder.itemView.setOnClickListener(mOnClickListener);
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            final TextView mIdView;

            ViewHolder(View view) {
                super(view);
                mIdView = view.findViewById(R.id.id_text);
            }
        }
    }
}
