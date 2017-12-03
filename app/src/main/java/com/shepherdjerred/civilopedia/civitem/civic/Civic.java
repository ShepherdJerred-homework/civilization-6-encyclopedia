package com.shepherdjerred.civilopedia.civitem.civic;

import android.os.Parcel;

import com.shepherdjerred.civilopedia.civitem.CivItem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Civic implements CivItem {
    private String civicType;
    private String name;
    private int cost;
    private String description;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.civicType);
        dest.writeString(this.name);
        dest.writeInt(this.cost);
        dest.writeString(this.description);
    }

    protected Civic(Parcel in) {
        this.civicType = in.readString();
        this.name = in.readString();
        this.cost = in.readInt();
        this.description = in.readString();
    }

    public static final Creator<Civic> CREATOR = new Creator<Civic>() {
        @Override
        public Civic createFromParcel(Parcel source) {
            return new Civic(source);
        }

        @Override
        public Civic[] newArray(int size) {
            return new Civic[size];
        }
    };
}
