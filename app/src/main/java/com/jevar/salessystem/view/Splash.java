package com.jevar.salessystem.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.jevar.salessystem.R;

public class Splash extends AppCompatActivity {

    private TextView tv;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        tv = (TextView) findViewById(R.id.tv);
        iv = (ImageView) findViewById(R.id.iv);
        Animation splashAnimation = AnimationUtils.loadAnimation(this, R.anim.splashtransition);
        tv.startAnimation(splashAnimation);
        iv.startAnimation(splashAnimation);

        final Intent login = new Intent(this, LoginActivity.class);

        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    startActivity(login);
                    finish();
                }
            }
        };
            timer.start();
    }
}
