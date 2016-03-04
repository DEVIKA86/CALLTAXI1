package in.wptrafficanalyzer.locationattouchedpositionv2;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity {	
	
	GoogleMap  googleMap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		SupportMapFragment supportMapFragment = (SupportMapFragment) 
							getSupportFragmentManager().findFragmentById(R.id.map);
		
		// Getting a reference to the map
		googleMap = supportMapFragment.getMap();
		
		// Setting a click event handler for the map 
		googleMap.setOnMapClickListener(new OnMapClickListener() {
			
			@Override
			public void onMapClick(LatLng latLng) {
				
				// Creating a marker
				MarkerOptions markerOptions = new MarkerOptions();
				
				// Setting the position for the marker
				markerOptions.position(latLng);
				
				// Setting the title for the marker. 
				// This will be displayed on taping the marker
				markerOptions.title(latLng.latitude + " : " + latLng.longitude);
				
				// Clears the previously touched position
				googleMap.clear();
				
				// Animating to the touched position                				
				googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
				
				// Placing a marker on the touched position
				googleMap.addMarker(markerOptions);
				
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}