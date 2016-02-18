package com.example.taxi;


import com.example.taxi.R;
import com.example.taxi.lgn;
import com.example.taxi.sgn;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	Button b1,b2;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
        b1=(Button)findViewById(R.id.blog);
        b2=(Button)findViewById(R.id.bsign);
         b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
					Intent n=new Intent(MainActivity.this,lgn.class);
					startActivity(n);
					
				
				}
					});
					 b2.setOnClickListener(new View.OnClickListener() {
							
							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
						Intent i=new Intent(MainActivity.this,sgn.class);
						startActivity(i);
								
							
			
					 }});
}}
		

	
     
        
		