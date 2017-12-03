package com.shepherdjerred.civilopedia.civitem.technology;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shepherdjerred.civilopedia.R;
import com.shepherdjerred.civilopedia.civitem.CivItemDetailsFragment;

public class TechnologyDetailsFragment extends CivItemDetailsFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_technology_details, container, false);

        if (civItem != null && civItem instanceof Technology) {
            Technology technology = (Technology) civItem;

            // Some technology descriptions are null
            if (technology.getDescription() != null) {
                ((TextView) rootView.findViewById(R.id.description)).setText("Description: " + technology.getDescription());
            }
            else {
                ((TextView) rootView.findViewById(R.id.description)).setText("Description: No description for this feature.");
            }
            ((TextView) rootView.findViewById(R.id.cost)).setText("Cost: " + technology.getCost());
        }

        return rootView;
    }

}
