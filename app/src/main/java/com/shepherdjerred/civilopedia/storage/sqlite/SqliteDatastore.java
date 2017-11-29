package com.shepherdjerred.civilopedia.storage.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
import com.shepherdjerred.civilopedia.civitem.building.Building;
import com.shepherdjerred.civilopedia.civitem.citystate.CityState;
import com.shepherdjerred.civilopedia.civitem.civilization.Civilization;
import com.shepherdjerred.civilopedia.civitem.district.District;
import com.shepherdjerred.civilopedia.civitem.leader.Leader;
import com.shepherdjerred.civilopedia.civitem.project.Project;
import com.shepherdjerred.civilopedia.civitem.unit.Unit;
import com.shepherdjerred.civilopedia.storage.Datastore;

import java.util.ArrayList;

public class SqliteDatastore extends SQLiteAssetHelper implements Datastore {

    private static final String DATABASE_NAME = "DebugGameplay.sqlite";
    private static final int DATABASE_VERSION = 1;
    private LocalizationDatastore localizationDatastore;

    public SqliteDatastore(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        localizationDatastore = new LocalizationDatastore(context);
    }

    @Override
    public ArrayList<Civilization> getCivilizations() {
        ArrayList<Civilization> civilizations = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM Civilizations WHERE StartingCivilizationLevelType == 'CIVILIZATION_LEVEL_FULL_CIV' ORDER BY Name", null);
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
        return civilizations;
    }

    @Override
    public ArrayList<Leader> getLeaders() {
        ArrayList<Leader> leaders = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM Leaders WHERE InheritFrom == 'LEADER_DEFAULT' ORDER BY Name", null);
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
        return leaders;
    }

    @Override
    public ArrayList<CityState> getCityStates() {
        ArrayList<CityState> cityStates = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM Civilizations WHERE StartingCivilizationLevelType == 'CIVILIZATION_LEVEL_CITY_STATE' ORDER BY Name", null);
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
        return cityStates;
    }

    @Override
    public ArrayList<District> getDistricts() {
        ArrayList<District> districts = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM Districts WHERE InternalOnly == 0 AND CityCenter != 1 ORDER BY Name", null);
        if (c.moveToFirst()) {
            do {
                String districtType = c.getString(0);
                String name = c.getString(1);
                String prereqTech = c.getString(2);
                String prereqCivic = c.getString(3);
                String description = c.getString(5);
                int cost = c.getInt(6);
                int hitPoints = c.getInt(15);

                District district = new District(districtType, name, prereqTech, prereqCivic, description, cost, hitPoints);
                districts.add(district);

            } while (c.moveToNext());
        }
        c.close();
        sqLiteDatabase.close();
        return districts;
    }

    @Override
    public ArrayList<Building> getBuildings() {
        ArrayList<Building> buildings = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM Buildings WHERE IsWonder == 0 ORDER BY Name", null);
        if (c.moveToFirst()) {
            do {
                String buildingType = c.getString(0);
                String name = localizationDatastore.getEnglishValue(c.getString(1));
                String prereqTech = localizationDatastore.getEnglishValue("LOC_TECH_" + c.getString(2) + "_NAME");
                String prereqCivic = localizationDatastore.getEnglishValue("LOC_CIVIC_" + c.getString(3) + "_NAME");
                int cost = c.getInt(4);
                String prereqDistrict = localizationDatastore.getEnglishValue("LOC_DISTRICT_" + c.getString(8) + "_NAME");
                String description = c.getString(10) != null ? localizationDatastore.getEnglishValue(c.getString(10)) : null;
                int maintenance = c.getInt(22);

                Building building = new Building(buildingType, name, prereqTech, prereqCivic, cost, prereqDistrict, description, maintenance);
                buildings.add(building);

            } while (c.moveToNext());
        }
        c.close();
        sqLiteDatabase.close();
        return buildings;
    }

    @Override
    public ArrayList<Building> getWonders() {
        ArrayList<Building> wonders = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM Buildings WHERE IsWonder == 1 ORDER BY Name", null);
        if (c.moveToFirst()) {
            do {
                String buildingType = c.getString(0);
                String name = localizationDatastore.getEnglishValue(c.getString(1));
                String prereqTech = localizationDatastore.getEnglishValue("LOC_TECH_" + c.getString(2) + "_NAME");
                String prereqCivic = localizationDatastore.getEnglishValue("LOC_CIVIC_" + c.getString(3) + "_NAME");
                int cost = c.getInt(4);
                String prereqDistrict = localizationDatastore.getEnglishValue("LOC_DISTRICT_" + c.getString(8) + "_NAME");
                String description = c.getString(10) != null ? localizationDatastore.getEnglishValue(c.getString(10)) : null;
                int maintenance = c.getInt(22);

                Building building = new Building(buildingType, name, prereqTech, prereqCivic, cost, prereqDistrict, description, maintenance);
                wonders.add(building);

            } while (c.moveToNext());
        }
        c.close();
        sqLiteDatabase.close();
        return wonders;
    }

    @Override
    public ArrayList<Project> getProjects() {
        ArrayList<Project> projects = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM Projects ORDER BY Name", null);
        if (c.moveToFirst()) {
            do {
                String projectType = c.getString(0);
                String name = c.getString(1);
                String shortName = c.getString(2);
                String description = c.getString(3);
                int cost = c.getInt(5);
                String prereqTech = c.getString(8);
                String prereqDistrict = c.getString(10);

                Project project = new Project(projectType, name, shortName, description, cost, prereqTech, prereqDistrict);
                projects.add(project);

            } while (c.moveToNext());
        }
        c.close();
        sqLiteDatabase.close();
        return projects;
    }

    @Override
    public ArrayList<Unit> getUnits() {
        ArrayList<Unit> units = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM Units ORDER BY Name", null);
        if (c.moveToFirst()) {
            do {
                String unitType = c.getString(0);
                String name = c.getString(1);
                int cost = c.getInt(10);
                String description = c.getString(24);

                Unit unit = new Unit(unitType, name, cost, description);
                units.add(unit);

            } while (c.moveToNext());
        }
        c.close();
        sqLiteDatabase.close();
        return units;
    }


}