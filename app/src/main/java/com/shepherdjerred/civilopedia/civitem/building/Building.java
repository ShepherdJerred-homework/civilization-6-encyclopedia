package com.shepherdjerred.civilopedia.civitem.building;

import android.os.Parcel;

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
    private String prereqDistrict;
    private String description;
    private int maintenance;


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
        dest.writeString(this.prereqDistrict);
        dest.writeString(this.description);
        dest.writeInt(this.maintenance);
    }

    protected Building(Parcel in) {
        this.buildingType = in.readString();
        this.name = in.readString();
        this.prereqTech = in.readString();
        this.prereqCivic = in.readString();
        this.cost = in.readInt();
        this.prereqDistrict = in.readString();
        this.description = in.readString();
        this.maintenance = in.readInt();
    }

    public static final Creator<Building> CREATOR = new Creator<Building>() {
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