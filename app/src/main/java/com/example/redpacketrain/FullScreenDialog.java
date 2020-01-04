package com.example.redpacketrain;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.redpacketrain.three.AutoPollAdapter;
import com.example.redpacketrain.three.AutoPollRecyclerView;
import com.example.redpacketrain.three.RedPacketBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HuangFusheng
 * @date 2020-01-04
 * description FullScreenDialog
 */
public class FullScreenDialog extends Dialog {

    private Button mStart;
    private Button mStop;
    private AutoPollRecyclerView mRvAutoPoll;

    public FullScreenDialog(@NonNull Context context) {
        super(context, R.style.dialog);
        setCancelable(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置一个布局
        setContentView(R.layout.dialog_full_screen);
        //设置window背景，默认的背景会有Padding值，不能全屏。当然不一定要是透明，你可以设置其他背景，替换默认的背景即可。
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //一定要在setContentView之后调用，否则无效
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

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
        List<RedPacketBean> list = new ArrayList<>();
        for (int i = 0; i < 3000; i++) {
            RedPacketBean bean = new RedPacketBean();
            if (i == 1500) {
                bean.setType(RedPacketBean.TYPE_EMPTY);
            } else {
                bean.setType(RedPacketBean.TYPE_NORMAL);
            }
            list.add(bean);
        }
        mRvAutoPoll.setLayoutManager(new LinearLayoutManager(getContext()));
        AutoPollAdapter adapter = new AutoPollAdapter(list);
        mRvAutoPoll.setAdapter(adapter);
        mRvAutoPoll.scrollToPosition(1500);
    }

    @Override
    public void show() {
        // Dialog 在初始化时会生成新的 Window，先禁止 Dialog Window 获取焦点，等 Dialog 显示后对 Dialog Window 的 DecorView 设置 setSystemUiVisibility ，接着再获取焦点。 这样表面上看起来就没有退出沉浸模式。
        // Set the dialog to not focusable (makes navigation ignore us adding the window)
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);

        //Show the dialog!
        super.show();

        //Set the dialog to immersive
//        fullScreenImmersive(getWindow().getDecorView());

        //Clear the not focusable flag from the window
        this.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
    }

    /**
     * 全屏显示，隐藏虚拟按钮
     *
     * @param view
     */
    private void fullScreenImmersive(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_FULLSCREEN;
            view.setSystemUiVisibility(uiOptions);
        }
    }

}
