package com.example.redpacketrain.three;

/**
 * @author HuangFusheng
 * @date 2020-01-04
 * description RedPacketBean
 */
public class RedPacketBean {
    public static final int TYPE_EMPTY = 0;
    public static final int TYPE_NORMAL = 1;

    private int type = TYPE_NORMAL;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
