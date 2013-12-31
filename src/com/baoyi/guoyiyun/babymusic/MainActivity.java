// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.baoyi.guoyiyun.babymusic;

import android.content.*;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.*;
import android.support.v4.app.*;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
//import com.adcocoa.sdk.AdcocoaPopupAd;
//import com.adcocoa.sdk.AdcocoaPopupAdListener;
import com.baoyi.guoyiyun.constant.Constant;
import com.baoyi.guoyiyun.util.HttpDownloader;
import com.baoyi.guoyiyun.util.MediaplayUtil;
//import com.by.update.UmsAgent;
//import com.iyoung.guaitu.Min;
//import com.nd.dianjin.*;
//import com.nd.dianjin.listener.AppActivatedListener;

// Referenced classes of package com.baoyi.guoyiyun.babymusic:
//            NetFragmen, LocalMuiscFragmen, ConvertFragment, SettingFragment

public class MainActivity extends FragmentActivity
{

    public MainActivity()
    {
        ocl = new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
                FragmentTransaction fragmenttransaction;
                int i;
                if(MainActivity.viewid == 31 && MainActivity.fmconvert_talkinfo != null)
                    getSupportFragmentManager().beginTransaction().remove(MainActivity.fmconvert_talkinfo).commit();
                if(MainActivity.viewid == 32 && MainActivity.fmconvert_newtalk != null)
                    getSupportFragmentManager().beginTransaction().remove(MainActivity.fmconvert_newtalk).commit();
                fragmenttransaction = getSupportFragmentManager().beginTransaction();
                i = view.getId();
                
//                if(i != 0x7f070005) goto _L2; else goto _L1
//_L1:
//                bt1.setBackgroundResource(0x7f050012);
//                bt2.setBackgroundResource(0x7f020023);
//                bt3.setBackgroundResource(0x7f020021);
//                bt4.setBackgroundResource(0x7f020027);
//                fragmenttransaction.hide(MainActivity.fmnet).hide(MainActivity.fmlocal).hide(MainActivity.fmconvert).hide(MainActivity.fmset).show(MainActivity.fmnet).commit();
//                MainActivity.viewid = 1;
//_L4:
//                return;
//_L2:
//                if(i == 0x7f070006)
//                {
//                    bt1.setBackgroundResource(0x7f020025);
//                    bt2.setBackgroundResource(0x7f050011);
//                    bt3.setBackgroundResource(0x7f020021);
//                    bt4.setBackgroundResource(0x7f020027);
//                    fragmenttransaction.hide(MainActivity.fmnet).hide(MainActivity.fmlocal).hide(MainActivity.fmconvert).hide(MainActivity.fmset).show(MainActivity.fmlocal).commit();
//                    MainActivity.viewid = 2;
//                } else
//                if(i == 0x7f070007)
//                {
//                    bt1.setBackgroundResource(0x7f020025);
//                    bt2.setBackgroundResource(0x7f020023);
//                    bt3.setBackgroundResource(0x7f050010);
//                    bt4.setBackgroundResource(0x7f020027);
//                    fragmenttransaction.hide(MainActivity.fmnet).hide(MainActivity.fmlocal).hide(MainActivity.fmconvert).hide(MainActivity.fmset).show(MainActivity.fmconvert).commit();
//                    MainActivity.viewid = 3;
//                } else
//                if(i == 0x7f070008)
//                {
//                    bt1.setBackgroundResource(0x7f020025);
//                    bt2.setBackgroundResource(0x7f020023);
//                    bt3.setBackgroundResource(0x7f020021);
//                    bt4.setBackgroundResource(0x7f050013);
//                    fragmenttransaction.hide(MainActivity.fmnet).hide(MainActivity.fmlocal).hide(MainActivity.fmconvert).hide(MainActivity.fmset).show(MainActivity.fmset).commit();
//                    MainActivity.viewid = 4;
//                }
//                if(true) goto _L4; else goto _L3
//_L3:
	// leb decom
				switch (i) {
				case 0x7f070005:
	                bt1.setBackgroundResource(0x7f050012);
	                bt2.setBackgroundResource(0x7f020023);
	                bt3.setBackgroundResource(0x7f020021);
	                bt4.setBackgroundResource(0x7f020027);
	                fragmenttransaction.hide(MainActivity.fmnet).hide(MainActivity.fmlocal).hide(MainActivity.fmconvert).hide(MainActivity.fmset).show(MainActivity.fmnet).commit();
	                MainActivity.viewid = 1;					
					break;
				case 0x7f070006:
                    bt1.setBackgroundResource(0x7f020025);
                    bt2.setBackgroundResource(0x7f050011);
                    bt3.setBackgroundResource(0x7f020021);
                    bt4.setBackgroundResource(0x7f020027);
                    fragmenttransaction.hide(MainActivity.fmnet).hide(MainActivity.fmlocal).hide(MainActivity.fmconvert).hide(MainActivity.fmset).show(MainActivity.fmlocal).commit();
                    MainActivity.viewid = 2;					
					break;
				case 0x7f070007:
                    bt1.setBackgroundResource(0x7f020025);
                    bt2.setBackgroundResource(0x7f020023);
                    bt3.setBackgroundResource(0x7f050010);
                    bt4.setBackgroundResource(0x7f020027);
                    fragmenttransaction.hide(MainActivity.fmnet).hide(MainActivity.fmlocal).hide(MainActivity.fmconvert).hide(MainActivity.fmset).show(MainActivity.fmconvert).commit();
                    MainActivity.viewid = 3;					
					break;
				case 0x7f070008:
                    bt1.setBackgroundResource(0x7f020025);
                    bt2.setBackgroundResource(0x7f020023);
                    bt3.setBackgroundResource(0x7f020021);
                    bt4.setBackgroundResource(0x7f050013);
                    fragmenttransaction.hide(MainActivity.fmnet).hide(MainActivity.fmlocal).hide(MainActivity.fmconvert).hide(MainActivity.fmset).show(MainActivity.fmset).commit();
                    MainActivity.viewid = 4;					
					break;
				default:
					break;
				}
            }

//            final MainActivity this$0;
//
//            
//            {
//                this$0 = MainActivity.this;
//                super();
//            }
        }
;
    }

    private void Exit()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle("\u63D0\u793A");
        builder.setIcon(0x7f02002c);
        builder.setMessage("\u662F\u5426\u8981\u9000\u51FA\u300A\u5B9D\u5B9D\u97F3\u4E50\u300B");
        builder.setPositiveButton("\u662F", new android.content.DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialoginterface, int i)
            {
                System.exit(0);
            }

//            final MainActivity this$0;
//
//            
//            {
//                this$0 = MainActivity.this;
//                super();
//            }
        }
);
        builder.setNeutralButton("\u8BC4\u4EF7", new android.content.DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialoginterface, int i)
            {
                Intent intent1 = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("market://details?id=")).append(getPackageName()).toString()));
                intent1.addFlags(0x10000000);
                startActivity(intent1);
            }

//            final MainActivity this$0;
//
//            
//            {
//                this$0 = MainActivity.this;
//                super();
//            }
        }
);
        builder.setNegativeButton("\u5426", new android.content.DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

//            final MainActivity this$0;
//
//            
//            {
//                this$0 = MainActivity.this;
//                super();
//            }
        }
);
        builder.show();
    }

    private void init()
    {
        bt1 = (Button)findViewById(0x7f070005);
        bt2 = (Button)findViewById(0x7f070006);
        bt3 = (Button)findViewById(0x7f070007);
        bt4 = (Button)findViewById(0x7f070008);
        ma = this;
        intent = new Intent();
        intent.setAction("com.baoyi.guoyiyun.service.DownService");
        Constant.musicplaymode = getSharedPreferences("sp", 0).getInt("mode", 1);
        mputil = new MediaplayUtil();
        fmnet = new NetFragmen();
        fmlocal = new LocalMuiscFragmen();
        fmconvert = new ConvertFragment();
        fmset = new SettingFragment();
        getSupportFragmentManager().beginTransaction().add(0x7f07000a, fmnet).add(0x7f07000a, fmlocal).add(0x7f07000a, fmconvert).add(0x7f07000a, fmset).commit();
        bt1.setOnClickListener(ocl);
        bt2.setOnClickListener(ocl);
        bt3.setOnClickListener(ocl);
        bt4.setOnClickListener(ocl);
        getSupportFragmentManager().beginTransaction().hide(fmnet).hide(fmlocal).hide(fmconvert).hide(fmset).show(fmnet).commit();
    }

    public void finish()
    {
        if(MediaplayUtil.mp != null)
            MediaplayUtil.mp.stop();
        super.finish();
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if(getResources().getConfiguration().orientation != 2)
        {
            int _tmp = getResources().getConfiguration().orientation;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03000a);
//        AdcocoaPopupAd.init(this);
//        UmsAgent.update(this);
        init();
//        DianJinPlatform.initialize(this, 36015, "ff3c7360c3c92f637cc958a153bb69c3");
//        ((AdBanner)findViewById(0x7f070073)).setAdListener(new AdBannerListener() {
//
//            public void onReceiveFailed()
//            {
//            }
//
//            public void onReceiveSucceed()
//            {
//            }
//
//            final MainActivity this$0;
//
//            
//            {
//                this$0 = MainActivity.this;
//                super();
//            }
//        }
//        		);
//        DianJinPlatform.setAppActivatedListener(new AppActivatedListener() {
//
//            public void onAppActivatedResponse(int i)
//            {
//                switch(i)
//                {
//                case 7: // '\007'
//                case 8: // '\b'
//                case 9: // '\t'
//                default:
//                    return;
//                }
//            }
//
//            final MainActivity this$0;
//
//            
//            {
//                this$0 = MainActivity.this;
//                super();
//            }
//        }
//);
//        AdcocoaPopupAd.setCloseableOnBackPressd(false);
//        AdcocoaPopupAd.prepareAndOpen(this, new AdcocoaPopupAdListener() {
//
//            public void onError(int i, String s)
//            {
//            }
//
//            public void onSucceed()
//            {
//            }
//
//            final MainActivity this$0;
//
//            
//            {
//                this$0 = MainActivity.this;
//                super();
//            }
//        }
//);
//        Min.getInstance(this).getM(getApplicationContext(), "92c59f419c76e9f839acf5e9f5e1957b", 2);
    }

    protected void onDestroy()
    {
//        AdcocoaPopupAd.destroy(this);
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        boolean flag = true;
        if(i == 4 && keyevent.getAction() == 0 && viewid != 1/*flag*/)
        {
            if(viewid == 31 && fmconvert_talkinfo != null)
            {
                getSupportFragmentManager().beginTransaction().remove(fmconvert_talkinfo).commit();
                getSupportFragmentManager().beginTransaction().hide(fmnet).hide(fmlocal).hide(fmconvert).hide(fmset).show(fmconvert).commit();
            } else
            if(viewid == 32 && fmconvert_newtalk != null)
            {
                getSupportFragmentManager().beginTransaction().remove(fmconvert_newtalk).commit();
                getSupportFragmentManager().beginTransaction().hide(fmnet).hide(fmlocal).hide(fmconvert).hide(fmset).show(fmconvert).commit();
            } else
            {
                bt1.setBackgroundResource(0x7f050012);
                bt2.setBackgroundResource(0x7f020023);
                bt3.setBackgroundResource(0x7f020021);
                bt4.setBackgroundResource(0x7f020027);
                getSupportFragmentManager().beginTransaction().hide(fmnet).hide(fmlocal).hide(fmconvert).hide(fmset).show(fmnet).commit();
                viewid = ((flag) ? 1 : 0);
            }
        } else
        {
            Exit();
            flag = super.onKeyDown(i, keyevent);
        }
        return flag;
    }

    public static Fragment fmconvert;
    public static Fragment fmconvert_newtalk;
    public static Fragment fmconvert_talkinfo;
    public static Fragment fmlocal;
    public static Fragment fmnet;
    public static Fragment fmset;
    public static Handler hd = new Handler() {

        public void handleMessage(Message message)
        {
            HttpDownloader.ok = true;
            if(message.what == 0)
                (new android.app.AlertDialog.Builder(MainActivity.ma)).setMessage((new StringBuilder(String.valueOf((String)message.obj))).append("\u4E0B\u8F7D\u5B8C\u6210").append("\u8BF7\u67E5\u627Esd\u5361babymusic/song\u76EE\u5F55").toString()).setPositiveButton("\u786E\u5B9A", new android.content.DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.cancel();
                    }

//                    final _cls2 this$1;

                    
//                    {
//                        this$1 = _cls2.this;
//                        super();
//                    }
                }
).show();
            if(message.what == 1)
                Toast.makeText(MainActivity.ma, (String)message.obj, 2000).show();
        }

    }
;
    public static Intent intent;
    public static MainActivity ma;
    public static MediaplayUtil mputil;
    public static int viewid = 1;
    private Button bt1;
    private Button bt2;
    private Button bt3;
    private Button bt4;
    private android.view.View.OnClickListener ocl;





}
