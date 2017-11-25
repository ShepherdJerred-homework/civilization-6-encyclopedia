package com.shepherdjerred.civilopedia.civitem.project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shepherdjerred.civilopedia.R;
import com.shepherdjerred.civilopedia.civitem.CivItemDetailsFragment;

public class ProjectDetailsFragment extends CivItemDetailsFragment {

    private static final String ARG_PROJECT = "project";
    private Project mProject;

    public static ProjectDetailsFragment newInstance(Project project) {
        ProjectDetailsFragment fragment = new ProjectDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PROJECT, project);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mProject = getArguments().getParcelable(ARG_PROJECT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_project_details, container, false);

        if (mProject != null) {
            ((TextView) rootView.findViewById(R.id.description)).setText("Description: " + mProject.getDescription());
            ((TextView) rootView.findViewById(R.id.cost)).setText("Production cost: " + mProject.getCost());

            ((TextView) rootView.findViewById(R.id.prereq_tech)).setText("Technology: " + mProject.getPrereqTech());
            ((TextView) rootView.findViewById(R.id.prereq_district)).setText("District: " + mProject.getPrereqDistrict());
        }

        return rootView;
    }

}
