package com.example.calltaxi;

import java.util.ArrayList;
import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Carbooking extends Activity {
	Button b1,b2,b3,b4;
	String names,balance;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_carbooking);
		
		Intent in=getIntent();
		 names=in.getStringExtra("name");
		balance=in.getStringExtra("balance");
		b1=(Button)findViewById(R.id.button1);
		b2=(Button)findViewById(R.id.button2);
		b3=(Button)findViewById(R.id.button3);
		b4=(Button)findViewById(R.id.button4);
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in=new Intent(getApplicationContext(),Booking.class);
				in.putExtra("name", names);
				in.putExtra("balance",balance);
				startActivity(in);
			}
		});
		b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in=new Intent(getApplicationContext(),MyRide.class);
				in.putExtra("name", names);
				in.putExtra("balance",balance);
				startActivity(in);
			}
		});
	b3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in=new Intent(getApplicationContext(),Viewmap.class);
				in.putExtra("name", names);
				in.putExtra("balance",balance);
				startActivity(in);
			}
		});
b4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in=new Intent(getApplicationContext(),MyHome.class);
				in.putExtra("name", names);
				in.putExtra("balance",balance);
				startActivity(in);
			}
		});
	}
	@Override
	public void onBackPressed()
	{
		Intent in=new Intent(getApplicationContext(),MyHome.class);
		in.putExtra("name", names);
		in.putExtra("balance",balance);
		startActivity(in);
	}
}
