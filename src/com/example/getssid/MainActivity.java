package com.example.getssid;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	Button btn;
	TextView txt;
	 static String ssid=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn=(Button)findViewById(R.id.btn);
		txt=(TextView)findViewById(R.id.txt);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				getCurrentSsid(getBaseContext());
				txt.setText(ssid);
				
			}
		});
	}


	public static  String  getCurrentSsid(Context context) {
		
		// TODO Auto-generated method stub
				
		ConnectivityManager connManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo=connManager.getNetworkInfo(connManager.TYPE_WIFI);
		
		if(networkInfo.isConnected())
		{
			final WifiManager wifiManager=(WifiManager)context.getSystemService(Context.WIFI_SERVICE);
			final WifiInfo wifiInfo=wifiManager.getConnectionInfo();
			
			if(wifiInfo!=null && !StringUtil.isBlank(wifiInfo.getSSID()))
			{
				
			ssid=wifiInfo.getSSID();	
			}
			
			
		}
		
		return ssid;
		
	}

	

}
