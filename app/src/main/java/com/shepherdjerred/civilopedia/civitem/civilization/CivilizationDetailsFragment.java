package com.shepherdjerred.civilopedia.civitem.civilization;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shepherdjerred.civilopedia.R;
import com.shepherdjerred.civilopedia.civitem.CivItemDetailsFragment;

public class CivilizationDetailsFragment extends CivItemDetailsFragment {

    private static final String ARG_CIVILIZATION = "civilization";
    private Civilization mCivilization;

    public static CivilizationDetailsFragment newInstance(Civilization civilization) {
        CivilizationDetailsFragment fragment = new CivilizationDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_CIVILIZATION, civilization);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mCivilization = getArguments().getParcelable(ARG_CIVILIZATION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_civilization_details, container, false);

        if (mCivilization != null) {
            ((TextView) rootView.findViewById(R.id.description)).setText("Description: " + mCivilization.getDescription());
        }

        return rootView;
    }

}
