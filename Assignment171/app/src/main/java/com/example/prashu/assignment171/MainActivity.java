package com.example.prashu.assignment171;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button startMusic;
    private Button stopMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startMusic = (Button) findViewById(R.id.playBtn);
        stopMusic = (Button) findViewById(R.id.stopBtn);
        startMusic.setOnClickListener(this);
        stopMusic.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.playBtn:
                Intent intent = new Intent(MainActivity.this, ServiceManager.class);
                startService(intent);
                break;
            case R.id.stopBtn:
                Intent stopIntent = new Intent(MainActivity.this, ServiceManager.class);
                stopService(stopIntent);
                break;

        }
    }
}