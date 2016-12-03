package br.com.teste.call.utils;

import android.util.Log;

public class LogUtils {
    public static void i(String tag, String msg) {
        Log.i(tag, msg);
    }
    public static void w(String tag, String msg) {
        Log.w(tag, msg);
    }
    public static void e(String tag, String msg) {
        Log.e(tag, msg);
    }
    public static void i(String tag, String msg, Throwable t) {
        Log.i(tag, msg, t);
    }
    public static void w(String tag, String msg, Throwable t) {
        Log.w(tag, msg, t);
    }
    public static void e(String tag, String msg, Throwable t) {
        Log.e(tag, msg, t);
    }
}
