package com.rasello.reservationtest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    
  /*  public void onBtnClicked(View v){
        if(v.getId() == R.id.button1){
        	String senderNum = "+255785172408";
        	String message = "Book John Tucker*25598234564*tucker@gmail.com*XYZ Restaurant*2015-10-12 13:00*10";
			boolean check;
		    Pattern p;
		    Matcher m;

		    String MOBILE_STRING = "^[+]?[0-9]{10,13}$";

		    p = Pattern.compile(MOBILE_STRING);

		    m = p.matcher(senderNum);
		    check = m.matches();

		    if(check)
		    {
		    	senderNum = senderNum.replace("+", "");

		    	senderNum = senderNum.replace(" ", "");
        	long id = 0;
        	
			String syn = "sender="+senderNum+"&text="+message;
			Sync s = new Sync();
			Toast toast = Toast.makeText(getBaseContext(), "Process Started.", Toast.LENGTH_LONG);
			toast.show();
//			try{
			s.jpt(getBaseContext(), syn, id);
//			}catch(Exception e){
//				Log.e("MYAPP", "exception", e);
//			}
		    }else{
		    	Toast toast = Toast.makeText(getBaseContext(), "Error", Toast.LENGTH_LONG);
				toast.show();
		    }
        }
    }*/
}
