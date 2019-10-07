package com.newApp.numad19f_yangyuqichang;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.backup.FullBackupDataOutput;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextClock;
import android.os.PowerManager.WakeLock;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Timer extends AppCompatActivity implements View.OnClickListener {
    private PendingIntent alarmIntent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);


        // attach the listener to both buttons
        findViewById(R.id.start).setOnClickListener(this);
        findViewById(R.id.stop).setOnClickListener(this);

        // create the launch sender
        Intent launchIntent = new Intent(this, AlarmService.class);
        alarmIntent = PendingIntent.getService(this, 0, launchIntent, 0);
    }

    @Override
    public void onClick(View v) {
        AlarmManager manager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        long interval = 60 * 1000; // 1 minute

        switch(v.getId()) {
            case R.id.start:
                Toast.makeText(this, "Scheduled", Toast.LENGTH_SHORT).show();

                Calendar c = Calendar.getInstance();
                c.add(Calendar.SECOND, 10);
                long afterTenSeconds = c.getTimeInMillis();

                manager.setRepeating(AlarmManager.RTC_WAKEUP, afterTenSeconds, interval, alarmIntent);
                break;

            case R.id.stop:
                Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show();
                manager.cancel(alarmIntent);
                break;
            default:
                break;
        }
    }
}
