// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.baoyi.guoyiyun.babymusic;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.*;
import android.support.v4.app.*;
import android.text.Editable;
import android.util.Log;
import android.view.*;
import android.widget.*;
import com.baoyi.guoyiyun.utils.RpcUtils2;
import com.boyi.guoyiyun.adapter.BackTalkAdapter;
import com.iring.dao.CommentaryDao;
import com.iring.entity.Commentary;
import com.iring.entity.Conversation;
import com.iring.rpc.CommentaryRpc;
import java.net.*;
import java.util.*;

// Referenced classes of package com.baoyi.guoyiyun.babymusic:
//            MainActivity, NewTalkFragment, ConvertFragment

public class ConvertTalkInfoFragment extends Fragment
{

    public ConvertTalkInfoFragment()
    {
        han = new Handler() {

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
//                message.what;
//                JVM INSTR tableswitch 5 5: default 28
//            //                           5 29;
//                   goto _L1 _L2
//_L1:
//                return;
//_L2:
//                listfotter.setVisibility(0);
//                ConvertTalkInfoFragment.frameAnimation.start();
//                if(true) goto _L1; else goto _L3
//_L3:
            }

//            final ConvertTalkInfoFragment this$0;
//
//            
//            {
//                this$0 = ConvertTalkInfoFragment.this;
//                super();
//            }
        }
;
        osl = new android.widget.AbsListView.OnScrollListener() {

            public void onScroll(AbsListView abslistview, int i, int j, int k)
            {
                lsitempos = j + i;
            }

            public void onScrollStateChanged(AbsListView abslistview, int i)
            {
                if(i == 0)
                {
                    han.sendEmptyMessage(5);
                    (new Thread(new Runnable() {

                        public void run()
                        {
                            try
                            {
                                Thread.sleep(500L);
                            }
                            catch(InterruptedException interruptedexception)
                            {
                                interruptedexception.printStackTrace();
                            }
                            refreshlist();
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
            }

//            final ConvertTalkInfoFragment this$0;
//
//
//            
//            {
//                this$0 = ConvertTalkInfoFragment.this;
//                super();
//            }
        }
;
    }

    private void add(final String content)
    {
        (new AsyncTask() {

            protected Integer doInBackground(Integer ainteger[])
            {
                CommentaryDao commentarydao = (CommentaryDao)RpcUtils2.getDao("commentaryDao", CommentaryDao.class);
                Commentary commentary = new Commentary();
                commentary.setConversationid(conver.getId());
                commentary.setContent(content);
                commentary.setIp(getLocalIpAddress());
                commentary.setPosttime((new Date()).getTime());
                commentarydao.add(commentary);
                return null;
            }

            protected Object doInBackground(Object aobj[])
            {
                return doInBackground((Integer[])aobj);
            }

            protected void onPostExecute(Integer integer)
            {
                refreshlist();
                lly1.setVisibility(0);
                lly2.setVisibility(8);
            }

            protected void onPostExecute(Object obj)
            {
                onPostExecute((Integer)obj);
            }

//            final ConvertTalkInfoFragment this$0;
//            private final String val$content;
//
//            
//            {
//                this$0 = ConvertTalkInfoFragment.this;
//                content = s;
//                super();
//            }
        }
).execute(new Integer[0]);
    }

    private void init()
    {
        conver = (Conversation)mActivity.getIntent().getBundleExtra("con").getSerializable("con");
        Log.i("test", (new StringBuilder()).append(conver.getId()).append(" title:").append(conver.getTitle()).toString());
        bt_newtalk = (Button)mParent.findViewById(0x7f070055);
        ivsearch = (ImageView)mParent.findViewById(0x7f070057);
        bt_toback = (Button)mParent.findViewById(0x7f07005c);
        bt_send = (Button)mParent.findViewById(0x7f07005d);
        ed_search = (EditText)mParent.findViewById(0x7f070056);
        ed = (EditText)mParent.findViewById(0x7f07005b);
        tv_title = (TextView)mParent.findViewById(0x7f070058);
        tv_content = (TextView)mParent.findViewById(0x7f070059);
        lv = (ListView)mParent.findViewById(0x7f07005a);
        lly1 = (LinearLayout)mParent.findViewById(0x7f07005e);
        lly2 = (LinearLayout)mParent.findViewById(0x7f07005f);
        listfotter = mActivity.getLayoutInflater().inflate(0x7f030013, null);
        ivlond = (ImageView)listfotter.findViewById(0x7f070060);
        lv.addFooterView(listfotter);
        listfotter.setVisibility(8);
    }

    private void initdata()
    {
        frameAnimation = (AnimationDrawable)ivlond.getBackground();
        tv_title.setText(conver.getTitle());
        tv_content.setText((new StringBuilder("\t\t\t\t")).append(conver.getContent()).toString());
        adapter = new BackTalkAdapter(mActivity);
        lv.setAdapter(adapter);
        lly1.setVisibility(0);
        lly2.setVisibility(8);
    }

    private void initlistener()
    {
        bt_newtalk.setOnClickListener(ocl);
        bt_toback.setOnClickListener(ocl);
        bt_send.setOnClickListener(ocl);
        ivsearch.setOnClickListener(ocl);
        lv.setOnScrollListener(osl);
    }

    private void refreshlist()
    {
        AsyncTask asynctask = new AsyncTask() {

            protected Integer doInBackground(Integer ainteger1[])
            {
//                CommentaryDao commentarydao = (CommentaryDao)RpcUtils2.getDao("commentaryDao", com/iring/dao/CommentaryDao);
//                if(commentarydao == null) goto _L2; else goto _L1
//_L1:
//                if(comls == null || comls.size() == 0) goto _L4; else goto _L3
//_L3:
//                rpc = commentarydao.qureyall(conver.getId(), comls.size());
//                if(rpc != null)
//                {
//                    Log.i("test", (new StringBuilder("123:")).append(rpc.getDatas()).toString());
//                    comls.addAll(rpc.getDatas());
//                }
//_L2:
//                return null;
//_L4:
//                rpc = commentarydao.qureyall(conver.getId(), 0);
//                if(rpc != null)
//                {
//                    Log.i("test", (new StringBuilder("123:")).append(rpc.getDatas()).toString());
//                    comls = rpc.getDatas();
//                }
//                if(true) goto _L2; else goto _L5
//_L5:
            	return null;
            }

            protected Object doInBackground(Object aobj[])
            {
                return doInBackground((Integer[])aobj);
            }

            protected void onPostExecute(Integer integer)
            {
                ConvertTalkInfoFragment.frameAnimation.stop();
                listfotter.setVisibility(8);
                if(rpc != null)
                {
                    ((BackTalkAdapter)adapter).setTbs(comls);
                    adapter.notifyDataSetChanged();
                } else
                {
                    Toast.makeText(mActivity, "\u65E0\u6CD5\u8FDE\u63A5\u5230\u670D\u52A1\u5668", 2000).show();
                }
            }

            protected void onPostExecute(Object obj)
            {
                onPostExecute((Integer)obj);
            }

            CommentaryRpc rpc;
//            final ConvertTalkInfoFragment this$0;
//
//            
//            {
//                this$0 = ConvertTalkInfoFragment.this;
//                super();
//                rpc = null;
//            }
        }
;
        Integer ainteger[] = new Integer[1];
        ainteger[0] = Integer.valueOf(0);
        asynctask.execute(ainteger);
    }

    public LinearLayout getLly1()
    {
        return lly1;
    }

    public LinearLayout getLly2()
    {
        return lly2;
    }

    public String getLocalIpAddress()
    {
//        Enumeration enumeration = NetworkInterface.getNetworkInterfaces();
//_L2:
//        Enumeration enumeration1;
//        if(!enumeration.hasMoreElements())
//            break MISSING_BLOCK_LABEL_91;
//        enumeration1 = ((NetworkInterface)enumeration.nextElement()).getInetAddresses();
//_L4:
//        if(!enumeration1.hasMoreElements()) goto _L2; else goto _L1
//_L1:
//        InetAddress inetaddress = (InetAddress)enumeration1.nextElement();
//        if(inetaddress.isLoopbackAddress()) goto _L4; else goto _L3
//_L3:
//        String s1 = inetaddress.getHostAddress().toString();
//        String s;
//        s = s1;
//        break MISSING_BLOCK_LABEL_93;
//        SocketException socketexception;
//        socketexception;
//        Log.e("WifiPreference IpAddress", socketexception.toString());
//        s = null;
//        return s;
    	return null;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        mActivity = getActivity();
        mParent = getView();
        Log.i("test", getLocalIpAddress());
        init();
        initdata();
        initlistener();
        refreshlist();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030012, viewgroup, false);
    }

    public void onHiddenChanged(boolean flag)
    {
        super.onHiddenChanged(flag);
        if(!flag)
        {
            comls = null;
            MainActivity.viewid = 31;
        }
    }

    private static AnimationDrawable frameAnimation;
    private BaseAdapter adapter;
    private Button bt_newtalk;
    private Button bt_send;
    private Button bt_toback;
    private List comls;
    private Conversation conver;
    private EditText ed;
    private EditText ed_search;
    private Handler han;
    private ImageView ivlond;
    private ImageView ivsearch;
    private View listfotter;
    private LinearLayout lly1;
    private LinearLayout lly2;
    private int lsitempos;
    private ListView lv;
    private FragmentActivity mActivity;
    private View mParent;
    private final android.view.View.OnClickListener ocl = new android.view.View.OnClickListener() {

        public void onClick(View view)
        {
//            int i = view.getId();
//            if(i != 0x7f07005c) goto _L2; else goto _L1
//_L1:
//            lly1.setVisibility(8);
//            lly2.setVisibility(0);
//            ed.setText("");
//_L4:
//            return;
//_L2:
//            if(i == 0x7f070055)
//            {
//                MainActivity.viewid = 32;
//                MainActivity.fmconvert_newtalk = new NewTalkFragment();
//                mActivity.getSupportFragmentManager().beginTransaction().add(0x7f07000a, MainActivity.fmconvert_newtalk).commit();
//                mActivity.getSupportFragmentManager().beginTransaction().hide(MainActivity.fmnet).hide(MainActivity.fmlocal).hide(MainActivity.fmconvert).hide(MainActivity.fmset).hide(MainActivity.fmconvert_talkinfo).hide(MainActivity.fmconvert_newtalk).show(MainActivity.fmconvert_newtalk).hide(MainActivity.fmconvert_talkinfo).commit();
//            } else
//            if(i == 0x7f07005d)
//            {
//                String s = ed.getText().toString().trim();
//                if(s == null || s.equals(""))
//                    Toast.makeText(mActivity, "\uFFFD\uFFFD\uFFFD\u0772\uFFFD\uFFFD\uFFFD\u03AA\uFFFD\uFFFD", 2000).show();
//                else
//                    add(s);
//            } else
//            if(i == 0x7f070057)
//            {
//                ConvertFragment.key = ed_search.getText().toString().trim();
//                ConvertFragment.pagenum = 1;
//                if(MainActivity.viewid == 31 && MainActivity.fmconvert_talkinfo != null)
//                    mActivity.getSupportFragmentManager().beginTransaction().remove(MainActivity.fmconvert_talkinfo).commit();
//                mActivity.getSupportFragmentManager().beginTransaction().hide(MainActivity.fmnet).hide(MainActivity.fmlocal).hide(MainActivity.fmconvert).hide(MainActivity.fmconvert_talkinfo).hide(MainActivity.fmset).show(MainActivity.fmconvert).commit();
//            }
//            if(true) goto _L4; else goto _L3
//_L3:
        }

//        final ConvertTalkInfoFragment this$0;
//
//            
//            {
//                this$0 = ConvertTalkInfoFragment.this;
//                super();
//            }
    }
;
    private android.widget.AbsListView.OnScrollListener osl;
    private int talkid;
    private TextView tv_content;
    private TextView tv_title;















}
