package com.example.yllub_pc.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Splash_screen extends AppCompatActivity {
    ImageView zero;
    Button button;
    ImageView x;
    ImageView title;
    Animation zero_rotation;

    Animation x_move;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();

       decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN
                       | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        getSupportActionBar().hide();


        setContentView(R.layout.splash_screen);
        title=(ImageView)findViewById(R.id.title);
        button=(Button)findViewById(R.id.button2);
        zero=(ImageView)findViewById(R.id.zero);
        x=(ImageView)findViewById(R.id.x) ;

        title.setVisibility(View.INVISIBLE);
        button.setVisibility(View.INVISIBLE);

        title.postDelayed(new Runnable() {
            @Override
            public void run() {
                title.setVisibility(View.VISIBLE);
                button.setVisibility(View.VISIBLE);
            }
        },4500);


        zero_rotation=AnimationUtils.loadAnimation(this,R.anim.zero_rotation);
        x_move=AnimationUtils.loadAnimation(this,R.anim.x_move);


        zero.setAnimation(zero_rotation);
        x.setAnimation(x_move);

        goToNextActivity();
    }
    protected void goToNextActivity(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Splash_screen.this, Game_mode_screen.class));


            }
            });


    }
        }