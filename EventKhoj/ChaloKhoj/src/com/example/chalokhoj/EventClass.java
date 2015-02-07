package com.example.chalokhoj;

public class EventClass {
	
	String id,name,latitude,longitude,address,end_time;
	int number_drivers;
	public EventClass(String id,String name,String latitude,String longitude,String address,String end_time,int number_drivers)
	{
		this.id=id;
		this.name=name;
		this.latitude=latitude;
		this.longitude=longitude;
		this.address=address;
		this.end_time=end_time;
		this.number_drivers=number_drivers;
	}
	
	public String getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}

	public String getLatitude()
	{
		return latitude;
	}

	public String getLongitude()
	{
		return longitude;
	}

	public String getAddress()
	{
		return address;
	}

	public String getEndTime()
	{
		return end_time;
	}

	public int getNumberDrivers()
	{
		return number_drivers;
	}


}
