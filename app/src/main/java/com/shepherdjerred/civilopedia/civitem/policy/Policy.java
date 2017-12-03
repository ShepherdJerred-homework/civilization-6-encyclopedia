package com.shepherdjerred.civilopedia.civitem.policy;

import android.os.Parcel;

import com.shepherdjerred.civilopedia.civitem.CivItem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Policy implements CivItem {
    private String policyType;
    private String name;
    private String description;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.policyType);
        dest.writeString(this.name);
        dest.writeString(this.description);
    }

    protected Policy(Parcel in) {
        this.policyType = in.readString();
        this.name = in.readString();
        this.description = in.readString();
    }

    public static final Creator<Policy> CREATOR = new Creator<Policy>() {
        @Override
        public Policy createFromParcel(Parcel source) {
            return new Policy(source);
        }

        @Override
        public Policy[] newArray(int size) {
            return new Policy[size];
        }
    };
}
