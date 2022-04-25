package com.yzx.netty.chat.protocol;

public enum MsgActionEnum {

    SYSTEM("SYSTEM", "系统命令"),
    LOGIN("LOGIN", "登录"),
    LOGOUT("LOGOUT", "登出"),
    CHAT("CHAT", "聊天"),
    FLOWER("FLOWER", "鲜花"),
    KEEPALIVE("KEEPALIVE", "心跳检测");

    private String name;
    private String msg;

    MsgActionEnum(String name, String msg) {
        this.name = name;
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public static boolean isIMP(String content){
        return content.matches("^\\[(SYSTEM|LOGIN|LOGOUT|CHAT|FLOWER)\\]");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
