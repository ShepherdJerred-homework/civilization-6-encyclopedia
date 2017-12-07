package com.shepherdjerred.civilopedia.civitem;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shepherdjerred.civilopedia.ActionBarFragment;
import com.shepherdjerred.civilopedia.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CivItemListFragment extends Fragment implements ActionBarFragment {

    private static final String ARG_ITEMS = "civ_items";
    private static final String ARG_TYPE = "civ_items_type";
    private List<CivItem> civItems;
    private String civItemsType;
    private OnListFragmentInteractionListener mListener;

    public static CivItemListFragment newInstance(ArrayList<? extends CivItem> civItems, String civItemsType) {
        CivItemListFragment fragment = new CivItemListFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_ITEMS, civItems);
        args.putString(ARG_TYPE, civItemsType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            civItems = getArguments().getParcelableArrayList(ARG_ITEMS);
            civItemsType = getArguments().getString(ARG_TYPE);
            Collections.sort(civItems, new Comparator<CivItem>() {
                @Override
                public int compare(CivItem civItem, CivItem t1) {
                    return civItem.getName().compareTo(t1.getName());
                }
            });
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_civitem_list, container, false);

        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setAdapter(new CivItemListRecyclerViewAdapter(civItems, mListener));
        }

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(CivItem item);
    }

    @Override
    public String getToolbarTitle() {
        return civItemsType;
    }
}
