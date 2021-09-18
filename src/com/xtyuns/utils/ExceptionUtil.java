package com.xtyuns.utils;

public class ExceptionUtil {
    public static String formatMsg(Exception e) {
        String msg = e.toString();
        // remove package name
        int split = msg.indexOf(':');
        int begin = msg.substring(0, split).lastIndexOf('.');
        msg = msg.substring(begin + 1);
        return msg;
    }
}
