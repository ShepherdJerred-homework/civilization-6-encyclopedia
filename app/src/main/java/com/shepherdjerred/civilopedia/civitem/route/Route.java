package com.shepherdjerred.civilopedia.civitem.route;

import android.os.Parcel;
import com.shepherdjerred.civilopedia.civitem.CivItem;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Route implements CivItem {

    private String routeType;
    private String name;
    private String description;
    private int cost;

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(this.routeType);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeInt(this.cost);
    }

    protected Route(Parcel in) {
        this.routeType = in.readString();
        this.name = in.readString();
        this.cost = in.readInt();
        this.description = in.readString();
    }

    public static final Creator<Route> CREATOR = new Creator<Route>() {
        @Override
        public Route createFromParcel(Parcel source) {
            return new Route(source);
        }

        @Override
        public Route[] newArray(int size) {
            return new Route[size];
        }
    };
}
