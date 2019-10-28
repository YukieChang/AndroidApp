package com.newApp.numad19f_yangyuqichang;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



public class EditData extends AppCompatActivity {

    private static final String TAG = "EditData";

    private Button btnOpen,btnDelete;
    private EditText editable_item;

    StoreDatabase mStoreDatabase;

    private String selectedName;
    private int selectedID;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);
        btnOpen = (Button) findViewById(R.id.btnOpen);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        editable_item = (EditText) findViewById(R.id.editable_item);
        mStoreDatabase = new StoreDatabase(this);

        //get the intent extra from the ListData
        Intent receivedIntent = getIntent();

        //now get the itemID we passed as an extra
        selectedID = receivedIntent.getIntExtra("id",-1); //NOTE: -1 is just the default value

        //now get the name we passed as an extra
        selectedName = receivedIntent.getStringExtra("name");

        //set the text to show the current selected name
        editable_item.setText(selectedName);

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url ="http://" + selectedName;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

                }

        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStoreDatabase.deleteName(selectedID,selectedName);
                editable_item.setText("");
                toastMessage("removed from database");
                openLinkCollector();
            }
        });

    }

    /**
     * customizable toast
     * @param message
     */
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
    public void openLinkCollector() {
        Intent intent = new Intent(this, LinkCollector.class);
        startActivity(intent);
    }
    public void showList(){
        Intent intent = new Intent(this, ListData.class);
        startActivity(intent);
    }
}
























