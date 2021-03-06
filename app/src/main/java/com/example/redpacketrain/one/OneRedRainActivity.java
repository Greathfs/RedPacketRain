package com.example.redpacketrain.one;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.redpacketrain.R;


public class OneRedRainActivity extends AppCompatActivity implements View.OnClickListener {

    private RedPacketView redRainView;
    private Button start, stop;
    private WebView mWebView;
    private int totalmoney = 0;
    AlertDialog.Builder ab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red_rain);

        ab = new AlertDialog.Builder(OneRedRainActivity.this);
        start = (Button) findViewById(R.id.start);
        stop = (Button) findViewById(R.id.stop);
        redRainView = (RedPacketView) findViewById(R.id.red_packets_view1);
        mWebView = findViewById(R.id.web_view);
        // 设置支持JavaScript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // 加载网页
        mWebView.loadUrl("https://www.baidu.com/");

        start.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.start) {
            startRedRain();
        } else if (v.getId() == R.id.stop) {
            stopRedRain();
        }
    }

    /**
     * 开始下红包雨
     */
    private void startRedRain() {
        redRainView.startRain();
        redRainView.setOnRedPacketClickListener(new RedPacketView.OnRedPacketClickListener() {
            @Override
            public void onRedPacketClickListener(RedPacket redPacket) {
                ab.setCancelable(false);
                ab.setTitle("红包提醒");
                ab.setNegativeButton("继续抢红包", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                if (redPacket.isRealRed) {
                    ab.setMessage("恭喜你，抢到了" + redPacket.money + "元！");
                } else {
                    ab.setMessage("很遗憾，下次继续努力！");
                }
                redRainView.post(new Runnable() {
                    @Override
                    public void run() {
                        ab.show();
                    }
                });
            }
        });
    }

    /**
     * 停止下红包雨
     */
    private void stopRedRain() {
        totalmoney = 0;//金额清零
        redRainView.stopRainNow();
    }

}

