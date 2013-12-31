// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.iring.dao;

import com.iring.entity.Music;
import com.iring.rpc.MusicRpc;
import com.iring.rpc.RpcSerializable;

public interface MusicDao
{

    public abstract RpcSerializable downMusic(int i);

    public abstract Music findById(int i);

    public abstract MusicRpc pageByArtist(int i, int j, int k);

    public abstract MusicRpc pageByHot(int i, int j);

    public abstract MusicRpc pageByHotDay(int i, int j);

    public abstract MusicRpc pageByHotMonth(int i, int j);

    public abstract MusicRpc pageByHotWeek(int i, int j);

    public abstract MusicRpc pageByNew(int i, int j);

    public abstract MusicRpc pageByRecommend(int i, int j);

    public abstract MusicRpc pageBySpecial(int i, int j, int k);

    public abstract MusicRpc pageBySpecialTop(int i, int j, int k, int l);

    public abstract MusicRpc pageByTop(int i, int j);

    public abstract MusicRpc pageByType(int i, int j, int k);

    public abstract MusicRpc pageByUserId(int i, int j, int k);

    public abstract MusicRpc search(String s, int i, int j);

    public abstract RpcSerializable upload(Music music, int i);
}
