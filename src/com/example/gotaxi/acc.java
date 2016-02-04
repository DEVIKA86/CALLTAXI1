package com.example.gotaxi;


import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class acc extends Activity {
EditText e1,e2;
TextView t1,t2;
Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account);

        b1=(Button)findViewById(R.id.debit);
        b2=(Button)findViewById(R.id.netbank);
        b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(acc.this,debitbanking.class);
				startActivity(i);
				
			
			}
				});
				 b2.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
					Intent i=new Intent(acc.this,netbanking.class);
					startActivity(i);
							
						
		}
        
				 });
			
        
    }}        
