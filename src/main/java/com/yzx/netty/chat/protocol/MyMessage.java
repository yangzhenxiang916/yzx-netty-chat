package com.yzx.netty.chat.protocol;

import lombok.Data;

import java.io.Serializable;

@Data
public class MyMessage implements Serializable {

    private static final long serialVersionUID = 8763561286199081881L;
    private String addr;
    private String cmd;
    private long time;
    private int onlineNum;
    private String sender;
    private String receiver;
    private String content;
    private String terminal;

    public MyMessage() {
    }

    public MyMessage(String cmd, String terminal, long time, String sender) {
        this.cmd = cmd;
        this.time = time;
        this.terminal = terminal;
        this.sender = sender;
    }

    public MyMessage(String cmd, long time, String sender, String content) {
        this.cmd = cmd;
        this.time = time;
        this.sender = sender;
        this.content = content;
    }

    public MyMessage(String cmd, long time, int onlineNum, String content) {
        this.cmd = cmd;
        this.time = time;
        this.onlineNum = onlineNum;
        this.content = content;
    }

}
