package com.example.demo.sevice;

import com.example.demo.controller.StuController;
import com.example.demo.controller.teaController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class dateChange {
    public static Date endTime;
    public static int testTimeJudge;
    public static int  dateListTo(String[] a) throws Exception {
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher h = p.matcher(a[0]);
        Matcher m = p.matcher(a[1]);
        Matcher s = p.matcher(a[2]);
        int rh=Integer.valueOf(h.replaceAll("").trim());
        int rm=Integer.valueOf(m.replaceAll("").trim());
        int rs=Integer.valueOf(s.replaceAll("").trim());
//        System.out.println(rh);
        int timeS=rh*3600 +rm*60 + rs;
        System.out.println(timeS);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        String nowDate=df.format(new Date());

        Calendar rightNow = Calendar.getInstance();
        Date dt = df.parse(nowDate);
        rightNow.setTime(dt);
        rightNow.add(Calendar.SECOND,+timeS);
        Date dt1=rightNow.getTime();
        String reStr = df.format(dt1);
        System.out.println("0:"+dt1);

        long at =new Date().getTime() ;
        long bt=dt1.getTime();
        int c = (int)((bt - at) / 1000);
        endTime=dt1;
        return c+1;
    }

    public  void dateCurrent(){
        long at =new Date().getTime() ;
        long bt=endTime.getTime();
        int c = (int)((bt - at) / 1000);
        System.out.println(new Date()+"当前时间");
        System.out.println(endTime+"截止时间");
//        System.out.println("1:"+teaController.finalQueList.toString());
        System.out.println(c);
        teaController.finalQueList.set(1,c);
        testTimeJudge =c;
//        System.out.println("2:"+teaController.finalQueList.toString());

    }
}
