package com.shepherdjerred.civilopedia.civitem.citystate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shepherdjerred.civilopedia.R;
import com.shepherdjerred.civilopedia.civitem.CivItemDetailsFragment;

public class CityStateDetailsFragment extends CivItemDetailsFragment {

    private static final String ARG_CITY_STATE = "city_state";
    private CityState mCityState;

    public static CityStateDetailsFragment newInstance(CityState cityState) {
        CityStateDetailsFragment fragment = new CityStateDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_CITY_STATE, cityState);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mCityState = getArguments().getParcelable(ARG_CITY_STATE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_citystate_details, container, false);

        if (mCityState != null) {
            ((TextView) rootView.findViewById(R.id.description)).setText("Description: " + mCityState.getDescription());
        }

        return rootView;
    }

}
