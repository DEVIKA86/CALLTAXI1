package com.example.gotaxi;

import java.util.ArrayList;
import java.util.List; 

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
 
public class debitbanking extends Activity implements OnItemSelectedListener
{
   
   EditText e1,e2,e3;
   Button bu1;
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.debit);
      
      // Spinner element
      Spinner spinner = (Spinner) findViewById(R.id.spinner1);
      e1=(EditText) findViewById(R.id.cardno);
      e2=(EditText) findViewById(R.id.cvv);
      e3=(EditText) findViewById(R.id.exp);
      // Spinner click listener
      spinner.setOnItemSelectedListener(this);
      
      // Spinner Drop down elements
      List<String> categories = new ArrayList<String>();
      categories.add("State bank of India");
      categories.add("Karur Vysa bank");
      categories.add("Citi bank");
      categories.add("Central bank oF India");
      
     
      
      // Creating adapter for spinner
      ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
      
      // Drop down layout style - list view with radio button
      dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      
      // attaching data adapter to spinner
      spinner.setAdapter(dataAdapter);
   }
   
   @Override
   public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      // On selecting a spinner item
      String item = parent.getItemAtPosition(position).toString();
      
      // Showing selected spinner item
      Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
   }
   public void onNothingSelected(AdapterView<?> arg0) {
      // TODO Auto-generated method stub
   }
}
