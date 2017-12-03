package com.shepherdjerred.civilopedia.civitem.improvements;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shepherdjerred.civilopedia.R;
import com.shepherdjerred.civilopedia.civitem.CivItemDetailsFragment;

public class ImprovementDetailsFragment extends CivItemDetailsFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_improvement_details, container, false);

        if (civItem != null && civItem instanceof Improvement) {
            Improvement improvement = (Improvement) civItem;
            ((TextView) rootView.findViewById(R.id.description)).setText("Description: " + improvement.getDescription().replace("[NEWLINE]", "\n"));
        }

        return rootView;
    }
}
