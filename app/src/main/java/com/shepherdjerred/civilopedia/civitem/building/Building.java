package com.shepherdjerred.civilopedia.civitem.building;

import android.os.Parcel;
import android.os.Parcelable;

import com.shepherdjerred.civilopedia.civitem.CivItem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Building implements CivItem {
    private String buildingType;
    private String name;
    private String prereqTech;
    private String prereqCivic;
    private int cost;
    private int maxPlayerInstances;
    private int maxWorldInstances;
    private boolean capital;
    private String prereqDistrict;
    private String adjacentDistrict;
    private String description;
    private boolean requiresPlacement;
    private boolean requiresRiver;
    private int outerDefenseHitPoints;
    private int housing;
    private int entertainment;
    private String adjacentResource;
    private boolean coast;
    private boolean enabledByReligion;
    private boolean allowsHolyCity;
    private String purchaseYield;
    private boolean mustPurchase;
    private int maintenance;
    private boolean isWonder;
    private String traitType;
    private int outerDefenseStrength;
    private int citizenSlots;
    private boolean mustBeLake;
    private boolean mustNotBeLake;
    private int regionalRange;
    private boolean adjacentToMountain;
    private String obsoleteEra;
    private boolean requiresReligion;
    private int grantFortification;
    private int defenseModifier;
    private boolean internalOnly;
    private boolean requiresAdjacentRiver;
    private String quote;
    private String quoteAudio;
    private boolean mustBeAdjacentLand;
    private boolean adjacentCapital;
    private String adjacentImprovement;
    private String cityAdjacentTerrain;
    private boolean unlockGovernmentPolicy;
    private String governmentTierRequirement;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.buildingType);
        dest.writeString(this.name);
        dest.writeString(this.prereqTech);
        dest.writeString(this.prereqCivic);
        dest.writeInt(this.cost);
        dest.writeInt(this.maxPlayerInstances);
        dest.writeInt(this.maxWorldInstances);
        dest.writeByte(this.capital ? (byte) 1 : (byte) 0);
        dest.writeString(this.prereqDistrict);
        dest.writeString(this.adjacentDistrict);
        dest.writeString(this.description);
        dest.writeByte(this.requiresPlacement ? (byte) 1 : (byte) 0);
        dest.writeByte(this.requiresRiver ? (byte) 1 : (byte) 0);
        dest.writeInt(this.outerDefenseHitPoints);
        dest.writeInt(this.housing);
        dest.writeInt(this.entertainment);
        dest.writeString(this.adjacentResource);
        dest.writeByte(this.coast ? (byte) 1 : (byte) 0);
        dest.writeByte(this.enabledByReligion ? (byte) 1 : (byte) 0);
        dest.writeByte(this.allowsHolyCity ? (byte) 1 : (byte) 0);
        dest.writeString(this.purchaseYield);
        dest.writeByte(this.mustPurchase ? (byte) 1 : (byte) 0);
        dest.writeInt(this.maintenance);
        dest.writeByte(this.isWonder ? (byte) 1 : (byte) 0);
        dest.writeString(this.traitType);
        dest.writeInt(this.outerDefenseStrength);
        dest.writeInt(this.citizenSlots);
        dest.writeByte(this.mustBeLake ? (byte) 1 : (byte) 0);
        dest.writeByte(this.mustNotBeLake ? (byte) 1 : (byte) 0);
        dest.writeInt(this.regionalRange);
        dest.writeByte(this.adjacentToMountain ? (byte) 1 : (byte) 0);
        dest.writeString(this.obsoleteEra);
        dest.writeByte(this.requiresReligion ? (byte) 1 : (byte) 0);
        dest.writeInt(this.grantFortification);
        dest.writeInt(this.defenseModifier);
        dest.writeByte(this.internalOnly ? (byte) 1 : (byte) 0);
        dest.writeByte(this.requiresAdjacentRiver ? (byte) 1 : (byte) 0);
        dest.writeString(this.quote);
        dest.writeString(this.quoteAudio);
        dest.writeByte(this.mustBeAdjacentLand ? (byte) 1 : (byte) 0);
        dest.writeByte(this.adjacentCapital ? (byte) 1 : (byte) 0);
        dest.writeString(this.adjacentImprovement);
        dest.writeString(this.cityAdjacentTerrain);
        dest.writeByte(this.unlockGovernmentPolicy ? (byte) 1 : (byte) 0);
        dest.writeString(this.governmentTierRequirement);
    }

    protected Building(Parcel in) {
        this.buildingType = in.readString();
        this.name = in.readString();
        this.prereqTech = in.readString();
        this.prereqCivic = in.readString();
        this.cost = in.readInt();
        this.maxPlayerInstances = in.readInt();
        this.maxWorldInstances = in.readInt();
        this.capital = in.readByte() != 0;
        this.prereqDistrict = in.readString();
        this.adjacentDistrict = in.readString();
        this.description = in.readString();
        this.requiresPlacement = in.readByte() != 0;
        this.requiresRiver = in.readByte() != 0;
        this.outerDefenseHitPoints = in.readInt();
        this.housing = in.readInt();
        this.entertainment = in.readInt();
        this.adjacentResource = in.readString();
        this.coast = in.readByte() != 0;
        this.enabledByReligion = in.readByte() != 0;
        this.allowsHolyCity = in.readByte() != 0;
        this.purchaseYield = in.readString();
        this.mustPurchase = in.readByte() != 0;
        this.maintenance = in.readInt();
        this.isWonder = in.readByte() != 0;
        this.traitType = in.readString();
        this.outerDefenseStrength = in.readInt();
        this.citizenSlots = in.readInt();
        this.mustBeLake = in.readByte() != 0;
        this.mustNotBeLake = in.readByte() != 0;
        this.regionalRange = in.readInt();
        this.adjacentToMountain = in.readByte() != 0;
        this.obsoleteEra = in.readString();
        this.requiresReligion = in.readByte() != 0;
        this.grantFortification = in.readInt();
        this.defenseModifier = in.readInt();
        this.internalOnly = in.readByte() != 0;
        this.requiresAdjacentRiver = in.readByte() != 0;
        this.quote = in.readString();
        this.quoteAudio = in.readString();
        this.mustBeAdjacentLand = in.readByte() != 0;
        this.adjacentCapital = in.readByte() != 0;
        this.adjacentImprovement = in.readString();
        this.cityAdjacentTerrain = in.readString();
        this.unlockGovernmentPolicy = in.readByte() != 0;
        this.governmentTierRequirement = in.readString();
    }

    public static final Parcelable.Creator<Building> CREATOR = new Parcelable.Creator<Building>() {
        @Override
        public Building createFromParcel(Parcel source) {
            return new Building(source);
        }

        @Override
        public Building[] newArray(int size) {
            return new Building[size];
        }
    };
}