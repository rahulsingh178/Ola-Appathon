package com.example.chalokhoj;



import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

public class LoginClass extends AsyncTask<Void, Void, String> 
{
	ProgressDialog pd;
	Context context;
	String driver_number;

	
	public LoginClass(Context c, String number)
	{
		context=c;
		driver_number=number;
		pd=new ProgressDialog(context);
	}
	
	protected void onPreExecute()
	{
		pd.setTitle("Logging in...");
		pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		pd.show();
	}
	
	@Override
	protected String doInBackground(Void... params) {
		// TODO Auto-generated method stub
		String html_response="";
		String driver_name="";
		
		try
		{
			/*String link="http://olaapp.site50.net/olaapp.php?id=" + driver_number;
			Document doc=Jsoup.connect(link).get();
			Elements name=doc.select("body");
			
			html_response=name.toString();*/
			
			String link="http://olaapp.site50.net/olaapp.php?id=" + driver_number;
			
			HttpClient client=new DefaultHttpClient();
			HttpGet httpGet=new HttpGet(link);
			
			Log.e("URL",link);
			HttpResponse response=client.execute(httpGet);
			
			HttpEntity entity=response.getEntity();
			html_response=EntityUtils.toString(entity);
			driver_name=html_response.split("<")[0];
			Log.e("Response Obtained",html_response.split("<")[0]);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return driver_name;
	}
	
	protected void onPostExecute(String x)
	{
		//go to next activity if login is correct
		//else go back to same screen and show toast
		//toast will say login incorrect.
		super.onPostExecute(x);
		pd.dismiss();
		//Toast.makeText(context,x.split("<")[0],Toast.LENGTH_LONG).show();
		Intent i=new Intent(context,MapActivity.class);
		i.putExtra("Driver_Name",x);
		context.startActivity(i);
	}

}
