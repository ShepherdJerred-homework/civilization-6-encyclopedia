package com.shepherdjerred.civilopedia.civitem.unit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shepherdjerred.civilopedia.R;
import com.shepherdjerred.civilopedia.civitem.CivItemDetailsFragment;

public class UnitDetailsFragment extends CivItemDetailsFragment {

    private static final String ARG_UNIT = "unit";
    private Unit mUnit;

    public static UnitDetailsFragment newInstance(Unit unit) {
        UnitDetailsFragment fragment = new UnitDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_UNIT, unit);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mUnit = getArguments().getParcelable(ARG_UNIT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_project_details, container, false);

        if (mUnit != null) {
            ((TextView) rootView.findViewById(R.id.description)).setText("Description: " + mUnit.getDescription());
            ((TextView) rootView.findViewById(R.id.cost)).setText("Production cost: " + mUnit.getCost());
        }

        return rootView;
    }

}
