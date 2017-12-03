package com.shepherdjerred.civilopedia.storage;

import com.shepherdjerred.civilopedia.civitem.CivItem;
import com.shepherdjerred.civilopedia.civitem.Resources.Resource;
import com.shepherdjerred.civilopedia.civitem.building.Building;
import com.shepherdjerred.civilopedia.civitem.citystate.CityState;
import com.shepherdjerred.civilopedia.civitem.civic.Civic;
import com.shepherdjerred.civilopedia.civitem.civilization.Civilization;
import com.shepherdjerred.civilopedia.civitem.district.District;
import com.shepherdjerred.civilopedia.civitem.feature.Feature;
import com.shepherdjerred.civilopedia.civitem.government.Government;
import com.shepherdjerred.civilopedia.civitem.improvements.Improvement;
import com.shepherdjerred.civilopedia.civitem.leader.Leader;
import com.shepherdjerred.civilopedia.civitem.policy.Policy;
import com.shepherdjerred.civilopedia.civitem.project.Project;
import com.shepherdjerred.civilopedia.civitem.religion.Religion;
import com.shepherdjerred.civilopedia.civitem.route.Route;
import com.shepherdjerred.civilopedia.civitem.technology.Technology;
import com.shepherdjerred.civilopedia.civitem.terrain.Terrain;
import com.shepherdjerred.civilopedia.civitem.unit.Unit;

import java.util.ArrayList;

public interface Datastore {
    ArrayList<CivItem> getCivItems();

    ArrayList<Building> getBuildings();

    ArrayList<Civilization> getCivilizations();

    ArrayList<Leader> getLeaders();

    ArrayList<CityState> getCityStates();

    ArrayList<District> getDistricts();

    ArrayList<Building> getWonders();

    ArrayList<Project> getProjects();

    ArrayList<Unit> getUnits();

    ArrayList<Route> getRoutes();

    ArrayList<Improvement> getImprovements();

    ArrayList<Resource> getResources();

    ArrayList<Feature> getFeatures();

    ArrayList<Terrain> getTerrains();

    ArrayList<Religion> getReligions();

    ArrayList<Policy> getPolicies();

    ArrayList<Government> getGovernments();

    ArrayList<Civic> getCivics();

    ArrayList<Technology> getTechnologies();
}
