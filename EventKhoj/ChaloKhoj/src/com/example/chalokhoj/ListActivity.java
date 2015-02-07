package com.example.chalokhoj;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

public class ListActivity extends Activity {

	ListView event_list;
	ListAdapterClass adapter;
	ArrayList<EventClass> eventdata=new ArrayList<EventClass>();
	ListActivity listactivity=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		ActionBar ab=getActionBar();
		ab.setTitle("List of Events");
		Intent intent=getIntent();
		String json_data=intent.getStringExtra("JSON_Data");
		event_list=(ListView)findViewById(R.id.total_list);
		Log.e("JSON DATA",json_data);
		
		
		decodeJSON(json_data);
		
		Log.e("Some Event Name",""+eventdata.get(3).getName().toString());
		Log.e("Some Event Time",""+eventdata.get(0).getEndTime().toString());
		Log.e("Some Event longitude",""+eventdata.get(4).getLongitude().toString());
		Log.e("Some Event address",""+eventdata.get(4).getAddress().toString());
		
		listactivity=this;
		Resources res=getResources();
		adapter=new ListAdapterClass(listactivity,eventdata,res);
		event_list.setAdapter(adapter);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list, menu);
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
	
	public void decodeJSON(String json)
	{
		try
		{
		JSONArray array=new JSONArray(json);
		
		for(int i=0;i<array.length();i++)
		{
			JSONObject o=array.getJSONObject(i);
			String event_id=o.getString("event_id");
			String event_name=o.getString("event_name");
			String event_latitude=o.getString("event_lattitude");
			String event_longitude=o.getString("event_longitude");
			String event_address=o.getString("event_address");
			String event_end_time=o.getString("event_end_time");
			int number_drivers=o.getInt("number_drivers");
			eventdata.add(new EventClass(event_id,event_name,event_latitude,event_longitude,event_address,event_end_time,number_drivers));
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	 public void onItemClick(int mPosition)
     {
         EventClass tempValues = (EventClass)eventdata.get(mPosition);
         Toast.makeText(ListActivity.this,"ITS WORKING!!!!",Toast.LENGTH_LONG).show();
     }
	
}
