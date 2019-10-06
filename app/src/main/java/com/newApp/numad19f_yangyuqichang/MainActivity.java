package com.newApp.numad19f_yangyuqichang;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.PowerManager;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        BroadcastReceiver receiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                int plugged = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
                if (plugged == BatteryManager.BATTERY_PLUGGED_AC) {
                    // on AC power

                    Toast.makeText(getBaseContext(), "POWER!!!", Toast.LENGTH_LONG).show();
                } else if (plugged == BatteryManager.BATTERY_PLUGGED_USB) {

                    Toast.makeText(getBaseContext(), "POWER!!!", Toast.LENGTH_LONG).show();
                } else if (plugged == 0) {

                    Toast.makeText(getBaseContext(), "POWER!!!", Toast.LENGTH_LONG).show();
                } else {

                    Toast.makeText(getBaseContext(), "not charging", Toast.LENGTH_LONG).show();                }
            }
        };
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(receiver, filter);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);





        button = (Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          openLink();
                                      }
                                  });

        button = (Button)findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openPrimeNumber();


            }

        });

        button = (Button)findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openTimer();


            }

    });}
    public void openPrimeNumber() {
        Intent intent = new Intent(this, PrimeNumber.class);
        startActivity(intent);
    }


    public void openTimer() {
        Intent intent = new Intent(this, Timer.class);
        startActivity(intent);
    }

    public void openLink() {
        Intent intent = new Intent(this, Link.class);
        startActivity(intent);
    };




    public void buttonOnClick(View v) {
        Button button=(Button) v;
        ((Button) v).setText("Yangyuqi chang\n changyyq@gmail.com");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
