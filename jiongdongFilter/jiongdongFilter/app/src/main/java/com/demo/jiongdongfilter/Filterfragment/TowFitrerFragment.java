package com.demo.jiongdongfilter.Filterfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.demo.jiongdongfilter.R;
import com.demo.jiongdongfilter.adapter.FiterAdapter;
import com.demo.jiongdongfilter.model.FiterBean;

import java.util.ArrayList;

/**
 * @FileName TowFitrerFragment
 * @Description 二级筛选界面
 * @Author zhouyong
 * @Date 2015-08-13 13:37
 * @Version V 1.0
 */
public class TowFitrerFragment extends BaseFragment implements View.OnClickListener {
    private ListView listView;
    private TextView tvCancel;
    private ImageView ivLeft;

    private String[] mString = {"宏碁", "华为", "微软", "三星", "联系", "酷比魔方", "戴尔", "七彩虹", "VOYO", "dostyle", "优派"};
    private ArrayList<String> fiterList;
    private FiterAdapter fiterAdapter;

    public TowFitrerFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fiter_fragment, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        listView = (ListView) view.findViewById(R.id.listView);
        tvCancel.setVisibility(View.INVISIBLE);
        initData();

    }

    private void initData() {
        fiterList = new ArrayList<>();
        for (int i = 0; i < mString.length; i++) {
            fiterList.add(mString[i]);
        }
        fiterAdapter = new FiterAdapter(getActivity(), fiterList);
        listView.setAdapter(fiterAdapter);
    }

    private FiterBean fiterBean(String name) {
        FiterBean bean = new FiterBean();
        bean.setFiterName(name);
        return bean;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        }
    }
}

