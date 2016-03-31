package com.example.calltaxi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Booking extends Activity {
	EditText name,cardnumber,date,cvv,cardno,amt,txt_name;
	DataBaseHelper sqlite;
	Spinner myProduct_type,myProduct_type1,activity_driver,activity_taximember;
	SQLiteDatabase db;
	Button activityokdialog,activityoamt;
	TextView txt7,txt_number;
	String balance,names,source,degination,drivername,taxiname,sourcename,deginationname,sourcedesamt,taxxiphone;
	String total,status;
	String database="calltaxi.db";
	boolean dbfound=true;
	Cursor cursor,cursor1,cursor2;
	ArrayList<String> myLocationname_list=new ArrayList<String>();
	ArrayList<String> myLocationname_list1=new ArrayList<String>();
	ArrayList<String> myLocationname_list2=new ArrayList<String>();
	ArrayList<String> myLocationname_list3=new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_booking);
		
		Intent in=getIntent();
		 names=in.getStringExtra("name");
		balance=in.getStringExtra("balance");
		sqlite=new DataBaseHelper(getApplicationContext());
		sqlite.getWritableDatabase();
		name=(EditText)findViewById(R.id.txt_city1);
		myProduct_type=(Spinner)findViewById(R.id.activity_source);
		myProduct_type1=(Spinner)findViewById(R.id.activity_degination);
		activity_driver=(Spinner)findViewById(R.id.activity_driver);
	
		activity_taximember=(Spinner)findViewById(R.id.activity_taximember);
		cardnumber=(EditText)findViewById(R.id.txt_experience);
		date=(EditText)findViewById(R.id.txt_phoneno);
		cvv=(EditText)findViewById(R.id.txt_mailid);
		activityoamt=(Button)findViewById(R.id.activityoamt);
		amt=(EditText)findViewById(R.id.txt_amount);
		txt_name=(EditText)findViewById(R.id.txt_name);
		txt7=(TextView)findViewById(R.id.txt7);
		txt_number=(TextView)findViewById(R.id.txt_number);
		name.setText(names);
		txt7.setText("Account Balance:"+balance);
		activityokdialog=(Button)findViewById(R.id.activityokdialog);
		try{
			db=openOrCreateDatabase(database,SQLiteDatabase.CREATE_IF_NECESSARY,null);
			db.setVersion(1);
			db.setLocale(Locale.getDefault());
			db.setLockingEnabled(true);
			dbfound=true;
			
			cursor=db.rawQuery("select * from sourcedes  ",null);
			  cursor.moveToFirst();
			
			    while (!cursor.isAfterLast()) {
			
			     source=cursor.getString(0);
			     degination=cursor.getString(1);
			     
			     System.out.println(source);
			     System.out.println(degination);
			     myLocationname_list.add(source);
			     myLocationname_list1.add(degination);
			
				
			
				
			      cursor.moveToNext();
			  
			    
			    }
			    cursor.close();
			    ArrayAdapter<String> aProd_type_adapter=new ArrayAdapter<String>(this, R.layout.spin_act,R.id.spin_text_id,myLocationname_list);
			    myProduct_type.setPopupBackgroundResource(R.drawable.popup);
			    myProduct_type.setAdapter(aProd_type_adapter);
			    
			    ArrayAdapter<String> aProd_type_adapter1=new ArrayAdapter<String>(this, R.layout.spin_act,R.id.spin_text_id,myLocationname_list1);
			    myProduct_type1.setPopupBackgroundResource(R.drawable.popup);
			    myProduct_type1.setAdapter(aProd_type_adapter1);
			    
			    
			    cursor1=db.rawQuery("select * from driverdetails  ",null);
				  cursor1.moveToFirst();
				
				    while (!cursor1.isAfterLast()) {
				
				     drivername=cursor1.getString(0);
				    
				     myLocationname_list2.add(drivername);
				     System.out.println(drivername);
				
					
				      cursor1.moveToNext();
				  
				    
				    }
				    cursor1.close();
				    ArrayAdapter<String> aProd_type_adapter2=new ArrayAdapter<String>(this, R.layout.spin_act,R.id.spin_text_id,myLocationname_list2);
				    activity_driver.setPopupBackgroundResource(R.drawable.popup);
				    activity_driver.setAdapter(aProd_type_adapter2);
				    
//				    cursor2=db.rawQuery("select * from taxidetails  ",null);
//					  cursor2.moveToFirst();
//					
//					    while (!cursor2.isAfterLast()) {
//					
//					     taxiname=cursor2.getString(2);
//					    
//					     myLocationname_list3.add(taxiname);
//						
//					
//						
//					      cursor2.moveToNext();
//					  
//					    
//					    }
//					    cursor2.close();
//					    ArrayAdapter<String> aProd_type_adapter3=new ArrayAdapter<String>(this, R.layout.spin_act,R.id.spin_text_id,myLocationname_list3);
//					    activity_taxiname.setPopupBackgroundResource(R.drawable.popup);
//					    activity_taxiname.setAdapter(aProd_type_adapter3);
		}catch(Exception e){
			e.printStackTrace();
			//display("Error DataBase");
		}
		myProduct_type.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				sourcename=myProduct_type.getSelectedItem().toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
		myProduct_type1.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				deginationname=myProduct_type1.getSelectedItem().toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
		
		activityoamt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try{
					db=openOrCreateDatabase(database,SQLiteDatabase.CREATE_IF_NECESSARY,null);
					db.setVersion(1);
					db.setLocale(Locale.getDefault());
					db.setLockingEnabled(true);
					dbfound=true;
					
					cursor=db.rawQuery("select * from sourcedes where source='"+sourcename+"' and designation='"+deginationname+"' ",null);
					  cursor.moveToFirst();
					
					    while (!cursor.isAfterLast()) {
					
					    	sourcedesamt=cursor.getString(2);
					  
					     
					   
					    	cardnumber.setText(sourcedesamt);
						
					
						
					      cursor.moveToNext();
					  
					    
					    }
					    cursor.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
		});
		activity_taximember.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				String taximember=activity_taximember.getSelectedItem().toString();
				
				try{
					db=openOrCreateDatabase(database,SQLiteDatabase.CREATE_IF_NECESSARY,null);
					db.setVersion(1);
					db.setLocale(Locale.getDefault());
					db.setLockingEnabled(true);
					dbfound=true;
					
					cursor=db.rawQuery("select * from taxidetails where memberid='"+taximember+"'  ",null);
					  cursor.moveToFirst();
					
					    while (!cursor.isAfterLast()) {
					    	
					String name=cursor.getString(2);
					    	taxxiphone=cursor.getString(3);
					          String txno=cursor.getString(5);
					     
					          txt_name.setText(name);
					    	amt.setText(taxxiphone);
					    	txt_number.setText(txno);
					
						
					      cursor.moveToNext();
					  
					    
					    }
					    cursor.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
	
		
		activityokdialog.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String taximember=activity_taximember.getSelectedItem().toString();
				try{
					db=openOrCreateDatabase(database,SQLiteDatabase.CREATE_IF_NECESSARY,null);
					db.setVersion(1);
					db.setLocale(Locale.getDefault());
					db.setLockingEnabled(true);
					dbfound=true;
					
					cursor=db.rawQuery("select * from taxidetails where memberid='"+taximember+"'  ",null);
					  cursor.moveToFirst();
					
					    while (!cursor.isAfterLast()) {
					    	
					    	status=cursor.getString(4);
					    	
					
						
					      cursor.moveToNext();
					  
					    
					    }
					    cursor.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				
				
				
				if(status.equalsIgnoreCase("0")){
				
				try{
					DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
					Date date = new Date();
					System.out.println(dateFormat.format(date));
				String amount=cardnumber.getText().toString();
				int a=Integer.parseInt(amount);
				int b=Integer.parseInt(balance);
				int c=b-a;
				total=Integer.toString(c);
				if(a>b){
					Toast.makeText(getApplicationContext(),"Your Balance To Low Please Maintaining Your Balance", Toast.LENGTH_SHORT).show();
				}else{
					sqlite.Insertbooking(names, sourcename, deginationname, cardnumber.getText().toString(), activity_driver.getSelectedItem().toString(),txt_name.getText().toString() , amt.getText().toString(),dateFormat.format(date));
					
					Toast.makeText(getApplicationContext(),"Insert Successfully", Toast.LENGTH_SHORT).show();
					
						db=openOrCreateDatabase(database,SQLiteDatabase.CREATE_IF_NECESSARY,null);
						db.setVersion(1);
						db.setLocale(Locale.getDefault());
						db.setLockingEnabled(true);
						dbfound=true;
						
					
				String updateing="update regsiter set cost='"+total+"' where username='"+names+"' ";
					db.execSQL(updateing);
					
					String updateing1="update taxidetails set taxistatuss='1' where memberid='"+taximember+"' ";
					db.execSQL(updateing1);
				
					Intent in=new Intent(getApplicationContext(),Carbooking.class);
					in.putExtra("name", names);
					in.putExtra("balance",total);
					startActivity(in);
				}
				
			
				}catch(Exception e){
					e.printStackTrace();
					//display("Error DataBase");
				}
				}else{
					Toast.makeText(getApplicationContext(), "Already Car Booked Choose Another Car! ", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
	}
	
}

