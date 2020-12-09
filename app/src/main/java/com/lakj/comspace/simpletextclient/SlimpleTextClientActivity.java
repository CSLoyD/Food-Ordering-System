package com.lakj.comspace.simpletextclient;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * This is a simple Android mobile client
 * This application read any string massage typed on the text field and
 * send it to the server when the Send button is pressed
 * Author by Lak J Comspace
 */
public class SlimpleTextClientActivity extends Activity {


    /*
    private Socket client;
    private PrintWriter printwriter;
    private EditText textField;
    private Button button;
    private String messsage;
    */
    static String name;

    @Override
    public void onBackPressed() {
        // do nothing.
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slimple_text_client);}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.slimple_text_client, menu);
        return true;
    }

    public void nextact(View view) {

        EditText table = (EditText) findViewById(R.id.table_no);
        if (table.getText().toString().isEmpty()) {

            Toast.makeText(getApplicationContext(),
                    "Please enter your name", Toast.LENGTH_SHORT).show();
        } else {
            name = table.getText().toString(); // get the text message on the text field

            Intent intent = new Intent(this, Order_Type.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fadin, R.anim.fadout);
        }
    }

}


