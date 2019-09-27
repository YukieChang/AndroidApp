package com.newApp.numad19f_yangyuqichang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.util.Linkify;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class LinkCollector extends AppCompatActivity {
    Button Insert;
    ArrayList<String> addArray = new ArrayList<String>();
    EditText text;
    ListView List;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_collector);
        text = (EditText)findViewById(R.id.txtInput);
        List = (ListView)findViewById(R.id.txtList);
        Insert = (Button)findViewById(R.id.btnInsert);
        Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = text.getText().toString();

                 if (getInput == null || getInput.trim().equals("")){
                    Toast.makeText(getBaseContext(), "The link is empty.", Toast.LENGTH_LONG).show();
                }

                else{
                     Toast.makeText(getBaseContext(), "The link has been added to the list.", Toast.LENGTH_LONG).show();
                     addArray.add(getInput);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(LinkCollector.this,android.R.layout.simple_list_item_1, addArray);
                    List.setAdapter(adapter);
                    ((EditText) findViewById(R.id.txtInput)).setText(" ");

                 }
            }
        });

    }
}

