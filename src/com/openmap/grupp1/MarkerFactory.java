package com.openmap.grupp1;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;

public class MarkerFactory {

	public MarkerFactory(){
		
	}
	
	public MarkerFactory(String stringTitle, Resources res  ){}
	
	public Bitmap createPic(String stringTitle, Resources res){
		Bitmap srv = BitmapFactory.decodeResource(res, R.drawable.markerpic); 
		Bitmap src = Bitmap.createScaledBitmap(srv, srv.getWidth()/2, srv.getHeight()/2, false);
    	Bitmap dest = Bitmap.createBitmap(src.getWidth(), src.getHeight(), Bitmap.Config.ARGB_8888);
    
    	
    	if(stringTitle.length() > 7){
    		stringTitle = (String) stringTitle.subSequence(0, 5);
    		stringTitle = stringTitle + "...";
    	}
    	
    		Canvas cs = new Canvas(dest);
	        Paint tPaint = new Paint();
	        tPaint.setTextSize(30);
	        tPaint.setColor(Color.BLACK);
	        tPaint.setStyle(Style.FILL);
	        cs.drawBitmap(src, 0f, 0f, null);
	        float height = tPaint.measureText("yY");
	        float width = tPaint.measureText(stringTitle);
	        float x_coord = (src.getWidth() - width)/2;
	        cs.drawText(stringTitle, x_coord, height-2f, tPaint); 
	        return dest;}
		
	}


