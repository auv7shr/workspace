package com.androidexample.broadcastreceiver;

import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;
import android.database.Cursor;

public class BroadcastNewSms extends Activity {

	public static final String DATABASE_NAME = "rasello_sms_gateway.db";
	public static final String SMS_TABLE_NAME = "tbl_sms";
	public static final String SMS_COLUMN_ID = "id";
	public static final String SMS_COLUMN_Sender = "sender";
	public static final String SMS_COLUMN_MESSAGE = "message";
	public static final String SMS_COLUMN_DATE = "date";
	public static final String SMS_COLUMN_SYNCED = "synced";
	public DBHelper mydb;
	public Cursor res;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.androidexample_broadcast_newsms);
		MyHandler.attach(this);
		 data();

//		findViewById(R.id.button1).setOnClickListener(
//				new View.OnClickListener() {
//					@Override
//					public void onClick(View v) {
//						// String syn = "sender=255752003021&text=kits";
//						// Sync s = new Sync();
//						// s.jpt(getBaseContext(), syn, 16);
//
//						// Inform the user the button has been clicked
//						DBHelper mydb = new DBHelper(getBaseContext());
//						Cursor res = mydb.getAllSms();
//						res.moveToFirst();
//
//						while (!res.isAfterLast()) {
//							String syn = "";
//							syn = "sender="
//									+ res.getString(res
//											.getColumnIndex(SMS_COLUMN_Sender))
//									+ "&text="
//									+ res.getString(res
//											.getColumnIndex(SMS_COLUMN_MESSAGE));
//							Sync s = new Sync();
//							s.jpt(getBaseContext(), syn, res.getLong(res
//									.getColumnIndex(SMS_COLUMN_ID)));
//
//							res.moveToNext();
//						}
//						data();
//					}
//				});
	}

	public void data() {
		DBHelper mydb = new DBHelper(getBaseContext());
		Cursor res = mydb.getAllSms();
		String t = "";
		res.moveToFirst();
		while (res.isAfterLast() == false) {
			t += "SMS = " + res.getString(res.getColumnIndex(SMS_COLUMN_ID))
					+ "   "
					+ res.getString(res.getColumnIndex(SMS_COLUMN_MESSAGE))
					+ "   "
					+ res.getString(res.getColumnIndex(SMS_COLUMN_SYNCED))
					+ " \n";
			res.moveToNext();
		}
		TextView tv1 = (TextView) findViewById(R.id.textView1);
		tv1.setText(t);
	}
}
