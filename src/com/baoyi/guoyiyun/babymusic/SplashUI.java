// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.baoyi.guoyiyun.babymusic;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.*;
import android.view.*;
import android.webkit.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baoyi.guoyiyun.util.MediaplayUtil;
import java.io.PrintStream;
import java.util.*;

// Referenced classes of package com.baoyi.guoyiyun.babymusic:
//            BaseActivity, SleepActivity, MainActivity, BabyMusicApplication

public class SplashUI extends BaseActivity
    implements android.view.GestureDetector.OnGestureListener, android.view.View.OnTouchListener
{

    public SplashUI()
    {
        handler = new Handler();
        go = new Runnable() {

            public void run()
            {
                gohome();
            }

//            final SplashUI this$0;
//
//            
//            {
//                this$0 = SplashUI.this;
//                super();
//            }
        }
;
        webChromeClient = new WebChromeClient() {

//            final SplashUI this$0;
//
//            
//            {
//                this$0 = SplashUI.this;
//                super();
//            }
        }
;
        client = new WebViewClient() {

            public void onLoadResource(WebView webview, String s)
            {
                super.onLoadResource(webview, s);
            }

            public void onPageFinished(WebView webview, String s)
            {
                super.onPageFinished(webview, s);
                frameLayout.setVisibility(0);
            }

            public void onReceivedError(WebView webview, int i, String s, String s1)
            {
                System.out.println((new StringBuilder()).append(i).append("/n").append(s).append("/n").append(s1).toString());
                super.onReceivedError(webview, i, s, s1);
            }

//            final SplashUI this$0;
//
//            
//            {
//                this$0 = SplashUI.this;
//                super();
//            }
        }
;
    }

    private boolean isServiceRunning()
    {
//        Iterator iterator = ((ActivityManager)getSystemService("activity")).getRunningServices(0x7fffffff).iterator();
//_L2:
//        boolean flag;
//        if(iterator.hasNext())
//            continue; /* Loop/switch isn't completed */
//        flag = false;
//_L3:
//        return flag;
//        if(!"com.baoyi.guoyiyun.service.DownService".equals(((android.app.ActivityManager.RunningServiceInfo)iterator.next()).service.getClassName())) goto _L2; else goto _L1
//_L1:
//        flag = true;
//          goto _L3
//        if(true) goto _L2; else goto _L4
//_L4:
    	return false;
    }

    public void finish()
    {
        if(MediaplayUtil.mp != null)
            MediaplayUtil.close();
        if(SleepActivity.timer != null)
        {
            SleepActivity.timer.cancel();
            SleepActivity.timer = null;
        }
        if(isServiceRunning())
        {
            Intent intent = new Intent();
            intent.setAction("com.baoyi.guoyiyun.service.DownService");
            stopService(intent);
        }
//        Process.killProcess(Process.myPid());
        super.finish();
    }

    public void gohome()
    {
//        startActivity(new Intent(this, com/baoyi/guoyiyun/babymusic/MainActivity));
//        overridePendingTransition(0x7f040003, 0x7f040000);
    }

    public void gohomeNo()
    {
//        handler.removeCallbacks(go);
//        startActivity(new Intent(this, com/baoyi/guoyiyun/babymusic/MainActivity));
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030000);
        frameLayout = (WebView)findViewById(0x7f07006b);
        imageView = (ImageView)findViewById(0x7f07006c);
        imageviewjiantou = (ImageView)findViewById(0x7f07006e);
        jiantou = (LinearLayout)findViewById(0x7f07006d);
        imageView.setClickable(true);
        frameLayout.setWebChromeClient(webChromeClient);
        frameLayout.setWebViewClient(client);
        handler.postDelayed(go, 3500L);
        detector = new GestureDetector(this);
        imageView.setOnTouchListener(this);
        frameLayout.setOnTouchListener(this);
        final AnimationDrawable animationDrawable = (AnimationDrawable)imageviewjiantou.getDrawable();
        handler.post(new Runnable() {

            public void run()
            {
                animationDrawable.start();
            }

//            final SplashUI this$0;
//            private final AnimationDrawable val$animationDrawable;
//
//            
//            {
//                this$0 = SplashUI.this;
//                animationDrawable = animationdrawable;
//                super();
//            }
        }
);
    }

    public boolean onDown(MotionEvent motionevent)
    {
        return false;
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
//        if(motionevent.getX() - motionevent1.getX() <= 120F) goto _L2; else goto _L1
//_L1:
//        gohomeNo();
//_L4:
//        return true;
//_L2:
//        if(motionevent.getX() - motionevent1.getX() < -120F)
//            gohomeNo();
//        if(true) goto _L4; else goto _L3
//_L3:
    	return false;
    }

    public void onLongPress(MotionEvent motionevent)
    {
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        return false;
    }

    public void onShowPress(MotionEvent motionevent)
    {
    }

    public boolean onSingleTapUp(MotionEvent motionevent)
    {
        return false;
    }

    protected void onStart()
    {
        super.onStart();
        if(((BabyMusicApplication)getApplication()).isExit())
            finish();
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        detector.onTouchEvent(motionevent);
        return false;
    }

    private WebViewClient client;
    private GestureDetector detector;
    WebView frameLayout;
    private Runnable go;
    private Handler handler;
    ImageView imageView;
    ImageView imageviewjiantou;
    LinearLayout jiantou;
    WebChromeClient webChromeClient;
}
