package com.shepherdjerred.civilopedia.civitem.technology;

import android.os.Parcel;

import com.shepherdjerred.civilopedia.civitem.CivItem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Technology implements CivItem {
    private String technologyType;
    private String name;
    private int cost;
    private String description;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.technologyType);
        dest.writeString(this.name);
        dest.writeInt(this.cost);
        dest.writeString(this.description);
    }

    protected Technology(Parcel in) {
        this.technologyType = in.readString();
        this.name = in.readString();
        this.cost = in.readInt();
        this.description = in.readString();
    }

    public static final Creator<Technology> CREATOR = new Creator<Technology>() {
        @Override
        public Technology createFromParcel(Parcel source) {
            return new Technology(source);
        }

        @Override
        public Technology[] newArray(int size) {
            return new Technology[size];
        }
    };
}
