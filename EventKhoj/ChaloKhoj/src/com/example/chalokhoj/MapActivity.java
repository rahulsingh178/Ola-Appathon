package com.example.chalokhoj;

import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback{

	Context context;
	Button search;
	TextView welcome;
	public View v;
	GoogleMap map;
	double latitude,longitude;
	Location location;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		Intent intent=getIntent();
		String driver_name=intent.getStringExtra("Driver_Name");
		welcome=(TextView)findViewById(R.id.welcome_message);
		search=(Button)findViewById(R.id.search_events);
		welcome.setText("Welcome Mr. " + driver_name);
		
		MapFragment mapFragment=(MapFragment)getFragmentManager().findFragmentById(R.id.map);
		mapFragment.getMapAsync(this);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void searchEvents(View v)
	{
		try
		{
		new ListParser(MapActivity.this).execute();
		}
		catch(Exception e)
		{
			
		}
	}
	
	@Override
	public void onMapReady(GoogleMap map) {
		// TODO Auto-generated method stub	
		LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();

        Location location = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
        if (location != null)
        {
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 13));

            CameraPosition cameraPosition = new CameraPosition.Builder()
            .target(new LatLng(location.getLatitude(), location.getLongitude()))      // Sets the center of the map to location user
            .zoom(17)                   // Sets the zoom
            .bearing(90)                // Sets the orientation of the camera to east
            .tilt(40)                   // Sets the tilt of the camera to 30 degrees
            .build();                   // Creates a CameraPosition from the builder
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        
        LatLng current=new LatLng(location.getLatitude(),location.getLongitude());
        map.addMarker(new MarkerOptions().title("Current Location").snippet("Bah").position(current));
        }
		
	}

	
	

}
