package com.hydra.core.common.utils;


public class P {

    public static void println(String msg, Object ...objects){

        if(StringUtil.isNotEmpty(msg)){
            String allStr = msg;
            for (int i = 0; i <objects.length ; i++) {
                allStr = allStr.replaceFirst("\\{\\}",objects[i].toString());
            }
            System.out.println(allStr);
        }

    }

    public static void println(Object msg){

        if(null != msg){
            String allStr = msg.toString();
            System.out.println(allStr);
        }
    }

}
