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
            if (building.getDescription() != null) {
                ((TextView) rootView.findViewById(R.id.description)).setText("Description: " + building.getDescription());
            } else {
                rootView.findViewById(R.id.description).setVisibility(View.GONE);
            }

            ((TextView) rootView.findViewById(R.id.cost)).setText("Cost: " + building.getCost() + " production");
            ((TextView) rootView.findViewById(R.id.maintenance)).setText("Maintenance: " + building.getMaintenance() + " gold per turn");

            if (building.getPrereqTech() != null) {
                ((TextView) rootView.findViewById(R.id.prereq_tech)).setText("Technology: " + building.getPrereqTech());

            } else {
                rootView.findViewById(R.id.prereq_tech).setVisibility(View.GONE);
            }
            if (building.getPrereqCivic() != null) {
                ((TextView) rootView.findViewById(R.id.prereq_civic)).setText("Civic: " + building.getPrereqCivic());

            } else {
                rootView.findViewById(R.id.prereq_civic).setVisibility(View.GONE);
            }
            if (building.getPrereqDistrict() != null) {
                ((TextView) rootView.findViewById(R.id.prereq_district)).setText("District: " + building.getPrereqDistrict());

            } else {
                rootView.findViewById(R.id.prereq_district).setVisibility(View.GONE);
            }
        }

        return rootView;
    }

}
