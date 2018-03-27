package com.example.salim.db_test.modele;

import android.content.Context;
import android.database.sqlite.*;

/**
 * Created by Salim on 23/03/2018.
 */

public class DB_Manager extends SQLiteOpenHelper{
    //Create DB query
    private static final String col_1="id";
    private static final String col_2="titre";
    private static final String col_3="priorite";
    private static final String col_4="couleur";
    private static final String col_5="description";
    private static final String col_6="visib";
    private static final String table_name="calendrier";

    //Resuete de création de la table calendrier
    String db_query="CREATE TABLE "+table_name+"("+col_1+" INTEGER PRIMARY KEY,"+col_2+" TEXT NOT NULL,"+col_3+" TEXT NOT NULL,"+col_4+" TEXT NOT NULL,"+col_5+" TEXT NOT NULL,"+col_6+" BOOLEAN NOT NULL)";

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
