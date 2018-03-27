package com.example.salim.db_test.modele;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Salim on 23/03/2018.
 */

public class Calendrier_Manager {
    DB_Manager db_manager;
    Calendrier calendrier;
    SQLiteDatabase db;

   public Calendrier_Manager(Context context){

    db_manager=new DB_Manager(context,"basecalendrier",null,1);

    }

    public void open(){

       db=db_manager.getWritableDatabase();
    }

    public void close(){
        db.close();
    }

    public long insertCalendar(Calendrier cal){
        ContentValues cv=new ContentValues();

        cv.put("titre",cal.getTitre());
        cv.put("priorite",cal.getPriorite());
        cv.put("couleur",cal.getCouleur());
        cv.put("description",cal.getDescription());
        cv.put("visib",cal.isVisib());

            return db.insert("calendrier",null,cv);

    }

    public int deleteCalendar(int delete_id){

        return db.delete("calendrier","id="+delete_id,null);
    }

}
