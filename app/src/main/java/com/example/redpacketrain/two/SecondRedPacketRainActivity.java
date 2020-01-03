package com.example.redpacketrain.two;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.redpacketrain.R;

import java.util.ArrayList;
import java.util.List;

public class SecondRedPacketRainActivity extends AppCompatActivity {

    RedPacketViewHelper mRedPacketViewHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_red_packet_rain);

        mRedPacketViewHelper = new RedPacketViewHelper(this);
    }

    public void start(View view) {
        mRedPacketViewHelper.endGiftRain();
        getWindow().getDecorView().postDelayed(() -> {
            List<BoxInfo> boxInfos = new ArrayList<>();
            for (int i = 0; i < 32; i++) {
                BoxInfo boxInfo = new BoxInfo();
                boxInfo.setAwardId(i);
                boxInfo.setVoucher("ice " + i);
                boxInfos.add(boxInfo);
            }
            mRedPacketViewHelper.launchGiftRainRocket(0, boxInfos, new RedPacketViewHelper.GiftRainListener() {
                @Override
                public void startLaunch() {

                }

                @Override
                public void startRain() {

                }

                @Override
                public void openGift(BoxPrizeBean boxPrizeBean) {

                }

                @Override
                public void endRain() {
                    view.setEnabled(true);
                }
            });
        }, 500);
    }

    public void end(View view) {
        mRedPacketViewHelper.endGiftRain();
    }
}
