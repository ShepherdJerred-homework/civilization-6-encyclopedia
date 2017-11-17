package com.shepherdjerred.civilopedia.object;

import android.os.Parcel;
import android.os.Parcelable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Unit implements Parcelable {
    private String unitType;
    private String name;
    private String description;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.unitType);
        dest.writeString(this.name);
        dest.writeString(this.description);
    }

    protected Unit(Parcel in) {
        this.unitType = in.readString();
        this.name = in.readString();
        this.description = in.readString();
    }

    public static final Creator<Unit> CREATOR = new Creator<Unit>() {
        @Override
        public Unit createFromParcel(Parcel source) {
            return new Unit(source);
        }

        @Override
        public Unit[] newArray(int size) {
            return new Unit[size];
        }
    };
}


