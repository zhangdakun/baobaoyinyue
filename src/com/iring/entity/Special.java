// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.iring.entity;

import java.io.Serializable;

public class Special
    implements Serializable
{

    public Special()
    {
    }

    public String getArtistid()
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

    public Integer getId()
    {
        return id;
    }

    public String getPicture()
    {
        return picture;
    }

    public String getSort()
    {
        return sort;
    }

    public int getUid()
    {
        return uid;
    }

    public void setArtistid(String s)
    {
        artistid = s;
    }

    public void setCategoryid(int i)
    {
        categoryid = i;
    }

    public void setCatname(String s)
    {
        catname = s;
    }

    public void setId(Integer integer)
    {
        id = integer;
    }

    public void setPicture(String s)
    {
        picture = s;
    }

    public void setSort(String s)
    {
        sort = s;
    }

    public void setUid(int i)
    {
        uid = i;
    }

    public String toString()
    {
        return (new StringBuilder("Special [id=")).append(id).append(", categoryid=").append(categoryid).append(", catname=").append(catname).append(", uid=").append(uid).append(", artistid=").append(artistid).append(", picture=").append(picture).append(",sort=").append(sort).append(",]").toString();
    }

    private String artistid;
    private int categoryid;
    private String catname;
    private Integer id;
    private String picture;
    private String sort;
    private int uid;
}
