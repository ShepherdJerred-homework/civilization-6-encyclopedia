package com.shepherdjerred.civilopedia.civitem.building;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shepherdjerred.civilopedia.R;
import com.shepherdjerred.civilopedia.civitem.CivItemDetailsFragment;

public class BuildingDetailsFragment extends CivItemDetailsFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_building_details, container, false);

        if (civItem != null && civItem instanceof Building) {
            Building building = (Building) civItem;
            ((TextView) rootView.findViewById(R.id.description)).setText("Description: " + building.getDescription());
            ((TextView) rootView.findViewById(R.id.cost)).setText("Production cost: " + building.getCost());
            ((TextView) rootView.findViewById(R.id.maintenance)).setText("Maintenance: " + building.getMaintenance());

            ((TextView) rootView.findViewById(R.id.prereq_tech)).setText("Technology: " + building.getPrereqTech());
            ((TextView) rootView.findViewById(R.id.prereq_civic)).setText("Civic: " + building.getPrereqCivic());
            ((TextView) rootView.findViewById(R.id.prereq_district)).setText("District: " + building.getPrereqDistrict());

            ((TextView) rootView.findViewById(R.id.outer_defense_hit_points)).setText("Hit points: " + building.getOuterDefenseHitPoints());
            ((TextView) rootView.findViewById(R.id.outer_defense_strength)).setText("Strength: " + building.getOuterDefenseStrength());
        }

        return rootView;
    }

}
