package com.shepherdjerred.civilopedia.civitem.feature;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shepherdjerred.civilopedia.R;
import com.shepherdjerred.civilopedia.civitem.CivItemDetailsFragment;

public class FeatureDetailsFragment extends CivItemDetailsFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_feature_details, container, false);

        if (civItem != null && civItem instanceof Feature) {
            Feature feature = (Feature) civItem;

            // The first 6 features have no description.
            if (feature.getDescription() != null) {
                ((TextView) rootView.findViewById(R.id.description)).setText("Description: " + feature.getDescription());
            }
            else {
                ((TextView) rootView.findViewById(R.id.description)).setText("Description: No description for this feature.");
            }
        }

        return rootView;
    }

}
