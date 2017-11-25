package com.shepherdjerred.civilopedia.civitem.project;

import android.os.Parcel;

import com.shepherdjerred.civilopedia.civitem.CivItem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Project implements CivItem {
    private String projectType;
    private String name;
    private String shortName;
    private String description;
    private int cost;
    private String prereqTech;
    private String prereqDistrict;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.projectType);
        dest.writeString(this.name);
        dest.writeString(this.shortName);
        dest.writeString(this.description);
        dest.writeInt(this.cost);
        dest.writeString(this.prereqTech);
        dest.writeString(this.prereqDistrict);
    }

    public Project() {
    }

    protected Project(Parcel in) {
        this.projectType = in.readString();
        this.name = in.readString();
        this.shortName = in.readString();
        this.description = in.readString();
        this.cost = in.readInt();
        this.prereqTech = in.readString();
        this.prereqDistrict = in.readString();
    }

    public static final Creator<Project> CREATOR = new Creator<Project>() {
        @Override
        public Project createFromParcel(Parcel source) {
            return new Project(source);
        }

        @Override
        public Project[] newArray(int size) {
            return new Project[size];
        }
    };
}
