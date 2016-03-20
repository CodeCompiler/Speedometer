package com.jk.speedometer;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Spinner;
import java.util.*;

public class MainActivity extends Activity implements LocationListener {

	TextView txt,txt1;
	String value=null; 
	Spinner spinn;
	String arr[]={"m/s","km/h"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		txt=(TextView)findViewById(R.id.display);
		txt1=(TextView)findViewById(R.id.value);
		spinn=(Spinner)findViewById(R.id.conversion);
		ArrayAdapter<String> adapter=new ArrayAdapter<String>( this,android.R.layout.simple_dropdown_item_1line,arr);
		spinn.setAdapter(adapter);
		spinn.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				value=arr[position];
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				
				
			}
			
		});
		LocationManager manager=(LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
		manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,0,this);
	}
    private void onUpdate(LocationTracer location)
    {
    	float speed=2f;
    	String str=null;;
    	if(location!=null)
    	{
    		speed=location.getSpeed();
    	}
    	if(value.compareTo("km/h")==0)
    	{
    		speed =(float) (speed*3.6);
    		str=String.valueOf(speed);
    	    txt.setText(str);
    	    txt1.setText("km/h");
    	}
    	else
    	{
    		str=String.valueOf(speed);
    		txt.setText(str);
    		txt1.setText("m/s");
    	}
    }
    
	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		LocationTracer mylocation=new LocationTracer(location);
		this.onUpdate(mylocation);
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}
    
}
