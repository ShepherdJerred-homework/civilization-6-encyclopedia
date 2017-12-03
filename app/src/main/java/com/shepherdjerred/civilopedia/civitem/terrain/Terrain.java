package com.shepherdjerred.civilopedia.civitem.terrain;

import android.os.Parcel;

import com.shepherdjerred.civilopedia.civitem.CivItem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Terrain implements CivItem {
    private String terrainType;
    private String name;
    private int influenceCost;
    private int movementCost;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.terrainType);
        dest.writeString(this.name);
        dest.writeInt(this.influenceCost);
        dest.writeInt(this.movementCost);
    }

    protected Terrain(Parcel in) {
        this.terrainType = in.readString();
        this.name = in.readString();
        this.influenceCost = in.readInt();
        this.movementCost = in.readInt();
    }

    public static final Creator<Terrain> CREATOR = new Creator<Terrain>() {
        @Override
        public Terrain createFromParcel(Parcel source) {
            return new Terrain(source);
        }

        @Override
        public Terrain[] newArray(int size) {
            return new Terrain[size];
        }
    };
}
