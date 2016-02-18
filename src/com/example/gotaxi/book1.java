package com.example.taxi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class book1 extends Activity {
	GridView gridView;

	static final String[] numbers = new String[] { 
			"Book My Ride",
			"My Rides",
			"Wallet",
			"Far Calculator"};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.book1);

		gridView = (GridView) findViewById(R.id.gridView1);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, numbers);

		gridView.setAdapter(adapter);

		gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			//public void onItemClick(AdapterView<?> parent, View v,int position, long id) {
				
			
							

			public void onItemClick(AdapterView<?> arg0, View arg1, int position,long id) {
				 switch(position)
				    {
				       case 0:  Intent i1 = new Intent(book1.this, ride1.class);     
				                startActivity(i1);
				                break;
				       case 1:  Intent i2 = new Intent(book1.this, my .class);     
				                startActivity(i2);
				                break;
				       case 2:  Intent i3 = new Intent(book1.this, wallet.class);     
				                startActivity(i3);
				                break;
				       case 3:  Intent i4 = new Intent(book1.this, cal.class);     
		                        startActivity(i4);
		                        break;

				      }

			}

			
				
			
			}); 
	}
}
		
		
			



	
