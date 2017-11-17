package com.shepherdjerred.civilopedia;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shepherdjerred.civilopedia.object.Building;

public class BuildingDetailFragment extends Fragment {

    public static final String ARG_ITEM = "item";
    private Building mBuilding;

    public BuildingDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM)) {
            mBuilding = getArguments().getParcelable(ARG_ITEM);

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mBuilding.getName());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.building_detail, container, false);

        if (mBuilding != null) {
            ((TextView) rootView.findViewById(R.id.prereq_tech)).setText("Prerequisite technology: " + mBuilding.getPrereqTech());
            ((TextView) rootView.findViewById(R.id.prereq_civic)).setText("Prerequisite civics: " + mBuilding.getPrereqCivic());
            ((TextView) rootView.findViewById(R.id.cost)).setText("Production cost: " + mBuilding.getCost());
            ((TextView) rootView.findViewById(R.id.capital)).setText("Requirements: " + mBuilding.isCapital());
            ((TextView) rootView.findViewById(R.id.prereq_district)).setText("Prerequisite district: " + mBuilding.getPrereqDistrict());
            ((TextView) rootView.findViewById(R.id.description)).setText("Description: " + mBuilding.getDescription());
            ((TextView) rootView.findViewById(R.id.outer_defense_hit_points)).setText("Outer defense hit points: " + mBuilding.getOuterDefenseHitPoints());
            ((TextView) rootView.findViewById(R.id.housing)).setText(String.valueOf("Housing: " + mBuilding.getHousing()));
            ((TextView) rootView.findViewById(R.id.entertainment)).setText("Entertainment: " + mBuilding.getEntertainment());
            ((TextView) rootView.findViewById(R.id.maintenance)).setText("Maintenance: " + mBuilding.getMaintenance());
            ((TextView) rootView.findViewById(R.id.trait_type)).setText("Trait type: " + mBuilding.getTraitType());
            ((TextView) rootView.findViewById(R.id.outer_defense_strength)).setText("Outer defense strength: " + mBuilding.getOuterDefenseStrength());
            ((TextView) rootView.findViewById(R.id.citizen_slots)).setText("Citizen slots: " + mBuilding.getCitizenSlots());
            ((TextView) rootView.findViewById(R.id.requires_adj_river)).setText("Requires adjacent river: " + mBuilding.isRequiresAdjacentRiver());
        }

        return rootView;
    }
}
