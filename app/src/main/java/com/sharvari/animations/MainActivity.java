package com.sharvari.animations;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView txtUsername, txtPassword, txtButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        txtButton = findViewById(R.id.txtButton);


        txtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
            }
        });
        animateScreen();
    }

    private void animateScreen(){
        Animation animation = new TranslateAnimation(1000,0, 0,0);
        animation.setStartOffset(100);
        animation.setDuration(1000);
        txtUsername.startAnimation(animation);

        Animation animation1 = new TranslateAnimation(1000,0, 0,0);
        animation1.setStartOffset(200);
        animation1.setDuration(1000);
        txtPassword.startAnimation(animation1);

        Animation animation2 = new TranslateAnimation(1000,0, 0,0);
        animation2.setStartOffset(300);
        animation2.setDuration(1000);
        txtButton.startAnimation(animation2);


    }

//
//    private void animateScreen(int fromX, int fromY,int toX, int toY, int duration, int startTime, TextView textView){
//        Display window = getWindowManager().getDefaultDisplay();
//
//        Animation animation = new TranslateAnimation(fromX,toX, fromY,toY);
//        animation.setStartTime(startTime);
//        textView.setAnimation(animation);
//
//        AnimationSet set = new AnimationSet(true);
//        set.addAnimation(animation);
//
//        textView.startAnimation(animation);
//    }
}
