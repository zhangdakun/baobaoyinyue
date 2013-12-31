// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.baoyi.ring.questionnaire;

import java.io.Serializable;

public class Questionnaire
    implements Serializable
{

    public Questionnaire()
    {
    }

    public Questionnaire(Integer integer, String s, String s1, String s2, Long long1)
    {
        id = integer;
        packagename = s;
        question = s1;
        answer = s2;
        pubtime = long1;
    }

    public String getAnswer()
    {
        return answer;
    }

    public Integer getId()
    {
        return id;
    }

    public String getPackagename()
    {
        return packagename;
    }

    public Long getPubtime()
    {
        return pubtime;
    }

    public String getQuestion()
    {
        return question;
    }

    public void setAnswer(String s)
    {
        answer = s;
    }

    public void setId(Integer integer)
    {
        id = integer;
    }

    public void setPackagename(String s)
    {
        packagename = s;
    }

    public void setPubtime(Long long1)
    {
        pubtime = long1;
    }

    public void setQuestion(String s)
    {
        question = s;
    }

    private String answer;
    private Integer id;
    private String packagename;
    private Long pubtime;
    private String question;
}
