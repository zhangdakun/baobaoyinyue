// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.baoyi.guoyiyun.babymusic;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.*;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.*;
import android.widget.*;
import com.baoyi.guoyiyun.bean.MusicBean;
import com.baoyi.guoyiyun.myview.DragSortController;
import com.baoyi.guoyiyun.myview.DragSortListView;
import com.baoyi.guoyiyun.util.MediaplayUtil;
import com.boyi.guoyiyun.adapter.BofangListAdapter;
import com.cn.baoyi.babysong.R;

import java.io.File;
import java.io.PrintStream;
import java.util.*;

// Referenced classes of package com.baoyi.guoyiyun.babymusic:
//            MainActivity

public class LocalMuiscFragmen extends Fragment
{

    public LocalMuiscFragmen()
    {
        first = false;
        contralseektomedia = false;
        onDrop = new com.baoyi.guoyiyun.myview.DragSortListView.DropListener() {

            public void drop(int i, int j)
            {
                if(i != j)
                {
                    MusicBean musicbean = (MusicBean)LocalMuiscFragmen.adapter.getItem(i);
                    LocalMuiscFragmen.adapter.getMusics().remove(i);
                    LocalMuiscFragmen.adapter.getMusics().add(j, musicbean);
                    LocalMuiscFragmen.adapter.notifyDataSetChanged();
                }
            }

//            final LocalMuiscFragmen this$0;
//
//            
//            {
//                this$0 = LocalMuiscFragmen.this;
//                super();
//            }
        }
;
        onRemove = new com.baoyi.guoyiyun.myview.DragSortListView.RemoveListener() {

            public void remove(int i)
            {
                if(MainActivity.mputil.getPosition() == i && MediaplayUtil.mp.isPlaying())
                    MainActivity.mputil.pause();
                File file = new File(((MusicBean)msblv.get(i)).getFilepath());
                if(file.exists())
                    if(file.delete())
                        System.out.println("\u027E\uFFFD\uFFFD\u0279\uFFFD");
                    else
                        System.out.println("\u027E\uFFFD\uFFFD\u02A7\uFFFD\uFFFD");
                LocalMuiscFragmen.adapter.getMusics().remove(i);
                LocalMuiscFragmen.adapter.notifyDataSetChanged();
            }

//            final LocalMuiscFragmen this$0;
//
//            
//            {
//                this$0 = LocalMuiscFragmen.this;
//                super();
//            }
        }
;
        osl = new android.widget.AbsListView.OnScrollListener() {

            public void onScroll(AbsListView abslistview, int i, int j, int k)
            {
                lsitempos = 1 + (j + i);
            }

            public void onScrollStateChanged(AbsListView abslistview, int i)
            {
                if(i == 0 && lsitempos >= LocalMuiscFragmen.adapter.getCount())
                    (new Thread(new Runnable() {

                        public void run()
                        {
                            LocalMuiscFragmen.hand.sendEmptyMessage(4);
                            try
                            {
                                Thread.sleep(500L);
                            }
                            catch(InterruptedException interruptedexception)
                            {
                                interruptedexception.printStackTrace();
                            }
                            refreshlist();
                            LocalMuiscFragmen.hand.sendEmptyMessage(3);
                        }

//                        final _cls3 this$1;
//
//                    
//                    {
//                        this$1 = _cls3.this;
//                        super();
//                    }
                    }
)).start();
            }

//            final LocalMuiscFragmen this$0;
//
//
//            
//            {
//                this$0 = LocalMuiscFragmen.this;
//                super();
//            }
        }
;
        ocl = new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
                boolean flag;
                int i;
                flag = false;
                i = view.getId();
//                if(i != 0x7f070011) goto _L2; else goto _L1
//_L1:
//                flag = MainActivity.mputil.nextMusic();
//_L4:
//                LocalMuiscFragmen.refadapter(flag);
//                return;
//_L2:
//                if(i == 0x7f07000e)
//                    flag = MainActivity.mputil.preMusic();
//                if(true) goto _L4; else goto _L3
//_L3:
                if(R.id.bofang_btnext == i) {
                	flag = MainActivity.mputil.nextMusic();
                } else if(R.id.bofang_btpre == i) {
                	flag = MainActivity.mputil.preMusic();
                }
                
                LocalMuiscFragmen.refadapter(flag);
            }

//            final LocalMuiscFragmen this$0;
//
//            
//            {
//                this$0 = LocalMuiscFragmen.this;
//                super();
//            }
        }
;
    }

    private void findsd()
    {
        if(Environment.getExternalStorageState().equals("mounted"))
        {
            sdCardFir = Environment.getExternalStorageDirectory().getPath();
            initdate();
            initlistener();
        } else
        {
            tv.setText(0x7f080007);
            lv.setVisibility(4);
        }
    }

    private void init()
    {
        lv = (DragSortListView)mParent.findViewById(0x7f07000b);
        btplayview = (CheckBox)mParent.findViewById(0x7f070013);
        btpre = (Button)mParent.findViewById(0x7f07000e);
        tv = (TextView)mParent.findViewById(0x7f070015);
        tvpos = (TextView)mParent.findViewById(0x7f07000d);
        btnext = (Button)mParent.findViewById(0x7f070011);
        chkplay = (CheckBox)mParent.findViewById(0x7f070010);
        sbmusicpos = (SeekBar)mParent.findViewById(0x7f07000c);
        lly = (LinearLayout)mParent.findViewById(0x7f07001c);
        listfooterview = mActivity.getLayoutInflater().inflate(0x7f030003, null);
        ivlon = (ImageView)listfooterview.findViewById(0x7f07000f);
        frameAnimation = (AnimationDrawable)ivlon.getBackground();
        listfooterview.setVisibility(8);
        lly.setVisibility(8);
        pd = new ProgressDialog(mActivity);
        pd.setMessage("\u4FDD\u5B58\u4E2D");
    }

    private void initMusicListDate()
    {
        Cursor cursor = mActivity.getContentResolver().query(android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, "title_key");
        if(cursor.moveToFirst())
            searchMusicFile(cursor);
    }

    private void initdate()
    {
        msblv = new ArrayList();
        reflv = new ArrayList();
        map = new HashMap();
        initMusicListDate();
        lv.addFooterView(listfooterview);
        adapter = new BofangListAdapter(mActivity, msblv);
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        listfooterview.setVisibility(8);
    }

    private void initlistener()
    {
        btpre.setOnClickListener(ocl);
        btnext.setOnClickListener(ocl);
        controller = new DragSortController(lv);
        controller.setDragHandleId(0x7f070069);
        controller.setRemoveEnabled(false);
        controller.setSortEnabled(true);
        controller.setDragInitMode(2);
        controller.setRemoveMode(1);
        lv.setDropListener(onDrop);
        lv.setRemoveListener(onRemove);
        lv.setFloatViewManager(controller);
        lv.setOnTouchListener(controller);
        lv.setDragEnabled(true);
        chkplay.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
//                if(flag) goto _L2; else goto _L1
//_L1:
//                if(MediaplayUtil.mp.isPlaying())
//                    MainActivity.mputil.pause();
//_L4:
//                return;
//_L2:
//                if(!MediaplayUtil.mp.isPlaying())
//                    MainActivity.mputil.restart();
//                if(true) goto _L4; else goto _L3
//_L3:
            	if(flag) {
                  if(!MediaplayUtil.mp.isPlaying())
                	  MainActivity.mputil.restart();          		
            	} else {
                  if(MediaplayUtil.mp.isPlaying())
                	  MainActivity.mputil.pause();          		
            	}
            }

//            final LocalMuiscFragmen this$0;
//
//            
//            {
//                this$0 = LocalMuiscFragmen.this;
//                super();
//            }
        }
);
        btplayview.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
//                List list1;
//                if(!flag)
//                    break MISSING_BLOCK_LABEL_101;
//                tv.setVisibility(0);
//                tv.setText(0x7f080006);
//                LocalMuiscFragmen.lv.setOnScrollListener(null);
//                controller.setRemoveEnabled(true);
//                list1 = LocalMuiscFragmen.adapter.getMusics();
//                if(list1 == null) goto _L2; else goto _L1
//_L1:
//                Iterator iterator1 = list1.iterator();
//_L5:
//                if(iterator1.hasNext()) goto _L4; else goto _L3
//_L3:
//                LocalMuiscFragmen.adapter.notifyDataSetChanged();
//_L2:
//                return;
//_L4:
//                ((MusicBean)iterator1.next()).setBtvis(0);
//                  goto _L5
//label0:
//                {
//                    tv.setVisibility(8);
//                    List list = LocalMuiscFragmen.adapter.getMusics();
//                    controller.setRemoveEnabled(false);
//                    if(list != null)
//                    {
//                        for(Iterator iterator = list.iterator(); iterator.hasNext(); ((MusicBean)iterator.next()).setBtvis(8))
//                            break label0;
//
//                        LocalMuiscFragmen.adapter.notifyDataSetChanged();
//                    }
//                    LocalMuiscFragmen.lv.setOnScrollListener(osl);
//                    LocalMuiscFragmen.pd.show();
//                    (new Thread(new Runnable() {
//
//                        public void run()
//                        {
//                            savelist();
//                            LocalMuiscFragmen.hand.sendEmptyMessage(2);
//                        }
//
//                        final _cls7 this$1;
//
//                    
//                    {
//                        this$1 = _cls7.this;
//                        super();
//                    }
//                    }
//)).start();
//                }
//                  goto _L2
            }

//            final LocalMuiscFragmen this$0;
//
//
//            
//            {
//                this$0 = LocalMuiscFragmen.this;
//                super();
//            }
        }
);
        lv.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                msblv = LocalMuiscFragmen.adapter.getMusics();
                MainActivity.mputil.start(msblv, i);
                Iterator iterator = LocalMuiscFragmen.adapter.getMusics().iterator();
                do
                {
                    if(!iterator.hasNext())
                    {
                        ((MusicBean)LocalMuiscFragmen.adapter.getMusics().get(MainActivity.mputil.getPosition())).setIschecked(true);
                        LocalMuiscFragmen.adapter.notifyDataSetChanged();
                        LocalMuiscFragmen.chkplay.setChecked(true);
                        if(!first)
                        {
                            first = true;
                            lly.setVisibility(0);
                        }
                        return;
                    }
                    ((MusicBean)iterator.next()).setIschecked(false);
                } while(true);
            }

//            final LocalMuiscFragmen this$0;
//
//            
//            {
//                this$0 = LocalMuiscFragmen.this;
//                super();
//            }
        }
);
        sbmusicpos.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
            {
                if(flag)
                {
                    int j = (i * ((MusicBean)LocalMuiscFragmen.adapter.getMusics().get(MainActivity.mputil.getPosition())).getTime()) / 200;
                    MediaplayUtil.mp.seekTo(j);
                    LocalMuiscFragmen.chkplay.setChecked(true);
                    MainActivity.mputil.restart();
                }
            }

            public void onStartTrackingTouch(SeekBar seekbar)
            {
                contralseektomedia = true;
            }

            public void onStopTrackingTouch(SeekBar seekbar)
            {
                contralseektomedia = false;
            }

//            final LocalMuiscFragmen this$0;
//
//            
//            {
//                this$0 = LocalMuiscFragmen.this;
//                super();
//            }
        }
);
        lv.setOnScrollListener(osl);
    }

    private static void refadapter(boolean flag)
    {
        Iterator iterator = adapter.getMusics().iterator();
        do
        {
            if(!iterator.hasNext())
            {
                if(MainActivity.mputil.getPosition() < adapter.getMusics().size())
                    ((MusicBean)adapter.getMusics().get(MainActivity.mputil.getPosition())).setIschecked(true);
                adapter.notifyDataSetChanged();
                if(flag)
                    chkplay.setChecked(flag);
                return;
            }
            ((MusicBean)iterator.next()).setIschecked(false);
        } while(true);
    }

    private void refreshlist()
    {
        prelenth = adapter.getMusics().size();
        Cursor cursor = mActivity.getContentResolver().query(android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, "title_key");
        if(cursor.moveToFirst())
        {
            SharedPreferences sharedpreferences = mActivity.getSharedPreferences("sp", 0);
            do
            {
                int i = cursor.getInt(cursor.getColumnIndexOrThrow("duration"));
                String s = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                String s1 = (new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()))).append("/babymusic/song").toString();
                String s2 = s.substring(0, s.lastIndexOf('/'));
                if(i >= 30000 && s1.equals(s2))
                {
                    File file = new File(s);
                    if(file.exists())
                    {
                        Log.i("test", (new StringBuilder("path:")).append(s).append(":").append(file.exists()).toString());
                        int j = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
                        int k = sharedpreferences.getInt((new StringBuilder()).append(j).toString(), -1);
                        MusicBean musicbean = new MusicBean();
                        musicbean.setTime(i);
                        musicbean.setName(cursor.getString(cursor.getColumnIndexOrThrow("title")));
                        musicbean.setIdinsys(j);
                        musicbean.setFilepath(s);
                        if(k == -1 && j != -1)
                            msblv.add(musicbean);
                    }
                }
            } while(cursor.moveToNext());
        }
        cursor.close();
        nowlenth = adapter.getMusics().size();
        if(prelenth != nowlenth)
            savelist();
    }

    private void savelist()
    {
        android.content.SharedPreferences.Editor editor = mActivity.getSharedPreferences("sp", 0).edit();
        editor.clear();
        int i = 0;
        Iterator iterator = adapter.getMusics().iterator();
        do
        {
            if(!iterator.hasNext())
                return;
            MusicBean musicbean = (MusicBean)iterator.next();
            String s = (new StringBuilder()).append(musicbean.getIdinsys()).toString();
            int j = i + 1;
            editor.putInt(s, i).commit();
            i = j;
        } while(true);
    }

    private void searchMusicFile(Cursor cursor)
    {
//        SharedPreferences sharedpreferences;
//        int i;
//        android.content.SharedPreferences.Editor editor1;
//        Iterator iterator1;
//        int j1;
//        sharedpreferences = mActivity.getSharedPreferences("sp", 0);
//        i = 0;
//        do
//        {
//            int j = cursor.getInt(cursor.getColumnIndexOrThrow("duration"));
//            String s = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
//            String s1 = (new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()))).append("/babymusic/song").toString();
//            String s2 = s.substring(0, s.lastIndexOf('/'));
//            if(j >= 30000 && s1.equals(s2))
//            {
//                File file = new File(s);
//                if(file.exists())
//                {
//                    Log.i("test", (new StringBuilder("path:")).append(s).append(":").append(file.exists()).toString());
//                    Log.i("test", (new StringBuilder(String.valueOf(s))).append("::").append(s2).toString());
//                    int l1 = sharedpreferences.getInt((new StringBuilder()).append(cursor.getInt(cursor.getColumnIndexOrThrow("_id"))).toString(), -1);
//                    MusicBean musicbean3 = new MusicBean();
//                    musicbean3.setTime(j);
//                    musicbean3.setName(cursor.getString(cursor.getColumnIndexOrThrow("title")));
//                    musicbean3.setIdinsys(cursor.getInt(cursor.getColumnIndexOrThrow("_id")));
//                    musicbean3.setFilepath(s);
//                    if(l1 != -1)
//                    {
//                        map.put(Integer.valueOf(l1), musicbean3);
//                        i++;
//                    } else
//                    {
//                        reflv.add(musicbean3);
//                    }
//                }
//            }
//        } while(cursor.moveToNext());
//        Log.i("test", (new StringBuilder(" ")).append(map.size()).append(":").append(reflv.size()).toString());
//        cursor.close();
//        if(map.size() != 0) goto _L2; else goto _L1
//_L1:
//        msblv = reflv;
//        reflv = null;
//        editor1 = sharedpreferences.edit();
//        editor1.clear();
//        iterator1 = msblv.iterator();
//        j1 = 0;
//_L5:
//        if(iterator1.hasNext()) goto _L4; else goto _L3
//_L3:
//        j1;
//_L8:
//        Log.i("test", (new StringBuilder("msblv:")).append(msblv.size()).toString());
//        return;
//_L4:
//        MusicBean musicbean2 = (MusicBean)iterator1.next();
//        String s4 = (new StringBuilder()).append(musicbean2.getIdinsys()).toString();
//        int k1 = j1 + 1;
//        editor1.putInt(s4, j1).commit();
//        j1 = k1;
//          goto _L5
//_L2:
//        int k = 0;
//_L9:
//        if(k < i) goto _L7; else goto _L6
//_L6:
//        android.content.SharedPreferences.Editor editor;
//        Iterator iterator;
//        int l;
//        editor = sharedpreferences.edit();
//        editor.clear();
//        iterator = msblv.iterator();
//        l = 0;
//_L10:
//        if(iterator.hasNext())
//            break MISSING_BLOCK_LABEL_670;
//        l;
//          goto _L8
//_L7:
//        MusicBean musicbean = (MusicBean)map.get(Integer.valueOf(k));
//        if(musicbean != null)
//            msblv.add(musicbean);
//        k++;
//          goto _L9
//        MusicBean musicbean1 = (MusicBean)iterator.next();
//        String s3 = (new StringBuilder()).append(musicbean1.getIdinsys()).toString();
//        int i1 = l + 1;
//        editor.putInt(s3, l).commit();
//        l = i1;
//          goto _L10
    }

    public DragSortListView getLv()
    {
        return lv;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        mActivity = getActivity();
        mParent = getView();
        init();
        findsd();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030002, viewgroup, false);
    }

    public void onHiddenChanged(boolean flag)
    {
        if(!flag)
        {
            if(adapter != null)
                refreshlist();
            if(MainActivity.mputil.isTypeb() && MediaplayUtil.mp.isPlaying())
                lly.setVisibility(0);
        } else
        {
            lly.setVisibility(8);
        }
        super.onHiddenChanged(flag);
    }

    private static BofangListAdapter adapter;
    private static CheckBox chkplay;
    private static AnimationDrawable frameAnimation;
    public static Handler hand = new Handler() {

        public void handleMessage(Message message)
        {
            super.handleMessage(message);
//            message.what;
//            JVM INSTR tableswitch 1 5: default 44
//        //                       1 45
//        //                       2 218
//        //                       3 227
//        //                       4 250
//        //                       5 266;
//               goto _L1 _L2 _L3 _L4 _L5 _L6
//_L1:
//            return;
//_L2:
//            LocalMuiscFragmen.sbmusicpos.setProgress(message.arg2);
//            LocalMuiscFragmen.sbmusicpos.setSecondaryProgress(message.arg2);
//            int i = message.arg1;
//            int j = i / 60000;
//            String s;
//            int k;
//            String s1;
//            if(j < 10)
//                s = (new StringBuilder("0")).append(j).toString();
//            else
//                s = (new StringBuilder(String.valueOf(""))).append(j).toString();
//            k = (i % 60000) / 1000;
//            if(k < 10)
//                s1 = (new StringBuilder("0")).append(k).toString();
//            else
//                s1 = (new StringBuilder(String.valueOf(""))).append(k).toString();
//            LocalMuiscFragmen.tvpos.setText((new StringBuilder(String.valueOf(s))).append(":").append(s1).toString());
//            continue; /* Loop/switch isn't completed */
//_L3:
//            LocalMuiscFragmen.pd.cancel();
//            continue; /* Loop/switch isn't completed */
//_L4:
//            LocalMuiscFragmen.listfooterview.setVisibility(8);
//            LocalMuiscFragmen.frameAnimation.stop();
//            LocalMuiscFragmen.adapter.notifyDataSetChanged();
//            continue; /* Loop/switch isn't completed */
//_L5:
//            LocalMuiscFragmen.listfooterview.setVisibility(0);
//            LocalMuiscFragmen.frameAnimation.start();
//            continue; /* Loop/switch isn't completed */
//_L6:
//            LocalMuiscFragmen.refadapter(false);
//            if(true) goto _L1; else goto _L7
//_L7:
            
            switch (message.what) {
			case 1:
	            LocalMuiscFragmen.sbmusicpos.setProgress(message.arg2);
	            LocalMuiscFragmen.sbmusicpos.setSecondaryProgress(message.arg2);
	            int i = message.arg1;
	            int j = i / 60000;
	            String s;
	            int k;
	            String s1;
	            if(j < 10)
	                s = (new StringBuilder("0")).append(j).toString();
	            else
	                s = (new StringBuilder(String.valueOf(""))).append(j).toString();
	            k = (i % 60000) / 1000;
	            if(k < 10)
	                s1 = (new StringBuilder("0")).append(k).toString();
	            else
	                s1 = (new StringBuilder(String.valueOf(""))).append(k).toString();
	            LocalMuiscFragmen.tvpos.setText((new StringBuilder(String.valueOf(s))).
	            		append(":").append(s1).toString());				
				break;
			case 2:
				LocalMuiscFragmen.pd.cancel();
				break;
			case 3:
	            LocalMuiscFragmen.listfooterview.setVisibility(8);
	            LocalMuiscFragmen.frameAnimation.stop();
	            LocalMuiscFragmen.adapter.notifyDataSetChanged();				
				break;
			case 4:
	            LocalMuiscFragmen.listfooterview.setVisibility(0);
	            LocalMuiscFragmen.frameAnimation.start();
				break;
			case 5:
				LocalMuiscFragmen.refadapter(false);
				break;
			default:
				break;
			}
        }

    }
;
    private static View listfooterview;
    private static DragSortListView lv;
    private static ProgressDialog pd;
    private static SeekBar sbmusicpos;
    private static TextView tvpos;
    private Button btnext;
    private CheckBox btplayview;
    private Button btpre;
    private boolean contralseektomedia;
    private DragSortController controller;
    private boolean first;
    private ImageView ivlon;
    private LinearLayout lly;
    private int lsitempos;
    private FragmentActivity mActivity;
    private View mParent;
    private Map map;
    private List msblv;
    private int nowlenth;
    private android.view.View.OnClickListener ocl;
    private com.baoyi.guoyiyun.myview.DragSortListView.DropListener onDrop;
    private com.baoyi.guoyiyun.myview.DragSortListView.RemoveListener onRemove;
    private android.widget.AbsListView.OnScrollListener osl;
    private int prelenth;
    private List reflv;
    private RelativeLayout rlayout;
    private String sdCardFir;
    private TextView tv;























}
