package com.example.taxi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class sgn extends Activity {
	Button b1;
	TextView t1,t2,t3,t4;
	EditText e1,e2,e3,e4;
protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sgn);


		e2=(EditText)findViewById(R.id.email);
		e3=(EditText)findViewById(R.id.epsd);
		e4=(EditText)findViewById(R.id.ecpsd);
		t1=(TextView)findViewById(R.id.textView1);
		t2=(TextView)findViewById(R.id.textView2);
		t3=(TextView)findViewById(R.id.textView3);
		t4=(TextView)findViewById(R.id.textView4);
		b1=(Button)findViewById(R.id.button1);
		 b1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stu3
					//Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
						Intent n=new Intent(sgn.this,book1.class);
						startActivity(n);
						
					
					}
		
		 });}
}
		
		


