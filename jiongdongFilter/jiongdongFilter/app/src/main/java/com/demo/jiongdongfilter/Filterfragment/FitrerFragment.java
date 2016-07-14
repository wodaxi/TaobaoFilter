package com.demo.jiongdongfilter.Filterfragment;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.jiongdongfilter.R;
import com.demo.jiongdongfilter.adapter.FiterAdapter;
import com.demo.jiongdongfilter.adapter.GridviewAdapter;
import com.demo.jiongdongfilter.model.FiterBean;
import com.demo.jiongdongfilter.model.MyListview;

import java.util.ArrayList;

/**
 * @FileName FitrerFragment
 * @Description 一级筛选界面
 * @Author
 * @Date 2015-08-13 13:36
 * @Version V 1.0
 */
public class FitrerFragment extends BaseFragment implements View.OnClickListener {

    private MyListview listView;
    private DrawerLayout mDrawerLayout;

    private String[] mString = {"品牌", "价格", "尺寸", "特色", "系统", "硬盘", "大家说"};
    private ArrayList<String> fiterList;
    private FiterAdapter fiterAdapter;

    public FitrerFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fiter_fragment, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        listView = (MyListview) view.findViewById(R.id.listView);

        mDrawerLayout = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);

        initData();

    }

    private void initData() {
        fiterList = new ArrayList<>();
        for (int i = 0; i < mString.length; i++) {
            fiterList.add(mString[i]);
        }
        GridviewAdapter adapter = new GridviewAdapter(getActivity(), fiterList);
        fiterAdapter = new FiterAdapter(getActivity(), fiterList);
        listView.setAdapter(adapter);

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
