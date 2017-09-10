package io.scwen7.artdemo.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.scwen7.artdemo.R;
import io.scwen7.artdemo.base.BaseFragment;
import io.scwen7.artdemo.data.bean.FindMultiItem;
import io.scwen7.artdemo.ui.activity.ShopCartActivity;
import io.scwen7.artdemo.ui.adapter.FindRecyclerAdapter;

/**
 * Created by 解晓辉  on 2017/9/9 12:20 *
 * QQ  ：811733738
 * 作用:
 */

public class FindFragment extends BaseFragment {

    @BindView(R.id.ivSearch)
    ImageView mIvSearch;
    @BindView(R.id.homeSearch)
    RelativeLayout mHomeSearch;
    @BindView(R.id.home_shopcart)
    ImageView mHomeShopcart;
    @BindView(R.id.tv_cartno)
    TextView mTvCartno;
    @BindView(R.id.ll_shopcart)
    RelativeLayout mLlShopcart;
    @BindView(R.id.ll_title)
    LinearLayout mLlTitle;
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;

    private FindRecyclerAdapter mFindRecyclerAdapter;
    private List<FindMultiItem> mFindMultiItems = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_find;
    }

    @Override
    protected void initData() {

        mRecyclerview.setLayoutManager(new LinearLayoutManager(mActivity));
        mFindRecyclerAdapter = new FindRecyclerAdapter(mFindMultiItems);

        mRecyclerview.setAdapter(mFindRecyclerAdapter);
        mRefreshLayout.setRefreshHeader(new ClassicsHeader(mActivity));
        mRefreshLayout.setEnableLoadmore(false);//是否启用上拉加载功能
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshData();
            }
        });
        mRefreshLayout.autoRefresh();//自动刷新
    }

    private void refreshData() {
        mRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mFindMultiItems.clear();
                mFindMultiItems.add(new FindMultiItem(FindMultiItem.BANNER, null));
                mFindMultiItems.add(new FindMultiItem(FindMultiItem.SESSION, null));
                mFindMultiItems.add(new FindMultiItem(FindMultiItem.TODAY, null));
                mFindMultiItems.add(new FindMultiItem(FindMultiItem.ARTIST, null));
                mFindMultiItems.add(new FindMultiItem(FindMultiItem.RENT, null));
                mRefreshLayout.finishRefresh();
                mFindRecyclerAdapter.setNewData(mFindMultiItems);
            }
        }, 3000);
    }


    @OnClick({R.id.homeSearch, R.id.ll_shopcart})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.homeSearch:

                break;
            case R.id.ll_shopcart:
                startActivity(ShopCartActivity.class);
                break;
        }
    }
}
