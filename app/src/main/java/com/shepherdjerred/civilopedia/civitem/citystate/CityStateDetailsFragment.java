package com.shepherdjerred.civilopedia.civitem.citystate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shepherdjerred.civilopedia.R;
import com.shepherdjerred.civilopedia.civitem.CivItemDetailsFragment;
import com.shepherdjerred.civilopedia.civitem.project.Project;

public class CityStateDetailsFragment extends CivItemDetailsFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_citystate_details, container, false);

        if (civItem != null && civItem instanceof CityState) {
            CityState cityState = (CityState) civItem;
            ((TextView) rootView.findViewById(R.id.description)).setText("Description: " + cityState.getDescription());
        }

        return rootView;
    }

}
