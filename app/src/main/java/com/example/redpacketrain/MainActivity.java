package com.example.redpacketrain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.redpacketrain.one.OneRedRainActivity;
import com.example.redpacketrain.second.SecondRedPacketRainActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void one(View view) {
        startActivity(new Intent(this, OneRedRainActivity.class));
    }

    public void second(View view) {
        startActivity(new Intent(this, SecondRedPacketRainActivity.class));
    }
}
