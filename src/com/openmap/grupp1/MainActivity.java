package com.openmap.grupp1;

import java.io.File;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;
import android.widget.SearchView.OnQueryTextListener;

public class MainActivity extends Activity implements OnQueryTextListener
 {

 private MyMap myMap; 

 @Override
 protected void onCreate(Bundle savedInstanceState) {
 
	 //create lite osäkert men alltid här
  super.onCreate(savedInstanceState);
  //The Action Bar replaces the title bar and provides an alternate location for an on-screen menu button on some devices. 
  getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
  
  //Creating content view
  setContentView(R.layout.activity_main);
  
  
  myMap = new MyMap(getFragmentManager(), getSystemService(Context.LOCATION_SERVICE),this,getResources());
  
  
  
 }

//actionbar
 @Override
 public boolean onCreateOptionsMenu(Menu menu) {
     super.onCreateOptionsMenu(menu);
     return true;
 }

 
 @Override
 protected void onResume() {
  // TODO Auto-generated method stub
  super.onResume(); }

@Override
public boolean onQueryTextChange(String arg0) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean onQueryTextSubmit(String arg0) {
	// TODO Auto-generated method stub
	return false;
}

 
 	
}

