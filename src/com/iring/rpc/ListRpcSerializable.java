// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.iring.rpc;

import java.util.List;

import com.iring.entity.Music;

// Referenced classes of package com.iring.rpc:
//            RpcSerializable

public class ListRpcSerializable extends RpcSerializable
{

    public ListRpcSerializable()
    {
    }

    public List getDatas()
    {
        return datas;
    }

    public void setDatas(List list)
    {
        datas = list;
    }

    private List<Music> datas;
}
