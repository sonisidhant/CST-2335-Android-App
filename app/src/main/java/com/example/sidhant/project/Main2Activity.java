package com.example.sidhant.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by sidhant on 2017-10-13.
 */

public class Main2Activity extends SQLiteOpenHelper {

    final static String DName = "Project.db";
    final static String TName = "Student";
    final static String Col_2 = "Key_Message";
    final static String COL_3 = "Message";
    final static String COL_4 = "FAT";
    final static String COL_5 = "Carbohydrates";
    final static String ID = "ID";
    final static String data="DATE";

    final static int version = 119;


    public Main2Activity(Context context) {
        super(context, DName, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        Log.i("ChatDatabaseHelper", "Calling onCreate");

        sqLiteDatabase.execSQL("CREATE TABLE " + TName + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+ Col_2 + " TEXT, " + COL_3 +" TEXT, " + COL_4 +" TEXT, " + COL_5 +" TEXT, " + data +" TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TName);

        Log.i("ChatDatabaseHelper", "Calling onUpgrade, oldVersion=" + i + "newVersion=" + i1);
           onCreate(sqLiteDatabase);
        }



    public void addproduct(String message,String cal, String fat,String carbo,String date,SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(Col_2, message);
        values.put(COL_3, cal);
        values.put(COL_4,fat);
        values.put(COL_5,carbo);
        values.put(data,date);

        db.insert(TName, null,values);
    }

    public Cursor readMessages(SQLiteDatabase db) {
        String[] dbstring= {ID,Col_2,COL_3,COL_4,COL_5};
        Cursor cursor;
      cursor= db.query(TName,dbstring,null,null,null,null,null);
        return cursor;
    }
    public Cursor getContact(String id,SQLiteDatabase sqLiteDatabase){
        String[] projections = {ID,Col_2,COL_3,COL_4,COL_5};
        String selections = ID+" LIKE ?";
        String[] selection_args={id};
        Cursor cursor = sqLiteDatabase.query(TName,projections,selections,selection_args,null,null,null);
    return cursor;
    }

    public void deletemessages(String id,SQLiteDatabase sqLiteDatabase){
        SQLiteDatabase database = this.getWritableDatabase();
        String selection = ID+" LIKE ?";
        String[] selection_args = {id};
        sqLiteDatabase.delete(TName,selection,selection_args);
    }
    public int update(String oldname, String newname,String calories,String fats,String carbohydrates,SQLiteDatabase sqLiteDatabase){
    ContentValues contentValues = new ContentValues();
        contentValues.put(Col_2,newname);
        contentValues.put(COL_3,calories);
        contentValues.put(COL_4,fats);
        contentValues.put(COL_5,carbohydrates);

        String selections = ID+" LIKE ?";
        String[] selections_args = {oldname};
    int count= sqLiteDatabase.update(TName,contentValues,selections,selections_args);
        return count;
    }
}