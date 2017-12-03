package com.shepherdjerred.civilopedia.civitem.government;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shepherdjerred.civilopedia.R;
import com.shepherdjerred.civilopedia.civitem.CivItemDetailsFragment;

public class GovernmentDetailsFragment extends CivItemDetailsFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_government_details, container, false);

        if (civItem != null && civItem instanceof Government) {
            Government government = (Government) civItem;
            ((TextView) rootView.findViewById(R.id.inherentDescription)).setText("Inherent Bonus: " + government.getInherentDescription());
            ((TextView) rootView.findViewById(R.id.accumulatedDescription)).setText("Accumulated Bonus: " + government.getAccumulatedDescription());
        }

        return rootView;
    }

}
