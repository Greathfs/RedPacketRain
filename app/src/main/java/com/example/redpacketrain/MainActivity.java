package com.example.redpacketrain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.redpacketrain.one.OneRedRainActivity;
import com.example.redpacketrain.two.SecondRedPacketRainActivity;
import com.example.redpacketrain.three.ThreeRedPacketRainActivity;

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
    public void three(View view) {
        startActivity(new Intent(this, ThreeRedPacketRainActivity.class));
    }

}
