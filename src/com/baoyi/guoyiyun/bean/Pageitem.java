// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.baoyi.guoyiyun.bean;


public class Pageitem
{

    public Pageitem(int i)
    {
        b = false;
        id = i;
    }

    public int getId()
    {
        return id;
    }

    public boolean isB()
    {
        return b;
    }

    public void setB(boolean flag)
    {
        b = flag;
    }

    public void setId(int i)
    {
        id = i;
    }

    private boolean b;
    private int id;
}
