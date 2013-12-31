// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.baoyi.guoyiyun.myview;

import android.content.Context;
import android.widget.Checkable;

// Referenced classes of package com.baoyi.guoyiyun.myview:
//            DragSortItemView

public class DragSortItemViewCheckable extends DragSortItemView
    implements Checkable
{

    public DragSortItemViewCheckable(Context context)
    {
        super(context);
    }

    public boolean isChecked()
    {
        boolean flag = false;
        android.view.View view = getChildAt(0);
        if(view instanceof Checkable)
            flag = ((Checkable)view).isChecked();
        return flag;
    }

    public void setChecked(boolean flag)
    {
        android.view.View view = getChildAt(0);
        if(view instanceof Checkable)
            ((Checkable)view).setChecked(flag);
    }

    public void toggle()
    {
        android.view.View view = getChildAt(0);
        if(view instanceof Checkable)
            ((Checkable)view).toggle();
    }
}
