package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Main2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void nextScene (View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void nextScene3 (View v) {
        Intent i = new Intent(this, Main3Activity.class);
        startActivity(i);
    }
}
