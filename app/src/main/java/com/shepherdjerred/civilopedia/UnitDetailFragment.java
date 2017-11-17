package com.shepherdjerred.civilopedia;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shepherdjerred.civilopedia.object.Unit;

public class UnitDetailFragment extends Fragment {

    public static final String ARG_ITEM = "unit";
    private Unit mUnit;

    public UnitDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM)) {
            mUnit = getArguments().getParcelable(ARG_ITEM);
            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mUnit.getName());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.unit_detail, container, false);

        if (mUnit != null) {
            ((TextView) rootView.findViewById(R.id.description)).setText(mUnit.getDescription());
        }

        return rootView;
    }
}
