// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.baoyi.guoyiyun.babymusic;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.*;
import android.text.Editable;
import android.view.*;
import android.widget.*;
import com.baoyi.guoyiyun.utils.RpcUtils2;
import com.iring.dao.ConversationDAO;
import com.iring.entity.Conversation;
import java.net.*;
import java.util.Date;
import java.util.Enumeration;

// Referenced classes of package com.baoyi.guoyiyun.babymusic:
//            ConvertFragment, MainActivity

public class NewTalkFragment extends Fragment
{

    public NewTalkFragment()
    {
        ocl = new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
//                int i = view.getId();
//                if(i != 0x7f070065) goto _L2; else goto _L1
//_L1:
//                ConvertFragment.key = ed_search.getText().toString().trim();
//                ConvertFragment.pagenum = 1;
//                if(MainActivity.viewid == 32 && MainActivity.fmconvert_newtalk != null)
//                    mActivity.getSupportFragmentManager().beginTransaction().remove(MainActivity.fmconvert_newtalk).commit();
//                mActivity.getSupportFragmentManager().beginTransaction().hide(MainActivity.fmnet).hide(MainActivity.fmlocal).hide(MainActivity.fmconvert).hide(MainActivity.fmset).show(MainActivity.fmconvert).commit();
//_L4:
//                return;
//_L2:
//                if(i == 0x7f070068)
//                {
//                    String s = ed_title.getText().toString().trim();
//                    if(s.equals("") || s == null)
//                    {
//                        Toast.makeText(mActivity, "\u6807\u9898\u4E0D\u80FD\u4E3A\u7A7A", 2000).show();
//                    } else
//                    {
//                        String s1 = ed_content.getText().toString().trim();
//                        if(s1.equals("") || s1 == null)
//                            Toast.makeText(mActivity, "\u5185\u5BB9\u4E0D\u80FD\u4E3A\u7A7A", 2000).show();
//                        else
//                            add(s, s1);
//                    }
//                }
//                if(true) goto _L4; else goto _L3
//_L3:
            }

//            final NewTalkFragment this$0;
//
//            
//            {
//                this$0 = NewTalkFragment.this;
//                super();
//            }
        }
;
    }

    private void add(final String title, final String content)
    {
        (new AsyncTask() {

            protected Object doInBackground(Object aobj[])
            {
                return doInBackground((String[])aobj);
            }

            protected String doInBackground(String as[])
            {
                ConversationDAO conversationdao = (ConversationDAO)RpcUtils2.getDao("conversationDao", ConversationDAO.class);
                Conversation conversation = new Conversation();
                conversation.setTitle(title);
                conversation.setAuthorid(0);
                conversation.setAuthorname(null);
                conversation.setContent(content);
                conversation.setHit(1);
                conversation.setPosttime((new Date()).getTime());
                conversation.setIp(getLocalIpAddress());
                conversationdao.add(conversation);
                return null;
            }

            protected void onPostExecute(Object obj)
            {
                onPostExecute((String)obj);
            }

            protected void onPostExecute(String s)
            {
                if(MainActivity.viewid == 32 && MainActivity.fmconvert_newtalk != null)
                    mActivity.getSupportFragmentManager().beginTransaction().remove(MainActivity.fmconvert_newtalk).commit();
                ConvertFragment.pagenum = 1;
                mActivity.getSupportFragmentManager().beginTransaction().hide(MainActivity.fmnet).hide(MainActivity.fmlocal).hide(MainActivity.fmconvert).hide(MainActivity.fmconvert_newtalk).hide(MainActivity.fmset).show(MainActivity.fmconvert).commit();
            }

//            final NewTalkFragment this$0;
//            private final String val$content;
//            private final String val$title;
//
//            
//            {
//                this$0 = NewTalkFragment.this;
//                title = s;
//                content = s1;
//                super();
//            }
        }
).execute(new String[0]);
    }

    private void init()
    {
        ed_search = (EditText)mParent.findViewById(0x7f070064);
        ed_title = (EditText)mParent.findViewById(0x7f070066);
        ed_content = (EditText)mParent.findViewById(0x7f070067);
        iv = (ImageView)mParent.findViewById(0x7f070065);
        bt = (Button)mParent.findViewById(0x7f070068);
    }

    private void initlistener()
    {
        iv.setOnClickListener(ocl);
        bt.setOnClickListener(ocl);
    }

    public String getLocalIpAddress()
    {
//        Enumeration enumeration = NetworkInterface.getNetworkInterfaces();
//_L2:
//        Enumeration enumeration1;
//        if(!enumeration.hasMoreElements())
//            break MISSING_BLOCK_LABEL_77;
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
//        break MISSING_BLOCK_LABEL_79;
//        SocketException socketexception;
//        socketexception;
//        s = null;
//        return s;
    	
    	return null;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        mActivity = getActivity();
        mParent = getView();
        init();
        initlistener();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f03000d, viewgroup, false);
    }

    private Button bt;
    private EditText ed_content;
    private EditText ed_search;
    private EditText ed_title;
    private ImageView iv;
    private FragmentActivity mActivity;
    private View mParent;
    private android.view.View.OnClickListener ocl;





}
