package com.example.wxm.myapplication;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Chronometer;

public class counttime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counttime);

        final Chronometer ch = (Chronometer) findViewById(R.id.chronometer1);
        ch.setBase(SystemClock.elapsedRealtime());
        ch.setFormat("已用时间：%s");
        ch.start();

        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if (SystemClock.elapsedRealtime() - ch.getBase() >=100000)
                    ch.stop();
            }
        });

    }

}
