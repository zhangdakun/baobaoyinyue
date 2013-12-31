// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.baoyi.guoyiyun.babymusic;

import android.app.Activity;
import android.os.Bundle;

public class BaseActivity extends Activity
{

    public BaseActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    protected void onPause()
    {
//        StatService.onPause(this);
        super.onPause();
    }

    protected void onResume()
    {
//        StatService.onResume(this);
        super.onResume();
    }
}
