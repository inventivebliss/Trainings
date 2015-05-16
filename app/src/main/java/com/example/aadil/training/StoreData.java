package com.example.aadil.training;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class StoreData extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_data);
        Bundle extras = getIntent().getExtras();
        if(extras!=null)
        {
            String user = extras.getString("username");
            String pass = extras.getString("password");
            MyDatabaseHelper db = new MyDatabaseHelper(this);
            db.adduser(user,pass);
            Toast.makeText(this,"user successfully registered",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this,MyActivity.class);
            startActivity(i);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.store_data, menu);
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
