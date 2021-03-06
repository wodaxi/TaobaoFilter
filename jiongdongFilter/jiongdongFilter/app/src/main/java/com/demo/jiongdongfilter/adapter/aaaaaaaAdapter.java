package com.demo.jiongdongfilter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.demo.jiongdongfilter.R;

import java.util.ArrayList;

/**
 * @FileName FiterAdapter
 * @Description 筛选适配器
 * @Author zhouyong
 * @Date 2015-08-13 14:24
 * @Version V 1.0
 */
public class aaaaaaaAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> list;
    private LayoutInflater layoutInflater;

    public aaaaaaaAdapter(Context contexts, ArrayList<String> lists) {
        this.context = contexts;
        this.list = lists;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.aaaaaaa, null);
            holder.tvFilterName = (TextView) convertView.findViewById(R.id.tv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvFilterName.setText(list.get(position));
        return convertView;
    }


    class ViewHolder {
        private TextView tvFilterName;
    }
}
