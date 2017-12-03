package com.shepherdjerred.civilopedia.civitem.Resources;

import android.os.Parcel;

import com.shepherdjerred.civilopedia.civitem.CivItem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Resource implements CivItem {

    private String resourceType;
    private String name;
    private int frequency;

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(this.resourceType);
        dest.writeString(this.name);
        dest.writeInt(this.frequency);
    }

    protected Resource(Parcel in) {
        this.resourceType = in.readString();
        this.name = in.readString();
        this.frequency = in.readInt();
    }

    public static final Creator<Resource> CREATOR = new Creator<Resource>() {
        @Override
        public Resource createFromParcel(Parcel source) {
            return new Resource(source);
        }

        @Override
        public Resource[] newArray(int size) {
            return new Resource[size];
        }
    };
}
