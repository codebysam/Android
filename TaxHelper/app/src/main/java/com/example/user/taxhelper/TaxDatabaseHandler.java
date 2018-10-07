package com.example.user.taxhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 8/19/2018.
 */

public class TaxDatabaseHandler extends SQLiteOpenHelper {

    public final static String DB_NAME = "TAXHELPER.db";
    public final static String T1_LOGIN_DETAILS = "LOGIN_DETAILS";
    public final static String T1_C1_USERNAME = "USERNAME";
    public final static String T1_C2_PASSWORD = "PASSWORD";
    public final static String T2_PROFILE = "PROFILE";
    public final static String T2_C1_USERNAME = "USERNAME";
    public final static String T2_C2_FULLNAME = "FULLNAME";
    public final static String T2_C3_USERTYPE = "USERTYPE";
    public final static String T2_C4_GENDER = "GENDER";
    public final static String T2_C5_PANNO = "PAN_NO";
    public final static String T2_C6_CONTACT = "CONTACT_NO";
    public final static String T2_C7_DOB = "DOB";
    public final static String T3_IT_DETAILS = "IT_DETAILS";
    public final static String T3_C1_USERNAME = "USERNAME";
    public final static String T3_C2_YEAR = "YEAR";
    public final static String T3_C3_SALARY = "SALARY";
    public final static String T3_C4_OTHERS = "OTHERS";
    public final static String T3_C5_TAX = "TAX";
    public final static String T3_C6_CESS = "CESS";
    public final static String T3_C7_REBATE = "REBATE";
    public final static String T3_C8_SURCHARGE = "SURCHARGE";
    public final static String T3_C9_TOTAL_TAX = "TOTAL_TAX";
    SQLiteDatabase db;

    public TaxDatabaseHandler(Context context) {
        super(context, DB_NAME, null, 1);
        db =this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+T1_LOGIN_DETAILS+" ( "+ T1_C1_USERNAME+" VARCHAR PRIMARY KEY,"+T1_C2_PASSWORD+" VARCHAR)");
        db.execSQL("CREATE TABLE "+T2_PROFILE+"("+T2_C1_USERNAME+" VARCHAR PRIMARY KEY REFERENCES "+T1_LOGIN_DETAILS+"("+T1_C1_USERNAME+"),"
                +T2_C2_FULLNAME+" VARCHAR,"+T2_C3_USERTYPE+" VARCHAR,"+T2_C4_GENDER+" VARCHAR,"
                +T2_C5_PANNO+" VARCHAR,"+T2_C6_CONTACT+" VARCHAR,"+T2_C7_DOB+" VARCHAR)");
        db.execSQL("CREATE TABLE "+T3_IT_DETAILS+" ( "+T3_C1_USERNAME+ " VARCHAR REFERENCES "+T1_LOGIN_DETAILS+"("+T1_C1_USERNAME+"),"
                +T3_C2_YEAR+" VARCHAR, "+ T3_C3_SALARY+" VARCHAR,"+ T3_C4_OTHERS+" VARCHAR," + T3_C5_TAX+ " VARCHAR,"+T3_C6_CESS +" VARCHAR,"+ T3_C7_REBATE+" VARCHAR,"
                +T3_C8_SURCHARGE+" VARCHAR,"+T3_C9_TOTAL_TAX+" VARCHAR, PRIMARY KEY("+T3_C1_USERNAME+", "+T3_C2_YEAR+"))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Boolean insertItdetails(String username,String year,String salary,String others,String tax,String cess,String rebate,String surcharge,String totaltax)
    {
        ContentValues content3 = new ContentValues();
        content3.put(T3_C1_USERNAME,username);
        content3.put(T3_C2_YEAR,year);
        content3.put(T3_C3_SALARY,salary);
        content3.put(T3_C4_OTHERS,others);
        content3.put(T3_C5_TAX,tax);
        content3.put(T3_C6_CESS,cess);
        content3.put(T3_C7_REBATE,rebate);
        content3.put(T3_C8_SURCHARGE,surcharge);
        content3.put(T3_C9_TOTAL_TAX,totaltax);
        long chk = db.insert(T3_IT_DETAILS,null,content3);
        if(chk == -1)
            return false;

        return true;

    }
    public Boolean insertprofileData(String fullname,String username,String password,String usertype,String dob,String panno,String phn_no,String gender)
    {

        ContentValues content1 = new ContentValues();
        content1.put(T1_C1_USERNAME,username);
        content1.put(T1_C2_PASSWORD,password);
        long chk = db.insert(T1_LOGIN_DETAILS,null,content1);
        if(chk == -1)
            return false;

        ContentValues content2 = new ContentValues();
        content2.put(T2_C1_USERNAME,username);
        content2.put(T2_C2_FULLNAME,fullname);
        content2.put(T2_C3_USERTYPE,usertype);
        content2.put(T2_C4_GENDER,gender);
        content2.put(T2_C5_PANNO,panno);
        content2.put(T2_C6_CONTACT,phn_no);
        content2.put(T2_C7_DOB,dob);
        chk = db.insert(T2_PROFILE,null,content2);
        if(chk == -1)
            return false;

        return true;

    }

    public void updateData(String newvalue,String column,String Table,String matchcolumn,String match)
    {
        db.execSQL("UPDATE "+Table+" SET "+column+" = '"+newvalue+"' WHERE "+matchcolumn+" = '"+match+"'");
    }

    public void updateData2(String newvalue,String column,String Table,String matchcolumn,String match1,String matchcol2,String match2)
    {
        db.execSQL("UPDATE "+Table+" SET "+column+" = '"+newvalue+"' WHERE "+matchcolumn+" = '"+match1+"' AND "+matchcol2+" = '"+match2+"'");
    }

    public Cursor getData(String required,String value,String table,String column)
    {
        String query = "SELECT "+required+" FROM "+table+" WHERE "+column+" = '"+value+"'";
        Cursor res = db.rawQuery(query,null);
        return res;
    }

    public Cursor getallData(String table)
    {
        String query = "SELECT * FROM "+table;
        Cursor res = db.rawQuery(query,null);
        return res;
    }


}
