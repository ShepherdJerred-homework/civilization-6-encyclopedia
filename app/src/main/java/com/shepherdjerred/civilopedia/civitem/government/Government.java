package com.shepherdjerred.civilopedia.civitem.government;

import android.os.Parcel;

import com.shepherdjerred.civilopedia.civitem.CivItem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Government implements CivItem {
    private String governmentType;
    private String name;
    private String inherentDescription;
    private String accumulatedDescription;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.governmentType);
        dest.writeString(this.name);
        dest.writeString(this.inherentDescription);
        dest.writeString(this.accumulatedDescription);
    }

    protected Government(Parcel in) {
        this.governmentType = in.readString();
        this.name = in.readString();
        this.inherentDescription = in.readString();
        this.accumulatedDescription = in.readString();
    }

    public static final Creator<Government> CREATOR = new Creator<Government>() {
        @Override
        public Government createFromParcel(Parcel source) {
            return new Government(source);
        }

        @Override
        public Government[] newArray(int size) {
            return new Government[size];
        }
    };
}
