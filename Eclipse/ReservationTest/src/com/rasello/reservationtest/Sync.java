package com.rasello.reservationtest;

import org.json.JSONObject;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class Sync {
	// URL to get JSON Array
	
	// reservation system
	private static String baseurl = "https://rasello.com/reservation?";
	private static String url = "";

	public long id;

	public void jpt(Context mContext, String urltext, long ida) {

		id = ida;
		url = baseurl + urltext;
//		try {
			JSONParse js = new JSONParse(mContext);
			js.execute(new String[] { url });
			CharSequence text = "Sent!!!";
			int duration = Toast.LENGTH_LONG;

			Toast toast = Toast.makeText(mContext, url, duration);
			toast.show();
//		} catch (Exception e) {
//			Log.e("MYAPP", "exception", e);
//			CharSequence text = "Operation Failed.";
//			int duration = Toast.LENGTH_LONG;
//			Toast toast = Toast.makeText(mContext, text, duration);
//			toast.show();
//		}
	}

	private class JSONParse extends AsyncTask<String, String, JSONObject> {
		private Context mContext;

		public JSONParse(Context context) {
			mContext = context;
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected JSONObject doInBackground(String... args) {
			JSONObject json = null;
			try {
			JSONParser jParser = new JSONParser();
			// Getting JSON from URL
			 json = jParser.getJSONFromUrl(url);
			} catch (Exception e) {
			    e.printStackTrace();
			     String jsona = e.getMessage();
					Toast toast = Toast.makeText(mContext, jsona, Toast.LENGTH_LONG);
					toast.show();
			     
			   }
			Log.e("URL", url);
			return json;

		}

		@Override
		protected void onPostExecute(JSONObject json) {
		super.onPostExecute(json);
			Toast toast = Toast.makeText(mContext, "Done", Toast.LENGTH_LONG);
			toast.show();
		}
	}
}
