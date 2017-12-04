package com.shepherdjerred.civilopedia.civitem.unit_promotion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shepherdjerred.civilopedia.R;
import com.shepherdjerred.civilopedia.civitem.CivItemDetailsFragment;

public class UnitPromotionDetailsFragment extends CivItemDetailsFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_unit_promotion_details, container, false);

        if (civItem != null && civItem instanceof UnitPromotion) {
            UnitPromotion unitPromotion = (UnitPromotion) civItem;
            ((TextView) rootView.findViewById(R.id.description)).setText("Description: " + unitPromotion.getDescription());
            ((TextView) rootView.findViewById(R.id.level)).setText("Level: " + unitPromotion.getLevel());
        }

        return rootView;
    }

}
