package com.shepherdjerred.civilopedia.civitem.Resources;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shepherdjerred.civilopedia.R;
import com.shepherdjerred.civilopedia.civitem.CivItemDetailsFragment;

public class ResourceDetailsFragment extends CivItemDetailsFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_resource_details, container, false);

        if (civItem != null && civItem instanceof Resource) {
            Resource resource = (Resource) civItem;
            ((TextView) rootView.findViewById(R.id.frequency)).setText("Frequency: " + resource.getFrequency());
        }

        return rootView;
    }
}
