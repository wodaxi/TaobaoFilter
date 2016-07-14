package com.demo.jiongdongfilter.adapter;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.jiongdongfilter.FlowLayout;
import com.demo.jiongdongfilter.R;

import java.util.ArrayList;

/**
 * @FileName FiterAdapter
 * @Description 筛选适配器
 * @Author zhouyong
 * @Date 2015-08-13 14:24
 * @Version V 1.0
 */
public class GridviewAdapter extends android.widget.BaseAdapter {
    private Context context;
    private ArrayList<String> list;
    private LayoutInflater layoutInflater;
    private final ViewGroup.MarginLayoutParams lp;

    public GridviewAdapter(Context contexts, ArrayList<String> lists) {
        this.context = contexts;
        this.list = lists;
        this.layoutInflater = LayoutInflater.from(context);

        //一个流布局
        lp = new ViewGroup.MarginLayoutParams(
                DrawerLayout.LayoutParams.WRAP_CONTENT, DrawerLayout.LayoutParams.WRAP_CONTENT);
        lp.leftMargin = 15;
        lp.rightMargin = 15;
        lp.topMargin = 5;
        lp.bottomMargin = 5;

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
            convertView = layoutInflater.inflate(R.layout.grid_item, null);
          holder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            holder.flow_view = (FlowLayout) convertView.findViewById(R.id.flow_view);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();

        }
        holder.tv_title.setText(list.get(position));

        holder.flow_view.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            TextView view = new TextView(context);
            view.setText(list.get(i));
            view.setTextSize(12);
            view.setBackground(context.getResources().getDrawable(R.drawable.button_shape_search_tvbg));
            holder.flow_view.addView(view, lp);
            holder.flow_view.setHorizontalSpacing(10);
            holder.flow_view.setVerticalSpacing(10);
            final int finalI = i;
            holder.flow_view.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, list.get(finalI), Toast.LENGTH_SHORT).show();
                }
            });
        }
        return convertView;
    }

    class ViewHolder {
        public TextView tv_title;
        public FlowLayout flow_view;
    }
}
