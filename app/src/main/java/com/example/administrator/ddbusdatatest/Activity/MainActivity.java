package com.example.administrator.ddbusdatatest.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.ddbusdatatest.Adapter.ExListStaInfoAdapter;
import com.example.administrator.ddbusdatatest.Bean.StaionInfo;
import com.example.administrator.ddbusdatatest.Bean.StaionNamicInfo;
import com.example.administrator.ddbusdatatest.Bean.StateCode;
import com.example.administrator.ddbusdatatest.Net.CommonData;
import com.example.administrator.ddbusdatatest.Net.HttpUtilsCallBack;
import com.example.administrator.ddbusdatatest.R;
import com.example.administrator.ddbusdatatest.widgets.StaInfoExListView;
import com.google.gson.Gson;
import com.lidroid.xutils.http.RequestParams;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Timer;
import java.util.TimerTask;
/*主界面*/
public class MainActivity extends AppCompatActivity {


    private RequestParams params;
    private StateCode stateCode;
    private StaionInfo staionInfo;
    private StaionNamicInfo staNamicInfo;
    private Gson gson;
    private StaInfoExListView ex_lv_stationinfo;
    private ExListStaInfoAdapter exLvAdapter;
    private View view;
    private Button btnTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        intiVew();
        getData();

    }
    private void intiVew() {
        ex_lv_stationinfo = (StaInfoExListView) findViewById(R.id.ex_lv_stationinfo);
        view = LayoutInflater.from(this).inflate(R.layout.item_head,null);
        ex_lv_stationinfo.addHeaderView(view);
        btnTime = (Button) view.findViewById(R.id.btn_time);

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post("刷新");
                timer();

            }
        });
    }


    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    if(msg.arg1==0){
                        btnTime.setText("5s");
                        btnTime.setClickable(true);
                    }else{
                        btnTime.setText(+msg.arg1+"s");
                        btnTime.setClickable(false);
                    }

                    break;
            }
        }
    };

        private void timer() {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 5; i >= 0; i--) {
                        Message msg = handler.obtainMessage();
                        msg.arg1 = i;
                        handler.sendMessage(msg);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
            private void getData() {
                gson = new Gson();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // 通过经纬度获取站台编码
                        getStacodeByLat();
                        // 通过站台编码获取站台静态信息
//                getStationInfoByCode();
                        //通过编码获取站台动态信息
//                getStationInfoBynamicCode();

                    }
                }).start();
            }


            //    http://202.175.87.15:7013/ddbus/station/stacode?debug=true&
// action=bdgps&&log=113.551013&lat=22.189383&range=300&MAC=A12321B1C1E6&HUID=238881bb1&mobile=android-v4.4&appVer=0.3.3&BypassToken=HuatuTesting0307
            private void getStacodeByLat() {
                params = CommonData.getRequestParama();
                params.addQueryStringParameter("action", "bdgps");
                params.addQueryStringParameter("log", "113.551013");
                params.addQueryStringParameter("lat", "22.189383");
                params.addQueryStringParameter("range", "300");
                params.addQueryStringParameter("MAC", "A12321B1C1E6");
                CommonData.getDataFromService(params, "ddbus/station/stacode", new HttpUtilsCallBack() {
                    @Override
                    public void succ(String result) {
                        Log.e("getStacodeByLat", result);
                        String strJson = result.substring(1, result.length() - 1);
                        stateCode = gson.fromJson(strJson, StateCode.class);
                        Log.e("stateCode", stateCode.toString());

                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < stateCode.getData().size(); i++) {
                            StateCode.DataBean dataBean = stateCode.getData().get(i);
                            sb.append(dataBean.getStacode() + ",");
                        }
                        Log.e("sbCode", sb.toString());
                        // 通过站台编码获取站台静态信息
                        getStationInfoByCode(sb.toString().substring(0, sb.length() - 1));

                    }

                    @Override
                    public void failure(String s) {
                        Log.e("getStacodeByLat", s);
                    }
                });
            }

            private void getStationInfoByCode(final String stacode) {

//        http://202.175.87.15:7013/station/info?mobile=android-v4.4&appVer=0.3.3
//  &BypassToken=HuatuTesting0307&action=staCode&stacode=10001,10002&MAC=A12321B1C1E6&HUID=238881bb1&

                params = CommonData.getRequestParama();
                params.addQueryStringParameter("action", "staCode");
                params.addQueryStringParameter("stacode", stacode);
                params.addQueryStringParameter("MAC", "A12321B1C1E6");

                CommonData.getDataFromService(params, "ddbus/station/info", new HttpUtilsCallBack() {
                    @Override
                    public void succ(String result) {

                        Log.e("result", "result:" + result);
                        String str = result.substring(1, result.length() - 1);
                        staionInfo = gson.fromJson(str, StaionInfo.class);
                        getStationInfoBynamicCode(stacode, staionInfo);
                        ;
                    }

                    @Override
                    public void failure(String s) {

                        Log.e("result", "failure:" + s);
                    }
                });
            }


            //    http://202.175.87.15:7013/ddbus/dynamic/station?debug=true&action=staCode&staCode=10393,10391&
//    MAC=01:02:03:04:05:06&HUID=238881bb1&mobile=android-v4.4&appVer=0.3.3&BypassToken=HuatuTesting0307
            private void getStationInfoBynamicCode(String stacode, StaionInfo staInfo) {
                params = CommonData.getRequestParama();
                params.addQueryStringParameter("action", "staCode");
                params.addQueryStringParameter("staCode", stacode);
                params.addQueryStringParameter("MAC", "01:02:03:04:05:06");
                CommonData.getDataFromService(params, "ddbus/dynamic/station", new HttpUtilsCallBack() {
                    @Override
                    public void succ(String result) {
                        Log.e("namiCodeS", "" + result);
                        staNamicInfo = gson.fromJson(result.substring(1, result.length() - 1), StaionNamicInfo.class);

                        exLvAdapter = new ExListStaInfoAdapter(MainActivity.this, staionInfo, staNamicInfo);
                        ex_lv_stationinfo.setAdapter(exLvAdapter);
                        exLvAdapter.notifyDataSetChanged();
//                openExSpanList();

                    }

                    @Override
                    public void failure(String s) {
                        Log.e("namiCodeF", "failur" + s);
                    }
                });

            }


            private void openExSpanList() {

                ex_lv_stationinfo.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                    @Override
                    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                        if (ex_lv_stationinfo.isGroupExpanded(groupPosition)) {
                            ex_lv_stationinfo.collapseGroup(groupPosition);

                        }
                        return false;
                    }
                });

            }

            // 处理消息
            @Subscribe(threadMode = ThreadMode.MAIN)
            public void handlerEventBus(String message) {

                Toast.makeText(this,  message+"中...", Toast.LENGTH_LONG).show();
                getStacodeByLat();

            }

            @Override
            protected void onDestroy() {
                super.onDestroy();
                EventBus.getDefault().unregister(this);
            }
        }


