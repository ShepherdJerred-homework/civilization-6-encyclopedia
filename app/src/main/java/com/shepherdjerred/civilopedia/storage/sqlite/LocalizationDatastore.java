package com.shepherdjerred.civilopedia.storage.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class LocalizationDatastore extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "DebugLocalization.sqlite";
    private static final int DATABASE_VERSION = 1;

    public LocalizationDatastore(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public String getEnglishValue(String tag) {

        if (tag != null) {
            SQLiteDatabase sqLiteDatabase = getReadableDatabase();

            Cursor c = sqLiteDatabase.rawQuery("SELECT Text FROM EnglishText WHERE Tag = ?", new String[]{tag});
            if (c.moveToFirst()) {
                return c.getString(0);
            }
            c.close();
            sqLiteDatabase.close();
        }
        return null;
    }

}
