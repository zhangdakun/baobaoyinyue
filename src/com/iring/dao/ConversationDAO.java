// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.iring.dao;

import com.iring.entity.Conversation;
import com.iring.rpc.ConversationRpc;

public interface ConversationDAO
{

    public abstract ConversationRpc add(Conversation conversation);

    public abstract ConversationRpc qureyall(int i);

    public abstract Integer qureyitemnum();

    public abstract ConversationRpc qureylike(String s, int i);

    public abstract Integer qureylikeitemnum(String s);
}
