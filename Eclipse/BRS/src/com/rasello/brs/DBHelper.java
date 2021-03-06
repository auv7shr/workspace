package com.rasello.brs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class DBHelper extends SQLiteOpenHelper {

   public static final String DATABASE_NAME = "test.db";
   public static final String SMS_TABLE_NAME = "tbl_sms";
   public static final String SMS_COLUMN_ID = "id";
   public static final String SMS_COLUMN_SID = "sid";
   public static final String SMS_COLUMN_SLOT = "slot";
   public static final String SMS_COLUMN_MESSAGE = "message";
   public static final String SMS_COLUMN_DATE = "date";
   public static final String SMS_COLUMN_SYNCED = "synced";
   
   public DBHelper(Context context)
   {
      super(context, DATABASE_NAME , null, 1);
   }

   @Override
   public void onCreate(SQLiteDatabase db) {
      // TODO Auto-generated method stub
      db.execSQL(
      "create table tbl_sms " +
      "(id integer primary key, sid integer, slot integer, message text, date text, synced integer, senderNum text)"
      );
   }

   @Override
   public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      // TODO Auto-generated method stub
      db.execSQL("DROP TABLE IF EXISTS tbl_sms");
      onCreate(db);
   }

   public boolean insertSms  (Integer sid, Integer slot, String message, String date, Integer synced, String senderNum)
   {
      SQLiteDatabase db = this.getWritableDatabase();
      ContentValues contentValues = new ContentValues();

      contentValues.put("sid", sid);
      contentValues.put("slot", slot);
      contentValues.put("message", message);	
      contentValues.put("date", date);
      contentValues.put("synced", synced);
      contentValues.put("senderNum", senderNum);

      db.insert(SMS_TABLE_NAME, null, contentValues);
      return true;
   }
   public Cursor getData(int id){
      SQLiteDatabase db = this.getReadableDatabase();
      Cursor res =  db.rawQuery( "select * from tbl_sms where id="+id+"", null );
      return res;
   }
   public int numberOfRows(){
      SQLiteDatabase db = this.getReadableDatabase();
      int numRows = (int) DatabaseUtils.queryNumEntries(db, SMS_TABLE_NAME);
      return numRows;
   }
   public boolean updateSms (Integer id, Integer sid, Integer slot, String message, String date, Integer synced, String senderNum)
   {
      SQLiteDatabase db = this.getWritableDatabase();
      ContentValues contentValues = new ContentValues();
      contentValues.put("sid", sid);
      contentValues.put("slot", slot);
      contentValues.put("message", message);	
      contentValues.put("date", date);
      contentValues.put("synced", synced);
      contentValues.put("senderNum", senderNum);
      db.update("tbl_sms", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
      return true;
   }

   public Integer deleteSms (Integer id)
   {
      SQLiteDatabase db = this.getWritableDatabase();
      return db.delete("tbl_sms", 
      "id = ? ", 
      new String[] { Integer.toString(id) });
   }
   
   public Integer deleteAllSms(){
	   SQLiteDatabase db = this.getWritableDatabase();
	   return db.delete(SMS_TABLE_NAME, "1", null);
   }
   
   public String getAllSms()
   {
      SQLiteDatabase db = this.getReadableDatabase();
      Cursor res =  db.rawQuery( "select * from tbl_sms", null );
//      return res;
      String t = "";
      res.moveToFirst();
		while(res.isAfterLast() == false){
			t += "SMS = "+ res.getString(res.getColumnIndex(SMS_COLUMN_MESSAGE)) + " \n\n\n";
			res.moveToNext();
		}
		return t;
   }
}