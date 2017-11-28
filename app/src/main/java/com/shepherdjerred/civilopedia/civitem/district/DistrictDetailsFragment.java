package com.shepherdjerred.civilopedia.civitem.district;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shepherdjerred.civilopedia.R;
import com.shepherdjerred.civilopedia.civitem.CivItemDetailsFragment;

public class DistrictDetailsFragment extends CivItemDetailsFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_district_details, container, false);

        if (civItem != null && civItem instanceof District) {
            District district = (District) civItem;
            ((TextView) rootView.findViewById(R.id.description)).setText("Description: " + district.getDescription());

            ((TextView) rootView.findViewById(R.id.prereq_tech)).setText("Technology: " + district.getPrereqTech());
            ((TextView) rootView.findViewById(R.id.prereq_civic)).setText("Civic: " + district.getPrereqCivic());

            ((TextView) rootView.findViewById(R.id.description)).setText("Hit points: " + district.getHitPoints());
        }

        return rootView;
    }

}
