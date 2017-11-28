package com.shepherdjerred.civilopedia.civitem.leader;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shepherdjerred.civilopedia.R;
import com.shepherdjerred.civilopedia.civitem.CivItemDetailsFragment;
import com.shepherdjerred.civilopedia.civitem.unit.Unit;

public class LeaderDetailsFragment extends CivItemDetailsFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_leader_details, container, false);

        if (civItem != null && civItem instanceof Leader) {
            Leader leader = (Leader) civItem;
        }

        return rootView;
    }

}
