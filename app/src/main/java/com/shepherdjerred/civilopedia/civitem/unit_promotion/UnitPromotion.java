package com.shepherdjerred.civilopedia.civitem.unit_promotion;

import android.os.Parcel;

import com.shepherdjerred.civilopedia.civitem.CivItem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UnitPromotion implements CivItem {
    private String unitPromotionType;
    private String name;
    private int level;
    private String description;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.unitPromotionType);
        dest.writeString(this.name);
        dest.writeInt(this.level);
        dest.writeString(this.description);
    }

    protected UnitPromotion(Parcel in) {
        this.unitPromotionType = in.readString();
        this.name = in.readString();
        this.level = in.readInt();
        this.description = in.readString();
    }

    public static final Creator<UnitPromotion> CREATOR = new Creator<UnitPromotion>() {
        @Override
        public UnitPromotion createFromParcel(Parcel source) {
            return new UnitPromotion(source);
        }

        @Override
        public UnitPromotion[] newArray(int size) {
            return new UnitPromotion[size];
        }
    };
}
