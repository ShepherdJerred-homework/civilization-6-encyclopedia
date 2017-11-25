package com.shepherdjerred.civilopedia.civitem.district;

import android.os.Parcel;

import com.shepherdjerred.civilopedia.civitem.CivItem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class District implements CivItem {
    private String districtType;
    private String name;
    private String prereqTech;
    private String prereqCivic;
    private String description;
    private int cost;
    private int hitPoints;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.districtType);
        dest.writeString(this.name);
        dest.writeString(this.prereqTech);
        dest.writeString(this.prereqCivic);
        dest.writeString(this.description);
        dest.writeInt(this.cost);
        dest.writeInt(this.hitPoints);
    }

    public District() {
    }

    protected District(Parcel in) {
        this.districtType = in.readString();
        this.name = in.readString();
        this.prereqTech = in.readString();
        this.prereqCivic = in.readString();
        this.description = in.readString();
        this.cost = in.readInt();
        this.hitPoints = in.readInt();
    }

    public static final Creator<District> CREATOR = new Creator<District>() {
        @Override
        public District createFromParcel(Parcel source) {
            return new District(source);
        }

        @Override
        public District[] newArray(int size) {
            return new District[size];
        }
    };
}
