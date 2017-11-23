package com.shepherdjerred.civilopedia.civitem.civilization;

import android.os.Parcel;

import com.shepherdjerred.civilopedia.civitem.CivItem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Civilization implements CivItem {

    private String civilizationType;
    private String name;
    private String description;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.civilizationType);
        dest.writeString(this.name);
        dest.writeString(this.description);
    }

    protected Civilization(Parcel in) {
        this.civilizationType = in.readString();
        this.name = in.readString();
        this.description = in.readString();
    }

    public static final Creator<Civilization> CREATOR = new Creator<Civilization>() {
        @Override
        public Civilization createFromParcel(Parcel source) {
            return new Civilization(source);
        }

        @Override
        public Civilization[] newArray(int size) {
            return new Civilization[size];
        }
    };
}
