// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.iring.entity;

import java.io.Serializable;

public class Commentary
    implements Serializable
{

    public Commentary()
    {
    }

    public Commentary(int i, int j, int k, String s, String s1, String s2, long l)
    {
        id = i;
        conversationid = j;
        authorid = k;
        authorname = s;
        content = s1;
        ip = s2;
        posttime = l;
    }

    public static long getSerialversionuid()
    {
        return 1L;
    }

    public int getAuthorid()
    {
        return authorid;
    }

    public String getAuthorname()
    {
        return authorname;
    }

    public String getContent()
    {
        return content;
    }

    public int getConversationid()
    {
        return conversationid;
    }

    public int getId()
    {
        return id;
    }

    public String getIp()
    {
        return ip;
    }

    public long getPosttime()
    {
        return posttime;
    }

    public void setAuthorid(int i)
    {
        authorid = i;
    }

    public void setAuthorname(String s)
    {
        authorname = s;
    }

    public void setContent(String s)
    {
        content = s;
    }

    public void setConversationid(int i)
    {
        conversationid = i;
    }

    public void setId(int i)
    {
        id = i;
    }

    public void setIp(String s)
    {
        ip = s;
    }

    public void setPosttime(long l)
    {
        posttime = l;
    }

    private static final long serialVersionUID = 1L;
    private int authorid;
    private String authorname;
    private String content;
    private int conversationid;
    private int id;
    private String ip;
    private long posttime;
}
