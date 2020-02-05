package com;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class test1 {
//    public static void main(String[] args) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-DD");
//        SimpleDateFormat minFormat = new SimpleDateFormat("HH:mm:ss");
//        SimpleDateFormat allFormat = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
//        System.out.println(dateFormat.format(System.currentTimeMillis()));
//        System.out.println(minFormat.format(System.currentTimeMillis()));
//        System.out.println(Date.valueOf(dateFormat.format(System.currentTimeMillis())).getClass());
//        System.out.println(allFormat.format(System.currentTimeMillis()));
//        System.out.println(allFormat.format(System.currentTimeMillis()));
//    }
public static void main(String[] args) {
    Date utilDate = new Date(System.currentTimeMillis());//util utilDate
    System.out.println("utilDate : " + utilDate);
    Timestamp sqlDate = new Timestamp(utilDate.getTime());//uilt date转sql date
    System.out.println("sqlDate : " + sqlDate);
    Date date = new Date(sqlDate.getTime());
    System.out.println(date);
}
}
