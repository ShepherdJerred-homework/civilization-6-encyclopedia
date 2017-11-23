package com.shepherdjerred.civilopedia.civitem.leader;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shepherdjerred.civilopedia.R;
import com.shepherdjerred.civilopedia.civitem.CivItemDetailsFragment;

public class LeaderDetailsFragment extends CivItemDetailsFragment {

    private static final String ARG_LEADER = "leader";
    private Leader mLeader;

    public static LeaderDetailsFragment newInstance(Leader civilization) {
        LeaderDetailsFragment fragment = new LeaderDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_LEADER, civilization);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mLeader = getArguments().getParcelable(ARG_LEADER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_leader_details, container, false);

        if (mLeader != null) {

        }

        return rootView;
    }

}
