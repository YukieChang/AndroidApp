package com.newApp.numad19f_yangyuqichang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Link extends AppCompatActivity {
    Button Insert;
    ArrayList<String> addArray = new ArrayList<String>();
    EditText text1;
    EditText text2;
    ListView List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link);

        text1 = (EditText) findViewById(R.id.txtInsertName);
        text2 = (EditText) findViewById(R.id.txtInput);
        List = (ListView) findViewById(R.id.txtList);
        Insert = (Button) findViewById(R.id.btnInsert);


        Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String getInput1 = text1.getText().toString();
                final String getInput2 = text2.getText().toString();


                if (getInput1 == null || getInput1.trim().equals("")) {
                    Toast.makeText(getBaseContext(), "The link is empty.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getBaseContext(), "The link has been added to the list.", Toast.LENGTH_LONG).show();
                   // ArrayList<String> arrayList = new ArrayList<>();

                    addArray.add(getInput1 + " " + getInput2);
                    String update = getInput2;
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(Link.this, android.R.layout.simple_list_item_1, addArray);
                    List.setAdapter(adapter);
                    ((EditText) findViewById(R.id.txtInsertName)).setText("");
                    ((EditText) findViewById(R.id.txtInput)).setText("");

                }

                List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
                        String url ="http://" + getInput2;
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);

                    }


                });

            }
        });
    }
}