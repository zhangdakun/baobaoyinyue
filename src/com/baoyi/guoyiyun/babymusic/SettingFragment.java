// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.baoyi.guoyiyun.babymusic;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.*;
import android.os.*;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.*;
import android.widget.*;
import com.baoyi.guoyiyun.constant.Constant;
//import com.by.update.UmsAgent;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package com.baoyi.guoyiyun.babymusic:
//            SettingtestActivity, SettingAboutActivity

public class SettingFragment extends Fragment
{

    public SettingFragment()
    {
        handler = new Handler();
        ocl = new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
//                int i = view.getId();
//                if(i != 0x7f07003a) goto _L2; else goto _L1
//_L1:
//                final ProgressDialog builder = new ProgressDialog(mActivity);
//                builder.setMessage("\u6B63\u5728\u6E05\u7406\u7F13\u5B58\u8BF7\u7A0D\u540E\uFF01\uFF01\uFF01");
//                builder.show();
//                (new Thread() {
//
//                    public void run()
//                    {
//                        clearData();
//                        Thread.sleep(2000L);
//                        handler.post(new Runnable() {
//
//                            public void run()
//                            {
//                                builder.dismiss();
//                            }
//
//                            final _cls1 this$2;
//                            private final ProgressDialog val$builder;
//
//                        
//                        {
//                            this$2 = _cls1.this;
//                            builder = progressdialog;
//                            super();
//                        }
//                        }
//);
//_L2:
//                        return;
//                        InterruptedException interruptedexception;
//                        interruptedexception;
//                        interruptedexception.printStackTrace();
//                        handler.post(new _cls1());
//                        if(true) goto _L2; else goto _L1
//_L1:
//                        Exception exception;
//                        exception;
//                        handler.post(new _cls1());
//                        throw exception;
//                    }
//
//                    final _cls1 this$1;
//                    private final ProgressDialog val$builder;
//
//                    
//                    {
//                        this$1 = _cls1.this;
//                        builder = progressdialog;
//                        super();
//                    }
//                }
//).start();
//_L4:
//                return;
//_L2:
//                if(i == 0x7f07003b)
//                    UmsAgent.updatenotice(mActivity);
//                else
//                if(i == 0x7f07003f)
//                {
//                    Intent intent = new Intent();
//                    intent.setClass(mActivity, com/baoyi/guoyiyun/babymusic/SettingtestActivity);
//                    startActivity(intent);
//                } else
//                if(i == 0x7f07003d)
//                {
//                    Intent intent1 = new Intent();
//                    intent1.setClass(mActivity, com/baoyi/guoyiyun/babymusic/SettingAboutActivity);
//                    startActivity(intent1);
//                }
//                if(true) goto _L4; else goto _L3
//_L3:
            }

//            final SettingFragment this$0;
//
//
//            
//            {
//                this$0 = SettingFragment.this;
//                super();
//            }
        }
;
    }

    private void clearData()
    {
//        PackageManager packagemanager;
//        Class aclass[];
//        packagemanager = mActivity.getPackageManager();
//        aclass = new Class[2];
//        aclass[0] = Long.TYPE;
//        aclass[1] = android/content/pm/IPackageDataObserver;
//        Method method = packagemanager.getClass().getMethod("freeStorageAndNotify", aclass);
//        Long long1 = Long.valueOf(getEnvironmentSize() - 1L);
//        (new Object[2])[0] = long1;
//        Object aobj[] = new Object[2];
//        aobj[0] = long1;
//        aobj[1] = new android.content.pm.IPackageDataObserver.Stub() {
//
//            public void onRemoveCompleted(String s, boolean flag)
//                throws RemoteException
//            {
//            }
//
//            final SettingFragment this$0;
//
//            
//            {
//                this$0 = SettingFragment.this;
//                super();
//            }
//        }
//;
//        method.invoke(packagemanager, aobj);
//_L1:
//        return;
//        IllegalArgumentException illegalargumentexception;
//        illegalargumentexception;
//        illegalargumentexception.printStackTrace();
//          goto _L1
//        NoSuchMethodException nosuchmethodexception;
//        nosuchmethodexception;
//        nosuchmethodexception.printStackTrace();
//          goto _L1
//        IllegalAccessException illegalaccessexception;
//        illegalaccessexception;
//        illegalaccessexception.printStackTrace();
//          goto _L1
//        InvocationTargetException invocationtargetexception;
//        invocationtargetexception;
//        invocationtargetexception.printStackTrace();
//          goto _L1
    }

    private static long getEnvironmentSize()
    {
        File file = Environment.getDataDirectory();
        if(file != null);
        StatFs statfs = new StatFs(file.getPath());
        return (long)statfs.getBlockSize() * (long)statfs.getBlockCount();
    }

    private void init()
    {
        bt_clearache = (Button)mParent.findViewById(0x7f07003a);
        bt_searchnewversion = (Button)mParent.findViewById(0x7f07003b);
        bt_test = (Button)mParent.findViewById(0x7f07003f);
        bt_aboutus = (Button)mParent.findViewById(0x7f07003d);
        tv = (TextView)mParent.findViewById(0x7f07003c);
        rg = (RadioGroup)mParent.findViewById(0x7f070036);
        rb1 = (RadioButton)mParent.findViewById(0x7f070037);
        rb2 = (RadioButton)mParent.findViewById(0x7f070038);
        rb3 = (RadioButton)mParent.findViewById(0x7f070039);
        bt_clearache.setOnClickListener(ocl);
        bt_searchnewversion.setOnClickListener(ocl);
        bt_test.setOnClickListener(ocl);
        bt_aboutus.setOnClickListener(ocl);
        tv.setText(getVersion());
        rg.setOnCheckedChangeListener(new android.widget.RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup radiogroup, int i)
            {
//                if(sp == null)
//                {
//                    sp = mActivity.getSharedPreferences("sp", 0);
//                    ed = sp.edit();
//                }
//                if(i != 0x7f070037) goto _L2; else goto _L1
//_L1:
//                ed.putInt("mode", 0).commit();
//                Constant.musicplaymode = 0;
//_L4:
//                return;
//_L2:
//                if(i == 0x7f070038)
//                {
//                    ed.putInt("mode", 1).commit();
//                    Constant.musicplaymode = 1;
//                } else
//                if(i == 0x7f070039)
//                {
//                    ed.putInt("mode", 2).commit();
//                    Constant.musicplaymode = 2;
//                }
//                if(true) goto _L4; else goto _L3
//_L3:
            }

//            final SettingFragment this$0;
//
//            
//            {
//                this$0 = SettingFragment.this;
//                super();
//            }
        }
);
    }

    public String getVersion()
    {
//        String s2;
//        String s1 = mActivity.getPackageManager().getPackageInfo(mActivity.getPackageName(), 0).versionName;
//        s2 = (new StringBuilder("v")).append(s1).toString();
//        String s = s2;
//_L2:
//        return s;
//        Exception exception;
//        exception;
//        exception.printStackTrace();
//        s = "\u7A0B\u5E8F\u5F02\u5E38\uFF0C\u8BF7\u7A0D\u540E\u518D\u8BD5~";
//        if(true) goto _L2; else goto _L1
//_L1:
    	return null;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        mActivity = getActivity();
        mParent = getView();
        init();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f03000e, viewgroup, false);
    }

    public void onHiddenChanged(boolean flag)
    {
        super.onHiddenChanged(flag);
//        if(flag) goto _L2; else goto _L1
//_L1:
//        sp = mActivity.getSharedPreferences("sp", 0);
//        Constant.musicplaymode = sp.getInt("mode", 1);
//        ed = sp.edit();
//        Constant.musicplaymode;
//        JVM INSTR tableswitch 0 2: default 84
//    //                   0 85
//    //                   1 110
//    //                   2 135;
//           goto _L3 _L4 _L5 _L6
//_L3:
//        return;
//_L4:
//        rb1.setChecked(true);
//        ed.putInt("mode", 0);
//        continue; /* Loop/switch isn't completed */
//_L5:
//        rb2.setChecked(true);
//        ed.putInt("mode", 1);
//        continue; /* Loop/switch isn't completed */
//_L6:
//        rb3.setChecked(true);
//        ed.putInt("mode", 2);
//        continue; /* Loop/switch isn't completed */
//_L2:
//        sp = null;
//        ed = null;
//        if(true) goto _L3; else goto _L7
//_L7:
    }

    private Button bt_aboutus;
    private Button bt_clearache;
    private Button bt_searchnewversion;
    private Button bt_test;
    private android.content.SharedPreferences.Editor ed;
    Handler handler;
    private FragmentActivity mActivity;
    private View mParent;
    private android.view.View.OnClickListener ocl;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioGroup rg;
    private SharedPreferences sp;
    private TextView tv;






}
