package com.shepherdjerred.civilopedia.storage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
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

import java.util.ArrayList;
import java.util.List;

public class SqliteStore extends SQLiteAssetHelper implements Store {

    private static final String DATABASE_NAME = "DebugGameplay.sqlite";
    private static final int DATABASE_VERSION = 1;
    private Context context;

    public SqliteStore(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public List<Building> getBuildings() {
        List<Building> buildings = new ArrayList<>();
        SqliteStore sqliteStore = new SqliteStore(context);
        SQLiteDatabase sqLiteDatabase = sqliteStore.getReadableDatabase();

        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM Buildings WHERE IsWonder == 0 ORDER BY Name", null);
        if (c.moveToFirst()) {
            do {
                String buildingType = c.getString(0);
                String name = c.getString(1);
                String prereqTech = c.getString(2);
                String prereqCivic = c.getString(3);
                int cost = c.getInt(4);
                int maxPlayerInstances = c.getInt(5);
                int maxWorldInstances = c.getInt(6);
                boolean capital = c.getInt(7) != 0;
                String prereqDistrict = c.getString(8);
                String adjacentDistrict = c.getString(9);
                String description = c.getString(10);
                boolean requiresPlacement = c.getInt(11) != 0;
                boolean requiresRiver = c.getInt(12) != 0;
                int outerDefenseHitPoints = c.getInt(13);
                int housing = c.getInt(14);
                int entertainment = c.getInt(15);
                String adjacentResource = c.getString(16);
                boolean coast = c.getInt(17) != 0;
                boolean enabledByReligion = c.getInt(18) != 0;
                boolean allowsHolyCity = c.getInt(19) != 0;
                String purchaseYield = c.getString(20);
                boolean mustPurchase = c.getInt(21) != 0;
                int maintenance = c.getInt(22);
                boolean isWonder = c.getInt(23) != 0;
                String traitType = c.getString(24);
                int outerDefenseStrength = c.getInt(25);
                int citizenSlots = c.getInt(25);
                boolean mustBeLake = c.getInt(27) != 0;
                boolean mustNotBeLake = c.getInt(28) != 0;
                int regionalRange = c.getInt(29);
                boolean adjacentToMountain = c.getInt(30) != 0;
                String obsoleteEra = c.getString(31);
                boolean requiresReligion = c.getInt(32) != 0;
                int grantFortification = c.getInt(33);
                int defenseModifier = c.getInt(34);
                boolean internalOnly = c.getInt(35) != 0;
                boolean requiresAdjacentRiver = c.getInt(36) != 0;
                String quote = c.getString(37);
                String quoteAudio = c.getString(38);
                boolean mustBeAdjacentLand = c.getInt(39) != 0;
                boolean adjacentCapital = c.getInt(40) != 0;
                String adjacentImprovement = c.getString(41);
                String cityAdjacentTerrain = c.getString(42);
                boolean unlockGovernmentPolicy = c.getInt(43) != 0;
                String governmentTierRequirement = c.getString(44);

                Building building = new Building(buildingType, name, prereqTech, prereqCivic, cost, maxPlayerInstances, maxWorldInstances,
                        capital, prereqDistrict, adjacentDistrict, description, requiresPlacement, requiresRiver, outerDefenseHitPoints,
                        housing, entertainment, adjacentResource, coast, enabledByReligion, allowsHolyCity, purchaseYield, mustPurchase,
                        maintenance, isWonder, traitType, outerDefenseStrength, citizenSlots, mustBeLake, mustNotBeLake, regionalRange,
                        adjacentToMountain, obsoleteEra, requiresReligion, grantFortification, defenseModifier, internalOnly, requiresAdjacentRiver,
                        quote, quoteAudio, mustBeAdjacentLand, adjacentCapital, adjacentImprovement, cityAdjacentTerrain, unlockGovernmentPolicy,
                        governmentTierRequirement);
                buildings.add(building);

            } while (c.moveToNext());
        }
        c.close();
        sqLiteDatabase.close();
        return buildings;
    }

    @Override
    public List<CityState> getCityStates() {
        return null;
    }

    @Override
    public List<Civic> getCivics() {
        return null;
    }

    @Override
    public List<Civilization> getCivilizations() {
        List<Civilization> civilizations = new ArrayList<>();
        SqliteStore sqliteStore = new SqliteStore(context);
        SQLiteDatabase sqLiteDatabase = sqliteStore.getReadableDatabase();

        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM Civilizations ORDER BY Name", null);
        if (c.moveToFirst()) {
            do {
                String civilizationType = c.getString(0);
                String name = c.getString(1);
                String description = c.getString(2);

                Civilization civilization = new Civilization(civilizationType, name, description);
                civilizations.add(civilization);

            } while (c.moveToNext());
        }
        c.close();
        sqLiteDatabase.close();
        return civilizations;
    }

    @Override
    public List<District> getDistricts() {
        return null;
    }

    @Override
    public List<Feature> getFeatures() {
        return null;
    }

    @Override
    public List<Government> getGovernments() {
        return null;
    }

    @Override
    public List<GreatPerson> getGreatPeople() {
        return null;
    }

    @Override
    public List<Improvement> getImprovements() {
        return null;
    }

    @Override
    public List<Leader> getLeaders() {
        return null;
    }

    @Override
    public List<Policy> getPolicies() {
        return null;
    }

    @Override
    public List<Project> getProjects() {
        return null;
    }

    @Override
    public List<Religion> getReligions() {
        return null;
    }

    @Override
    public List<Resource> getResources() {
        return null;
    }

    @Override
    public List<Route> getRoutes() {
        return null;
    }

    @Override
    public List<Technology> getTechnologies() {
        return null;
    }

    @Override
    public List<Terrain> getTerrain() {
        return null;
    }

    @Override
    public List<Unit> getUnits() {
        List<Unit> units = new ArrayList<>();
        SqliteStore sqliteStore = new SqliteStore(context);
        SQLiteDatabase sqLiteDatabase = sqliteStore.getReadableDatabase();

        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM Units ORDER BY Name", null);
        if (c.moveToFirst()) {
            do {
                String unitType = c.getString(0);
                String name = c.getString(1);
                String description = c.getString(24);

                Unit unit = new Unit(unitType, name, description);
                units.add(unit);

            } while (c.moveToNext());
        }
        c.close();
        sqLiteDatabase.close();
        return units;
    }

    @Override
    public List<UnitPromotion> getUnitPromotions() {
        return null;
    }

    @Override
    public List<Building> getWonders() {
        return null;
    }
}
