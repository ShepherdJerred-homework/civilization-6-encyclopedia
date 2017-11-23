package com.shepherdjerred.civilopedia.civitem.leader;

import android.os.Parcel;

import com.shepherdjerred.civilopedia.civitem.CivItem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Leader implements CivItem {
    private String leaderType;
    private String name;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.leaderType);
        dest.writeString(this.name);
    }

    public Leader() {
    }

    protected Leader(Parcel in) {
        this.leaderType = in.readString();
        this.name = in.readString();
    }

    public static final Creator<Leader> CREATOR = new Creator<Leader>() {
        @Override
        public Leader createFromParcel(Parcel source) {
            return new Leader(source);
        }

        @Override
        public Leader[] newArray(int size) {
            return new Leader[size];
        }
    };
}
