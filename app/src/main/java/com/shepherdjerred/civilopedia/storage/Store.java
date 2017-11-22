package com.shepherdjerred.civilopedia.storage;

import com.shepherdjerred.civilopedia.activities.building.Building;
import com.shepherdjerred.civilopedia.activities.citystate.CityState;
import com.shepherdjerred.civilopedia.activities.civic.Civic;
import com.shepherdjerred.civilopedia.activities.civilization.Civilization;
import com.shepherdjerred.civilopedia.activities.district.District;
import com.shepherdjerred.civilopedia.activities.feature.Feature;
import com.shepherdjerred.civilopedia.activities.government.Government;
import com.shepherdjerred.civilopedia.activities.greatperson.GreatPerson;
import com.shepherdjerred.civilopedia.activities.improvement.Improvement;
import com.shepherdjerred.civilopedia.activities.leader.Leader;
import com.shepherdjerred.civilopedia.activities.policy.Policy;
import com.shepherdjerred.civilopedia.activities.project.Project;
import com.shepherdjerred.civilopedia.activities.religion.Religion;
import com.shepherdjerred.civilopedia.activities.resource.Resource;
import com.shepherdjerred.civilopedia.activities.route.Route;
import com.shepherdjerred.civilopedia.activities.technology.Technology;
import com.shepherdjerred.civilopedia.activities.terrain.Terrain;
import com.shepherdjerred.civilopedia.activities.unit.Unit;
import com.shepherdjerred.civilopedia.activities.unitpromotion.UnitPromotion;

import java.util.List;

public interface Store {
    List<Building> getBuildings();
    List<CityState> getCityStates();
    List<Civic> getCivics();
    List<Civilization> getCivilizations();
    List<District> getDistricts();
    List<Feature> getFeatures();
    List<Government> getGovernments();
    List<GreatPerson> getGreatPeople();
    List<Improvement> getImprovements();
    List<Leader> getLeaders();
    List<Policy> getPolicies();
    List<Project> getProjects();
    List<Religion> getReligions();
    List<Resource> getResources();
    List<Route> getRoutes();
    List<Technology> getTechnologies();
    List<Terrain> getTerrain();
    List<Unit> getUnits();
    List<UnitPromotion> getUnitPromotions();
    List<Building> getWonders();
}
