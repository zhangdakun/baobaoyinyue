// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.iring.entity;

import java.io.Serializable;

public class Music
    implements Serializable
{

    public Music()
    {
    }

    public String getArtist()
    {
        return artist;
    }

    public int getArtistid()
    {
        return artistid;
    }

    public int getCategoryid()
    {
        return categoryid;
    }

    public String getCatname()
    {
        return catname;
    }

    public int getDownload()
    {
        return download;
    }

    public int getHit()
    {
        return hit;
    }

    public Integer getId()
    {
        return id;
    }

    public int getIsread()
    {
        return isread;
    }

    public String getLyric()
    {
        return lyric;
    }

    public String getName()
    {
        return name;
    }

    public int getOrder()
    {
        return order;
    }

    public String getPic()
    {
        return pic;
    }

    public String getSimeplelyric()
    {
        return simeplelyric;
    }

    public Integer getSpecialid()
    {
        return specialid;
    }

    public String getSpecialname()
    {
        return specialname;
    }

    public String getUrl()
    {
        return url;
    }

    public void setArtist(String s)
    {
        artist = s;
    }

    public void setArtistid(int i)
    {
        artistid = i;
    }

    public void setCategoryid(int i)
    {
        categoryid = i;
    }

    public void setCatname(String s)
    {
        catname = s;
    }

    public void setDownload(int i)
    {
        download = i;
    }

    public void setHit(int i)
    {
        hit = i;
    }

    public void setId(Integer integer)
    {
        id = integer;
    }

    public void setIsread(int i)
    {
        isread = i;
    }

    public void setLyric(String s)
    {
        lyric = s;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setOrder(int i)
    {
        order = i;
    }

    public void setPic(String s)
    {
        pic = s;
    }

    public void setSimeplelyric(String s)
    {
        simeplelyric = s;
    }

    public void setSpecialid(Integer integer)
    {
        specialid = integer;
    }

    public void setSpecialname(String s)
    {
        specialname = s;
    }

    public void setUrl(String s)
    {
        url = s;
    }

    public String toString()
    {
        return (new StringBuilder("Music [id=")).append(id).append(", url=").append(url).append(", name=").append(name).append(", artist=").append(artist).append(", artistid=").append(artistid).append(", hit=").append(hit).append(", download=").append(download).append(", specialid=").append(specialid).append(", specialname=").append(specialname).append(", categoryid=").append(categoryid).append(", catname=").append(catname).append("]").toString();
    }

    private String artist;
    private int artistid;
    private int categoryid;
    private String catname;
    private int download;
    private int hit;
    private Integer id;
    private int isread;
    private String lyric;
    private String name;
    private int order;
    private String pic;
    private String simeplelyric;
    private Integer specialid;
    private String specialname;
    private String url;
}
