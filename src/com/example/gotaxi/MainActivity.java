package com.example.gotaxi;


import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;


public class MainActivity extends ActionBarActivity {
EditText e1,e2;
TextView t1,t2;
Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        b1=(Button)findViewById(R.id.log);
        b2=(Button)findViewById(R.id.signup);
        b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(MainActivity.this,login.class);
				startActivity(i);
				
			
			}
				});
				 b2.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
					Intent i=new Intent(MainActivity.this,sign.class);
					startActivity(i);
							
						
		}
        
				 });
			
        
    }}        