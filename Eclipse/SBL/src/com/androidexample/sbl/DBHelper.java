package com.androidexample.sbl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class DBHelper extends SQLiteOpenHelper {

	public static final String DATABASE_NAME = "rasello_sms_gateway.db";
	public static final String SMS_TABLE_NAME = "tbl_sms";
	public static final String SMS_COLUMN_ID = "id";
	public static final String SMS_COLUMN_Sender = "sender";
	public static final String SMS_COLUMN_MESSAGE = "message";
	public static final String SMS_COLUMN_DATE = "date";
	public static final String SMS_COLUMN_SYNCED = "synced";

	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table tbl_sms "
				+ "(id integer primary key, sender text, message text, date text, synced integer)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS tbl_sms");
		onCreate(db);
	}

	public long insertSms(String sender, String message, String date,
			Integer synced) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues contentValues = new ContentValues();

		contentValues.put("sender", sender);
		contentValues.put("message", message);
		contentValues.put("date", date);
		contentValues.put("synced", synced);

		long id = db.insert(SMS_TABLE_NAME, null, contentValues);
		return id;
	}

	public Cursor getData(int id) {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor res = db.rawQuery("select * from tbl_sms where id=" + id + "",
				null);
		return res;
	}

	public int numberOfRows() {
		SQLiteDatabase db = this.getReadableDatabase();
		int numRows = (int) DatabaseUtils.queryNumEntries(db, SMS_TABLE_NAME);
		return numRows;
	}

	public boolean updateSms(long id, String sender, String message,
			String date, Integer synced) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put("sender", sender);
		contentValues.put("message", message);
		contentValues.put("date", date);
		contentValues.put("synced", synced);
		db.update("tbl_sms", contentValues, "id = ? ",
				new String[] { Long.toString(id) });
		return true;
	}

	public boolean updateSuccess(long id, Integer synced) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put("synced", synced);
		db.update("tbl_sms", contentValues, "id = ? ",
				new String[] { Long.toString(id) });
		return true;
	}

	public Integer deleteSms(long id) {
		SQLiteDatabase db = this.getWritableDatabase();
		return db.delete("tbl_sms", "id = ? ",
				new String[] { Long.toString(id) });
	}

	public Integer deleteAllSms() {
		SQLiteDatabase db = this.getWritableDatabase();
		return db.delete(SMS_TABLE_NAME, "1", null);
	}

	public Cursor getAllSms() {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor res = db.rawQuery("select * from tbl_sms where synced = 0", null);
		return res;
//		String t = "";
//		res.moveToFirst();
//		while (res.isAfterLast() == false) {
//			t += "SMS = " + res.getString(res.getColumnIndex(SMS_COLUMN_ID))
//					+ "   " + res.getString(res.getColumnIndex(SMS_COLUMN_MESSAGE))
//					+ "   " + res.getString(res.getColumnIndex(SMS_COLUMN_SYNCED))
//					+ " \n\n\n";
//			res.moveToNext();
//		}
//		return t;
	}
}