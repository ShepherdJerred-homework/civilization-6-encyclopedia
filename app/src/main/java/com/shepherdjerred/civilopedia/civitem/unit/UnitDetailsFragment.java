package com.shepherdjerred.civilopedia.civitem.unit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shepherdjerred.civilopedia.R;
import com.shepherdjerred.civilopedia.civitem.CivItemDetailsFragment;

public class UnitDetailsFragment extends CivItemDetailsFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_unit_details, container, false);

        if (civItem != null && civItem instanceof Unit) {
            Unit unit = (Unit) civItem;
            ((TextView) rootView.findViewById(R.id.description)).setText("Description: " + unit.getDescription());
            ((TextView) rootView.findViewById(R.id.cost)).setText("Production cost: " + unit.getCost());
        }

        return rootView;
    }

}
