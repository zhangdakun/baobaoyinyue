// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.boyi.guoyiyun.adapter;

import android.content.Context;
import android.view.*;
import android.widget.*;
import com.baoyi.guoyiyun.bean.MusicBean;
import com.baoyi.guoyiyun.constant.Constant;
import java.util.List;

public class BofangListAdapter extends BaseAdapter
{
    class ViewHolder
    {

        CheckBox cb;
        ImageView iv;
//        final BofangListAdapter this$0;
        TextView time;
        TextView title;

//        ViewHolder()
//        {
//            this$0 = BofangListAdapter.this;
//            super();
//        }
    }


    public BofangListAdapter(Context context)
    {
        len = 0;
        inflater = LayoutInflater.from(context);
    }

    public BofangListAdapter(Context context, List list)
    {
        len = 0;
        inflater = LayoutInflater.from(context);
        musics = list;
    }

    public int getCount()
    {
        int i;
        if(musics == null)
            i = 0;
        else
            i = musics.size();
        return i;
    }

    public Object getItem(int i)
    {
        return musics.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public List getMusics()
    {
        return musics;
    }

    public int getPretype()
    {
        return pretype;
    }

    public int getType()
    {
        return type;
    }

    public int getUrlpos()
    {
        return urlpos;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        ViewHolder viewholder;
        int j;
        if(view == null)
        {
            viewholder = new ViewHolder();
            view = inflater.inflate(0x7f030004, null);
            viewholder.title = (TextView)view.findViewById(0x7f070018);
            viewholder.time = (TextView)view.findViewById(0x7f070019);
            viewholder.cb = (CheckBox)view.findViewById(0x7f07001a);
            viewholder.iv = (ImageView)view.findViewById(0x7f070069);
        } else
        {
            viewholder = (ViewHolder)view.getTag();
        }
        viewholder.title.setText(((MusicBean)musics.get(i)).getName());
        j = ((MusicBean)musics.get(i)).getTime();
        if(j >= 0)
        {
            if(j != 0)
            {
                int k = j / 60000;
                String s;
                int l;
                String s1;
                if(k < 10)
                    s = (new StringBuilder("0")).append(k).toString();
                else
                    s = (new StringBuilder(String.valueOf(""))).append(k).toString();
                l = (j % 60000) / 1000;
                if(l < 10)
                    s1 = (new StringBuilder("0")).append(l).toString();
                else
                    s1 = (new StringBuilder(String.valueOf(""))).append(l).toString();
                viewholder.time.setVisibility(0);
                viewholder.time.setText((new StringBuilder(String.valueOf(s))).append(":").append(s1).toString());
            } else
            {
                viewholder.time.setVisibility(8);
            }
        } else
        {
            viewholder.time.setText("\uFFFD\u0474\uFFFD\uFFFD\uFFFD");
        }
        if((type == Constant.TYPE_CHINESE || type == Constant.TYPE_ENGLISTH) && i == urlpos && pretype == type)
            ((MusicBean)musics.get(i)).setIschecked(true);
        viewholder.cb.setChecked(((MusicBean)musics.get(i)).isIschecked());
        viewholder.iv.setVisibility(((MusicBean)musics.get(i)).getBtvis());
        view.setTag(viewholder);
        return view;
    }

    public void setMusics(List list)
    {
        musics = list;
        if(list == null || list.size() == 0)
            len = 0;
        else
            len = list.size();
    }

    public void setPretype(int i)
    {
        pretype = i;
    }

    public void setType(int i)
    {
        type = i;
    }

    public void setUrlpos(int i)
    {
        urlpos = i;
    }

    private LayoutInflater inflater;
    private int len;
    private List musics;
    private int pretype;
    private int type;
    private int urlpos;
}
