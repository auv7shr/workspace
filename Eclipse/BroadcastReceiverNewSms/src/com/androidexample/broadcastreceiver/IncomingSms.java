package com.androidexample.broadcastreceiver;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.text.format.DateFormat;
import android.util.Log;


public class IncomingSms extends BroadcastReceiver {
	
	// Get the object of SmsManager
	final SmsManager sms = SmsManager.getDefault();
	
	public void onReceive(Context context, Intent intent) {
	
		// Retrieves a map of extended data from the intent.
		final Bundle bundle = intent.getExtras();

		try {
			
			if (bundle != null) {
				
				final Object[] pdusObj = (Object[]) bundle.get("pdus");
				
				for (int i = 0; i < pdusObj.length; i++) {
					
					SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
					String phoneNumber = currentMessage.getDisplayOriginatingAddress();
					
			        String senderNum = phoneNumber;
			        String message = currentMessage.getDisplayMessageBody();
			        Long mill = currentMessage.getTimestampMillis();
			        
			        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String currentDateandTime = sdf.format(new Date()); 
					
					String dateString = convertDate(mill,"hh:mm:ss");
					
					String date = currentDateandTime+" "+dateString;
					DBHelper mydb = new DBHelper(context);
					
					boolean check;
				    Pattern p;
				    Matcher m;

				    String MOBILE_STRING = "^[+]?[0-9]{10,13}$";

				    p = Pattern.compile(MOBILE_STRING);

				    m = p.matcher(senderNum);
				    check = m.matches();

				    if(check)
				    {
				    long id = mydb.insertSms(senderNum, message, date, 0);
					String syn = "sender="+senderNum+"&text="+message;
					Sync s = new Sync();
					s.jpt(context, syn, id);
				    }
				} // end for loop
              } // bundle is null

		} catch (Exception e) {
			Log.e("SmsReceiver", "Exception smsReceiver" +e);
			
		}
		
	}
	
	public static String convertDate(Long mill,String dateFormat) {
	    return DateFormat.format(dateFormat, mill).toString();
	}

	
	
}