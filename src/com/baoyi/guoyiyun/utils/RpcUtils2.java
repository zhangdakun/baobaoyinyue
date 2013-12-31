// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.baoyi.guoyiyun.utils;

import android.util.Log;
import com.iring.dao.MusicDao;
import java.net.URL;
import org.json.rpc.client.HttpJsonRpcClientTransport;
import org.json.rpc.client.JsonRpcInvoker;

public class RpcUtils2
{

    public RpcUtils2()
    {
    }

    public static Object getApi(String s, Object obj)
    {
        Object obj1 = null;
        Object obj2;
        try {
			

        HttpJsonRpcClientTransport httpjsonrpcclienttransport = new HttpJsonRpcClientTransport(new URL(url));
        JsonRpcInvoker jsonrpcinvoker = new JsonRpcInvoker();
        Class aclass[] = new Class[1];
        aclass[0] = obj.getClass();
        obj1 = jsonrpcinvoker.get(httpjsonrpcclienttransport, "commentRpcimpl", aclass);
//        obj1 = obj2;
		} catch (Exception e) {
			// TODO: handle exception
		}
//_L2:
//        return obj1;
//        Exception exception;
//        exception;
//        exception.printStackTrace();
//        if(true) goto _L2; else goto _L1
//_L1:
        return obj1;
    }

    public static Object getDao(String s, Class class1)
    {
        Object obj = null;
        Object obj1;
        try {
			

        HttpJsonRpcClientTransport httpjsonrpcclienttransport = new HttpJsonRpcClientTransport(new URL(url));
        JsonRpcInvoker jsonrpcinvoker = new JsonRpcInvoker();
        Class aclass[] = new Class[1];
        aclass[0] = class1;
        obj1 = jsonrpcinvoker.get(httpjsonrpcclienttransport, s, aclass);
        obj = obj1;
		} catch (Exception e) {
			// TODO: handle exception
		}
//_L2:
//        return obj;
//        Exception exception;
//        exception;
//        exception.printStackTrace();
//        Log.i("test", "exception");
//        if(true) goto _L2; else goto _L1
//_L1:
        return obj;
    }

    public static MusicDao getMusicDao()
    {
        MusicDao musicdao = null;
        try
        {
            HttpJsonRpcClientTransport httpjsonrpcclienttransport = new HttpJsonRpcClientTransport(new URL(mp3url));
            JsonRpcInvoker jsonrpcinvoker = new JsonRpcInvoker();
            Class aclass[] = new Class[1];
            aclass[0] = MusicDao.class;
            musicdao = (MusicDao)jsonrpcinvoker.get(httpjsonrpcclienttransport, "musicDao", aclass);
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        return musicdao;
    }

    static String mp3url = "http://iring.wutianxia.com:8080/iting/v4";
    static String url = "http://iring.wutianxia.com:8080/BabyMusicServer/v4";

}
