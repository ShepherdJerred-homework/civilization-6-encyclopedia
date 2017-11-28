package com.shepherdjerred.civilopedia.civitem.project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shepherdjerred.civilopedia.R;
import com.shepherdjerred.civilopedia.civitem.CivItemDetailsFragment;

public class ProjectDetailsFragment extends CivItemDetailsFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_project_details, container, false);

        if (civItem != null && civItem instanceof Project) {
            Project project = (Project) civItem;
            ((TextView) rootView.findViewById(R.id.description)).setText("Description: " + project.getDescription());
            ((TextView) rootView.findViewById(R.id.cost)).setText("Production cost: " + project.getCost());

            ((TextView) rootView.findViewById(R.id.prereq_tech)).setText("Technology: " + project.getPrereqTech());
            ((TextView) rootView.findViewById(R.id.prereq_district)).setText("District: " + project.getPrereqDistrict());
        }

        return rootView;
    }

}
