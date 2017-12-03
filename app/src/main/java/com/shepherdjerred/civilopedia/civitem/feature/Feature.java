package com.shepherdjerred.civilopedia.civitem.feature;

import android.os.Parcel;

import com.shepherdjerred.civilopedia.civitem.CivItem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Feature implements CivItem {
    private String featureType;
    private String name;
    private String description;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.featureType);
        dest.writeString(this.name);
        dest.writeString(this.description);
    }

    protected Feature(Parcel in) {
        this.featureType = in.readString();
        this.name = in.readString();
        this.description = in.readString();
    }

    public static final Creator<Feature> CREATOR = new Creator<Feature>() {
        @Override
        public Feature createFromParcel(Parcel source) {
            return new Feature(source);
        }

        @Override
        public Feature[] newArray(int size) {
            return new Feature[size];
        }
    };
}
