package com.example.paymentmode;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;


import android.support.v7.app.ActionBarActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class debit extends ActionBarActivity {
	EditText name_box,pass_box;
	Button log_btn;
	String pwd_value,email_value;
	EditText cdno1,exp1,cvv1;
    String card_value,cvv2_value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.debit1);
        cdno1 = (EditText)findViewById(R.id.cno);
        exp1 = (EditText)findViewById(R.id.exp);
        cvv1 = (EditText)findViewById(R.id.cvv);
        log_btn = (Button)findViewById(R.id.button1);
       if( cdno1.getText().toString().length() == 0 )
           cdno1.setError( "card number is required!" );
       if( exp1.getText().toString().length() == 0 )
           exp1.setError( "Expirydate is required!" );
       if( cvv1.getText().toString().length() == 0 )
           cvv1.setError( "cvv is required!" );
     
         log_btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				card_value=cdno1.getText().toString();	
			    cvv2_value = cvv1.getText().toString();
				try {
					
					card_value = URLEncoder.encode(card_value, "UTF-8");
					cvv2_value = URLEncoder.encode(cvv2_value, "UTF-8");
				
					
					
					String url = "http://localhost/x/banks.php?Accno1="+ card_value.trim() + "&Cvv1="+ cvv2_value.trim() ;
					System.out.println(url);
					pass_value_to_db get = new pass_value_to_db();
					get.execute(new String[] { url });

				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
// i = new Intent(MainActivity.this,list.class);
//startActivity(i);
			}
		});

	}

	public class pass_value_to_db extends AsyncTask<String, Void, String> {

		ProgressDialog dialog;

		@Override
		protected void onPreExecute() { // TODO Auto-generated method stub
			dialog = new ProgressDialog(debit.this);
			dialog.setTitle("Processing...");
			dialog.setMessage("Please wait.");
			dialog.setCancelable(false);
			dialog.show();
		}

		@Override
		protected String doInBackground(String... urls) {
			String result = "";
			for (String url : urls) {
				InputStream is = null;
				try {

					HttpClient httpclient = new DefaultHttpClient();
					HttpPost httppost = new HttpPost(url);
					HttpResponse response = httpclient.execute(httppost);
					int status = response.getStatusLine().getStatusCode();
					Log.d("KG", "status=" + status);

					if (status == 200) {
						HttpEntity entity = response.getEntity();
						is = entity.getContent();
						BufferedReader reader = new BufferedReader(
								new InputStreamReader(is, "iso-8859-1"), 8);
						String line = "";
						while ((line = reader.readLine()) != null) {
							result += line;
						}
						is.close();

						Log.v("KG", result);

					}
				} catch (Exception ex) {
					Log.e("Error", ex.toString());
				}
				
				//Toast.makeText(getApplicationContext(),"Registered successfully", Toast.LENGTH_LONG).show();
				//Intent i=new Intent(SubActivity.this,MainActivity.class);
				//startActivity(i);
			}
			return result;
		}

		protected void onPostExecute(String result) {
			Log.v("KG", "output=" + result);
			result = result.trim(); //
			// Toast.makeText(getApplicationContext(), result, //
			// Toast.LENGTH_LONG).show();
			if (result.equals("false")) {

				
				Toast.makeText(getApplicationContext()," Please try again later...", Toast.LENGTH_LONG).show();
				
			} else {
				

			Toast.makeText(getApplicationContext(),"Login Sucessful", Toast.LENGTH_LONG).show();
			Intent i=new Intent(debit.this,debitnext.class);
			startActivity(i);
			}

			if (dialog != null)
				dialog.dismiss();

		}

		private Context getApplicationContext() {
			// TODO Auto-generated method stub
			return null;
		}
	}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.main, menu);
	return true;
}


	
}
	
