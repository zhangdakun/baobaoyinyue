// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.boyi.guoyiyun.adapter;

import android.content.Context;
import android.view.*;
import android.widget.*;
import com.baoyi.guoyiyun.bean.Pageitem;
import java.util.ArrayList;
import java.util.List;

public class PageItemAdapter extends BaseAdapter
{
    class ViewHolder
    {

        CheckBox cb;
        TextView id;
//        final PageItemAdapter this$0;

//        ViewHolder()
//        {
//            this$0 = PageItemAdapter.this;
//            super();
//        }
    }


    public PageItemAdapter(Context context, int i)
    {
        inflater = LayoutInflater.from(context);
        pageitems = new ArrayList();
        len = i;
        int j = 0;
        do
        {
            if(j >= i)
                return;
            pageitems.add(new Pageitem(j + 1));
            if(j == 0)
                ((Pageitem)pageitems.get(j)).setB(true);
            j++;
        } while(true);
    }

    public int getCount()
    {
        return len;
    }

    public Object getItem(int i)
    {
        return pageitems.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public int getLen()
    {
        return len;
    }

    public List getPageitems()
    {
        return pageitems;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        ViewHolder viewholder;
        if(view == null)
        {
            viewholder = new ViewHolder();
            view = inflater.inflate(0x7f030005, null);
            viewholder.id = (TextView)view.findViewById(0x7f070050);
            viewholder.cb = (CheckBox)view.findViewById(0x7f07004f);
        } else
        {
            viewholder = (ViewHolder)view.getTag();
        }
        viewholder.id.setText((new StringBuilder()).append(((Pageitem)pageitems.get(i)).getId()).toString());
        viewholder.cb.setChecked(((Pageitem)pageitems.get(i)).isB());
        view.setTag(viewholder);
        return view;
    }

    public void setLen(int i)
    {
        len = i;
    }

    public void setPageitems(List list)
    {
        pageitems = list;
    }

    private LayoutInflater inflater;
    private int len;
    private List pageitems;
}
