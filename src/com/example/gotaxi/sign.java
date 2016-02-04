package com.example.gotaxi;

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

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sign extends Activity {
	EditText e3, e4, e5, e6, e7;
	// TextView t3,t4,t5,t6,t7,t8;
	Button bu3;
	String name_value, mail_value, psd_value, cpsd_value, mob_value;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);

		e3 = (EditText) findViewById(R.id.name);
		e4 = (EditText) findViewById(R.id.mail);
		e5 = (EditText) findViewById(R.id.pd);
		e6 = (EditText) findViewById(R.id.cpsd);
		e7 = (EditText) findViewById(R.id.mobno);

		// t3=(TextView)findViewById(R.id.name);
		// t4=(TextView)findViewById(R.id.mail);
		// t5=(TextView)findViewById(R.id.psd);
		// t6=(TextView)findViewById(R.id.cpsd);
		// t7=(TextView)findViewById(R.id.mob);
		// t8=(TextView)findViewById(R.id.hint);
		bu3 = (Button) findViewById(R.id.button1);
		bu3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				name_value = e3.getText().toString();
				mail_value = e4.getText().toString();
				psd_value = e5.getText().toString();
				cpsd_value = e6.getText().toString();
				mob_value = e7.getText().toString();

				if (psd_value.equals(cpsd_value)) {
					if ("".equalsIgnoreCase(name_value)
							|| "".equalsIgnoreCase(mail_value)
							|| "".equalsIgnoreCase(psd_value)
							|| "".equalsIgnoreCase(cpsd_value)
							|| "".equalsIgnoreCase(mob_value))

					{
						Toast.makeText(sign.this, "All Fields Required.",
								Toast.LENGTH_SHORT).show();
					} 
					else {
						Toast.makeText(getApplicationContext(),
								"Registered succesfully", Toast.LENGTH_LONG);
						Intent i = new Intent(sign.this, acc.class);
						startActivity(i);

					}
				}

				else {
					Toast.makeText(getApplicationContext(),
							"Password does not match", Toast.LENGTH_LONG)
							.show();

				}

				try {
					name_value = URLEncoder.encode(name_value, "UTF-8");
					mail_value = URLEncoder.encode(mail_value, "UTF-8");
					psd_value = URLEncoder.encode(psd_value, "UTF-8");
					cpsd_value = URLEncoder.encode(cpsd_value, "UTF-8");
					mob_value = URLEncoder.encode(mob_value, "UTF-8");

					String url = "http://127.0.0.1/signup.php?&Name="
							+ name_value.trim() + "&MailId="+mail_value.trim() +"&Password="
							+ psd_value.trim() + "&confirm_password="
							+ cpsd_value.trim() + "&Mobile_number="
							+ mob_value.trim();
					System.out.println(url);
					pass_value_to_db get = new pass_value_to_db();
					get.execute(new String[] { url });

				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
	}

	public class pass_value_to_db extends AsyncTask<String, Void, String> {

		ProgressDialog dialog;

		@Override
		protected void onPreExecute() {
			dialog = new ProgressDialog(sign.this);
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

						Log.v("KG",result);

					}
				} catch (Exception ex) {
					Log.e("Error", ex.toString());
				}
			}
			return result;
		}

		protected void onPostExecute(String result) {
			Log.v("KG", "output=" + result);
			result = result.trim(); //
			// Toast.makeText(getApplicationContext(), result, //
			// Toast.LENGTH_LONG).show();
			if (result.equals("false")) {

				// *******************************************************

				Toast.makeText(getApplicationContext(), "Please try again",Toast.LENGTH_LONG).show();
			} else {
				System.out.println(result);

				Toast.makeText(getApplicationContext(), "successful",
						Toast.LENGTH_LONG).show();
			}
			if (dialog != null)
				dialog.dismiss();

		}
	}
}

