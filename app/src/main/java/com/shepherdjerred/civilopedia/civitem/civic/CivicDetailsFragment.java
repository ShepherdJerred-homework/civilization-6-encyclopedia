package com.shepherdjerred.civilopedia.civitem.civic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shepherdjerred.civilopedia.R;
import com.shepherdjerred.civilopedia.civitem.CivItemDetailsFragment;

public class CivicDetailsFragment extends CivItemDetailsFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_civic_details, container, false);

        if (civItem != null && civItem instanceof Civic) {
            Civic civic = (Civic) civItem;

            // Some civic descrtiptions are null
            if (civic.getDescription() != null) {
                ((TextView) rootView.findViewById(R.id.description)).setText("Description: " + civic.getDescription());
            }
            else {
                ((TextView) rootView.findViewById(R.id.description)).setText("Description: No description for this feature.");
            }
            ((TextView) rootView.findViewById(R.id.cost)).setText("Production cost: " + civic.getCost());
        }

        return rootView;
    }

}
