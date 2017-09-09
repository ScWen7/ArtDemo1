package io.scwen7.artdemo.ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import butterknife.BindView;
import butterknife.OnClick;
import io.scwen7.artdemo.R;
import io.scwen7.artdemo.base.BaseFragment;
import io.scwen7.artdemo.ui.activity.ShopCartActivity;

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
    XRecyclerView mRecyclerview;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_find;
    }

    @Override
    protected void initData() {

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
