package com.shepherdjerred.civilopedia.civitem.improvements;

import android.os.Parcel;

import com.shepherdjerred.civilopedia.civitem.CivItem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Improvement implements CivItem {

    private String improvementType;
    private String name;
    private String description;

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(this.improvementType);
        dest.writeString(this.name);
        dest.writeString(this.description);
    }

    protected Improvement(Parcel in) {
        this.improvementType = in.readString();
        this.name = in.readString();
        this.description = in.readString();
    }

    public static final Creator<Improvement> CREATOR = new Creator<Improvement>() {
        @Override
        public Improvement createFromParcel(Parcel source) {
            return new Improvement(source);
        }

        @Override
        public Improvement[] newArray(int size) {
            return new Improvement[size];
        }
    };
}
