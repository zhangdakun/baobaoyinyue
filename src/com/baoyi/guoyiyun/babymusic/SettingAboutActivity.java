// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.baoyi.guoyiyun.babymusic;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingAboutActivity extends Activity
{

    public SettingAboutActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03000f);
        ((Button)findViewById(0x7f07003e)).setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
                finish();
            }

//            final SettingAboutActivity this$0;
//
//            
//            {
//                this$0 = SettingAboutActivity.this;
//                super();
//            }
        }
);
    }
}
