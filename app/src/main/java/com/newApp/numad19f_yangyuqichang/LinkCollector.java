package com.newApp.numad19f_yangyuqichang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

    }
}
