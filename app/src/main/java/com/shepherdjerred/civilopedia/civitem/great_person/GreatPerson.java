package com.shepherdjerred.civilopedia.civitem.great_person;

import android.os.Parcel;

import com.shepherdjerred.civilopedia.civitem.CivItem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GreatPerson implements CivItem {
    private String greatPersonType;
    private String name;
    private String greatPersonClassType;
    private String gender;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.greatPersonType);
        dest.writeString(this.name);
        dest.writeString(this.greatPersonClassType);
        dest.writeString(this.gender);
    }

    protected GreatPerson(Parcel in) {
        this.greatPersonType = in.readString();
        this.name = in.readString();
        this.greatPersonClassType = in.readString();
        this.gender = in.readString();
    }

    public static final Creator<GreatPerson> CREATOR = new Creator<GreatPerson>() {
        @Override
        public GreatPerson createFromParcel(Parcel source) {
            return new GreatPerson(source);
        }

        @Override
        public GreatPerson[] newArray(int size) {
            return new GreatPerson[size];
        }
    };
}
