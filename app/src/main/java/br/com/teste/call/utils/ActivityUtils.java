package br.com.teste.call.utils;

import android.app.Activity;

import br.com.teste.call.R;

public class ActivityUtils {
    private static final String TAG = ActivityUtils.class.getSimpleName();

    public static void openWithSlide(Activity ctx){
        try{
            ctx.overridePendingTransition(R.anim.abc_slide_in_right, R.anim.abc_slide_out_left);
        }catch (Exception e) {
            LogUtils.w(TAG, e.getMessage());
        }
    }

    public static void closeWithSlide(Activity ctx){
        try{
            ctx.overridePendingTransition(R.anim.abc_slide_in_left, R.anim.abc_slide_out_right);
        }catch (Exception e) {
            LogUtils.w(TAG, e.getMessage());
        }
    }

    public static void openWithFade(Activity ctx) {
        try{
            ctx.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }catch (Exception e){
            LogUtils.w(TAG, e.getMessage());
        }
    }

    public static void closeWithFade(Activity ctx) {
        try{
            ctx.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }catch (Exception e){
            LogUtils.w(TAG, e.getMessage());
        }
    }
}

