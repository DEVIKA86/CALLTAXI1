package com.example.calltaxi;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Admin extends Activity {
Button btn_manager,btn_executive,btn_cate;
View promptsView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin);
		btn_manager=(Button)findViewById(R.id.btn_manager);
		btn_executive=(Button)findViewById(R.id.btn_executive);
		btn_cate=(Button)findViewById(R.id.btn_cate);
		btn_manager.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AddLifestyle();
			}
		});
		btn_executive.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				addmanager();
			}
		});
		btn_cate.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				addtaxi();
			}
		});
	}
	public void AddLifestyle() {
		//Log.e("Products", products);
		
		
		LayoutInflater li = LayoutInflater.from(Admin.this);
		promptsView = li.inflate(R.layout.addsource, null);

		final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				Admin.this);

		alertDialogBuilder.setView(promptsView);
		final EditText name=(EditText)promptsView.findViewById(R.id.txt_user);
		final EditText pass=(EditText)promptsView.findViewById(R.id.txt_pass);

		final Button  activityokdialog=(Button)promptsView.findViewById(R.id.activityokdialog);
		final Button activitycanceldialog=(Button)promptsView.findViewById(R.id.activitycanceldialog);
		final AlertDialog myalertDialog = alertDialogBuilder.create();
		
		
		// show it
		myalertDialog.show();
		myalertDialog.setCancelable(false);
		myalertDialog.setCanceledOnTouchOutside(false);
		
		
		activityokdialog.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

				StrictMode.setThreadPolicy(policy); 
				if((name.getText().toString().equals("admin")&&pass.getText().toString().equals("admin")))
				{
					
					
				
					
						
						myalertDialog.dismiss();
						}
						
			    			
					else{
						Toast.makeText(getApplicationContext(),"Please Enter All Values",Toast.LENGTH_SHORT).show();
					}	
		
		}
		});
		activitycanceldialog.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				myalertDialog.dismiss();
			}
		});

		
	}
public void addmanager(){
		
		LayoutInflater li = LayoutInflater.from(Admin.this);
		promptsView = li.inflate(R.layout.driverdetails, null);

		final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				Admin.this);

		alertDialogBuilder.setView(promptsView);
		
		final EditText city,location,exper,phone,mail,about,rate,maile;
		final Button bu1,activityokdialog,activitycanceldialog;
		final	RadioButton amaleradio=(RadioButton)promptsView.findViewById(R.id.radioMale);
		final RadioButton aFemale=(RadioButton)promptsView.findViewById(R.id.radioFemale);
		final RadioGroup myRadio_group= (RadioGroup) promptsView.findViewById(R.id.radioSex);
		  city=(EditText)promptsView.findViewById(R.id.txt_city1);
		  location=(EditText)promptsView.findViewById(R.id.txt_location);
		  exper=(EditText)promptsView.findViewById(R.id.txt_experience);
		  phone=(EditText)promptsView.findViewById(R.id.txt_phoneno);
		
		
		   activityokdialog=(Button)promptsView.findViewById(R.id.activityokdialog);
		  activitycanceldialog=(Button)promptsView.findViewById(R.id.activitycanceldialog);
			final AlertDialog myalertDialog = alertDialogBuilder.create();
		  myalertDialog.show();
			myalertDialog.setCancelable(false);
			myalertDialog.setCanceledOnTouchOutside(false);
			
		activityokdialog.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 
				  String citys=city.getText().toString();
				  String locations=location.getText().toString();
				  String expers=exper.getText().toString();
				  String phones=phone.getText().toString();
				
				 
				 StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

					StrictMode.setThreadPolicy(policy); 
				if((citys.length()!=0)&&(locations.length()!=0)&&(expers.length()!=0)&&(phones.length()!=0)){
					
			
				
				Toast.makeText(getApplicationContext(), "Insert successfully",Toast.LENGTH_SHORT).show();
				
				myalertDialog.dismiss();
					}else{
						Toast.makeText(getApplicationContext(),"Please Enter All Values",Toast.LENGTH_SHORT).show();
					}		
			}
		});
		activitycanceldialog.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				myalertDialog.dismiss();
			}
		});
	}
public void addtaxi(){
	
	LayoutInflater li = LayoutInflater.from(Admin.this);
	promptsView = li.inflate(R.layout.taxireg, null);

	final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
			Admin.this);

	alertDialogBuilder.setView(promptsView);
	
	final EditText city,location,exper,phone,mail,about,rate,maile;
	final Button bu1,activityokdialog,activitycanceldialog;
	
	  city=(EditText)promptsView.findViewById(R.id.txt_city1);
	  location=(EditText)promptsView.findViewById(R.id.txt_location);
	  exper=(EditText)promptsView.findViewById(R.id.txt_experience);
	  phone=(EditText)promptsView.findViewById(R.id.txt_phoneno);
	
	
	   activityokdialog=(Button)promptsView.findViewById(R.id.activityokdialog);
	  activitycanceldialog=(Button)promptsView.findViewById(R.id.activitycanceldialog);
		final AlertDialog myalertDialog = alertDialogBuilder.create();
	  myalertDialog.show();
		myalertDialog.setCancelable(false);
		myalertDialog.setCanceledOnTouchOutside(false);
		
	activityokdialog.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			 
			  String citys=city.getText().toString();
			  String locations=location.getText().toString();
			  String expers=exper.getText().toString();
			  String phones=phone.getText().toString();
			
			 
			 StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

				StrictMode.setThreadPolicy(policy); 
			if((citys.length()!=0)&&(locations.length()!=0)&&(expers.length()!=0)&&(phones.length()!=0)){
				
		
			
			Toast.makeText(getApplicationContext(), "Insert successfully",Toast.LENGTH_SHORT).show();
			
			myalertDialog.dismiss();
				}else{
					Toast.makeText(getApplicationContext(),"Please Enter All Values",Toast.LENGTH_SHORT).show();
				}		
		}
	});
	activitycanceldialog.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			myalertDialog.dismiss();
		}
	});
}
}
