package com.demo.jiongdongfilter;

import android.app.ActionBar;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.demo.jiongdongfilter.Filterfragment.FitrerFragment;
import com.demo.jiongdongfilter.adapter.ShopCommodityListAdapter;
import com.demo.jiongdongfilter.adapter.SurpriseGuessListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FilterActivity extends FragmentActivity implements View.OnClickListener {
    @BindView(R.id.tv_menu_change)
    TextView tvMenuChange;
    @BindView(R.id.auto_textview)
    AutoCompleteTextView autoTextview;
    @BindView(R.id.ll_search)
    LinearLayout llSearch;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.tab_rb_a)
    RadioButton tabRbA;
    @BindView(R.id.tab_rb_b)
    RadioButton tabRbB;
    @BindView(R.id.tab_rb_c)
    RadioButton tabRbC;
    @BindView(R.id.tab_rb_d)
    RadioButton tabRbD;
    @BindView(R.id.home_page_tabs)
    RadioGroup homePageTabs;
    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    @BindView(R.id.drawer_content)
    RelativeLayout drawerContent;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    private DrawerLayout mDrawerLayout;
    private RelativeLayout drawer_content;
    private TextView slide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        //显示默认fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.drawer_content, new FitrerFragment()).commit();
        StaggredView(2);





    }
    /**
     * 设置recycle的条目的间距
     */
    class SpaceItemDecoration extends RecyclerView.ItemDecoration {

        private int space;

        public SpaceItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

//            if(parent.getChildPosition(view) != 0)
            outRect.top = space / 2;
            outRect.bottom = space / 2;
            outRect.left = space;
            outRect.right = space;
        }
    }
    private int num = 1;
    @OnClick({R.id.tv_menu_change, R.id.auto_textview, R.id.ll_search, R.id.tv_cancel, R.id.tab_rb_a, R.id.tab_rb_b, R.id.tab_rb_c, R.id.tab_rb_d, R.id.drawer_content, R.id.drawer_layout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_menu_change:
                num--;
                StaggredView(num);
                break;
            case R.id.auto_textview:

                break;
            case R.id.ll_search:
                break;
            case R.id.tv_cancel:
                num++;
                StaggredView(num);
                break;
            case R.id.tab_rb_a:
                //弹框  选择
                ShowPUP(tabRbA);
                break;
            case R.id.tab_rb_b:
                recycleView.clearDisappearingChildren();
                recycleView.setHasFixedSize(true);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
                StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
                recycleView.setLayoutManager(staggeredGridLayoutManager);
                recycleView.setAdapter(new SurpriseGuessListAdapter(this));
                break;
            case R.id.tab_rb_c:
                recycleView.clearDisappearingChildren();
                StaggredView(2);
                break;
            case R.id.tab_rb_d:
                drawerLayout.openDrawer(drawerContent);//打开抽屉内容
                break;
            case R.id.drawer_content:
                break;
            case R.id.drawer_layout:
                break;
        }
    }

    /**
     * 弹出选择表
     */
    private void ShowPUP(View v) {
        View inflate = LayoutInflater.from(this).inflate(R.layout.layout_select, null);
        final PopupWindow popupWindow = new PopupWindow(inflate, ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT,true);
        inflate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(popupWindow.isShowing()){
                    popupWindow.dismiss();
                }
            }
        });
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, -1500, 0);
        translateAnimation.setDuration(1000);
        inflate.setAnimation(translateAnimation);

        popupWindow.showAsDropDown(v);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());

    }

    /**
     * 瀑布流视图
     */
    private void StaggredView(int x) {
        if(x < 1){
            return;
        }
        recycleView.clearDisappearingChildren();
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(x, StaggeredGridLayoutManager.VERTICAL);
        recycleView.setHasFixedSize(true);
        recycleView.setLayoutManager(staggeredGridLayoutManager);
        ShopCommodityListAdapter adapter = new ShopCommodityListAdapter(this);
        recycleView.setAdapter(adapter);
        //一个平移动画
//        TranslateAnimation translateAnimation = new TranslateAnimation(0,10,1500,0);
//        translateAnimation.setDuration(1000);
//        recycleView.setAnimation(translateAnimation);

    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.bind(this).unbind();
    }


}
