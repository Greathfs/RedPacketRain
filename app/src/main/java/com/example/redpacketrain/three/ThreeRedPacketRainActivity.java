package com.example.redpacketrain.three;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.redpacketrain.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HuangFusheng
 * @date 2020-01-03
 * description ThreeRedPacketRainActivity
 */
public class ThreeRedPacketRainActivity extends AppCompatActivity {

    private WebView mWebView;
    private Button mStart;
    private Button mStop;
    private AutoPollRecyclerView mRvAutoPoll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_red_packet_rain);

        mWebView = findViewById(R.id.web_view);
        mStart = findViewById(R.id.start);
        mStop = findViewById(R.id.stop);

        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRvAutoPoll.start();
            }
        });

        mStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRvAutoPoll.stop();
            }
        });

        initView();
    }

    private void initView() {
        mRvAutoPoll = findViewById(R.id.rv_auto_poll);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 3000; ) {
            list.add(" Item: " + ++i);
        }
        mRvAutoPoll.setLayoutManager(new LinearLayoutManager(this));
        AutoPollAdapter adapter = new AutoPollAdapter(list);
        mRvAutoPoll.setAdapter(adapter);
        mRvAutoPoll.scrollToPosition(1500);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRvAutoPoll.stop();
    }
}
