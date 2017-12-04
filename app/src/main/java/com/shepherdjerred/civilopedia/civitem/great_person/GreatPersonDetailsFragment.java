package com.shepherdjerred.civilopedia.civitem.great_person;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shepherdjerred.civilopedia.R;
import com.shepherdjerred.civilopedia.civitem.CivItemDetailsFragment;

public class GreatPersonDetailsFragment extends CivItemDetailsFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_great_person_details, container, false);

        if (civItem != null && civItem instanceof GreatPerson) {
            GreatPerson greatPerson = (GreatPerson) civItem;

            ((TextView) rootView.findViewById(R.id.classType)).setText("Class: " + greatPerson.getGreatPersonClassType());

            if (greatPerson.getGender() != null) {
                ((TextView) rootView.findViewById(R.id.gender)).setText("Gender: " + greatPerson.getGender());
            }
            else {
                ((TextView) rootView.findViewById(R.id.gender)).setText("Gender: No gender specified.");
            }
        }

        return rootView;
    }

}
