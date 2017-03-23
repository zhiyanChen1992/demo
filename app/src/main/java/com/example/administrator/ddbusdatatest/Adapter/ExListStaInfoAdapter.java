package com.example.administrator.ddbusdatatest.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.ddbusdatatest.Bean.StaionInfo;
import com.example.administrator.ddbusdatatest.Bean.StaionNamicInfo;
import com.example.administrator.ddbusdatatest.R;
import com.example.administrator.ddbusdatatest.widgets.AnimatedExpandableListView;

/**
 * Created by Administrator on 2017/3/22 0022.
 */
public class ExListStaInfoAdapter extends AnimatedExpandableListView.AnimatedExpandableListAdapter{
    private Context context;
    private StaionInfo staInfo;
    private StaionNamicInfo staNamicInfo;
    public ExListStaInfoAdapter(Context context,StaionInfo staInfo,StaionNamicInfo staNamicInfo)  {
        this.context = context;
        this.staInfo = staInfo;
        this.staNamicInfo = staNamicInfo;

    }
    public StaionInfo getStaInfo(){
        return  staInfo;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder grHolder;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_group,null);
            grHolder= new GroupViewHolder();
            grHolder.tvStaName = (TextView) convertView.findViewById(R.id.tv_sta_name);
            grHolder.ivRight = (ImageView) convertView.findViewById(R.id.iv_right);
            convertView.setTag(grHolder);
        }else{
            grHolder = (GroupViewHolder) convertView.getTag();

        }
        String staName = staInfo.getData().get(groupPosition).getStaname();
        String staNum = staInfo.getData().get(groupPosition).getStationcode();
        grHolder.tvStaName.setText(staNum+"-"+staName);
        return convertView;
    }
    @Override
    public View getRealChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder childHolder;
        if (convertView== null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_child,null);
            childHolder = new ChildViewHolder();
            childHolder.iv_bus_icon = (ImageView) convertView.findViewById(R.id.iv_bus_icon);
            childHolder.tv_rout_code = (TextView) convertView.findViewById(R.id.tv_rout_name);
            childHolder.tv_rout_info = (TextView) convertView.findViewById(R.id.tv_rout_info);
            childHolder.tv_sta_count  = (TextView) convertView.findViewById(R.id.tv_stop_count);
            convertView.setTag(childHolder);
        }else {
            childHolder = (ChildViewHolder) convertView.getTag();
        }
        String strRuCode = staInfo.getData().get(groupPosition).getRouteStaticinfo().get(childPosition).getRoutename();
        String strRuInfo = staInfo.getData().get(groupPosition).getRouteStaticinfo().get(childPosition).getLastname();
        String strStaCount = staInfo.getData().get(groupPosition).getRouteStaticinfo().get(childPosition).getStopxh();
        childHolder.tv_rout_code.setText(strRuCode);
        childHolder.tv_rout_info.setText("开往"+strRuInfo);
        childHolder.tv_sta_count.setText(strStaCount+"站");

        return convertView;
    }

    @Override
    public int getRealChildrenCount(int groupPosition) {
        return staInfo.getData().get(groupPosition).getRouteStaticinfo().size();
    }

    @Override
    public int getGroupCount() {
        return staInfo.getData().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return staInfo.getData().get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return staInfo.getData().get(groupPosition).getRouteStaticinfo().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }



    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    private class ChildViewHolder{

        public TextView tv_rout_code,tv_rout_info,tv_sta_count;
        public ImageView iv_bus_icon;


    }

    private class GroupViewHolder{

        public TextView tvStaName;
        public ImageView ivRight;

    }

}
