package com.jk.speedometer;

import android.location.Location;

public class LocationTracer extends Location {

	static boolean change=false;
	
	public LocationTracer(Location location )
	{
		super(location);
	}
    public float getSpeed()
    {
	    float speed=super.getSpeed();
    	return speed;
    }
}
