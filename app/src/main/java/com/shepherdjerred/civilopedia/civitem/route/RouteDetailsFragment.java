package com.shepherdjerred.civilopedia.civitem.route;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shepherdjerred.civilopedia.R;
import com.shepherdjerred.civilopedia.civitem.CivItemDetailsFragment;

public class RouteDetailsFragment extends CivItemDetailsFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_route_details, container, false);

        if (civItem != null && civItem instanceof Route) {
            Route route = (Route) civItem;
            ((TextView) rootView.findViewById(R.id.description)).setText("Description: " + route.getDescription());
            ((TextView) rootView.findViewById(R.id.cost)).setText("Movement points: " + route.getCost());
        }

        return rootView;
    }
}
