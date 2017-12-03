package com.shepherdjerred.civilopedia.storage.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
import com.shepherdjerred.civilopedia.civitem.CivItem;
import com.shepherdjerred.civilopedia.civitem.Resources.Resource;
import com.shepherdjerred.civilopedia.civitem.building.Building;
import com.shepherdjerred.civilopedia.civitem.citystate.CityState;
import com.shepherdjerred.civilopedia.civitem.civilization.Civilization;
import com.shepherdjerred.civilopedia.civitem.district.District;
import com.shepherdjerred.civilopedia.civitem.feature.Feature;
import com.shepherdjerred.civilopedia.civitem.improvements.Improvement;
import com.shepherdjerred.civilopedia.civitem.leader.Leader;
import com.shepherdjerred.civilopedia.civitem.project.Project;
import com.shepherdjerred.civilopedia.civitem.route.Route;
import com.shepherdjerred.civilopedia.civitem.unit.Unit;
import com.shepherdjerred.civilopedia.storage.Datastore;

import java.util.ArrayList;

public class SqliteDatastore extends SQLiteAssetHelper implements Datastore {

    private static final String DATABASE_NAME = "DebugGameplay.sqlite";
    private static final int DATABASE_VERSION = 1;
    private LocalizationDatastore localizationDatastore;

    private ArrayList<CivItem> civItems;
    private ArrayList<Civilization> civilizations;
    private ArrayList<Leader> leaders;
    private ArrayList<CityState> cityStates;
    private ArrayList<District> districts;
    private ArrayList<Building> buildings;
    private ArrayList<Building> wonders;
    private ArrayList<Project> projects;
    private ArrayList<Unit> units;
    private ArrayList<Route> routes;
    private ArrayList<Improvement> improvements;
    private ArrayList<Resource> resources;
    private ArrayList<Feature> features;

    public SqliteDatastore(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        localizationDatastore = new LocalizationDatastore(context);
    }

    @Override
    public ArrayList<CivItem> getCivItems() {
        if (civItems == null) {
            civItems = new ArrayList<>();
            civItems.addAll(getCivilizations());
            civItems.addAll(getLeaders());
            civItems.addAll(getCityStates());
            civItems.addAll(getDistricts());
            civItems.addAll(getBuildings());
            civItems.addAll(getWonders());
            civItems.addAll(getProjects());
            civItems.addAll(getUnits());
            civItems.addAll(getRoutes());
            civItems.addAll(getImprovements());
            civItems.addAll(getResources());
            civItems.addAll(getFeatures());
        }
        return civItems;
    }

    @Override
    public ArrayList<Building> getBuildings() {
        if (buildings == null) {
            loadBuildings();
        }
        return buildings;
    }

    @Override
    public ArrayList<Civilization> getCivilizations() {
        if (civilizations == null) {
            loadCivilizations();
        }
        return civilizations;
    }

    @Override
    public ArrayList<Leader> getLeaders() {
        if (leaders == null) {
            loadLeaders();
        }
        return leaders;
    }

    @Override
    public ArrayList<CityState> getCityStates() {
        if (cityStates == null) {
            loadCityStates();
        }
        return cityStates;
    }

    @Override
    public ArrayList<District> getDistricts() {
        if (districts == null) {
            loadDistricts();
        }
        return districts;
    }

    @Override
    public ArrayList<Building> getWonders() {
        if (wonders == null) {
            loadWonders();
        }
        return wonders;
    }

    @Override
    public ArrayList<Project> getProjects() {
        if (projects == null) {
            loadProjects();
        }
        return projects;
    }

    @Override
    public ArrayList<Unit> getUnits() {
        if (units == null) {
            loadUnits();
        }
        return units;
    }

    @Override
    public ArrayList<Route> getRoutes() {
        if (routes == null) {
            loadRoutes();
        }
        return routes;
    }

    @Override
    public ArrayList<Improvement> getImprovements() {
        if (improvements == null) {
            loadImprovements();
        }
        return improvements;
    }

    @Override
    public ArrayList<Resource> getResources() {
        if (resources == null) {
            loadResources();
        }
        return resources;
    }

    @Override
    public ArrayList<Feature> getFeatures() {
        if (features == null) {
            loadFeatures();
        }
        return features;
    }

    private void loadCivilizations() {
        civilizations = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String sql = "SELECT * FROM Civilizations WHERE StartingCivilizationLevelType == 'CIVILIZATION_LEVEL_FULL_CIV' ORDER BY Name";
        Cursor c = sqLiteDatabase.rawQuery(sql, null);
        if (c.moveToFirst()) {
            do {
                String civilizationType = c.getString(0);
                String name = localizationDatastore.getEnglishValue(c.getString(1));
                String description = localizationDatastore.getEnglishValue(c.getString(2));

                Civilization civilization = new Civilization(civilizationType, name, description);
                civilizations.add(civilization);
            } while (c.moveToNext());
        }
        c.close();
        sqLiteDatabase.close();
    }

    private void loadLeaders() {
        leaders = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String sql = "SELECT * FROM Leaders WHERE InheritFrom == 'LEADER_DEFAULT' ORDER BY Name";
        Cursor c = sqLiteDatabase.rawQuery(sql, null);
        if (c.moveToFirst()) {
            do {
                String leaderType = c.getString(0);
                String name = localizationDatastore.getEnglishValue(c.getString(1));

                Leader leader = new Leader(leaderType, name);
                leaders.add(leader);
            } while (c.moveToNext());
        }
        c.close();
        sqLiteDatabase.close();
    }

    private void loadCityStates() {
        cityStates = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String sql = "SELECT * FROM Civilizations WHERE StartingCivilizationLevelType == 'CIVILIZATION_LEVEL_CITY_STATE' ORDER BY Name";
        Cursor c = sqLiteDatabase.rawQuery(sql, null);
        if (c.moveToFirst()) {
            do {
                String civilizationType = c.getString(0);
                String name = localizationDatastore.getEnglishValue(c.getString(1));
                String description = localizationDatastore.getEnglishValue(c.getString(2));

                CityState cityState = new CityState(civilizationType, name, description);
                cityStates.add(cityState);

            } while (c.moveToNext());
        }
        c.close();
        sqLiteDatabase.close();
    }

    private void loadDistricts() {
        districts = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String sql = "SELECT * FROM Districts WHERE InternalOnly == 0 AND CityCenter != 1 ORDER BY Name";
        Cursor c = sqLiteDatabase.rawQuery(sql, null);
        if (c.moveToFirst()) {
            do {
                String districtType = c.getString(0);
                String name = localizationDatastore.getEnglishValue(c.getString(1));
                String prereqTech = localizationDatastore.getEnglishValue("LOC_" + c.getString(2) + "_NAME");
                String prereqCivic = localizationDatastore.getEnglishValue("LOC_" + c.getString(3) + "_NAME");
                String description = localizationDatastore.getEnglishValue("LOC_" + c.getString(5) + "_NAME");
                int cost = c.getInt(6);
                int hitPoints = c.getInt(15);

                District district = new District(districtType, name, prereqTech, prereqCivic, description, cost, hitPoints);
                districts.add(district);

            } while (c.moveToNext());
        }
        c.close();
        sqLiteDatabase.close();
    }

    private void loadBuildings() {
        buildings = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String sql = "SELECT * FROM Buildings WHERE IsWonder == 0 ORDER BY Name";
        Cursor c = sqLiteDatabase.rawQuery(sql, null);
        if (c.moveToFirst()) {
            do {
                String buildingType = c.getString(0);
                String name = localizationDatastore.getEnglishValue(c.getString(1));
                String prereqTech = localizationDatastore.getEnglishValue("LOC_" + c.getString(2) + "_NAME");
                String prereqCivic = localizationDatastore.getEnglishValue("LOC_" + c.getString(3) + "_NAME");
                int cost = c.getInt(4);
                String prereqDistrict = localizationDatastore.getEnglishValue("LOC_" + c.getString(8) + "_NAME");
                String description = c.getString(10) != null ? localizationDatastore.getEnglishValue(c.getString(10)) : null;
                int maintenance = c.getInt(22);

                Building building = new Building(buildingType, name, prereqTech, prereqCivic, cost, prereqDistrict, description, maintenance);
                buildings.add(building);

            } while (c.moveToNext());
        }
        c.close();
        sqLiteDatabase.close();
    }

    private void loadWonders() {
        wonders = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String sql = "SELECT * FROM Buildings WHERE IsWonder == 1 ORDER BY Name";
        Cursor c = sqLiteDatabase.rawQuery(sql, null);
        if (c.moveToFirst()) {
            do {
                String buildingType = c.getString(0);
                String name = localizationDatastore.getEnglishValue(c.getString(1));
                String prereqTech = localizationDatastore.getEnglishValue("LOC_" + c.getString(2) + "_NAME");
                String prereqCivic = localizationDatastore.getEnglishValue("LOC_" + c.getString(3) + "_NAME");
                int cost = c.getInt(4);
                String prereqDistrict = localizationDatastore.getEnglishValue("LOC_" + c.getString(8) + "_NAME");
                String description = c.getString(10) != null ? localizationDatastore.getEnglishValue(c.getString(10)) : null;
                int maintenance = c.getInt(22);

                Building building = new Building(buildingType, name, prereqTech, prereqCivic, cost, prereqDistrict, description, maintenance);
                wonders.add(building);

            } while (c.moveToNext());
        }
        c.close();
        sqLiteDatabase.close();
    }

    private void loadProjects() {
        projects = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String sql = "SELECT * FROM Projects ORDER BY Name";
        Cursor c = sqLiteDatabase.rawQuery(sql, null);
        if (c.moveToFirst()) {
            do {
                String projectType = c.getString(0);
                String name = localizationDatastore.getEnglishValue(c.getString(1));
                String shortName = c.getString(2);
                String description = localizationDatastore.getEnglishValue(c.getString(3));
                int cost = c.getInt(5);
                String prereqTech = localizationDatastore.getEnglishValue("LOC_" + c.getString(8) + "_NAME");
                String prereqDistrict = localizationDatastore.getEnglishValue("LOC_" + c.getString(10) + "_NAME");

                Project project = new Project(projectType, name, shortName, description, cost, prereqTech, prereqDistrict);
                projects.add(project);

            } while (c.moveToNext());
        }
        c.close();
        sqLiteDatabase.close();
    }

    private void loadUnits() {
        units = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String sql = "SELECT * FROM Units ORDER BY Name";
        Cursor c = sqLiteDatabase.rawQuery(sql, null);
        if (c.moveToFirst()) {
            do {
                String unitType = c.getString(0);
                String name = localizationDatastore.getEnglishValue(c.getString(1));
                int cost = c.getInt(10);
                String description = localizationDatastore.getEnglishValue(c.getString(24));

                Unit unit = new Unit(unitType, name, cost, description);
                units.add(unit);

            } while (c.moveToNext());
        }
        c.close();
        sqLiteDatabase.close();
    }

    private void loadRoutes() {
        routes = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String sql = "SELECT * FROM Routes ORDER BY Name";
        Cursor c = sqLiteDatabase.rawQuery(sql, null);
        if (c.moveToFirst()) {
            do {
                String routeType = c.getString(0);
                String name = localizationDatastore.getEnglishValue(c.getString(1));
                int cost = c.getInt(3);
                String description = localizationDatastore.getEnglishValue(c.getString(2));

                Route route = new Route(routeType, name, description, cost);
                routes.add(route);

            } while (c.moveToNext());
        }
        c.close();
        sqLiteDatabase.close();
    }

    private void loadImprovements() {
        improvements = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String sql = "SELECT * FROM Improvements ORDER BY Name";
        Cursor c = sqLiteDatabase.rawQuery(sql, null);
        if (c.moveToFirst()) {
            do {
                String improvementType = c.getString(0);
                String name = localizationDatastore.getEnglishValue(c.getString(1));
                String description = localizationDatastore.getEnglishValue(c.getString(6));

                Improvement improvement = new Improvement(improvementType, name, description);
                improvements.add(improvement);

            } while (c.moveToNext());
        }
        c.close();
        sqLiteDatabase.close();
    }

    private void loadResources() {
        resources = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String sql = "SELECT * FROM Resources ORDER BY Name";
        Cursor c = sqLiteDatabase.rawQuery(sql, null);
        if (c.moveToFirst()) {
            do {
                String resourceType = c.getString(0);
                String name = localizationDatastore.getEnglishValue(c.getString(1));
                int frequency = c.getInt(6);

                Resource resource = new Resource(resourceType, name, frequency);
                resources.add(resource);

            } while (c.moveToNext());
        }
        c.close();
        sqLiteDatabase.close();
    }

    private void loadFeatures() {
        features = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String sql = "SELECT * FROM Features ORDER BY Name";
        Cursor c = sqLiteDatabase.rawQuery(sql, null);
        if (c.moveToFirst()) {
            do {
                String featureType = c.getString(0);
                String name = localizationDatastore.getEnglishValue(c.getString(1));
                String description = localizationDatastore.getEnglishValue(c.getString(2));

                Feature feature = new Feature(featureType, name, description);
                features.add(feature);

            } while (c.moveToNext());
        }
        c.close();
        sqLiteDatabase.close();
    }
}