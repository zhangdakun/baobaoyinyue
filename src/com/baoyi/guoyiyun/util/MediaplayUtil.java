// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.baoyi.guoyiyun.util;

import android.media.MediaPlayer;
import android.os.*;
import android.util.Log;
import com.baoyi.guoyiyun.babymusic.LocalMuiscFragmen;
import com.baoyi.guoyiyun.babymusic.NetFragmen;
import com.baoyi.guoyiyun.bean.MusicBean;
import com.baoyi.guoyiyun.constant.Constant;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class MediaplayUtil
{

    public MediaplayUtil()
    {
        bthhstart = false;
        thfirst = false;
        mp = new MediaPlayer();
        (new Thread(new Runnable() {

            public void run()
            {
                do
                {
                    if(!MediaplayUtil.b)
                        return;
                    try
                    {
                        Thread.sleep(1000L);
                        sendposition();
                    }
                    catch(Exception exception)
                    {
                        exception.printStackTrace();
                    }
                } while(true);
            }

//            final MediaplayUtil this$0;
//
//            
//            {
//                this$0 = MediaplayUtil.this;
//                super();
//            }
        }
)).start();
        mp.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer mediaplayer)
            {
//                if(MediaplayUtil.mslv == null) goto _L2; else goto _L1
//_L1:
//                Constant.musicplaymode;
//                JVM INSTR tableswitch 0 2: default 36
//            //                           0 37
//            //                           1 58
//            //                           2 144;
//                   goto _L2 _L3 _L4 _L5
//_L2:
//                return;
//_L3:
//                start(MediaplayUtil.mslv, position);
//                continue; /* Loop/switch isn't completed */
//_L4:
//                MediaplayUtil mediaplayutil = MediaplayUtil.this;
//                mediaplayutil.position = 1 + mediaplayutil.position;
//                if(position == MediaplayUtil.mslv.size())
//                    start(MediaplayUtil.mslv, 0);
//                else
//                    start(MediaplayUtil.mslv, position);
//                sendselection(position);
//                continue; /* Loop/switch isn't completed */
//_L5:
//                int i = (int)(Math.random() * (double)MediaplayUtil.mslv.size());
//                start(MediaplayUtil.mslv, i);
//                sendselection(i);
//                if(true) goto _L2; else goto _L6
//_L6:
            }

//            final MediaplayUtil this$0;
//
//            
//            {
//                this$0 = MediaplayUtil.this;
//                super();
//            }
        }
);
    }

    public static void close()
    {
        b = false;
        if(mp.isPlaying())
        {
            mp.stop();
            mp.release();
            mp = null;
        }
    }

    private void sendposition()
    {
//        if(!thfirst || !mp.isPlaying()) goto _L2; else goto _L1
//_L1:
//        if(!typeb) goto _L4; else goto _L3
//_L3:
//        Message message1 = LocalMuiscFragmen.hand.obtainMessage();
//        message1.what = 1;
//        message1.arg1 = mp.getCurrentPosition();
//        int i = ((MusicBean)mslv.get(position)).getTime();
//        message1.arg2 = (int)(200F * ((float)message1.arg1 / (float)i));
//        LocalMuiscFragmen.hand.sendMessage(message1);
//_L6:
//        if(!b)
//        {
//            mp.stop();
//            mp.release();
//        }
//_L2:
//        return;
//_L4:
//        if(NetFragmen.hand != null && bthhstart)
//        {
//            Message message = NetFragmen.hand.obtainMessage();
//            message.what = 5;
//            message.arg1 = mp.getCurrentPosition();
//            message.arg2 = (int)(200F * ((float)message.arg1 / (float)urlmusictime));
//            NetFragmen.hand.sendMessage(message);
//        }
//        if(true) goto _L6; else goto _L5
//_L5:
    }

    private void sendselection(int i)
    {
        Message message = LocalMuiscFragmen.hand.obtainMessage();
        message.what = 5;
        message.arg1 = i;
        LocalMuiscFragmen.hand.handleMessage(message);
    }

    public List getMslv()
    {
        return mslv;
    }

    public int getPosition()
    {
        return position;
    }

    public int getUrlmusictime()
    {
        return urlmusictime;
    }

    public String getUrlname()
    {
        return urlname;
    }

    public boolean isTypeb()
    {
        return typeb;
    }

    public boolean nextMusic()
    {
        boolean flag = false;
//        if(mslv == null) goto _L2; else goto _L1
//_L1:
//        if(!mp.isPlaying())
//        {
//            mp.stop();
//            mp.reset();
//            flag = true;
//        }
//        Constant.musicplaymode;
//        JVM INSTR tableswitch 0 2: default 60
//    //                   0 62
//    //                   1 77
//    //                   2 137;
//           goto _L2 _L3 _L4 _L5
//_L2:
//        return flag;
//_L3:
//        start(mslv, position);
//        continue; /* Loop/switch isn't completed */
//_L4:
//        position = 1 + position;
//        if(position == mslv.size())
//            start(mslv, 0);
//        else
//            start(mslv, position);
//        sendselection(position);
//        continue; /* Loop/switch isn't completed */
//_L5:
//        int i = (int)(Math.random() * (double)mslv.size());
//        start(mslv, i);
//        sendselection(i);
//        if(true) goto _L2; else goto _L6
//_L6:
        return false;
    }

    public void pause()
    {
        if(mp.isPlaying())
            mp.pause();
    }

    public boolean preMusic()
    {
        boolean flag = false;
//        if(mslv == null) goto _L2; else goto _L1
//_L1:
//        if(!mp.isPlaying())
//        {
//            mp.stop();
//            mp.reset();
//            flag = true;
//        }
//        Constant.musicplaymode;
//        JVM INSTR tableswitch 0 2: default 60
//    //                   0 62
//    //                   1 77
//    //                   2 140;
//           goto _L2 _L3 _L4 _L5
//_L2:
//        return flag;
//_L3:
//        start(mslv, position);
//        continue; /* Loop/switch isn't completed */
//_L4:
//        position = -1 + position;
//        if(position < 0)
//            start(mslv, -1 + mslv.size());
//        else
//            start(mslv, position);
//        sendselection(position);
//        continue; /* Loop/switch isn't completed */
//_L5:
//        int i = (int)(Math.random() * (double)mslv.size());
//        start(mslv, i);
//        sendselection(i);
//        if(true) goto _L2; else goto _L6
//_L6:
        return false;
    }

    public void restart()
    {
        if(!mp.isPlaying())
            mp.start();
    }

    public void setMslv(List list)
    {
        mslv = list;
    }

    public void setPosition(int i)
    {
        position = i;
    }

    public void setTypeb(boolean flag)
    {
        typeb = flag;
    }

    public void setUrlmusictime(int i)
    {
        urlmusictime = i;
    }

    public void setUrlname(String s)
    {
        urlname = s;
    }

    public int start(List list, final int position)
    {
        if(list != null)
        {
            mslv = list;
            this.position = position;
        }
        if(!thfirst)
        {
            Log.i("test", "\uFFFD\uFFFD\u04BB\uFFFD\u03B2\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD");
            thfirst = true;
        }
        if(mp.isPlaying())
            stop();
        NetFragmen.back = 1;
        mp.reset();
        mp.setAudioStreamType(3);
//        if(list == null || list.size() <= 0) goto _L2; else goto _L1
//_L1:
//        if(((MusicBean)mslv.get(position)).getFilepath() != null && (((MusicBean)mslv.get(position)).getUrl() == null || ((MusicBean)mslv.get(position)).getUrl().equals(""))) goto _L4; else goto _L3
//_L3:
        MusicBean musicbean = (MusicBean)mslv.get(position);
        final String fs = (new StringBuilder(String.valueOf((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").toString()))).append("babymusic/song/").append(musicbean.getName()).append(".mp3").toString();
        final File f = new File(fs);
        asy = null;
        urlname = null;
        urlmusictime = 0;
        typeb = false;
        bthhstart = false;
        asy = new AsyncTask() {

            protected Integer doInBackground(Integer ainteger[])
            {
                try
                {
                    NetFragmen.hand.sendEmptyMessage(1);
                    urlname = (new StringBuilder("http://iring.wutianxia.com:8999")).append(((MusicBean)MediaplayUtil.mslv.get(position)).getUrl()).toString();
                    Log.i("test", (new StringBuilder("mp.url:")).append(urlname).toString());
                    if(f.exists())
                        MediaplayUtil.mp.setDataSource(fs);
                    else
                        MediaplayUtil.mp.setDataSource(urlname);
                    MediaplayUtil.mp.prepare();
                    MediaplayUtil.mp.start();
                    urlmusictime = MediaplayUtil.mp.getDuration();
                    bthhstart = true;
                    NetFragmen.hand.sendEmptyMessage(2);
                }
                catch(IllegalArgumentException illegalargumentexception1)
                {
                    illegalargumentexception1.printStackTrace();
                    MediaplayUtil.mp.reset();
                    NetFragmen.back = 2;
                }
                catch(SecurityException securityexception1)
                {
                    securityexception1.printStackTrace();
                    MediaplayUtil.mp.reset();
                    NetFragmen.back = 2;
                }
                catch(IllegalStateException illegalstateexception1)
                {
                    illegalstateexception1.printStackTrace();
                    MediaplayUtil.mp.reset();
                    NetFragmen.back = 2;
                }
                catch(IOException ioexception1)
                {
                    ioexception1.printStackTrace();
                    MediaplayUtil.mp.reset();
                    NetFragmen.back = 2;
                }
                return null;
            }

            protected Object doInBackground(Object aobj[])
            {
                return doInBackground((Integer[])aobj);
            }

//            final MediaplayUtil this$0;
//            private final File val$f;
//            private final String val$fs;
//            private final int val$position;
//
//            
//            {
//                this$0 = MediaplayUtil.this;
//                position = i;
//                f = file;
//                fs = s;
//                super();
//            }
        }
;
        asy.execute(new Integer[0]);
//_L5:
//        NetFragmen.back = 0;
//_L2:
//        int i = 0;
//_L6:
//        return i;
//_L4:
//        mp.setDataSource(((MusicBean)mslv.get(position)).getFilepath());
//        typeb = true;
//        mp.prepare();
//        mp.start();
//          goto _L5
//        IllegalArgumentException illegalargumentexception;
//        illegalargumentexception;
//        illegalargumentexception.printStackTrace();
//        NetFragmen.back = 2;
//        mp.reset();
//        i = 2;
//          goto _L6
//        SecurityException securityexception;
//        securityexception;
//        securityexception.printStackTrace();
//        mp.reset();
//        NetFragmen.back = 2;
//        i = 2;
//          goto _L6
//        IllegalStateException illegalstateexception;
//        illegalstateexception;
//        illegalstateexception.printStackTrace();
//        mp.reset();
//        NetFragmen.back = 2;
//        i = 2;
//          goto _L6
//        IOException ioexception;
//        ioexception;
//        ioexception.printStackTrace();
//        mp.reset();
//        NetFragmen.back = 2;
//        i = 2;
//          goto _L6
        
        return 0;
    }

    public void stop()
    {
        mp.stop();
    }

    public static final String HTTPTITLE = "http://iring.wutianxia.com:8999";
    private static AsyncTask asy;
    private static boolean b = true;
    public static MediaPlayer mp;
    private static List mslv;
    private boolean bthhstart;
    private int position;
    private boolean thfirst;
    private boolean typeb;
    private int urlmusictime;
    private String urlname;











}
