package com.example.a2fit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class dbHelper extends SQLiteOpenHelper {

    public static final String USER_TABLE = "USER_TABLE";
    public static final String KCAL_INTAKE = "KCAL_INTAKE";
    public static final String BURNED_KCAL = "BURNED_KCAL";
    public static final String T_SLEEP = "T_SLEEP";
    public static final String T_WEIGHT = "T_WEIGHT";
    public static final String BMI = "BMI";


    public dbHelper(@Nullable Context context) {
        super(context, "user.db", null, 1);
    }

    //this is for first time database use
    @Override
    public void onCreate(SQLiteDatabase db) {
        String TableStatement = "CREATE TABLE " + USER_TABLE + " (" + KCAL_INTAKE + " INTEGER, " + BURNED_KCAL + " INTEGER, " + T_SLEEP + " INTEGER, " + T_WEIGHT + " INTEGER, " + BMI + " FLOAT)";

        db.execSQL(TableStatement);

    }

    //this to automatically modify the schema ie: if the version number of database changes
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    //adds total intake Kcal
    public boolean addOne(@Nullable foodModel FoodModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cov = new ContentValues();

        //get total Kcal
        cov.put(KCAL_INTAKE, FoodModel.getBfast() + FoodModel.getDinner() + FoodModel.getLunch());


        long insert = db.insert(USER_TABLE, null, cov);
        return insert != -1;
    }

    //adds total intake Kcal
    public boolean deleteOne(@Nullable overallModel overallModel){
        SQLiteDatabase db = this.getWritableDatabase();
        String qString = "DELETE FROM " + overallModel + " WHERE " + BMI + " = " + overallModel.getBMI();
        Cursor cursor = db.rawQuery(qString, null);

        if (cursor.moveToFirst()){
            return true;
        }
        else {
            return false;
        }

    }



    //adds burned kcal from exercise
    public boolean addTwo(@Nullable exerciseModel exerciseModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cov = new ContentValues();

        cov.put(BURNED_KCAL, exerciseModel.getBurnedKcal());

        long insert = db.insert(USER_TABLE, null, cov);
        return insert != -1;
    }

    //adds sleep time
    public boolean addThree(@Nullable sleepModel sleepModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cov = new ContentValues();

        cov.put(T_SLEEP, sleepModel.getSleepTime());

        long insert = db.insert(USER_TABLE, null, cov);
        return insert != -1;
    }

    //adds BMI and target weight
    public boolean addFour(@Nullable UserModel UserModel){
        /*BMI Calculation:
            User height in cm / 100 = User height in m
            User height in m * User height in m = squared height
            Weight / squared height = BMI
        */
        float a = (float) UserModel.getHeight() / 100;
        float b = (a * a);
        float c = (float) UserModel.getWeight() / b;

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cov = new ContentValues();


        cov.put(BMI, c);
        cov.put(T_WEIGHT, UserModel.getT_weight());
        long insert = db.insert(USER_TABLE, null, cov);
        return insert != -1;
    }


    public List<overallModel> getUser() {
        List<overallModel> returnList = new ArrayList<>();

        //to get data from database
        String dqString = "SELECT * FROM " + USER_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();

        //The result set from the SQL statement is in the cursor.
        Cursor cursor = db.rawQuery(dqString,null);

        if(cursor.moveToFirst()){
            //New user objects can be created by looping over the cursor.
            do {
                int KCAL_INTAKE = cursor.getInt(0);
                int T_WEIGHT = cursor.getInt(3);
                float BMI = cursor.getFloat(4);

                //create new user object
                overallModel overallModel = new overallModel(KCAL_INTAKE,T_WEIGHT, (int) BMI);
                returnList.add(overallModel);

            } while (cursor.moveToNext());
        }
        else {
                //error
        }

        //close db and cursor
        cursor.close();
        db.close();
        return returnList;
    }


}
