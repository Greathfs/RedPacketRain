package com.example.redpacketrain.three;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.redpacketrain.R;

import java.util.List;

/**
 * @author HuangFusheng
 * @date 2020-01-03
 * description AutoPollAdapter
 */
public class AutoPollAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "AutoPollAdapter";
    private final List<RedPacketBean> mData;

    public AutoPollAdapter(List<RedPacketBean> list) {
        this.mData = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == RedPacketBean.TYPE_EMPTY) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_auto_poll_empty, parent, false);
            return new EmptyViewHolder(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_auto_poll, parent, false);
        return new NormalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        return position == 1500 ? RedPacketBean.TYPE_EMPTY : RedPacketBean.TYPE_NORMAL;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class NormalViewHolder extends RecyclerView.ViewHolder {
        public NormalViewHolder(View itemView) {
            super(itemView);
        }
    }

    class EmptyViewHolder extends RecyclerView.ViewHolder{
        public EmptyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
