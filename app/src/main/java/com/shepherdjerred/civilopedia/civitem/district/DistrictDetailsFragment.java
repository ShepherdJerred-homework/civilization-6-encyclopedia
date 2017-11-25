package com.shepherdjerred.civilopedia.civitem.district;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shepherdjerred.civilopedia.R;
import com.shepherdjerred.civilopedia.civitem.CivItemDetailsFragment;

public class DistrictDetailsFragment extends CivItemDetailsFragment {

    private static final String ARG_DISTRICT = "district";
    private District mDistrict;

    public static DistrictDetailsFragment newInstance(District district) {
        DistrictDetailsFragment fragment = new DistrictDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_DISTRICT, district);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mDistrict = getArguments().getParcelable(ARG_DISTRICT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_district_details, container, false);

        if (mDistrict != null) {
            ((TextView) rootView.findViewById(R.id.description)).setText("Description: " + mDistrict.getDescription());

            ((TextView) rootView.findViewById(R.id.prereq_tech)).setText("Technology: " + mDistrict.getPrereqTech());
            ((TextView) rootView.findViewById(R.id.prereq_civic)).setText("Civic: " + mDistrict.getPrereqCivic());

            ((TextView) rootView.findViewById(R.id.description)).setText("Hit points: " + mDistrict.getHitPoints());
        }

        return rootView;
    }

}
