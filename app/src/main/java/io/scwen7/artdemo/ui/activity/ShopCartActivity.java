package io.scwen7.artdemo.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import io.scwen7.artdemo.R;
import io.scwen7.artdemo.base.BaseActivity;

public class ShopCartActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.titleName)
    TextView mTitleName;
    @BindView(R.id.tv_title_right)
    TextView mTvTitleRight;
    @BindView(R.id.lv_shopcart_listview)
    ListView mLvShopcartListview;
    @BindView(R.id.cb_checked_all)
    CheckBox mCbCheckedAll;
    @BindView(R.id.btn_payment)
    Button mBtnPayment;
    @BindView(R.id.tv_checked_money)
    TextView mTvCheckedMoney;

    @BindView(R.id.tv_checked_artwork_num)
    TextView mTvCheckedArtworkNum;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_shop_cart;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        mTitleName.setText("购物车");
        mTvTitleRight.setText("删除");



    }


    @OnClick({R.id.back, R.id.tv_title_right, R.id.cb_checked_all, R.id.btn_payment})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                break;
            case R.id.tv_title_right:
                break;
            case R.id.cb_checked_all:
                break;
            case R.id.btn_payment:
                break;
        }
    }
}
