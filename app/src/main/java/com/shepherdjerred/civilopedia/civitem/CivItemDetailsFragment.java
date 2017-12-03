package com.shepherdjerred.civilopedia.civitem;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.shepherdjerred.civilopedia.ActionBarFragment;
import com.shepherdjerred.civilopedia.civitem.building.Building;
import com.shepherdjerred.civilopedia.civitem.building.BuildingDetailsFragment;
import com.shepherdjerred.civilopedia.civitem.citystate.CityState;
import com.shepherdjerred.civilopedia.civitem.citystate.CityStateDetailsFragment;
import com.shepherdjerred.civilopedia.civitem.civilization.Civilization;
import com.shepherdjerred.civilopedia.civitem.civilization.CivilizationDetailsFragment;
import com.shepherdjerred.civilopedia.civitem.district.District;
import com.shepherdjerred.civilopedia.civitem.district.DistrictDetailsFragment;
import com.shepherdjerred.civilopedia.civitem.leader.Leader;
import com.shepherdjerred.civilopedia.civitem.leader.LeaderDetailsFragment;
import com.shepherdjerred.civilopedia.civitem.project.Project;
import com.shepherdjerred.civilopedia.civitem.project.ProjectDetailsFragment;
import com.shepherdjerred.civilopedia.civitem.route.Route;
import com.shepherdjerred.civilopedia.civitem.route.RouteDetailsFragment;
import com.shepherdjerred.civilopedia.civitem.unit.Unit;
import com.shepherdjerred.civilopedia.civitem.unit.UnitDetailsFragment;

public abstract class CivItemDetailsFragment extends Fragment implements ActionBarFragment {

    private OnFragmentInteractionListener mListener;

    private static final String ARG_CIV_ITEM = "civ_item";
    protected CivItem civItem;

    public static CivItemDetailsFragment newInstance(CivItem civItem) {

        Log.d("CivItem", civItem.toString());

        CivItemDetailsFragment civItemDetailsFragment;

        if (civItem instanceof Civilization) {
            civItemDetailsFragment = new CivilizationDetailsFragment();
        } else if (civItem instanceof Leader) {
            civItemDetailsFragment = new LeaderDetailsFragment();
        } else if (civItem instanceof CityState) {
            civItemDetailsFragment = new CityStateDetailsFragment();
        } else if (civItem instanceof District) {
            civItemDetailsFragment = new DistrictDetailsFragment();
        } else if (civItem instanceof Building) {
            civItemDetailsFragment = new BuildingDetailsFragment();
        } else if (civItem instanceof Project) {
            civItemDetailsFragment = new ProjectDetailsFragment();
        } else if (civItem instanceof Unit) {
            civItemDetailsFragment = new UnitDetailsFragment();
        } else if (civItem instanceof Route) {
            civItemDetailsFragment = new RouteDetailsFragment();
        } else {
            throw new UnsupportedOperationException();
        }

        Bundle args = new Bundle();
        args.putParcelable(ARG_CIV_ITEM, civItem);
        civItemDetailsFragment.setArguments(args);
        return civItemDetailsFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            civItem = getArguments().getParcelable(ARG_CIV_ITEM);
        }
    }

    // TODO Should probably make this method abstract?
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onCivItemDetailsFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onCivItemDetailsFragmentInteraction(Uri uri);
    }

    @Override
    public String getToolbarTitle() {
        return civItem.getName();
    }
}
