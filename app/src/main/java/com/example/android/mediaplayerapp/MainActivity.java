package com.example.android.mediaplayerapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //find asala textView by id
        TextView asala = (TextView) findViewById(R.id.asala);
        //creat onClick listener
        asala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent asalaIntent = new Intent(MainActivity.this, AsalaActivity.class);
                startActivity(asalaIntent);
            }
        });

        //find mohammad textView by id
        TextView mohammad = (TextView) findViewById(R.id.mohammad);
        //creat onClick listener
        mohammad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mohammadIntent = new Intent(MainActivity.this, MohammadActivity.class);
                startActivity(mohammadIntent);
            }
        });

        //find asy textView by id
        TextView asy = (TextView) findViewById(R.id.asy);
        //creat onClick listener
        asy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent asyIntent = new Intent(MainActivity.this, AsyActivity.class);
                startActivity(asyIntent);
            }
        });

        //find shereen textView by id
        TextView shereen = (TextView) findViewById(R.id.shereen);
        //creat onClick listener
        shereen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shereenIntent = new Intent(MainActivity.this, ShereenActivity.class);
                startActivity(shereenIntent);
            }
        });


    }
}