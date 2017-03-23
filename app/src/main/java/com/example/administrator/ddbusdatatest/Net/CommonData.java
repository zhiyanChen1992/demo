package com.example.administrator.ddbusdatatest.Net;

import android.util.Log;


import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.HttpHandler;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import org.apache.http.NameValuePair;

import java.util.List;


/**
 * Created by Administrator on 2017/3/21 0021.
 */
public class CommonData {



//    http://202.175.87.15:8013/ddbus/station/stacode?debug=true&action=bdgps&&log=113.551013&
//     lat=22.189383&range=300&MAC=A12321B1C1E6&HUID=238881bb1&mobile=android-v4.4&appVer=0.3.3&BypassToken=HuatuTesting0307
    public static final String API_URL = "http://202.175.87.15:7013/";
    public static  RequestParams requestParams=null;


    public static RequestParams getRequestParama(){
        requestParams = new RequestParams();
        requestParams.addQueryStringParameter("HUID","238881bb1");
        requestParams.addQueryStringParameter("mobile","android-v4.4");
        requestParams.addQueryStringParameter("appVer","0.3.3");
        requestParams.addQueryStringParameter("BypassToken","HuatuTesting0307");
        return requestParams;
    }
    public static void getDataFromService(RequestParams params, String urlName,final HttpUtilsCallBack callBack){
        Log.e("requestUrl",API_URL+urlName);
        List<NameValuePair> list = params.getQueryStringParams();
        StringBuffer sb = new StringBuffer();
        for (NameValuePair aa : list) {
            sb.append(aa.getName() + "=" + aa.getValue() + "&");
        }
        Log.e("URL", API_URL+urlName +"?"+ sb.toString());
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.configCurrentHttpCacheExpiry(0);
        httpUtils.configTimeout(300000);
        HttpHandler<String> handler=httpUtils.send(HttpRequest.HttpMethod.POST, API_URL+urlName, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                callBack.succ(responseInfo.result);
            }
            @Override
            public void onFailure(HttpException e, String s) {
                callBack.failure(s);
            }
        });
    }



}
