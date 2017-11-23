package com.shepherdjerred.civilopedia.civitem;

import android.content.Context;
import android.net.Uri;
import android.support.v4.app.Fragment;

public abstract class CivItemDetailsFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

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
}
