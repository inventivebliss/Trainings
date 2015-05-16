package com.example.aadil.training;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aadil on 3/5/15.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static String s,v;

    int ctr=0;
    private static final String DATABASE_NAME="UserLogin";

    public MyDatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    @Override

    public void onCreate(SQLiteDatabase database) {

        database.execSQL("CREATE TABLE user ( id INT PRIMARY KEY,username TEXT, password TEXT);");


    }
    public void removeall() {
        SQLiteDatabase db = this.getWritableDatabase();
        //db.delete("user",null,null);
       // db.execSQL("drop table if exists" + "user");
        //db.execSQL("CREATE TABLE user ( id INT PRIMARY KEY,username TEXT, password TEXT);");
    }

    public List<String> getData(String userid,String password) {

            List<String> list = new ArrayList<String>();
            String Table_Name="user";
            int ctr=0;
        String d=" ";
            String selectQuery = "SELECT username,password FROM  " + Table_Name + " where username=? and password=?" ;
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery(selectQuery,new String[]{userid,password});
            String [] data={"","","","","","","","","",""};
         //ArrayList<String> list= new ArrayList<String>();
        cursor.moveToFirst();
     //  if (cursor != null)
       //     cursor.moveToFirst();
            //data[1]=cursor.getString(cursor.getColumnIndex("username"));
            //data[0]=cursor.getString(cursor.getColumnIndex("username"));
            //cursor.moveToNext();
            //s=cursor.getString(cursor.getColumnIndex("password"));
       while(!cursor.isAfterLast()) {
            s = cursor.getString(cursor.getColumnIndex("username"));
            //d.concat(s);
           v = cursor.getString(cursor.getColumnIndex("password"));
              //  d.concat(v);
           list.add(s);
           list.add(v);
                //data[ctr++]=s;
                //data[ctr++]=v;
            cursor.moveToNext();
        }
          //  db.close();
        cursor.close();
            return list;


    }
    @Override

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS user");

        onCreate(db);

    }
    public void adduser(String username,String password)

    {

        ContentValues values=new ContentValues(2);
        values.put("username", username);

        values.put("password", password);

        getWritableDatabase().insert("user", "name", values);

        //getWritableDatabase().insert("", "name", values);

    }

}
