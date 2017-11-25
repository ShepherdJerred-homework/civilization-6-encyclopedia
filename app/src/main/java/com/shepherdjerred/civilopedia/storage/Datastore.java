package com.shepherdjerred.civilopedia.storage;

import com.shepherdjerred.civilopedia.civitem.building.Building;
import com.shepherdjerred.civilopedia.civitem.citystate.CityState;
import com.shepherdjerred.civilopedia.civitem.civilization.Civilization;
import com.shepherdjerred.civilopedia.civitem.district.District;
import com.shepherdjerred.civilopedia.civitem.leader.Leader;
import com.shepherdjerred.civilopedia.civitem.project.Project;

import java.util.ArrayList;

public interface Datastore {
    ArrayList<Building> getBuildings();

    ArrayList<Civilization> getCivilizations();

    ArrayList<Leader> getLeaders();

    ArrayList<CityState> getCityStates();

    ArrayList<District> getDistricts();

    ArrayList<Building> getWonders();

    ArrayList<Project> getProjects();
}
