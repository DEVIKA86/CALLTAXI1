package com.example.calltaxi;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper{
	
	SQLiteDatabase sqlite;
	static String DBName="calltaxi.db";
	static int DBVersion=3;
	static String TBName="regsiter";
	static String TBNameexec="bookingdetails";
	static String  TBNamesource="sourcedes";
	static String  TBNamedriver="driverdetails";
	static String  TBNametaxi="taxidetails";
	Cursor cursor;

	public DataBaseHelper(Context context) {
		super(context,DBName,null,DBVersion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		db.execSQL("create table "+TBName+"(username text primary key,pass text,retypepass text,address text,mob text,email text,gender text,cost text)");
		db.execSQL("create table "+TBNamesource+"(source text primary key,designation text,costing text)");
		db.execSQL("create table "+TBNameexec+"(name text primary key,source text,desination text,amount text,drivername text,taxiname text,taxiphone text,bookingdate text)");
		db.execSQL("create table "+TBNamedriver+"(name text primary key,phone text,experience text,age text,gender text)");
		db.execSQL("create table "+TBNametaxi+"(memberid text primary key,taxino text,taxiname text,taxiphone text,taxistatuss text,taxtinumber text)");
		// TODO Auto-generated method stub
		
	}

	public void Insert(String name,String pass,String retype,String address,String mob,String email,String gender)
	{
		sqlite=this.getWritableDatabase();
		ContentValues cv=new ContentValues();
		cv.put("username", name);
		cv.put("pass", pass);
		cv.put("retypepass", retype);
		cv.put("address", address);
		cv.put("mob", mob);
		cv.put("email", email);
		cv.put("gender", gender);
		cv.put("cost", "500");
		sqlite.insert(TBName, null, cv);
	}
	public void Insertsource(String source,String deignation,String cost)
	{
		sqlite=this.getWritableDatabase();
		ContentValues cv=new ContentValues();
		cv.put("source", source);
		cv.put("designation", deignation);
		cv.put("costing", cost);
		
	
		sqlite.insert(TBNamesource, null, cv);
	}
	public void Insertexecutive(String name,String bankname,String cardname,String expiration,String cvv,String holdername,String amount)
	{
		sqlite=this.getWritableDatabase();
		ContentValues cv=new ContentValues();
		cv.put("source", name);
		cv.put("designation", bankname);
		cv.put("cardno", cardname);
		cv.put("expirationdate", expiration);
		cv.put("cvv", cvv);
		cv.put("holdername", holdername);
		cv.put("amount", amount);
		
		sqlite.insert(TBNameexec, null, cv);
	}
	public void Insertdriver(String name,String phone,String experience,String age,String gender)
	{
		sqlite=this.getWritableDatabase();
		ContentValues cv=new ContentValues();
		cv.put("name", name);
		cv.put("phone", phone);
		cv.put("experience", experience);
		cv.put("age", age);
		cv.put("gender", gender);
	
		
		sqlite.insert(TBNamedriver, null, cv);
	}
	
	public void Inserttaxi(String memberid,String taxino,String taxiname,String taxiphone)
	{
		
		sqlite=this.getWritableDatabase();
		ContentValues cv=new ContentValues();
		cv.put("memberid", memberid);
		cv.put("taxino", taxino);
		cv.put("taxiname", taxiname);
		cv.put("taxiphone", taxiphone);
		cv.put("taxistatuss","0");
		
		cv.put("taxtinumber","TN364777");
		sqlite.insert(TBNametaxi, null, cv);
	}
	
	public void Insertbooking(String name,String source,String desination,String amount,String drivername,String taxiname,String taxiphone,String bookingdate)
	{
		sqlite=this.getWritableDatabase();
		ContentValues cv=new ContentValues();
		cv.put("name", name);
		cv.put("source", source);
		cv.put("desination", desination);
		cv.put("amount", amount);
		cv.put("drivername", drivername);
		cv.put("taxiname", taxiname);
		cv.put("taxiphone", taxiphone);
		cv.put("bookingdate", bookingdate);
		sqlite.insert(TBNameexec, null, cv);
	}
	
	//name text primary key,source text,desination text,amount text,drivername text,taxiname text,taxiphone text,bookingdate text)
	public ArrayList<HashMap<String, String>> alist1(String name)
	{
		sqlite=this.getReadableDatabase();
		Cursor c=sqlite.rawQuery("select * from bookingdetails where name='"+name+"' ", null);
		
		ArrayList<HashMap<String, String>> listdata=new ArrayList<HashMap<String,String>>();
		
		while(c.moveToNext())
		{
			HashMap<String, String> al=new HashMap<String, String>();
			al.put("source", c.getString(c.getColumnIndex("source")).toString());
			al.put("desination", c.getString(c.getColumnIndex("desination")).toString());
			al.put("amount", c.getString(c.getColumnIndex("amount")).toString());
			al.put("drivername", c.getString(c.getColumnIndex("drivername")).toString());
			al.put("taxiname", c.getString(c.getColumnIndex("taxiname")).toString());
			al.put("taxiphone", c.getString(c.getColumnIndex("taxiphone")).toString());
			al.put("bookingdate", c.getString(c.getColumnIndex("bookingdate")).toString());
			listdata.add(al);
		}
		
		return listdata;
		
		
	}
	public ArrayList<HashMap<String, String>> alist2()
	{
		sqlite=this.getReadableDatabase();
		Cursor c=sqlite.rawQuery("select * from regsiter ", null);
		
		ArrayList<HashMap<String, String>> listdata=new ArrayList<HashMap<String,String>>();
		
		while(c.moveToNext())
		{
			HashMap<String, String> al=new HashMap<String, String>();
			al.put("name", c.getString(c.getColumnIndex("username")).toString());
			al.put("wallet", c.getString(c.getColumnIndex("cost")).toString());
			
			listdata.add(al);
		}
		
		return listdata;
		
		
	}
	public ArrayList<HashMap<String, String>> alist3()
	{
		sqlite=this.getReadableDatabase();
		Cursor c=sqlite.rawQuery("select * from taxidetails ", null);
		
		ArrayList<HashMap<String, String>> listdata=new ArrayList<HashMap<String,String>>();
		
		while(c.moveToNext())
		{
			HashMap<String, String> al=new HashMap<String, String>();
			al.put("name", c.getString(c.getColumnIndex("taxiname")).toString());
			al.put("phone", c.getString(c.getColumnIndex("taxiphone")).toString());
			al.put("number", c.getString(c.getColumnIndex("taxtinumber")).toString());
			
			listdata.add(al);
		}
		
		return listdata;
		
		
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
