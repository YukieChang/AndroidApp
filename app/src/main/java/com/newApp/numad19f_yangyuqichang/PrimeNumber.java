package com.newApp.numad19f_yangyuqichang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PrimeNumber extends AppCompatActivity {
    int count = 0;
    Thread t;
   // Handler customHandler = new Handler();
    int check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime_number);
        final TextView textView = findViewById(R.id.txtPN);
        final TextView primeText = (TextView) findViewById(R.id.txtPrime);
        t = new Thread() {
            @Override
            public void run() {

                while (t!=null) {

                    try {
                        Thread.sleep(1000);  //1000ms = 1 sec

                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                count++;
                                if(count>1&count<=3){
                                    primeText.setText("Prime Number");
                                }
                                textView.setText(String.valueOf(count));

                                int num;
                                num=(int) Math.sqrt(count);
                                for(int x=2;x<=num;x++)
                                {
                                    if(count%x==0)
                                    {
                                        primeText.setText(" ");
                                        return;
                                    }
                                    primeText.setText("Prime Number");
                                }

                            }


                        });

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };


    }

    public void btnClick(View view) throws InterruptedException {

        t.start();


    }

    public void btnStop(View view) {
        if (t != null) {
            t.interrupt();
            t = null;

        }

    }
}

