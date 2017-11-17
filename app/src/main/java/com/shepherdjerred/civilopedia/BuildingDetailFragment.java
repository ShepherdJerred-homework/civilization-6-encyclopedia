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
            ((TextView) rootView.findViewById(R.id.prereq_tech)).setText(mBuilding.getPrereqTech());
            ((TextView) rootView.findViewById(R.id.prereq_civic)).setText(mBuilding.getPrereqCivic());
            ((TextView) rootView.findViewById(R.id.cost)).setText(String.valueOf(mBuilding.getCost()));
            ((TextView) rootView.findViewById(R.id.capital)).setText(String.valueOf(mBuilding.isCapital()));
            ((TextView) rootView.findViewById(R.id.prereq_district)).setText(mBuilding.getPrereqDistrict());
            ((TextView) rootView.findViewById(R.id.description)).setText(mBuilding.getDescription());
            ((TextView) rootView.findViewById(R.id.outer_defense_hit_points)).setText(String.valueOf(mBuilding.getOuterDefenseHitPoints()));
            ((TextView) rootView.findViewById(R.id.housing)).setText(String.valueOf(mBuilding.getHousing()));
            ((TextView) rootView.findViewById(R.id.entertainment)).setText(String.valueOf(mBuilding.getEntertainment()));
            ((TextView) rootView.findViewById(R.id.maintenance)).setText(String.valueOf(mBuilding.getMaintenance()));
            ((TextView) rootView.findViewById(R.id.trait_type)).setText(mBuilding.getTraitType());
            ((TextView) rootView.findViewById(R.id.outer_defense_strength)).setText(String.valueOf(mBuilding.getOuterDefenseStrength()));
            ((TextView) rootView.findViewById(R.id.citizen_slots)).setText(String.valueOf(mBuilding.getCitizenSlots()));
            ((TextView) rootView.findViewById(R.id.requires_adj_river)).setText(String.valueOf(mBuilding.isRequiresAdjacentRiver()));
        }

        return rootView;
    }
}
