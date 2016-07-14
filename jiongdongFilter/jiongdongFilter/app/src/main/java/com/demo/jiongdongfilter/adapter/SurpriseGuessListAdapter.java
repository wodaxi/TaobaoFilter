package com.demo.jiongdongfilter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.demo.jiongdongfilter.R;


/**
 * Created by xulei on 2016/7/7.
 */
public class SurpriseGuessListAdapter extends RecyclerView.Adapter<SurpriseGuessListAdapter.SurpriseViewholder> implements View.OnClickListener {
    private Context context;

    public SurpriseGuessListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public SurpriseViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.surprise_activity_item, null);
        SurpriseViewholder surpriseViewholder = new SurpriseViewholder(inflate, myItemClickListener);
        inflate.setOnClickListener(this);
        return surpriseViewholder;
    }

    @Override
    public void onBindViewHolder(SurpriseViewholder holder, int position) {

        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, -2000, 0);
        translateAnimation.setDuration(1000);
        holder.itemView.setAnimation(translateAnimation);
        holder.tv_title.setText(position+1+"");

    }

    public void setOnItemClickListener(MyItemClickListener listener) {
        this.myItemClickListener = listener;
    }

    @Override
    public int getItemCount() {
        return 200;
    }

    private MyItemClickListener myItemClickListener;


    @Override
    public void onClick(View v) {
        if (myItemClickListener != null) {
            myItemClickListener.onItemClick(v, (String) v.getTag());
        }
    }

    class SurpriseViewholder extends RecyclerView.ViewHolder {
        public TextView tv_title;
        public SurpriseViewholder(View view, MyItemClickListener myItemClickListener) {
            super(view);
            tv_title = (TextView) view.findViewById(R.id.tv_title);

        }
    }

    public interface MyItemClickListener {
        public void onItemClick(View view, String data);
    }

}
