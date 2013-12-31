// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.baoyi.guoyiyun.bean;

import com.iring.entity.Music;

public class MusicBean extends Music
{

    public MusicBean()
    {
        ischecked = false;
        time = 0;
        btvis = 8;
    }

    public int getBtvis()
    {
        return btvis;
    }

    public String getFilepath()
    {
        return filepath;
    }

    public int getIdinsys()
    {
        return idinsys;
    }

    public int getTime()
    {
        return time;
    }

    public boolean isIschecked()
    {
        return ischecked;
    }

    public void setBtvis(int i)
    {
        btvis = i;
    }

    public void setFilepath(String s)
    {
        filepath = s;
    }

    public void setIdinsys(int i)
    {
        idinsys = i;
    }

    public void setIschecked(boolean flag)
    {
        ischecked = flag;
    }

    public void setMusic(Music music)
    {
        setArtist(music.getArtist());
        setArtistid(music.getArtistid());
        setCategoryid(music.getCategoryid());
        setCatname(music.getCatname());
        setDownload(music.getDownload());
        setHit(music.getHit());
        setId(music.getId());
        setIsread(music.getIsread());
        setLyric(music.getLyric());
        setName(music.getName());
        setPic(music.getPic());
        setOrder(music.getOrder());
        setSimeplelyric(music.getSimeplelyric());
        setSpecialid(music.getSpecialid());
        setUrl(music.getUrl());
    }

    public void setTime(int i)
    {
        time = i;
    }

    private int btvis;
    private String filepath;
    private int idinsys;
    private boolean ischecked;
    private int time;
}
