// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.baoyi.guoyiyun.myview;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.*;
import android.widget.*;
import com.baoyi.guoyiyun.babymusic.MainActivity;
import com.baoyi.guoyiyun.bean.MusicBean;
import com.baoyi.guoyiyun.util.MediaplayUtil;
import com.boyi.guoyiyun.adapter.BofangListAdapter;
import java.util.List;

public class MyDragListView extends ListView
{

    public MyDragListView(Context context1, AttributeSet attributeset)
    {
        super(context1, attributeset);
        islongselect = false;
        context = context1;
        scaledTouchSlop = ViewConfiguration.get(context1).getScaledTouchSlop();
    }

    public boolean isIslongselect()
    {
        return islongselect;
    }

    public void onDrag(int i)
    {
//        byte byte0;
//        if(dragImageView != null)
//        {
//            windowParams.alpha = 0.8F;
//            windowParams.y = (i - dragPoint) + dragOffset;
//            windowManager.updateViewLayout(dragImageView, windowParams);
//        }
//        int j = pointToPosition(0, i);
//        if(j != -1)
//            dragPosition = j;
//        byte0 = 0;
//        if(i >= upScrollBounce) goto _L2; else goto _L1
//_L1:
//        byte0 = 8;
//_L4:
//        if(byte0 != 0)
//            setSelectionFromTop(dragPosition, byte0 + getChildAt(dragPosition - getFirstVisiblePosition()).getTop());
//        return;
//_L2:
//        if(i > downScrollBounce)
//            byte0 = -8;
//        if(true) goto _L4; else goto _L3
//_L3:
    }

    public void onDrop(int i)
    {
        int j = pointToPosition(0, i);
        if(j != -1)
            dragPosition = j;
        if(i < getChildAt(0).getTop())
            dragPosition = 0;
        else
        if(i > getChildAt(-1 + getChildCount()).getBottom())
            dragPosition = -2 + getAdapter().getCount();
        if(dragPosition >= 0 && dragPosition < -1 + getAdapter().getCount())
        {
            final BofangListAdapter adapter = (BofangListAdapter)((HeaderViewListAdapter)getAdapter()).getWrappedAdapter();
            if(dragSrcPosition != dragPosition)
            {
                MusicBean musicbean = (MusicBean)adapter.getItem(dragSrcPosition);
                adapter.getMusics().remove(dragSrcPosition);
                adapter.getMusics().add(dragPosition, musicbean);
                adapter.notifyDataSetChanged();
            } else
            {
                (new android.app.AlertDialog.Builder(context)).setMessage("\u0237\uFFFD\uFFFD\u027E\uFFFD\uFFFD").setNegativeButton("\u0221\uFFFD\uFFFD", new android.content.DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialoginterface, int k)
                    {
                        dialoginterface.cancel();
                    }
//
//                    final MyDragListView this$0;
//
//            
//            {
//                this$0 = MyDragListView.this;
//                super();
//            }
                }
).setPositiveButton("\u0237\uFFFD\uFFFD", new android.content.DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialoginterface, int k)
                    {
                        adapter.getMusics().remove(dragSrcPosition);
                        if(dragSrcPosition == MainActivity.mputil.getPosition() && MediaplayUtil.mp.isPlaying())
                            MediaplayUtil.mp.stop();
                        adapter.notifyDataSetChanged();
                    }

//                    final MyDragListView this$0;
//                    private final BofangListAdapter val$adapter;
//
//            
//            {
//                this$0 = MyDragListView.this;
//                adapter = bofanglistadapter;
//                super();
//            }
                }
).show();
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        boolean flag;
        if(motionevent.getAction() == 0)
        {
            int i = (int)motionevent.getX();
            int j = (int)motionevent.getY();
            int k = getWidth();
            int l = pointToPosition(i, j);
            dragPosition = l;
            dragSrcPosition = l;
            if(dragPosition == -1)
            {
                flag = super.onInterceptTouchEvent(motionevent);
            } else
            {
                if(islongselect && i > (k * 2) / 3)
                {
                    Log.i("test", (new StringBuilder()).append(dragPosition).append(":").append(getFirstVisiblePosition()).append(":").append(((MusicBean)((BofangListAdapter)((HeaderViewListAdapter)getAdapter()).getWrappedAdapter()).getMusics().get(dragPosition)).getName()).toString());
                    ViewGroup viewgroup = (ViewGroup)getChildAt(dragPosition - getFirstVisiblePosition());
                    String s = ((TextView)viewgroup.findViewById(0x7f070018)).getText().toString();
                    Log.i("test", s);
                    ((TextView)viewgroup.findViewById(0x7f070018)).setText(s);
                    ((CheckBox)viewgroup.findViewById(0x7f07001a)).setChecked(((CheckBox)viewgroup.findViewById(0x7f07001a)).isChecked());
                    ((TextView)viewgroup.findViewById(0x7f070019)).setText(((TextView)viewgroup.findViewById(0x7f070019)).getText().toString());
                    dragPoint = j - viewgroup.getTop();
                    dragOffset = (int)(motionevent.getRawY() - (float)j);
                    upScrollBounce = Math.min(j - scaledTouchSlop, getHeight() / 3);
                    downScrollBounce = Math.max(j + scaledTouchSlop, (2 * getHeight()) / 3);
                    viewgroup.setDrawingCacheEnabled(true);
                    startDrag(Bitmap.createBitmap(viewgroup.getDrawingCache()), j);
                }
                flag = false;
            }
        } else
        {
            flag = super.onInterceptTouchEvent(motionevent);
        }
        return flag;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
//        if(dragImageView == null || dragPosition == -1)
//            break MISSING_BLOCK_LABEL_78;
//        motionevent.getAction();
//        JVM INSTR tableswitch 1 2: default 44
//    //                   1 48
//    //                   2 66;
//           goto _L1 _L2 _L3
//_L1:
//        boolean flag = true;
//_L4:
//        return flag;
//_L2:
//        int i = (int)motionevent.getY();
//        stopDrag();
//        onDrop(i);
//          goto _L1
//_L3:
//        onDrag((int)motionevent.getY());
//          goto _L1
//        flag = super.onTouchEvent(motionevent);
//          goto _L4
    	return false;
    }

    public void setIslongselect(boolean flag)
    {
        islongselect = flag;
    }

    public void startDrag(Bitmap bitmap, int i)
    {
        stopDrag();
        windowParams = new android.view.WindowManager.LayoutParams();
        windowParams.gravity = 48;
        windowParams.x = 0;
        windowParams.y = (i - dragPoint) + dragOffset;
        windowParams.width = -2;
        windowParams.height = -2;
        windowParams.flags = 408;
        windowParams.format = -3;
        windowParams.windowAnimations = 0;
        dragImageView = new ImageView(getContext());
        dragImageView.setImageBitmap(bitmap);
        windowManager = (WindowManager)getContext().getSystemService("window");
        windowManager.addView(dragImageView, windowParams);
    }

    public void stopDrag()
    {
        if(dragImageView != null)
        {
            windowManager.removeView(dragImageView);
            dragImageView = null;
        }
    }

    private Context context;
    private int downScrollBounce;
    private ImageView dragImageView;
    private int dragOffset;
    private int dragPoint;
    private int dragPosition;
    private int dragSrcPosition;
    private boolean islongselect;
    private int scaledTouchSlop;
    private int upScrollBounce;
    private WindowManager windowManager;
    private android.view.WindowManager.LayoutParams windowParams;

}
