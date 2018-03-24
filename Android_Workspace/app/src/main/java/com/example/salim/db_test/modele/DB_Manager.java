package com.example.salim.db_test.modele;

import android.content.Context;
import android.database.sqlite.*;

/**
 * Created by Salim on 23/03/2018.
 */

public class DB_Manager extends SQLiteOpenHelper{
    //Create DB query
    String db_query="CREATE TABLE calendrier" +
            "(id INTEGER PRIMARY KEY," +
            "titre TEXT NOT NULL," +
            "priorite TEXT NOT NULL," +
            "couleur TEXT NOT NULL," +
            "description TEXT NOT NULL," +
            "visib BOOLEAN NOT NULL)";

    public DB_Manager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(db_query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
