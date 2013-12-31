// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.baoyi.guoyiyun.util;

import android.os.Environment;
import java.io.*;

public class FileUtils
{

    public FileUtils()
    {
        SDPATH = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").toString();
    }

    public File createSDDir(String s)
    {
        File file = new File((new StringBuilder(String.valueOf(SDPATH))).append(s).toString());
        file.mkdir();
        return file;
    }

    public File createSDFile(String s)
        throws IOException
    {
        File file = new File((new StringBuilder(String.valueOf(SDPATH))).append(s).toString());
        file.createNewFile();
        return file;
    }

    public String getSDPATH()
    {
        return SDPATH;
    }

    public boolean isFileExist(String s)
    {
        return (new File((new StringBuilder(String.valueOf(SDPATH))).append(s).toString())).exists();
    }

    public File writeDataToSDCrard(String s, String s1, BufferedInputStream bufferedinputstream)
    {
//        FileOutputStream fileoutputstream;
//        File file;
//        String s2;
//        File file1;
//        fileoutputstream = null;
//        file = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append(s).append(s1).toString());
//        s2 = (new StringBuilder(String.valueOf(s))).append(s1).append("temp").toString();
//        file1 = new File(s2);
//        IOException ioexception;
//        Exception exception;
//        File file2;
//        FileOutputStream fileoutputstream1;
//        BufferedOutputStream bufferedoutputstream;
//        byte abyte0[];
//        int i;
//        try
//        {
//            createSDDir(s);
//            if(file1.exists())
//                file1.delete();
//            file2 = createSDFile(s2);
//            fileoutputstream1 = new FileOutputStream(file2);
//        }
//        // Misplaced declaration of an exception variable
//        catch(IOException ioexception)
//        {
//            continue; /* Loop/switch isn't completed */
//        }
//        bufferedoutputstream = new BufferedOutputStream(fileoutputstream1);
//        abyte0 = new byte[6144];
//_L1:
//        i = bufferedinputstream.read(abyte0);
//        if(i != -1)
//            break MISSING_BLOCK_LABEL_194;
//        fileoutputstream1.flush();
//        boolean flag = file2.renameTo(file);
//        System.out.println((new StringBuilder("rename:")).append(flag).toString());
//        try
//        {
//            fileoutputstream1.close();
//        }
//        catch(IOException ioexception3)
//        {
//            ioexception3.printStackTrace();
//        }
//        return file;
//        bufferedoutputstream.write(abyte0, 0, i);
//          goto _L1
//        ioexception;
//        fileoutputstream = fileoutputstream1;
//_L5:
//        ioexception.printStackTrace();
//        try
//        {
//            fileoutputstream.close();
//        }
//        catch(IOException ioexception2)
//        {
//            ioexception2.printStackTrace();
//        }
//        break MISSING_BLOCK_LABEL_191;
//        exception;
//_L3:
//        try
//        {
//            fileoutputstream.close();
//        }
//        catch(IOException ioexception1)
//        {
//            ioexception1.printStackTrace();
//        }
//        throw exception;
//        exception;
//        fileoutputstream = fileoutputstream1;
//        continue; /* Loop/switch isn't completed */
//        exception;
//        fileoutputstream = fileoutputstream1;
//        if(true) goto _L3; else goto _L2
//_L2:
//        break MISSING_BLOCK_LABEL_116;
//        ioexception;
//        fileoutputstream = fileoutputstream1;
//        if(true) goto _L5; else goto _L4
//_L4:
    	return null;
    }

    private String SDPATH;
}
