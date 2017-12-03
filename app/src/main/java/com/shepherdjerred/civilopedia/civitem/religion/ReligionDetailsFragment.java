package com.shepherdjerred.civilopedia.civitem.religion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shepherdjerred.civilopedia.R;
import com.shepherdjerred.civilopedia.civitem.CivItemDetailsFragment;

public class ReligionDetailsFragment extends CivItemDetailsFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_religion_details, container, false);

        if (civItem != null && civItem instanceof Religion) {
            Religion religion = (Religion) civItem;
            ((TextView) rootView.findViewById(R.id.name)).setText("Name: " + religion.getName());
        }

        return rootView;
    }

}
