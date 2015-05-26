package com.rasello.brs;

import android.support.v7.app.ActionBarActivity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;


public class BroadcastNewSms extends ActionBarActivity {
	
	// Cursor Adapter
		SimpleCursorAdapter adapter;
		TextView lblMsg, lblNo;
		ListView lvMsg;
    @SuppressWarnings("deprecation")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_new_sms);
     // Create Inbox box URI
//     			Uri inboxURI = Uri.parse("content://sms/inbox");
//
//     			// List required columns
//     			String[] reqCols = new String[] { "_id", "address", "body" };
//
//     			// Get Content Resolver object, which will deal with Content
//     			// Provider
//     			ContentResolver cr = getContentResolver();
//
//     			// Fetch Inbox SMS Message from Built-in Content Provider
//     			Cursor c = cr.query(inboxURI, reqCols, null, null, null);
//
//     			// Attached Cursor with adapter and display in listview
//     			adapter = new SimpleCursorAdapter(this, R.layout.row, c,
//     					new String[] { "body", "address" }, new int[] {
//     							R.id.lblMsg, R.id.lblNumber });
//     			lvMsg.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.broadcast_new_sms, menu);
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
}
