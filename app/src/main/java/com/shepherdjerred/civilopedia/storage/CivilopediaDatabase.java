package com.shepherdjerred.civilopedia.storage;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class CivilopediaDatabase extends SQLiteAssetHelper implements Store {

    private static final String DATABASE_NAME = "DebugGameplay.sqlite";
    private static final int DATABASE_VERSION = 1;

    public CivilopediaDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

}
