package com.example.yls.test.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yls.test.R;
import com.example.yls.test.javaBean.javaBean_fragment2;
import com.example.yls.test.javaBean.javaBean_fragment3;

/**
 * Created by yls on 2017/5/16.
 */

public class adapter_fragment3_listitem extends BaseAdapter {
    private javaBean_fragment3 data = new javaBean_fragment3();
    private Context context;
    public adapter_fragment3_listitem(javaBean_fragment3 data, Context context){
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            View v = View.inflate(context, R.layout.layout_fragment4_listitem,null);
        ImageView image = (ImageView) v.findViewById(R.id.fragment4_listitem_image);
        TextView tv_ctime = (TextView) v.findViewById(R.id.fragment4_listitem_ctime);
        TextView tv_title = (TextView) v.findViewById(R.id.fragment4_listitem_title);
        TextView tv_content = (TextView) v.findViewById(R.id.fragment4_listitem_desc);
        tv_title.setText(data.getNewslist().get(position).getTitle());
        tv_ctime.setText(data.getNewslist().get(position).getCtime());
        tv_content.setText(data.getNewslist().get(position).getDescription());
        Glide.with(context).load(data.getNewslist().get(position).getPicUrl()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(image);
        return v;
    }
}
