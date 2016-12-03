package br.com.teste.call.helper;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Modifier;

public class PrefsHelper {
    private static Gson gson;
    public PrefsHelper() {
    }

    private static SharedPreferences getGCMPreferences(Context context){
        return(context.getSharedPreferences("br.com.going2.carroramaobd", Context.MODE_PRIVATE));
    }

    private static Gson myGson(){
        if(gson == null){
            gson = new GsonBuilder()
                    .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                    .serializeNulls()
                    .create();
        }

        return gson;
    }

    public static void setObject(Context context, Object t, String key){
        String json = myGson().toJson(t);
        SharedPreferences prefs = getGCMPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, json);
        editor.commit();
    }

    public static Object getObject(Context context, String key, Object myClass){

        SharedPreferences prefs = getGCMPreferences(context);
        String json = prefs.getString(key, "");

        if( json.equals("") ){
            return null;
        }else{

            try{
                myClass = myGson().fromJson(json, myClass.getClass() );
                return  myClass;
            }catch (Exception e){
                return null;
            }

        }

    }

    public static void deleteObject(Context context, String key){
        SharedPreferences prefs = getGCMPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.remove(key);
        editor.commit();
    }
}
