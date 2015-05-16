package com.example.aadil.training;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Session extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);
        Bundle extras = getIntent().getExtras();
        TextView user = (TextView) findViewById(R.id.user);
        if(extras!=null)
        {
            String value = extras.getString("username");
            String password = extras.getString("password");
            String id="1";
           // user.setText("Welcome " + value);
           MyDatabaseHelper databaseHelper = new MyDatabaseHelper(this);
           //databaseHelper.removeall();
           // databaseHelper.adduser(value,password);
            //ArrayList<String> text = new ArrayList<String>();
            String text[]= {"","","","","","","","","",""};
             List<String> t=databaseHelper.getData(value,password);
            String values[] = new String[] {"i","j","k"};
            ArrayList<String> list = new ArrayList<String>();
            list.addAll(Arrays.asList(values));
            if(t.isEmpty()) {
                Toast.makeText(getBaseContext(), "not Registered", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getBaseContext(),Registration.class);
               startActivity(intent);
            }
                else {
                Toast.makeText(this, MyDatabaseHelper.s, Toast.LENGTH_SHORT).show();
                //Toast.makeText(this, MyDatabaseHelper.v, Toast.LENGTH_SHORT).show();
                ListView listView = (ListView) findViewById(R.id.list2);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.listviewlayout, t);
                listView.setAdapter(adapter);
            }
            //user.setText(String.valueOf(t));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.session, menu);
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
