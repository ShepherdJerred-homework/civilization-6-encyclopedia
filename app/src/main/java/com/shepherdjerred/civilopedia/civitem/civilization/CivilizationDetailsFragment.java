package com.shepherdjerred.civilopedia.civitem.civilization;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shepherdjerred.civilopedia.R;
import com.shepherdjerred.civilopedia.civitem.CivItemDetailsFragment;
import com.shepherdjerred.civilopedia.civitem.project.Project;

public class CivilizationDetailsFragment extends CivItemDetailsFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_civilization_details, container, false);

        if (civItem != null && civItem instanceof Civilization) {
            Civilization civilization = (Civilization) civItem;
            ((TextView) rootView.findViewById(R.id.description)).setText("Description: " + civilization.getDescription());
        }

        return rootView;
    }

}
