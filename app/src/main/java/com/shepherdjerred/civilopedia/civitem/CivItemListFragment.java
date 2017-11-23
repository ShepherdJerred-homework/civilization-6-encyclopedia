package com.shepherdjerred.civilopedia.civitem;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shepherdjerred.civilopedia.R;

import java.util.ArrayList;
import java.util.List;

public class CivItemListFragment extends Fragment {

    private static final String ARG_ITEMS = "civ_items";
    private List<CivItem> civItems;
    private OnListFragmentInteractionListener mListener;

    public CivItemListFragment() {
    }

    public static CivItemListFragment newInstance(ArrayList<? extends CivItem> civItems) {
        CivItemListFragment fragment = new CivItemListFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_ITEMS, civItems);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            civItems = getArguments().getParcelableArrayList(ARG_ITEMS);
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
}
