package com.example.soai_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

import java.util.Timer;
import java.util.TimerTask;

public class InitialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);

        RelativeLayout parent  = (RelativeLayout) findViewById(R.id.gradient_layout);

        AnimationDrawable gradientAnimator = (AnimationDrawable) parent.getBackground();
        gradientAnimator.setEnterFadeDuration(500);
        gradientAnimator.setExitFadeDuration(500);
        gradientAnimator.start();

        new Timer().schedule(new TimerTask(){
            public void run() {
                startActivity(new Intent(InitialActivity.this, StartFollowupActivity.class));
                finish();

                Log.d("InitialActivity:", "onCreate: waiting 2 seconds for InitialActivity... loading StartFollowupActivity.class");
            }
        }, 2000 );
    }
}