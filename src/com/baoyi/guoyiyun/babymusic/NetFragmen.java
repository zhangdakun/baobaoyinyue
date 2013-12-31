// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.baoyi.guoyiyun.babymusic;

import android.app.ActivityManager;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.*;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.*;
import android.widget.*;
import com.baoyi.guoyiyun.bean.MusicBean;
import com.baoyi.guoyiyun.constant.Constant;
import com.baoyi.guoyiyun.util.HttpDownloader;
import com.baoyi.guoyiyun.util.MediaplayUtil;
import com.baoyi.guoyiyun.utils.RpcUtils2;
import com.boyi.guoyiyun.adapter.BofangListAdapter;
import com.iring.dao.MusicDao;
import com.iring.entity.Music;
import com.iring.rpc.MusicRpc;
import java.io.File;
import java.io.PrintStream;
import java.util.*;

// Referenced classes of package com.baoyi.guoyiyun.babymusic:
//            MainActivity, SleepActivity

public class NetFragmen extends Fragment
{

    public NetFragmen()
    {
        SIZE = 10;
        contralseektomedia = false;
        basy = true;
        first = false;
        firstref = true;
        ocl = new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
                int i = view.getId();
//                if(i != 0x7f070022) goto _L2; else goto _L1
//_L1:
                if(i== 0x7f070022)
                if(basy)
                {
                    current = 0;
                    lsmb = null;
                    i1.setVisibility(8);
                    i2.setVisibility(0);
                    i3.setVisibility(8);
                    refreshlist(Constant.TYPE_SLEEP);
                    NetFragmen.adapter.notifyDataSetChanged();
                }
//_L4:
//                return;
//_L2:
                if(i == 0x7f070023)
                {
                    if(basy)
                    {
                        current = 0;
                        lsmb = null;
                        refreshlist(Constant.TYPE_CHINESE);
                        i1.setVisibility(0);
                        i2.setVisibility(8);
                        i3.setVisibility(8);
                    }
                } else
                if(i == 0x7f070024)
                {
                    if(basy)
                    {
                        current = 0;
                        lsmb = null;
                        refreshlist(Constant.TYPE_ENGLISTH);
                        i1.setVisibility(8);
                        i2.setVisibility(8);
                        i3.setVisibility(0);
                    }
                } else
                if(i == 0x7f07002d)
                {
                    Intent intent = new Intent();
                    intent.setClass(NetFragmen.mActivity, SleepActivity.class);
                    startActivity(intent);
                } else
                if(i == 0x7f07002b)
                {
                    NetFragmen.back = 0;
                    NetFragmen.adapter.setUrlpos(-1);
                    NetFragmen.adapter.setPretype(NetFragmen.nowtype);
                    bgo = MainActivity.mputil.nextMusic();
                } else
                if(i == 0x7f070029)
                {
                    NetFragmen.back = 0;
                    NetFragmen.adapter.setUrlpos(-1);
                    NetFragmen.adapter.setPretype(NetFragmen.nowtype);
                    bgo = MainActivity.mputil.preMusic();
                } else
                if(i == 0x7f07002c)
                {
                    MusicBean musicbean = (MusicBean)MainActivity.mputil.getMslv().get(MainActivity.mputil.getPosition());
                    File file = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()))).append("/babymusic/song/").append(musicbean.getName()).append(".mp3").toString());
                    System.out.println(file.getAbsolutePath());
                    if(file.exists())
                    {
                        Toast.makeText(NetFragmen.mActivity, "\u6587\u4EF6\u5DF2\u5B58\u5728", 0).show();
                    } else
                    {
                        boolean flag = isServiceRunning();
                        Log.i("test", (new StringBuilder("ser is run?")).append(flag).toString());
                        if(!flag)
                        {
                            Bundle bundle = new Bundle();
                            String s = (new StringBuilder("http://iring.wutianxia.com:8999")).append(((MusicBean)MainActivity.mputil.getMslv().get(MainActivity.mputil.getPosition())).getUrl()).toString();
                            Log.i("test", (new StringBuilder("    dfgds  ")).append(s).toString());
                            bundle.putString("url", s);
                            bundle.putString("name", ((MusicBean)MainActivity.mputil.getMslv().get(MainActivity.mputil.getPosition())).getName());
                            MainActivity.intent.putExtras(bundle);
                            NetFragmen.mActivity.startService(MainActivity.intent);
                        } else
                        if(HttpDownloader.ok)
                        {
                            Bundle bundle1 = new Bundle();
                            String s1 = (new StringBuilder("http://iring.wutianxia.com:8999")).append(((MusicBean)MainActivity.mputil.getMslv().get(MainActivity.mputil.getPosition())).getUrl()).toString();
                            Log.i("test", (new StringBuilder("    dfgds  ")).append(s1).toString());
                            bundle1.putString("url", s1);
                            bundle1.putString("name", ((MusicBean)MainActivity.mputil.getMslv().get(MainActivity.mputil.getPosition())).getName());
                            MainActivity.intent.putExtras(bundle1);
                            NetFragmen.mActivity.startService(MainActivity.intent);
                        } else
                        {
                            String s2 = HttpDownloader.name;
                            if(s2 == null)
                                s2 = "";
                            Toast.makeText(NetFragmen.mActivity, (new StringBuilder(String.valueOf(s2))).append("\u4E0B\u8F7D\u6210\u529F").toString(), 2000).show();
                        }
                    }
                }
//                if(true) goto _L4; else goto _L3
//_L3:
            }

//            final NetFragmen this$0;
//
//            
//            {
//                this$0 = NetFragmen.this;
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
                if(i == 0 && lsitempos >= NetFragmen.adapter.getCount())
                    (new Thread(new Runnable() {

                        public void run()
                        {
                            NetFragmen.hand.sendEmptyMessage(4);
                            refreshlist(ttype);
                        }

//                        final _cls2 this$1;
//
//                    
//                    {
//                        this$1 = _cls2.this;
//                        super();
//                    }
                    }
)).start();
            }

//            final NetFragmen this$0;
//
//
//            
//            {
//                this$0 = NetFragmen.this;
//                super();
//            }
        }
;
    }

    private void init()
    {
        lv = (ListView)mParent.findViewById(0x7f070026);
        btpre = (Button)mParent.findViewById(0x7f070029);
        btnext = (Button)mParent.findViewById(0x7f07002b);
        btdownload = (Button)mParent.findViewById(0x7f07002c);
        btsleep = (Button)mParent.findViewById(0x7f07002d);
        chkplay = (CheckBox)mParent.findViewById(0x7f07002a);
        sbmusicpos = (SeekBar)mParent.findViewById(0x7f070027);
        tv = (TextView)mParent.findViewById(0x7f070028);
        ivmusictype1 = (ImageView)mParent.findViewById(0x7f070022);
        ivmusictype2 = (ImageView)mParent.findViewById(0x7f070023);
        ivmusictype3 = (ImageView)mParent.findViewById(0x7f070024);
        lly = (LinearLayout)mParent.findViewById(0x7f070021);
        i1 = (ImageView)mParent.findViewById(0x7f070074);
        i2 = (ImageView)mParent.findViewById(0x7f070075);
        i3 = (ImageView)mParent.findViewById(0x7f070076);
        listfooterview = mActivity.getLayoutInflater().inflate(0x7f030003, null);
        ivlon = (ImageView)listfooterview.findViewById(0x7f07000f);
        frameAnimation = (AnimationDrawable)ivlon.getBackground();
        ivlon.setVisibility(0);
        frameAnimation.start();
    }

    private void initdata()
    {
        pd = new ProgressDialog(mActivity);
        pd.setMessage("\u52A0\u8F7D\u4E2D\u8BF7\u7A0D\u7B49");
        adapter = new BofangListAdapter(mActivity);
        lv.addFooterView(listfooterview);
        lv.setAdapter(adapter);
        frameAnimation.start();
        listfooterview.setVisibility(0);
    }

    private void initlistener()
    {
        ivmusictype1.setOnClickListener(ocl);
        ivmusictype2.setOnClickListener(ocl);
        ivmusictype3.setOnClickListener(ocl);
        btdownload.setOnClickListener(ocl);
        btsleep.setOnClickListener(ocl);
        btpre.setOnClickListener(ocl);
        btnext.setOnClickListener(ocl);
        lv.setOnScrollListener(osl);
        lv.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                Log.i("test", (new StringBuilder()).append(i).toString());
                lsmb = NetFragmen.adapter.getMusics();
                NetFragmen.back = 0;
                NetFragmen.back = MainActivity.mputil.start(lsmb, i);
                NetFragmen.adapter.setUrlpos(-1);
                NetFragmen.adapter.setPretype(NetFragmen.nowtype);
                if(!first)
                {
                    first = true;
                    lly.setVisibility(0);
                }
            }

//            final NetFragmen this$0;
//
//            
//            {
//                this$0 = NetFragmen.this;
//                super();
//            }
        }
);
        chkplay.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if(flag) //goto _L2; else goto _L1 
                	{
//_L1:
                if(MediaplayUtil.mp.isPlaying())
                    MainActivity.mputil.pause();
//_L4:
//                return;
                	}
//_L2:  
                else {
                if(!MediaplayUtil.mp.isPlaying())
                    MainActivity.mputil.restart();
                }
//                if(true) goto _L4; else goto _L3
//_L3:
            }

//            final NetFragmen this$0;
//
//            
//            {
//                this$0 = NetFragmen.this;
//                super();
//            }
        }
);
        sbmusicpos.setFocusable(false);
        sbmusicpos.setClickable(false);
        sbmusicpos.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
            {
                if(flag)
                {
                    int j = (i * ((MusicBean)NetFragmen.adapter.getMusics().get(MainActivity.mputil.getPosition())).getTime()) / 200;
                    MediaplayUtil.mp.seekTo(j);
                    NetFragmen.chkplay.setChecked(true);
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

//            final NetFragmen this$0;
//
//            
//            {
//                this$0 = NetFragmen.this;
//                super();
//            }
        }
);
    }

    private boolean isServiceRunning()
    {
        Iterator iterator = ((ActivityManager)mActivity.getSystemService("activity")).getRunningServices(0x7fffffff).iterator();
//_L2:
//        boolean flag;
//        if(iterator.hasNext())
//            continue; /* Loop/switch isn't completed */
//        flag = false;
//_L3:
//        return flag;
//        if(!"com.baoyi.guoyiyun.service.DownService".equals(((android.app.ActivityManager.RunningServiceInfo)iterator.next()).service.getClassName())) goto _L2; else goto _L1
//_L1:
//        flag = true;
//          goto _L3
//        if(true) goto _L2; else goto _L4
//_L4:
        boolean flag = false;
        while(iterator.hasNext()) {
        	if("com.baoyi.guoyiyun.service.DownService".
        			equals(((android.app.ActivityManager.RunningServiceInfo)
        					iterator.next()).service.getClassName())) {
        		flag = true;
        		break;
        	}
        }
        return flag;
    }

    private void refreshlist(final int type)
    {
        ivmusictype1.setClickable(false);
        ivmusictype2.setClickable(false);
        ivmusictype3.setClickable(false);
        (new AsyncTask() {

            protected Integer doInBackground(Integer ainteger[])
            {
                basy = false;
                rpc = RpcUtils2.getMusicDao().pageBySpecial(type, SIZE, current);
//                if(rpc == null) goto _L2; else goto _L1
//_L1:
//                List list;
//                list = rpc.getDatas();
//                if(lsmb == null || lsmb.size() == 0)
//                    lsmb = new ArrayList();
//                if(rpc.getCode() == -1 || list == null || list.size() <= 0) goto _L4; else goto _L3
//_L3:
//                Iterator iterator = list.iterator();
//_L8:
//                if(iterator.hasNext()) goto _L6; else goto _L5
//_L5:
//                NetFragmen netfragmen = NetFragmen.this;
//                netfragmen.current = 1 + netfragmen.current;
//_L4:
//                ttype = type;
//_L2:
//                return null;
//_L6:
//                Music music = (Music)iterator.next();
//                MusicBean musicbean = new MusicBean();
//                musicbean.setMusic(music);
//                lsmb.add(musicbean);
//                if(true) goto _L8; else goto _L7
//_L7:
                if(null == rpc) 
                	return null;
                List list = rpc.getDatas();
                if(lsmb == null || lsmb.isEmpty()) {
                	lsmb = new ArrayList();

                }
                
                if(rpc.getCode() == -1 || list == null || list.size()<=0) {
                	ttype = type;
                	return null;
                } else {
                	Iterator iterator = list.iterator();
                	while(iterator.hasNext()) {
                      Music music = (Music)iterator.next();
                      MusicBean musicbean = new MusicBean();
                      musicbean.setMusic(music);
                      lsmb.add(musicbean);
                	}
                  NetFragmen netfragmen = NetFragmen.this;
                  netfragmen.current = 1 + netfragmen.current;
                 }
                ttype = type;
                return null;
            }

            protected Object doInBackground(Object aobj[])
            {
                return doInBackground((Integer[])aobj);
            }

            protected void onPostExecute(Integer integer)
            {
                if(rpc != null)
                {
                    NetFragmen.adapter.setType(type);
                    if(!first)
                        NetFragmen.adapter.setUrlpos(-1);
                    else
                        NetFragmen.adapter.setUrlpos(MainActivity.mputil.getPosition());
                    NetFragmen.nowtype = type;
                    NetFragmen.adapter.setMusics(lsmb);
                    lv.setSelection(0);
                    NetFragmen.listfooterview.setVisibility(8);
                    NetFragmen.frameAnimation.stop();
                    NetFragmen.adapter.notifyDataSetChanged();
                } else
                {
                    Toast.makeText(NetFragmen.mActivity, "\u52A0\u8F7D\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5", 2000).show();
                }
                basy = true;
                ivmusictype1.setClickable(true);
                ivmusictype2.setClickable(true);
                ivmusictype3.setClickable(true);
            }

            protected void onPostExecute(Object obj)
            {
                onPostExecute((Integer)obj);
            }

            MusicRpc rpc;
//            final NetFragmen this$0;
//            private final int val$type;
//
//            
//            {
//                this$0 = NetFragmen.this;
//                type = i;
//                super();
//                rpc = null;
//            }
        }
).execute(new Integer[0]);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        mActivity = getActivity();
        mParent = getView();
        init();
        initdata();
        initlistener();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f03000c, viewgroup, false);
    }

    public void onHiddenChanged(boolean flag)
    {
//        if(flag) goto _L2; else goto _L1
//_L1:
//        if(firstref)
//        {
//            refreshlist(Constant.TYPE_CHINESE);
//            firstref = false;
//        }
//        if(!MainActivity.mputil.isTypeb() && MediaplayUtil.mp.isPlaying())
//            lly.setVisibility(0);
//_L4:
//        return;
//_L2:
//        lly.setVisibility(8);
//        first = false;
//        if(pd.isShowing())
//        {
//            pd.cancel();
//            btdownload.setEnabled(false);
//        }
//        if(true) goto _L4; else goto _L3
//_L3:
    	if(flag) {
          lly.setVisibility(8);
          first = false;
          if(pd.isShowing())
          {
              pd.cancel();
              btdownload.setEnabled(false);
          }	
    	} else {
          if(firstref)
          {
              refreshlist(Constant.TYPE_CHINESE);
              firstref = false;
          }
          if(!MainActivity.mputil.isTypeb() && MediaplayUtil.mp.isPlaying())
              lly.setVisibility(0);
    	}
    }

    public static final String HTTPTITLE = "http://iring.wutianxia.com:8999";
    private static BofangListAdapter adapter;
    public static int back;
    private static Button btdownload;
    private static CheckBox chkplay;
    private static AnimationDrawable frameAnimation;
    public static Handler hand = new Handler() {

        public void handleMessage(Message message)
        {
//            message.what;
//            JVM INSTR tableswitch 1 5: default 40
//        //                       1 41
//        //                       2 56
//        //                       3 40
//        //                       4 213
//        //                       5 229;
//               goto _L1 _L2 _L3 _L1 _L4 _L5
//_L1:
//            return;
//_L2:
//            if(NetFragmen.mActivity != null)
//                NetFragmen.pd.show();
//            continue; /* Loop/switch isn't completed */
//_L3:
//            NetFragmen.pd.cancel();
//            if(NetFragmen.back == 2)
//                NetFragmen.chkplay.setChecked(false);
//            if(NetFragmen.adapter == null) goto _L7; else goto _L6
//_L6:
//            Iterator iterator = NetFragmen.adapter.getMusics().iterator();
//_L9:
//            if(iterator.hasNext()) goto _L8; else goto _L7
//_L7:
//            NetFragmen.back = 0;
//            NetFragmen.chkplay.setEnabled(true);
//            if(NetFragmen.back == 0)
//            {
//                ((MusicBean)NetFragmen.adapter.getMusics().get(MainActivity.mputil.getPosition())).setIschecked(true);
//                NetFragmen.btdownload.setClickable(true);
//            } else
//            {
//                ((MusicBean)NetFragmen.adapter.getMusics().get(MainActivity.mputil.getPosition())).setIschecked(false);
//                NetFragmen.btdownload.setClickable(false);
//            }
//            NetFragmen.adapter.notifyDataSetChanged();
//            continue; /* Loop/switch isn't completed */
//_L8:
//            ((MusicBean)iterator.next()).setIschecked(false);
//            if(true) goto _L9; else goto _L4
//_L4:
//            NetFragmen.frameAnimation.start();
//            NetFragmen.listfooterview.setVisibility(0);
//            continue; /* Loop/switch isn't completed */
//_L5:
//            NetFragmen.sbmusicpos.setProgress(1 + message.arg2);
//            NetFragmen.sbmusicpos.setSecondaryProgress(message.arg2);
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
//            NetFragmen.tv.setText((new StringBuilder(String.valueOf(s))).append(":").append(s1).toString());
//            if(MainActivity.mputil.getUrlmusictime() != 0)
//                ((MusicBean)NetFragmen.adapter.getMusics().get(MainActivity.mputil.getPosition())).setTime(MainActivity.mputil.getUrlmusictime());
//            NetFragmen.adapter.notifyDataSetChanged();
//            if(true) goto _L1; else goto _L10
//_L10:
        	
        	switch (message.what) {
			case 41:
	            if(NetFragmen.mActivity != null)
	            	NetFragmen.pd.show();
				break;
			case 56:
				break;
			default:
				break;
			}
        }

    }
;
    private static View listfooterview;
    private static FragmentActivity mActivity;
    private static int nowtype;
    private static ProgressDialog pd;
    private static SeekBar sbmusicpos;
    private static TextView tv;
    private int SIZE;
    private boolean basy;
    private boolean bgo;
    private Button btnext;
    private Button btpre;
    private Button btsleep;
    private boolean contralseektomedia;
    private int current;
    private boolean first;
    private boolean firstref;
    private ImageView i1;
    private ImageView i2;
    private ImageView i3;
    private ImageView ivlon;
    private ImageView ivmusictype1;
    private ImageView ivmusictype2;
    private ImageView ivmusictype3;
    private LinearLayout lly;
    private int lsitempos;
    private List lsmb;
    private ListView lv;
    private View mParent;
    private android.view.View.OnClickListener ocl;
    private android.widget.AbsListView.OnScrollListener osl;
    private int ttype;





































}
