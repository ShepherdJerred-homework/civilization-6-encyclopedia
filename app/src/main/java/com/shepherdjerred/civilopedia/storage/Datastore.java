package com.shepherdjerred.civilopedia.storage;

import com.shepherdjerred.civilopedia.civitem.building.Building;

import java.util.ArrayList;

public interface Datastore {
    ArrayList<Building> getBuildings();
}
