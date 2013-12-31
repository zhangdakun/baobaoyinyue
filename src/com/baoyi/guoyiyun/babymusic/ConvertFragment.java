// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.baoyi.guoyiyun.babymusic;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.*;
import android.text.Editable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.*;
import android.widget.*;
import com.baoyi.guoyiyun.bean.Pageitem;
import com.baoyi.guoyiyun.utils.RpcUtils2;
import com.boyi.guoyiyun.adapter.ConvertListAdapter;
import com.boyi.guoyiyun.adapter.PageItemAdapter;
//import com.iring.dao.ConversationDAO;
//import com.iring.rpc.ConversationRpc;
import java.io.Serializable;
import java.util.List;

// Referenced classes of package com.baoyi.guoyiyun.babymusic:
//            MainActivity, NewTalkFragment, ConvertTalkInfoFragment

public class ConvertFragment extends Fragment
{

    public ConvertFragment()
    {
        prepos = 1;
        dorefreshgrid = false;
        otcl = new android.widget.AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                Log.i("test", (new StringBuilder("a")).append(prepos).append(":").append(ConvertFragment.pagenum).toString());
                prepos = ConvertFragment.pagenum;
                ConvertFragment.pagenum = i + 1;
                Log.i("test", (new StringBuilder("b")).append(prepos).append(":").append(ConvertFragment.pagenum).toString());
                ((Pageitem)((PageItemAdapter)adapter_gv).getPageitems().get(-1 + prepos)).setB(false);
                ((Pageitem)((PageItemAdapter)adapter_gv).getPageitems().get(i)).setB(true);
                adapter_gv.notifyDataSetChanged();
                refreshListAndGrid(ConvertFragment.pagenum, ConvertFragment.key);
            }

//            final ConvertFragment this$0;
//
//            
//            {
//                this$0 = ConvertFragment.this;
//                super();
//            }
        }
;
        ocl = new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
                int i = view.getId();
//                if(i != 0x7f070043) goto _L2; else goto _L1
//_L1:
//                MainActivity.viewid = 32;
//                MainActivity.fmconvert_newtalk = new NewTalkFragment();
//                mActivity.getSupportFragmentManager().beginTransaction().add(0x7f07000a, MainActivity.fmconvert_newtalk).commit();
//                mActivity.getSupportFragmentManager().beginTransaction().hide(MainActivity.fmnet).hide(MainActivity.fmlocal).hide(MainActivity.fmconvert).hide(MainActivity.fmset).hide(MainActivity.fmconvert_newtalk).show(MainActivity.fmconvert_newtalk).commit();
//_L4:
//                return;
//_L2:
//                if(i == 0x7f070049)
//                    hsv.scrollBy(-pagesizedpi, 0);
//                else
//                if(i == 0x7f07004a)
//                    hsv.scrollBy(pagesizedpi, 0);
//                else
//                if(i == 0x7f070046)
//                {
//                    ConvertFragment.key = edt_search.getText().toString().trim();
//                    ConvertFragment.pagenum = 1;
//                    refreshListAndGrid(ConvertFragment.pagenum, ConvertFragment.key);
//                }
//                if(true) goto _L4; else goto _L3
//_L3:
				// leb decom
				switch (i) {
				case 0x7f070043:
	                MainActivity.viewid = 32;
	                MainActivity.fmconvert_newtalk = new NewTalkFragment();
	                mActivity.getSupportFragmentManager().beginTransaction().add(0x7f07000a, MainActivity.fmconvert_newtalk).commit();
	                mActivity.getSupportFragmentManager().beginTransaction().
	                hide(MainActivity.fmnet).hide(MainActivity.fmlocal).hide(MainActivity.fmconvert).
	                hide(MainActivity.fmset).hide(MainActivity.fmconvert_newtalk).
	                show(MainActivity.fmconvert_newtalk).commit();					
					break;
				case 0x7f070049:
					hsv.scrollBy(-pagesizedpi, 0);
					break;
				case 0x7f07004a:
					hsv.scrollBy(pagesizedpi, 0);
					break;
				case 0x7f070046:
                    ConvertFragment.key = edt_search.getText().toString().trim();
                    ConvertFragment.pagenum = 1;
                    refreshListAndGrid(ConvertFragment.pagenum, ConvertFragment.key);					
					break;
				default:
					break;
				}
            }

//            final ConvertFragment this$0;
//
//            
//            {
//                this$0 = ConvertFragment.this;
//                super();
//            }
        }
;
    }

    private void init()
    {
        bt_newtalk = (Button)mParent.findViewById(0x7f070043);
        bt_left = (Button)mParent.findViewById(0x7f070049);
        bt_right = (Button)mParent.findViewById(0x7f07004a);
        edt_search = (EditText)mParent.findViewById(0x7f070045);
        iv_search = (ImageView)mParent.findViewById(0x7f070046);
        iv_londing = (ImageView)mParent.findViewById(0x7f070044);
        lv = (ListView)mParent.findViewById(0x7f070047);
        hsv = (HorizontalScrollView)mParent.findViewById(0x7f070048);
        lly = (LinearLayout)mParent.findViewById(0x7f07004c);
        contentlly = (LinearLayout)mParent.findViewById(0x7f07004d);
        londinglly = (LinearLayout)mParent.findViewById(0x7f07004e);
        gv = new GridView(mActivity);
    }

    private void initdata()
    {
        adapter_lv = new ConvertListAdapter(mActivity);
        lv.setAdapter(adapter_lv);
        lvlen = adapter_lv.getCount();
        dpi = mActivity.getResources().getDisplayMetrics().density;
        pagesizedpi = (int)(5F * (42F * dpi));
        adapter_gv = new PageItemAdapter(mActivity, 20);
        gvlen = adapter_gv.getCount();
        gv.setNumColumns(gvlen);
        int i = (int)(0.5F + 42F * dpi * (float)gvlen);
        gv.setHorizontalSpacing((int)(0.5F + 2.0F * dpi));
        gv.setColumnWidth((int)(40F * dpi));
        gv.setLayoutParams(new android.view.ViewGroup.LayoutParams(i, -2));
        gv.setStretchMode(0);
        gv.setAdapter(adapter_gv);
        lly.addView(gv);
        frameAnimation = (AnimationDrawable)iv_londing.getBackground();
        initlistener();
    }

    private void initlistener()
    {
        bt_newtalk.setOnClickListener(ocl);
        bt_right.setOnClickListener(ocl);
        bt_left.setOnClickListener(ocl);
        iv_search.setOnClickListener(ocl);
        lv.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                MainActivity.fmconvert_talkinfo = new ConvertTalkInfoFragment();
                mActivity.getSupportFragmentManager().beginTransaction().add(0x7f07000a, MainActivity.fmconvert_talkinfo).commit();
                Bundle bundle = new Bundle();
                bundle.putSerializable("con", (Serializable)((ConvertListAdapter)adapter_lv).getConversations().get(i));
                mActivity.getIntent().putExtra("con", bundle);
                mActivity.getSupportFragmentManager().beginTransaction().hide(MainActivity.fmnet).hide(MainActivity.fmlocal).hide(MainActivity.fmconvert).hide(MainActivity.fmset).hide(MainActivity.fmconvert_talkinfo).show(MainActivity.fmconvert_talkinfo).commit();
            }

//            final ConvertFragment this$0;
//
//            
//            {
//                this$0 = ConvertFragment.this;
//                super();
//            }
        }
);
        gv.setOnItemClickListener(otcl);
    }

    private void refreshListAndGrid(final int page, final String ss)
    {
        contentlly.setVisibility(8);
        lv.setVisibility(8);
        londinglly.setVisibility(0);
        (new AsyncTask() {

            private void refreshgrid()
            {
                gv.setOnItemClickListener(null);
                lly.removeAllViews();
                gv = null;
                gv = new GridView(mActivity);
                ((PageItemAdapter)adapter_gv).setLen(len);
                gv.setNumColumns(len);
                dpi = mActivity.getResources().getDisplayMetrics().density;
                int i = (int)(0.5F + 42F * dpi * (float)len);
                gv.setHorizontalSpacing((int)(0.5F + 2.0F * dpi));
                gv.setColumnWidth((int)(40F * dpi));
                gv.setLayoutParams(new android.view.ViewGroup.LayoutParams(i, -2));
                gv.setStretchMode(0);
                gv.setAdapter(adapter_gv);
                lly.addView(gv);
                gv.setOnItemClickListener(otcl);
                adapter_gv.notifyDataSetChanged();
                dorefreshgrid = false;
                contentlly.setVisibility(0);
                lv.setVisibility(0);
                londinglly.setVisibility(8);
            }

            protected Object doInBackground(Object aobj[])
            {
                return doInBackground((String[])aobj);
            }

            protected String doInBackground(String as[])
            {
//                ConversationDAO conversationdao;
//                conlist = null;
//                conversationdao = (ConversationDAO)RpcUtils2.getDao("conversationDao", 
//                		com/iring/dao/ConversationDAO);
//                if(ss != null && !ss.equals("")) goto _L2; else goto _L1
//_L1:
//                ii = conversationdao.qureyitemnum();
//                rpc = conversationdao.qureyall(page);
//                if(ii != null && rpc != null)
//                {
//                    int i;
//                    if(ii.intValue() % 10 == 0)
//                        i = ii.intValue() / 10;
//                    else
//                        i = 1 + ii.intValue() / 10;
//                    len = i;
//                    conlist = rpc.getDatas();
//                }
//_L4:
//                return null;
//_L2:
//                rpc = conversationdao.qureylike(ss, page);
//                ii = conversationdao.qureylikeitemnum(ss);
//                if(ii != null && rpc != null)
//                {
//                    int j;
//                    if(ii.intValue() % 10 == 0)
//                        j = ii.intValue() / 10;
//                    else
//                        j = 1 + ii.intValue() / 10;
//                    len = j;
//                    conlist = rpc.getDatas();
//                }
//                if(true) goto _L4; else goto _L3
//_L3:
                return null;
            }

            protected void onPostExecute(Object obj)
            {
                onPostExecute((String)obj);
            }

            protected void onPostExecute(String s)
            {
                contentlly.setVisibility(0);
                lv.setVisibility(0);
                londinglly.setVisibility(8);
//                if(rpc != null && ii != null)
//                {
//                    if(dorefreshgrid)
//                        refreshgrid();
//                    ((ConvertListAdapter)adapter_lv).setConversations(conlist);
//                    adapter_lv.notifyDataSetChanged();
//                    lv.setSelection(0);
//                } else
//                {
//                    Toast.makeText(mActivity, "\uFFFD\u07B7\uFFFD\uFFFD\uFFFD\uFFFD\u04F5\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD", 2000).show();
//                }
            }

            Integer ii;
            int len;
//            ConversationRpc rpc;
//            final ConvertFragment this$0;
//            private final int val$page;
//            private final String val$ss;
//
//            
//            {
//                this$0 = ConvertFragment.this;
//                ss = s;
//                page = i;
//                super();
//                ii = null;
//                rpc = null;
//            }
        }
).execute(new String[0]);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        mActivity = getActivity();
        mParent = getView();
        init();
        initdata();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030007, viewgroup, false);
    }

    public void onHiddenChanged(boolean flag)
    {
        super.onHiddenChanged(flag);
        if(!flag)
        {
            MainActivity.viewid = 1;
            frameAnimation.start();
            dorefreshgrid = true;
            Log.i("test", (new StringBuilder()).append(dorefreshgrid).toString());
            hsv.scrollTo((int)(42F * dpi * (float)pagenum), 0);
            refreshListAndGrid(pagenum, key);
        } else
        {
            key = null;
            contentlly.setVisibility(8);
            lv.setVisibility(8);
            londinglly.setVisibility(0);
        }
    }

    private static AnimationDrawable frameAnimation;
    public static String key = null;
    public static int pagenum = 1;
    private BaseAdapter adapter_gv;
    private BaseAdapter adapter_lv;
    private Button bt_left;
    private Button bt_newtalk;
    private Button bt_right;
    private List conlist;
    private LinearLayout contentlly;
    private boolean dorefreshgrid;
    private float dpi;
    private EditText edt_search;
    private GridView gv;
    private int gvlen;
    private HorizontalScrollView hsv;
    private ImageView iv_londing;
    private ImageView iv_search;
    private LinearLayout lly;
    private LinearLayout londinglly;
    private ListView lv;
    private int lvlen;
    private FragmentActivity mActivity;
    private View mParent;
    private android.view.View.OnClickListener ocl;
    private android.widget.AdapterView.OnItemClickListener otcl;
    private int pagesizedpi;
    private int prepos;























}
