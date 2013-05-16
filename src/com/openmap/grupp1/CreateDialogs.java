package com.openmap.grupp1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class CreateDialogs extends Activity {
	
	private EditText txtTitle;
	private EditText txtDescription;
	private LatLng point;
	private Resources res;
	private GoogleMap myMap;
	public CreateDialogs(){
	
	
	}

	//Undersök varför det måste vara final här + styr upp denna koden 
	public void insertInfo(Context context,final LatLng point,final Resources res, final GoogleMap myMap){
			final String TAG = "MyActivity";
			
			LayoutInflater li = LayoutInflater.from(context);
			View popupView = li.inflate(R.layout.dialog1, null);
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
			
			
			
			// set prompts.xml to alertdialog builder
			alertDialogBuilder.setView(popupView);
			
			//the two strings
			txtTitle = (EditText) popupView.findViewById(R.id.txtTitle);
			//txtDescription = (EditText) popupView.findViewById(R.id.txtDescription);
			Log.d(TEXT_SERVICES_MANAGER_SERVICE, "Hej4");
		/*	ImageButton B = (ImageButton) popupView.findViewById(R.id.imageButton1);
			Log.d(TEXT_SERVICES_MANAGER_SERVICE, "Hej2");
			
			});*/
				
			Log.d(TEXT_SERVICES_MANAGER_SERVICE, "Hej3");
			
			this.point = point;
			this.res = res;
			this.myMap = myMap;
			
		
			// set dialog message
			alertDialogBuilder
			.setCancelable(false)
			.setPositiveButton("OK",
			new DialogInterface.OnClickListener() {
						
					  public void onClick(DialogInterface dialog,int id) {
					    	String stringTitle = txtTitle.getText().toString();
					    	
					    	
					  
					    	MarkerFactory markerFactory = new MarkerFactory();
					    	Bitmap scr = markerFactory.createPic(stringTitle, res);
					    	
					    	Marker m = myMap.addMarker(new MarkerOptions()
		                    .position(point)
		                    .icon(BitmapDescriptorFactory.fromBitmap(scr)));
					    	m.isVisible();}  })
					
					    	
					.setNegativeButton("Cancel",
					  new DialogInterface.OnClickListener() {
					    public void onClick(DialogInterface dialog,int id) {
						dialog.cancel();
						// marker.remove();
					    }
					  });
			
				// create alert dialog
				AlertDialog alertDialog = alertDialogBuilder.create();
				//cancelable(enable backkey)
				
				alertDialog.setCancelable(true);
				// show it
				Log.d(TAG, "hej6");
				
				alertDialog.show();
				Log.d(TAG, "hej8");
			 // marker = myMap.addMarker(new MarkerOptions().position(point).title(point.toString()));
		
	}
}
