// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.baoyi.guoyiyun.bean;


public class TalkBack
{

    public TalkBack(int i, int j, String s, String s1, String s2)
    {
        backid = i;
        talkid = j;
        ip = s;
        content = s1;
        time = s2;
    }

    public int getBackid()
    {
        return backid;
    }

    public String getContent()
    {
        return content;
    }

    public String getIp()
    {
        return ip;
    }

    public int getTalkid()
    {
        return talkid;
    }

    public String getTime()
    {
        return time;
    }

    public void setBackid(int i)
    {
        backid = i;
    }

    public void setContent(String s)
    {
        content = s;
    }

    public void setIp(String s)
    {
        ip = s;
    }

    public void setTalkid(int i)
    {
        talkid = i;
    }

    public void setTime(String s)
    {
        time = s;
    }

    private int backid;
    private String content;
    private String ip;
    private int talkid;
    private String time;
}
