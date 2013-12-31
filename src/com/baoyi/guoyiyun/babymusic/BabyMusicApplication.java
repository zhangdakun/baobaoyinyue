// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.baoyi.guoyiyun.babymusic;

import android.app.Application;

public class BabyMusicApplication extends Application
{

    public BabyMusicApplication()
    {
        exit = false;
    }

    public boolean isExit()
    {
        return exit;
    }

    public void onCreate()
    {
        super.onCreate();
    }

    public void setExit(boolean flag)
    {
        exit = flag;
    }

    private boolean exit;
}
