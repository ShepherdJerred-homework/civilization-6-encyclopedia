package com.shepherdjerred.civilopedia.civitem.religion;

import android.os.Parcel;

import com.shepherdjerred.civilopedia.civitem.CivItem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Religion implements CivItem {
    private String religionType;
    private String name;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.religionType);
        dest.writeString(this.name);
    }

    protected Religion(Parcel in) {
        this.religionType = in.readString();
        this.name = in.readString();
    }

    public static final Creator<Religion> CREATOR = new Creator<Religion>() {
        @Override
        public Religion createFromParcel(Parcel source) {
            return new Religion(source);
        }

        @Override
        public Religion[] newArray(int size) {
            return new Religion[size];
        }
    };
}
