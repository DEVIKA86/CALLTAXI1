package com.example.taxi;



import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class my extends TabActivity {

	 Button b1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my);
        TabHost tb_host=getTabHost();
        TabSpec Upcoming=tb_host.newTabSpec("Upcoming Journey");
        Upcoming.setIndicator("Upcoming Journey", getResources().getDrawable(R.drawable.abc_ab_bottom_transparent_dark_holo));
        Intent i= new Intent(my.this,my1.class);
        Upcoming.setContent(i);
        startActivity(i);
        TabSpec past = tb_host.newTabSpec("Past Journey");        
        past.setIndicator("Past Journey",getResources().getDrawable(R.drawable.abc_ab_bottom_solid_dark_holo));
        Intent i1 = new Intent(my.this, my2.class);
        past.setContent(i1);
        startActivity(i1);
        TabSpec cancel = tb_host.newTabSpec("Cancelled Journey");
        cancel.setIndicator("Cancelled Journey", getResources().getDrawable(R.drawable.abc_ab_solid_light_holo));
        Intent i2 = new Intent(my.this, my3.class);
        cancel.setContent(i2);
        startActivity(i2);
        tb_host.addTab(Upcoming);
        tb_host.addTab(past);
        tb_host.addTab(cancel);
        
        
        
        
}
}