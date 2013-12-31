// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.boyi.guoyiyun.adapter;

import android.content.Context;
import android.view.*;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.iring.entity.Commentary;
import java.text.SimpleDateFormat;
import java.util.List;

public class BackTalkAdapter extends BaseAdapter
{
    class ViewHolder
    {

        TextView content;
        TextView ip;
//        final BackTalkAdapter this$0;
        TextView time;

//        ViewHolder()
//        {
//            this$0 = BackTalkAdapter.this;
//            super();
//        }
    }


    public BackTalkAdapter(Context context)
    {
        inflater = LayoutInflater.from(context);
    }

    public int getCount()
    {
        return len;
    }

    public Object getItem(int i)
    {
        return tbs.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public List getTbs()
    {
        return tbs;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        ViewHolder viewholder;
        String s;
        if(view == null)
        {
            viewholder = new ViewHolder();
            view = inflater.inflate(0x7f030014, null);
            viewholder.ip = (TextView)view.findViewById(0x7f070061);
            viewholder.time = (TextView)view.findViewById(0x7f070063);
            viewholder.content = (TextView)view.findViewById(0x7f070062);
        } else
        {
            viewholder = (ViewHolder)view.getTag();
        }
        viewholder.ip.setText((new StringBuilder(String.valueOf(i + 1))).append("\245").toString());
        s = (new SimpleDateFormat("yyyy-MM-dd")).format(Long.valueOf(((Commentary)tbs.get(i)).getPosttime()));
        viewholder.time.setText(s);
        viewholder.content.setText(((Commentary)tbs.get(i)).getContent());
        view.setTag(viewholder);
        return view;
    }

    public void setTbs(List list)
    {
        tbs = list;
        len = list.size();
    }

    private LayoutInflater inflater;
    private int len;
    private List tbs;
}
