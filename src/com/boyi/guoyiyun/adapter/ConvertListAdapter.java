// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.boyi.guoyiyun.adapter;

import android.content.Context;
import android.view.*;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.iring.entity.Conversation;
import java.util.List;

public class ConvertListAdapter extends BaseAdapter
{
    class ViewHolder
    {

        TextView backnum;
        TextView content;
//        final ConvertListAdapter this$0;
        TextView title;

//        ViewHolder()
//        {
//            this$0 = ConvertListAdapter.this;
//            super();
//        }
    }


    public ConvertListAdapter(Context context)
    {
        inflater = LayoutInflater.from(context);
    }

    public List getConversations()
    {
        return conversations;
    }

    public int getCount()
    {
        return len;
    }

    public Object getItem(int i)
    {
        Object obj;
        if(conversations == null)
            obj = null;
        else
            obj = conversations.get(i);
        return obj;
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public int getLen()
    {
        return len;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        ViewHolder viewholder;
        if(view == null)
        {
            viewholder = new ViewHolder();
            view = inflater.inflate(0x7f030006, null);
            viewholder.title = (TextView)view.findViewById(0x7f070052);
            viewholder.content = (TextView)view.findViewById(0x7f070053);
            viewholder.backnum = (TextView)view.findViewById(0x7f070054);
            view.setTag(viewholder);
        } else
        {
            viewholder = (ViewHolder)view.getTag();
        }
        if(conversations != null && conversations.size() > 0)
        {
            viewholder.title.setText(((Conversation)conversations.get(i)).getTitle());
            String s = ((Conversation)conversations.get(i)).getContent();
            if(s.length() < 25)
                viewholder.content.setText((new StringBuilder(String.valueOf(s))).append("...").toString());
            else
                viewholder.content.setText((new StringBuilder(String.valueOf(s.substring(0, 25)))).append("...").toString());
            viewholder.backnum.setText((new StringBuilder()).append(((Conversation)conversations.get(i)).getHit()).toString());
        }
        return view;
    }

    public void setConversations(List list)
    {
        conversations = list;
        if(list != null)
        {
            int i;
            if(list.size() != 0)
                i = list.size();
            else
                i = 0;
            len = i;
        }
    }

    public void setLen(int i)
    {
        len = i;
    }

    private List conversations;
    private LayoutInflater inflater;
    private int len;
}
