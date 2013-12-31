// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.baoyi.guoyiyun.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.*;
import android.util.Log;
import android.widget.Toast;
import com.baoyi.guoyiyun.util.FileUtils;
import com.baoyi.guoyiyun.util.HttpDownloader;
import java.io.File;

public class DownService extends Service
{

    public DownService()
    {
    }

    public IBinder onBind(Intent intent)
    {
        ds = this;
        return null;
    }

    public void onCreate()
    {
        super.onCreate();
    }

    public void onDestroy()
    {
        super.onDestroy();
        Log.i("test", "service destory");
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        Log.i("test", "asfasfasfasfasfsafasfasf");
        Log.i("test", (new StringBuilder("intent:")).append(intent).toString());
        if(intent != null)
        {
            Bundle bundle = intent.getExtras();
            url = bundle.getString("url");
            name = bundle.getString("name");
            Toast.makeText(getApplicationContext(), (new StringBuilder("\u6B63\u5728\u4E0B\u8F7D")).append(name).append("\u8BF7\u7A0D\u540E...").toString(), 1500).show();
            (new Thread(new Runnable() {

                public void run()
                {
                    Log.i("test", "service thread");
                    FileUtils fileutils = new FileUtils();
                    fileutils.createSDDir("babymusic");
                    fileutils.createSDDir("babymusic/song");
                    int k = (new HttpDownloader()).downFile(getApplicationContext(), url, "babymusic/song/", (new StringBuilder(String.valueOf(name))).append(".mp3").toString());
                    Log.i("test", (new StringBuilder(" a ")).append(k).toString());
                    if(k == 0)
                        scanFileAsync(getApplicationContext(), (new StringBuilder("babymusic/song/")).append(name).append(".mp3").toString());
                }

//                final DownService this$0;
//
//            
//            {
//                this$0 = DownService.this;
//                super();
//            }
            }
)).start();
        }
        return super.onStartCommand(intent, i, j);
    }

    public void scanFileAsync(Context context, String s)
    {
        Log.i("test", (new StringBuilder("has to a service:")).append(s).toString());
        File file = Environment.getExternalStorageDirectory();
        File file1 = new File((new StringBuilder()).append(file.getAbsoluteFile()).append("/").append(s).toString());
        Log.i("test", (new StringBuilder("asdad")).append(file1.exists()).toString());
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.fromFile(file1));
        context.sendBroadcast(intent);
    }

    private DownService ds;
    private String name;
    private String url;


}
