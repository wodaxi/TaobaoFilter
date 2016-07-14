package com.demo.jiongdongfilter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.demo.jiongdongfilter.R;


/**
 * Created by xulei on 2016/7/7.
 */
public class ShopCommodityListAdapter extends RecyclerView.Adapter<ShopCommodityListAdapter.SurpriseViewholder> implements View.OnClickListener {
    private Context context;

    public ShopCommodityListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public SurpriseViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.activity_shop_commodity_items, null);
        SurpriseViewholder surpriseViewholder = new SurpriseViewholder(inflate, myItemClickListener);
        inflate.setOnClickListener(this);
        return surpriseViewholder;
    }

    @Override
    public void onBindViewHolder(SurpriseViewholder holder, int position) {
        switch (position % 2) {
            case 0:

                Animation animation = AnimationUtils.loadAnimation(context, R.anim.rotate_ani);
                holder.iv_pic.setAnimation(animation);
                break;
            case 1:
                Animation animation2 = AnimationUtils.loadAnimation(context, R.anim.scale_ani);
                holder.iv_pic.setAnimation(animation2);
                break;
        }

    }

    public void setOnItemClickListener(MyItemClickListener listener) {
        this.myItemClickListener = listener;
    }

    @Override
    public int getItemCount() {
        return 100;
    }

    private MyItemClickListener myItemClickListener;


    @Override
    public void onClick(View v) {
        if (myItemClickListener != null) {
            myItemClickListener.onItemClick(v, (String) v.getTag());
        }
    }

    class SurpriseViewholder extends RecyclerView.ViewHolder {
        public ImageView iv_pic;

        public SurpriseViewholder(View view, MyItemClickListener myItemClickListener) {
            super(view);
            iv_pic = (ImageView) view.findViewById(R.id.iv_pic);
        }
    }

    public interface MyItemClickListener {
        public void onItemClick(View view, String data);
    }

}
