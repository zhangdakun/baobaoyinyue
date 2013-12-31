// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.iring.entity;

import java.io.Serializable;

public class Conversation
    implements Serializable
{

    public Conversation()
    {
    }

    public Conversation(int i, String s, int j, String s1, String s2, int k, long l, String s3)
    {
        id = i;
        title = s;
        authorid = j;
        authorname = s1;
        content = s2;
        hit = k;
        posttime = l;
        ip = s3;
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

    public int getHit()
    {
        return hit;
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

    public String getTitle()
    {
        return title;
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

    public void setHit(int i)
    {
        hit = i;
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

    public void setTitle(String s)
    {
        title = s;
    }

    public String toString()
    {
        return (new StringBuilder("Conversation [id=")).append(id).append(", title=").append(title).append(", authorid=").append(authorid).append(", authorname=").append(authorname).append(", content=").append(content).append(", hit=").append(hit).append(", posttime=").append(posttime).append(", ip=").append(ip).append("]").toString();
    }

    private int authorid;
    private String authorname;
    private String content;
    private int hit;
    private int id;
    private String ip;
    private long posttime;
    private String title;
}
