package com.androidexample.reservation;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class Sync {
	// URL to get JSON Array
	
	// ssra
	private static String baseurl = "http://www.rasello.com/reservation?";
//	private static String baseurl = "http://bi.rasello.com/cs3/api/ssra_sms_unsubscribe?";
	private static String url = "";

	public long id;

	public void jpt(Context mContext, String urltext, long ida) {
		id = ida;
		url = baseurl + urltext;
		try {
			JSONParse js = new JSONParse(mContext);
			js.execute(new String[] { url });
			CharSequence text = "Sent!!!";
			int duration = Toast.LENGTH_LONG;

			Toast toast = Toast.makeText(mContext, url, duration);
			toast.show();
		} catch (Exception $e) {

		}
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

			JSONParser jParser = new JSONParser();
			// Getting JSON from URL
			JSONObject json = jParser.getJSONFromUrl(url);
			Log.e("URL", url);
			return json;

		}

		@Override
		protected void onPostExecute(JSONObject json) {
			try {
				String dataVersion = json.getString("success");
				Log.e("Success", dataVersion);
//				DBHelper mydb = new DBHelper(mContext);
//				mydb.updateSuccess(id, Integer.parseInt(dataVersion.toString()));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				Log.e("JPT", "FAILURE");
			}
		}
	}
}
