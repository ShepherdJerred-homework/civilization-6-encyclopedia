package com.shepherdjerred.civilopedia.civitem.policy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shepherdjerred.civilopedia.R;
import com.shepherdjerred.civilopedia.civitem.CivItemDetailsFragment;

public class PolicyDetailsFragment extends CivItemDetailsFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_policy_details, container, false);

        if (civItem != null && civItem instanceof Policy) {
            Policy policy = (Policy) civItem;
            ((TextView) rootView.findViewById(R.id.description)).setText("Description: " + policy.getDescription());
        }

        return rootView;
    }

}
