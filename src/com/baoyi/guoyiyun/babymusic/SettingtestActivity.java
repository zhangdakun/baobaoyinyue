// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.baoyi.guoyiyun.babymusic;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.baoyi.guoyiyun.utils.RpcUtils;
import com.baoyi.ring.questionnaire.Questionnaire;
import com.baoyi.ring.questionnaire.QuestionnaireDao;

public class SettingtestActivity extends Activity
{
    class Pust extends AsyncTask
    {

        protected Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected Void doInBackground(Void avoid[])
        {
            if(qd != null)
            {
                qd.AddQue(qq1);
                qd.AddQue(qq2);
                qd.AddQue(qq3);
                qd.AddQue(qq4);
                qd.AddQue(qq5);
            }
            return null;
        }

        protected void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            Toast.makeText(SettingtestActivity.this, "\u611F\u8C22\u60A8\u7684\u8BC4\u5206\uFF0C\u6211\u4EEC\u4F1A\u8FFD\u6C42\u505A\u5230\u6700\u597D\u3002", 0).show();
            finish();
        }

        protected void onPreExecute()
        {
            tijiao.setClickable(false);
            tijiao.setBackgroundResource(0x7f02006a);
        }

//        final SettingtestActivity this$0;
//
//        Pust()
//        {
//            this$0 = SettingtestActivity.this;
//            super();
//        }
    }


    public SettingtestActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030010);
        tijiao = (Button)findViewById(0x7f070088);
        rb11 = (RadioButton)findViewById(0x7f070079);
        rb12 = (RadioButton)findViewById(0x7f07007a);
        rb13 = (RadioButton)findViewById(0x7f07007b);
        rb21 = (RadioButton)findViewById(0x7f07007c);
        rb22 = (RadioButton)findViewById(0x7f07007d);
        rb23 = (RadioButton)findViewById(0x7f07007e);
        rb31 = (RadioButton)findViewById(0x7f07007f);
        rb32 = (RadioButton)findViewById(0x7f070080);
        rb33 = (RadioButton)findViewById(0x7f070081);
        rb41 = (RadioButton)findViewById(0x7f070082);
        rb42 = (RadioButton)findViewById(0x7f070083);
        rb43 = (RadioButton)findViewById(0x7f070084);
        rb51 = (RadioButton)findViewById(0x7f070085);
        rb52 = (RadioButton)findViewById(0x7f070086);
        rb53 = (RadioButton)findViewById(0x7f070087);
        cancle = (Button)findViewById(0x7f070040);
        cancle.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
                finish();
            }

//            final SettingtestActivity this$0;
//
//            
//            {
//                this$0 = SettingtestActivity.this;
//                super();
//            }
        }
);
        q1 = getString(0x7f080019);
        q2 = getString(0x7f08001a);
        q3 = getString(0x7f08001b);
        q4 = getString(0x7f08001c);
        q5 = getString(0x7f08001d);
        tijiao.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
                String s;
                if(rb11.isChecked())
                    a1 = getString(0x7f08001e);
                else
                if(rb12.isChecked())
                    a1 = getString(0x7f08001f);
                else
                if(rb13.isChecked())
                    a1 = getString(0x7f080020);
                if(rb21.isChecked())
                    a2 = getString(0x7f080021);
                else
                if(rb22.isChecked())
                    a2 = getString(0x7f080022);
                else
                if(rb23.isChecked())
                    a2 = getString(0x7f080023);
                if(rb31.isChecked())
                    a3 = getString(0x7f080024);
                else
                if(rb32.isChecked())
                    a3 = getString(0x7f080025);
                else
                if(rb33.isChecked())
                    a3 = getString(0x7f080026);
                if(rb41.isChecked())
                    a4 = getString(0x7f080027);
                else
                if(rb42.isChecked())
                    a4 = getString(0x7f080028);
                else
                if(rb43.isChecked())
                    a4 = getString(0x7f080029);
                if(rb51.isChecked())
                    a5 = getString(0x7f08002a);
                else
                if(rb52.isChecked())
                    a5 = getString(0x7f08002b);
                else
                if(rb53.isChecked())
                    a5 = getString(0x7f08002c);
                s = getPackageName();
                qq1 = new Questionnaire(Integer.valueOf(0), s, q1, a1, Long.valueOf(0L));
                qq2 = new Questionnaire(Integer.valueOf(0), s, q2, a2, Long.valueOf(0L));
                qq3 = new Questionnaire(Integer.valueOf(0), s, q3, a3, Long.valueOf(0L));
                qq4 = new Questionnaire(Integer.valueOf(0), s, q4, a4, Long.valueOf(0L));
                qq5 = new Questionnaire(Integer.valueOf(0), s, q5, a5, Long.valueOf(0L));
                (new Pust()).execute(new Void[0]);
            }

//            final SettingtestActivity this$0;
//
//            
//            {
//                this$0 = SettingtestActivity.this;
//                super();
//            }
        }
);
//        qd = (QuestionnaireDao)RpcUtils.getDao("questionnaireDao", com/baoyi/ring/questionnaire/QuestionnaireDao);
    }

    private String a1;
    private String a2;
    private String a3;
    private String a4;
    private String a5;
    private Button cancle;
    private String q1;
    private String q2;
    private String q3;
    private String q4;
    private String q5;
    private QuestionnaireDao qd;
    Questionnaire qq1;
    Questionnaire qq2;
    Questionnaire qq3;
    Questionnaire qq4;
    Questionnaire qq5;
    private RadioButton rb11;
    private RadioButton rb12;
    private RadioButton rb13;
    private RadioButton rb21;
    private RadioButton rb22;
    private RadioButton rb23;
    private RadioButton rb31;
    private RadioButton rb32;
    private RadioButton rb33;
    private RadioButton rb41;
    private RadioButton rb42;
    private RadioButton rb43;
    private RadioButton rb51;
    private RadioButton rb52;
    private RadioButton rb53;
    private Button tijiao;
































}
