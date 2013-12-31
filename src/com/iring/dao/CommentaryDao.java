// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.iring.dao;

import com.iring.entity.Commentary;
import com.iring.rpc.CommentaryRpc;

public interface CommentaryDao
{

    public abstract CommentaryRpc add(Commentary commentary);

    public abstract CommentaryRpc qureyall(int i, int j);
}
