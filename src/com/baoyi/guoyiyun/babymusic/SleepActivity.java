// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.baoyi.guoyiyun.babymusic;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.baoyi.guoyiyun.babymusic:
//            MainActivity, BabyMusicApplication

public class SleepActivity extends Activity
{

    public SleepActivity()
    {
        ocl = new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
//                int i;
//                i = view.getId();
//                Log.i("test", (new StringBuilder()).append(SleepActivity.whatcheck).toString());
//                if(SleepActivity.whatcheck == 0) goto _L2; else goto _L1
//_L1:
//                stopsleep();
//                rdb15.setChecked(false);
//                rdb30.setChecked(false);
//                rdb45.setChecked(false);
//                rdb60.setChecked(false);
//                rdb90.setChecked(false);
//                rdbedit.setChecked(false);
//                SleepActivity.whatcheck = 0;
//_L4:
//                return;
//_L2:
//                if(i == 0x7f07002e)
//                {
//                    SleepActivity.whatcheck = i;
//                    rdb15.setChecked(true);
//                    rdb30.setChecked(false);
//                    rdb45.setChecked(false);
//                    rdb60.setChecked(false);
//                    rdb90.setChecked(false);
//                    rdbedit.setChecked(false);
//                    gosleep(15L);
//                    tv.setText("\u4EB2\uFF0C\u60A8\u8BBE\u7F6E15\u5206\u949F\u540E\u5C06\u4F1A\u9000\u51FA\u5E94\u7528");
//                } else
//                if(i == 0x7f07002f)
//                {
//                    SleepActivity.whatcheck = i;
//                    rdb15.setChecked(false);
//                    rdb30.setChecked(true);
//                    rdb45.setChecked(false);
//                    rdb60.setChecked(false);
//                    rdb90.setChecked(false);
//                    rdbedit.setChecked(false);
//                    gosleep(30L);
//                    tv.setText("\u4EB2\uFF0C\u60A8\u8BBE\u7F6E30\u5206\u949F\u540E\u5C06\u4F1A\u9000\u51FA\u5E94\u7528");
//                } else
//                if(i == 0x7f070030)
//                {
//                    SleepActivity.whatcheck = i;
//                    rdb15.setChecked(false);
//                    rdb30.setChecked(false);
//                    rdb45.setChecked(true);
//                    rdb60.setChecked(false);
//                    rdb90.setChecked(false);
//                    rdbedit.setChecked(false);
//                    gosleep(45L);
//                    tv.setText("\u4EB2\uFF0C\u60A8\u8BBE\u7F6E45\u5206\u949F\u540E\u5C06\u4F1A\u9000\u51FA\u5E94\u7528");
//                } else
//                if(i == 0x7f070031)
//                {
//                    SleepActivity.whatcheck = i;
//                    rdb15.setChecked(false);
//                    rdb30.setChecked(false);
//                    rdb45.setChecked(false);
//                    rdb60.setChecked(true);
//                    rdb90.setChecked(false);
//                    rdbedit.setChecked(false);
//                    gosleep(60L);
//                    tv.setText("\u4EB2\uFF0C\u60A8\u8BBE\u7F6E60\u5206\u949F\u540E\u5C06\u4F1A\u9000\u51FA\u5E94\u7528");
//                } else
//                if(i == 0x7f070032)
//                {
//                    SleepActivity.whatcheck = i;
//                    rdb15.setChecked(false);
//                    rdb30.setChecked(false);
//                    rdb45.setChecked(false);
//                    rdb60.setChecked(false);
//                    rdb90.setChecked(true);
//                    rdbedit.setChecked(false);
//                    gosleep(90L);
//                    tv.setText("\u4EB2\uFF0C\u60A8\u8BBE\u7F6E90\u5206\u949F\u540E\u5C06\u4F1A\u9000\u51FA\u5E94\u7528");
//                } else
//                if(i == 0x7f070033)
//                    dialog.show();
//                else
//                if(i == 0x7f070071)
//                {
//                    SleepActivity.time = (new Integer(edsl.getText().toString())).intValue();
//                    if(SleepActivity.time <= 0)
//                    {
//                        Toast.makeText(SleepActivity.this, "\u65F6\u95F4\u4E0D\u80FD\u4E3A0", 1500).show();
//                    } else
//                    {
//                        gosleep(SleepActivity.time);
//                        rdb15.setChecked(false);
//                        rdb30.setChecked(false);
//                        rdb45.setChecked(false);
//                        rdb60.setChecked(false);
//                        rdb90.setChecked(false);
//                        rdbedit.setChecked(true);
//                        SleepActivity.whatcheck = i;
//                        tv.setText((new StringBuilder("\u4EB2\uFF0C\u60A8\u8BBE\u7F6E")).append(SleepActivity.time).append("\u5206\u949F\u540E\u5C06\u4F1A\u9000\u51FA\u5E94\u7528").toString());
//                        dialog.cancel();
//                    }
//                } else
//                if(i == 0x7f070072)
//                {
//                    dialog.cancel();
//                    rdb15.setChecked(false);
//                    rdb30.setChecked(false);
//                    rdb45.setChecked(false);
//                    rdb60.setChecked(false);
//                    rdb90.setChecked(false);
//                    rdbedit.setChecked(false);
//                }
//                if(true) goto _L4; else goto _L3
//_L3:
            }

//            final SleepActivity this$0;
//
//            
//            {
//                this$0 = SleepActivity.this;
//                super();
//            }
        }
;
    }

    private void gosleep(long l)
    {
        timer = new Timer();
        timer.schedule(new TimerTask() {

            public void run()
            {
                if(SleepActivity.this != null)
                    finish();
                MainActivity.ma.finish();
                ((BabyMusicApplication)getApplication()).setExit(true);
            }

//            final SleepActivity this$0;
//
//            
//            {
//                this$0 = SleepActivity.this;
//                super();
//            }
        }
, 60L * (1000L * l));
    }

    private void init()
    {
        rdb15 = (RadioButton)findViewById(0x7f07002e);
        rdb30 = (RadioButton)findViewById(0x7f07002f);
        rdb45 = (RadioButton)findViewById(0x7f070030);
        rdb60 = (RadioButton)findViewById(0x7f070031);
        rdb90 = (RadioButton)findViewById(0x7f070032);
        rdbedit = (RadioButton)findViewById(0x7f070033);
        tv = (TextView)findViewById(0x7f070035);
        re = (RelativeLayout)findViewById(0x7f070089);
        closeBtn = (ImageButton)findViewById(0x7f07008a);
        rdb15.setOnClickListener(ocl);
        rdb30.setOnClickListener(ocl);
        rdb45.setOnClickListener(ocl);
        rdb60.setOnClickListener(ocl);
        rdb90.setOnClickListener(ocl);
        rdbedit.setOnClickListener(ocl);
        closeBtn.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view1)
            {
                finish();
            }

//            final SleepActivity this$0;
//
//            
//            {
//                this$0 = SleepActivity.this;
//                super();
//            }
        }
);
        dialog = new Dialog(this, 0x103000b);
        View view = LayoutInflater.from(this).inflate(0x7f030008, null);
        dialog.requestWindowFeature(1);
        dialog.setContentView(view);
        edsl = (EditText)dialog.findViewById(0x7f070070);
        btok = (Button)dialog.findViewById(0x7f070071);
        btcn = (Button)dialog.findViewById(0x7f070072);
        btok.setOnClickListener(ocl);
        btcn.setOnClickListener(ocl);
//        if(whatcheck != 0x7f07002e) goto _L2; else goto _L1
//_L1:
//        rdb15.setChecked(true);
//        rdb30.setChecked(false);
//        rdb45.setChecked(false);
//        rdb60.setChecked(false);
//        rdb90.setChecked(false);
//        rdbedit.setChecked(false);
//        tv.setText("\u4EB2\uFF0C\u60A8\u8BBE\u7F6E15\u5206\u949F\u540E\u5C06\u4F1A\u9000\u51FA\u5E94\u7528");
//_L4:
//        return;
//_L2:
//        if(whatcheck == 0x7f07002f)
//        {
//            rdb15.setChecked(false);
//            rdb30.setChecked(true);
//            rdb45.setChecked(false);
//            rdb60.setChecked(false);
//            rdb90.setChecked(false);
//            rdbedit.setChecked(false);
//            tv.setText("\u4EB2\uFF0C\u60A8\u8BBE\u7F6E30\u5206\u949F\u540E\u5C06\u4F1A\u9000\u51FA\u5E94\u7528");
//        } else
//        if(whatcheck == 0x7f070030)
//        {
//            rdb15.setChecked(false);
//            rdb30.setChecked(false);
//            rdb45.setChecked(true);
//            rdb60.setChecked(false);
//            rdb90.setChecked(false);
//            rdbedit.setChecked(false);
//            tv.setText("\u4EB2\uFF0C\u60A8\u8BBE\u7F6E45\u5206\u949F\u540E\u5C06\u4F1A\u9000\u51FA\u5E94\u7528");
//        } else
//        if(whatcheck == 0x7f070031)
//        {
//            rdb15.setChecked(false);
//            rdb30.setChecked(false);
//            rdb45.setChecked(false);
//            rdb60.setChecked(true);
//            rdb90.setChecked(false);
//            rdbedit.setChecked(false);
//            tv.setText("\u4EB2\uFF0C\u60A8\u8BBE\u7F6E60\u5206\u949F\u540E\u5C06\u4F1A\u9000\u51FA\u5E94\u7528");
//        } else
//        if(whatcheck == 0x7f070032)
//        {
//            rdb15.setChecked(false);
//            rdb30.setChecked(false);
//            rdb45.setChecked(false);
//            rdb60.setChecked(false);
//            rdb90.setChecked(true);
//            rdbedit.setChecked(false);
//            tv.setText("\u4EB2\uFF0C\u60A8\u8BBE\u7F6E90\u5206\u949F\u540E\u5C06\u4F1A\u9000\u51FA\u5E94\u7528");
//        } else
//        if(whatcheck == 0x7f070033)
//        {
//            rdb15.setChecked(false);
//            rdb30.setChecked(false);
//            rdb45.setChecked(false);
//            rdb60.setChecked(false);
//            rdb90.setChecked(false);
//            rdbedit.setChecked(true);
//            tv.setText((new StringBuilder("\u4EB2\uFF0C\u60A8\u8BBE\u7F6E")).append(time).append("\u5206\u949F\u540E\u5C06\u4F1A\u9000\u51FA\u5E94\u7528").toString());
//        }
//        if(true) goto _L4; else goto _L3
//_L3:
    }

    private void stopsleep()
    {
        if(timer != null)
        {
            timer.cancel();
            timer = null;
            tv.setText("\u4EB2\uFF0C\u60A8\u5DF2\u7ECF\u53D6\u6D88\u7761\u7720\u6A21\u5F0F\uE703~~~");
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030011);
        init();
    }

    public static int time = -1;
    public static Timer timer;
    public static int whatcheck = 0;
    private Button btcn;
    private Button btok;
    private ImageButton closeBtn;
    private Dialog dialog;
    private EditText edsl;
    private android.view.View.OnClickListener ocl;
    private RadioButton rdb15;
    private RadioButton rdb30;
    private RadioButton rdb45;
    private RadioButton rdb60;
    private RadioButton rdb90;
    private RadioButton rdbedit;
    private RelativeLayout re;
    private TextView tv;












}
