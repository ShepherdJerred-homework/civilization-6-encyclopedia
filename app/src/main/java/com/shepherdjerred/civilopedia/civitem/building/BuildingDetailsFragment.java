package com.shepherdjerred.civilopedia.civitem.building;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shepherdjerred.civilopedia.R;
import com.shepherdjerred.civilopedia.civitem.CivItemDetailsFragment;

public class BuildingDetailsFragment extends CivItemDetailsFragment {

    private Resources res;

    private ImageView icon;
    private TextView description;
    private TextView cost;
    private TextView maintenance;
    private LinearLayout prereq;
    private TextView prereqTech;
    private TextView prereqCivic;
    private TextView prereqDistrict;

    private Building building;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_building_details, container, false);

        if (civItem != null && civItem instanceof Building) {
            building = (Building) civItem;
            bindViews(rootView);
            bindValues();
        }

        return rootView;
    }

    private void bindViews(View view) {
        icon = view.findViewById(R.id.icon);
        description = view.findViewById(R.id.description);
        cost = view.findViewById(R.id.cost);
        maintenance = view.findViewById(R.id.maintenance);
        prereq = view.findViewById(R.id.prereq);
        prereqTech = view.findViewById(R.id.prereq_tech);
        prereqCivic = view.findViewById(R.id.prereq_civic);
        prereqDistrict = view.findViewById(R.id.prereq_district);
    }

    private void bindValues() {
        res = getResources();

        String iconResourceName = building.getName().toLowerCase().replace(" ", "_");
        int iconResourceId = res.getIdentifier(iconResourceName, "drawable", getContext().getPackageName());

        if (iconResourceId != 0) {
            icon.setImageDrawable(res.getDrawable(iconResourceId));
        }

        if (building.getDescription() != null) {
            description.setText(res.getString(R.string.description, building.getDescription()));
        } else {
            description.setVisibility(View.GONE);
        }

        cost.setText("Cost: " + building.getCost() + " production");
        maintenance.setText("Maintenance: " + building.getMaintenance() + " gold per turn");

        if (building.getPrereqTech() == null && building.getPrereqCivic() == null && building.getPrereqDistrict() == null) {
            prereq.setVisibility(View.GONE);
        } else {

            if (building.getPrereqTech() != null) {
                prereqTech.setText("Technology: " + building.getPrereqTech());
            } else {
                prereqTech.setVisibility(View.GONE);
            }

            if (building.getPrereqCivic() != null) {
                prereqCivic.setText("Civic: " + building.getPrereqCivic());
            } else {
                prereqCivic.setVisibility(View.GONE);
            }

            if (building.getPrereqDistrict() != null) {
                prereqDistrict.setText("District: " + building.getPrereqDistrict());
            } else {
                prereqDistrict.setVisibility(View.GONE);
            }
        }
    }
}
