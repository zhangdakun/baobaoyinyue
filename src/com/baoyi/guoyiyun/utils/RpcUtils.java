// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.baoyi.guoyiyun.utils;

import java.net.URL;
import org.json.rpc.client.HttpJsonRpcClientTransport;
import org.json.rpc.client.JsonRpcInvoker;

public class RpcUtils
{

    public RpcUtils()
    {
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
        obj = jsonrpcinvoker.get(httpjsonrpcclienttransport, s, aclass);
//        obj = obj1;
		} catch (Exception e) {
			// TODO: handle exception
		}
//_L2:
//        return obj;
//        Exception exception;
//        exception;
//        exception.printStackTrace();
//        if(true) goto _L2; else goto _L1
//_L1:
        return obj;
    }

    static String url = "http://wallpaper.xabaoyi.com:8080/youthfulness/v1";

}
