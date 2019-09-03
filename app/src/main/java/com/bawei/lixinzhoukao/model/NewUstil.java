package com.bawei.lixinzhoukao.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.lixinzhoukao.app.Api;
import com.bawei.lixinzhoukao.app.App;

public class NewUstil {
    private static final String TAG = "NewUstil";
     private  static NewUstil newUstil=null;
     private NewUstil (){}
     public  static  NewUstil getInstance(){
         if (newUstil==null){
             synchronized (NewUstil.class){
                 if (newUstil==null){
                     newUstil=new NewUstil();
                 }
             }
         }
         return newUstil;
     }
     public  boolean wan(){
         ConnectivityManager cm= (ConnectivityManager) App.sContext.getSystemService(Context.CONNECTIVITY_SERVICE);
         NetworkInfo info = cm.getActiveNetworkInfo();
         if (info != null) {
             return info.isAvailable();
         }
         return false;
     }
     public  interface  ICallBack{
         void  onCheng(Object obj);
         void onShi(String meg);
     }
     public  void  doGet(final String path, final ICallBack iCallBack){
         boolean wan = wan();
         if (wan){
             RequestQueue requestQueue = Volley.newRequestQueue(App.sContext);
             StringRequest request=new StringRequest(Request.Method.GET, path, new Response.Listener<String>() {
                 @Override
                 public void onResponse(String response) {
                     SharedPreferences sharedPreferences = App.sContext.getSharedPreferences(Api.CON_FIG, Context.MODE_PRIVATE);
                     SharedPreferences.Editor edit = sharedPreferences.edit();
                     edit.putString(path,response);
                     edit.commit();
                     Log.d(TAG, "onResponse: ");
                     if (iCallBack != null) {
                         iCallBack.onCheng(response);
                     }
                 }
             }, new Response.ErrorListener() {
                 @Override
                 public void onErrorResponse(VolleyError error) {
                     Log.d(TAG, "onErrorResponse: ");
                     if (iCallBack != null) {

                         iCallBack.onShi(error.getMessage());
                     }
                 }
             });
             requestQueue.add(request);
         }else {
             SharedPreferences sharedPreferences = App.sContext.getSharedPreferences(Api.CON_FIG, Context.MODE_PRIVATE);
             String che = sharedPreferences.getString(path, "");
             if (TextUtils.isEmpty(che)) {
                 iCallBack.onCheng(che);
             }else {
                 iCallBack.onShi("无缓存");
             }
         }

     }
}
