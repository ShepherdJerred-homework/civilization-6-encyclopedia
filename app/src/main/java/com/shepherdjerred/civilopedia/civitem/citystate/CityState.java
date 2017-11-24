package com.shepherdjerred.civilopedia.civitem.citystate;

import android.os.Parcel;

import com.shepherdjerred.civilopedia.civitem.CivItem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CityState implements CivItem {

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

    protected CityState(Parcel in) {
        this.civilizationType = in.readString();
        this.name = in.readString();
        this.description = in.readString();
    }

    public static final Creator<CityState> CREATOR = new Creator<CityState>() {
        @Override
        public CityState createFromParcel(Parcel source) {
            return new CityState(source);
        }

        @Override
        public CityState[] newArray(int size) {
            return new CityState[size];
        }
    };
}
