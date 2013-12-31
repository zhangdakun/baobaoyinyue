// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.baoyi.guoyiyun.util;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baoyi.guoyiyun.babymusic.MainActivity;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.baoyi.guoyiyun.util:
//            FileUtils

public class HttpDownloader
{

    public HttpDownloader()
    {
        url = null;
    }

    public int downFile(Context context, String s, String s1, String s2)
    {
//        BufferedInputStream bufferedinputstream;
//        FileUtils fileutils;
//        ok = false;
//        name = s2;
//        Log.i("test", (new StringBuilder("down:")).append(s1).append(":").append(s).toString());
//        bufferedinputstream = null;
//        fileutils = new FileUtils();
//        if(!fileutils.isFileExist((new StringBuilder(String.valueOf(s1))).append(s2).toString())) goto _L2; else goto _L1
//_L1:
//        int i;
//        Message message2 = MainActivity.hd.obtainMessage();
//        message2.what = 1;
//        message2.obj = (new StringBuilder(String.valueOf(s2))).append("\u6587\u4EF6\u5DF2\u5B58\u5728").toString();
//        ok = true;
//        Log.i("test", (String)message2.obj);
//        MainActivity.hd.sendMessage(message2);
//        name = null;
//        i = 1;
//_L4:
//        return i;
//_L2:
//        bufferedinputstream = getInputSreamFromUrl(s);
//        if(fileutils.writeDataToSDCrard(s1, s2, bufferedinputstream) != null)
//            break MISSING_BLOCK_LABEL_375;
//        Message message1 = MainActivity.hd.obtainMessage();
//        message1.what = 1;
//        message1.obj = (new StringBuilder(String.valueOf(s2))).append("\u4E0B\u8F7D\u5931\u8D25").toString();
//        ok = true;
//        MainActivity.hd.sendMessage(message1);
//        name = null;
//        Log.i("test", (String)message1.obj);
//        if(bufferedinputstream != null)
//            try
//            {
//                bufferedinputstream.close();
//            }
//            catch(IOException ioexception4)
//            {
//                ioexception4.printStackTrace();
//                Log.i("test", "bbbbbbbbb");
//                i = -1;
//                continue; /* Loop/switch isn't completed */
//            }
//        i = -1;
//        continue; /* Loop/switch isn't completed */
//        IOException ioexception1;
//        ioexception1;
//        ioexception1.printStackTrace();
//        Log.i("test", "aaaaaaaaa");
//        if(bufferedinputstream != null)
//            try
//            {
//                bufferedinputstream.close();
//            }
//            catch(IOException ioexception2)
//            {
//                ioexception2.printStackTrace();
//                Log.i("test", "bbbbbbbbb");
//                i = -1;
//                continue; /* Loop/switch isn't completed */
//            }
//        i = -1;
//        continue; /* Loop/switch isn't completed */
//        Exception exception;
//        exception;
//        if(bufferedinputstream != null)
//            try
//            {
//                bufferedinputstream.close();
//            }
//            catch(IOException ioexception)
//            {
//                ioexception.printStackTrace();
//                Log.i("test", "bbbbbbbbb");
//                i = -1;
//                continue; /* Loop/switch isn't completed */
//            }
//        throw exception;
//        if(bufferedinputstream == null)
//            break MISSING_BLOCK_LABEL_385;
//        bufferedinputstream.close();
//        Log.i("test", "\uFFFD\uFFFD\uFFFD\u0633\u0279\uFFFD\uFFFD\uFFFD\uFFFD\u0633\u0279\uFFFD\uFFFD\uFFFD\uFFFD\u0633\u0279\uFFFD\uFFFD\uFFFD\uFFFD\u0633\u0279\uFFFD\uFFFD\uFFFD\uFFFD\u0633\u0279\uFFFD\uFFFD\uFFFD\uFFFD\u0633\u0279\uFFFD\uFFFD\uFFFD\uFFFD\u0633\u0279\uFFFD\uFFFD\uFFFD\uFFFD\u0633\u0279\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD");
//        Message message = MainActivity.hd.obtainMessage();
//        message.obj = s2;
//        message.what = 0;
//        ok = true;
//        MainActivity.hd.sendMessage(message);
//        Log.i("test", (String)message.obj);
//        name = null;
//        i = 0;
//        continue; /* Loop/switch isn't completed */
//        IOException ioexception3;
//        ioexception3;
//        ioexception3.printStackTrace();
//        Log.i("test", "bbbbbbbbb");
//        i = -1;
//        if(true) goto _L4; else goto _L3
//_L3:
    	return 0;
    }

    public BufferedInputStream getInputSreamFromUrl(String s)
        throws IOException
    {
        url = new URL(s);
        return new BufferedInputStream(((HttpURLConnection)url.openConnection()).getInputStream());
    }

    public static String name;
    public static boolean ok;
    private URL url;
}
