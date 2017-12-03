package com.shepherdjerred.civilopedia.civitem.terrain;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shepherdjerred.civilopedia.R;
import com.shepherdjerred.civilopedia.civitem.CivItemDetailsFragment;

public class TerrainDetailsFragment extends CivItemDetailsFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_terrain_details, container, false);

        if (civItem != null && civItem instanceof Terrain) {
            Terrain terrain = (Terrain) civItem;
            ((TextView) rootView.findViewById(R.id.influenceCost)).setText("Influence Cost: " + terrain.getInfluenceCost());
            ((TextView) rootView.findViewById(R.id.movementCost)).setText("Movement Cost: " + terrain.getMovementCost());
        }

        return rootView;
    }

}
