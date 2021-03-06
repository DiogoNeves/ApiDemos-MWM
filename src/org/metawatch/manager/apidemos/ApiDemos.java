package org.metawatch.manager.apidemos;

import org.metawatch.manager.apidemos.R;
import org.metawatch.manager.apidemos.app.App;
import org.metawatch.manager.apidemos.app.Life;
import org.metawatch.manager.apidemos.widget.Widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.preference.Preference.OnPreferenceClickListener;

public class ApiDemos extends PreferenceActivity {
	
	public static final String TAG = "MWM-ApiDemos";
	
	Context context;
	PreferenceScreen preferenceScreen;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context = this;
		
		App.announce(context);
		Life.announce(context);
		
		addPreferencesFromResource(R.layout.mainmenu);
		preferenceScreen = getPreferenceScreen();
	}
	
	@Override
	protected void onStart() {
		
		preferenceScreen.findPreference("send_text_notification").setOnPreferenceClickListener(new OnPreferenceClickListener() {	
			public boolean onPreferenceClick(Preference arg0) {
				
				Intent broadcast = new Intent("org.metawatch.manager.NOTIFICATION");
				Bundle b = new Bundle();
				b.putString("title", "Title");
				b.putString("text", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");

				// omit these if you don't want vibration!
            	b.putInt("vibrate_on", 500);
            	b.putInt("vibrate_off", 500);
            	b.putInt("vibrate_cycles", 3);

				broadcast.putExtras(b);

				context.sendBroadcast(broadcast);
		    	return true;
			}
		});
		
		preferenceScreen.findPreference("send_bitmap_notification").setOnPreferenceClickListener(new OnPreferenceClickListener() {	
			public boolean onPreferenceClick(Preference arg0) {
				
				Intent broadcast = new Intent("org.metawatch.manager.NOTIFICATION");
				Bundle b = new Bundle();

				Bitmap bitmap = Utils.loadBitmapFromAssets(context, "Mona.png");				

				b.putIntArray("array", Utils.makeSendableArray(bitmap));
				
				// omit these if you don't want vibration!
            	b.putInt("vibrate_on", 250);
            	b.putInt("vibrate_off", 500);
            	b.putInt("vibrate_cycles", 2);

				broadcast.putExtras(b);

				context.sendBroadcast(broadcast);
		    	return true;
			}
		});
		
		
		preferenceScreen.findPreference("update_widget").setOnPreferenceClickListener(new OnPreferenceClickListener() {	
			public boolean onPreferenceClick(Preference arg0) {
				Widget.update(context);
		    	return true;
			}
		});
		
		
		preferenceScreen.findPreference("app_start").setOnPreferenceClickListener(new OnPreferenceClickListener() {	
			public boolean onPreferenceClick(Preference arg0) {
				App.start(context);
		    	return true;
			}
		});
		
		preferenceScreen.findPreference("app_update").setOnPreferenceClickListener(new OnPreferenceClickListener() {	
			public boolean onPreferenceClick(Preference arg0) {
				App.update(context);
		    	return true;
			}
		});
		
		preferenceScreen.findPreference("app_stop").setOnPreferenceClickListener(new OnPreferenceClickListener() {	
			public boolean onPreferenceClick(Preference arg0) {
				App.stop(context);
		    	return true;
			}
		});
		
		preferenceScreen.findPreference("vibrate1").setOnPreferenceClickListener(new OnPreferenceClickListener() {	
			public boolean onPreferenceClick(Preference arg0) {
				
				Intent broadcast = new Intent("org.metawatch.manager.VIBRATE");
				Bundle b = new Bundle();

            	b.putInt("vibrate_on", 250);
            	b.putInt("vibrate_off", 250);
            	b.putInt("vibrate_cycles", 3);

				broadcast.putExtras(b);

				context.sendBroadcast(broadcast);
		    	return true;
			}
		});

		
		preferenceScreen.findPreference("vibrate2").setOnPreferenceClickListener(new OnPreferenceClickListener() {	
			public boolean onPreferenceClick(Preference arg0) {
				
				Intent broadcast = new Intent("org.metawatch.manager.VIBRATE");
				Bundle b = new Bundle();

            	b.putInt("vibrate_on", 1000);
            	b.putInt("vibrate_off", 1000);
            	b.putInt("vibrate_cycles", 2);

				broadcast.putExtras(b);

				context.sendBroadcast(broadcast);
		    	return true;
			}
		});
		
		preferenceScreen.findPreference("vibrate3").setOnPreferenceClickListener(new OnPreferenceClickListener() {	
			public boolean onPreferenceClick(Preference arg0) {
				
				Intent broadcast = new Intent("org.metawatch.manager.VIBRATE");
				Bundle b = new Bundle();

            	b.putInt("vibrate_on", 250);
            	b.putInt("vibrate_off", 1000);
            	b.putInt("vibrate_cycles", 6);

				broadcast.putExtras(b);

				context.sendBroadcast(broadcast);
		    	return true;
			}
		});
		
		
		super.onStart();
	}
}