package com.application.tests.day12;

import com.application.utilities.Driver;

public class Singleton {

    private Singleton(){}

    private static String str;

    public static String getSingleton(){
        if(str == null){
            System.out.println("assign something str");
            str = "value";
        }else {
            System.out.println("it is already assigned something");
            str = "value2";
        }
        return str;
    }

    public static void main(String[] args) {
        String s1 = Singleton.getSingleton();
        String s2 = Singleton.getSingleton();
        String s3 = Singleton.getSingleton();

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        System.out.println("s3 = " + s3);

        //throw new RuntimeException("this exception will be made by Eren");

        Driver.get().get("www.amazon.com");

    }





}
