package com.example.aadil.training;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public  class MyActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Button button = (Button) findViewById(R.id.button);
        final EditText username = (EditText) findViewById(R.id.uname);
        final EditText password = (EditText) findViewById(R.id.pass);
        final TextView temp = (TextView) findViewById(R.id.unametext);
        final RadioButton button1 = (RadioButton) findViewById(R.id.button1);
        final RadioButton button2 = (RadioButton) findViewById(R.id.button2);
        Button buttonr = (Button) findViewById(R.id.register);
        buttonr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(),Registration.class);
                startActivity(i);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
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
    @Override
    public void onClick(View view) {

        final RadioButton button1 = (RadioButton) findViewById(R.id.button1);
        final RadioButton button2 = (RadioButton) findViewById(R.id.button2);
        final EditText username = (EditText) findViewById(R.id.uname);
        final EditText password = (EditText) findViewById(R.id.pass);
        final TextView temp = (TextView) findViewById(R.id.unametext);
        String temper = username.getText().toString();

        /*if (temper != null && !temper.isEmpty()) {
             int data2 = Integer.parseInt(temper);


            if (button1.isChecked()) {
                data2-=32;
                data2/=9;
                data2*=5;
                temp.setText(String.valueOf(data2));
            }
            else {
                int data = data2;
                data = data2 / 5;
                data *= 9;
                data += 32;
                temp.setText(String.valueOf(data));
            }

        }*/
            //Toast.makeText(view.getContext(), "login", Toast.LENGTH_SHORT).show();
       // if(username.getText().toString().equals("aadil") && password.getText().toString().equals("h"))
        {
            Intent i = new Intent(getBaseContext(),Session.class);
           // Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.vogella.com"));
            i.putExtra("username",username.getText().toString());
            i.putExtra("password",password.getText().toString());
            startActivity(i);
        }
    }


}
