package io.scwen7.artdemo.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.scwen7.artdemo.R;
import io.scwen7.artdemo.base.BaseActivity;
import io.scwen7.artdemo.data.bean.CartItem;
import io.scwen7.artdemo.ui.adapter.ShopCartAdapter;

public class ShopCartActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.titleName)
    TextView mTitleName;
    @BindView(R.id.tv_title_right)
    TextView mTvTitleRight;
    @BindView(R.id.ry_shopcart)
    RecyclerView mRyShopcart;
    @BindView(R.id.cb_checked_all)
    CheckBox mCbCheckedAll;
    @BindView(R.id.btn_payment)
    Button mBtnPayment;
    @BindView(R.id.tv_checked_money)
    TextView mTvCheckedMoney;

    @BindView(R.id.tv_checked_artwork_num)
    TextView mTvCheckedArtworkNum;

    private List<CartItem> mCartItems;
    private ShopCartAdapter mShopCartAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_shop_cart;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        mTitleName.setText("购物车");
        mTvTitleRight.setVisibility(View.VISIBLE);
        mTvTitleRight.setText("删除");

        initCartItems();

        showRecycler();

    }

    private void showRecycler() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRyShopcart.setLayoutManager(layoutManager);

        mRyShopcart.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        ((SimpleItemAnimator) mRyShopcart.getItemAnimator()).setSupportsChangeAnimations(false);

        mShopCartAdapter = new ShopCartAdapter(R.layout.item_shopcart, mCartItems, mTvCheckedArtworkNum, mTvCheckedMoney, mCbCheckedAll);
        mRyShopcart.setAdapter(mShopCartAdapter);
    }

    private void initCartItems() {
        mCartItems = new ArrayList<>();
        CartItem cartItem1 = new CartItem(R.drawable.oil_chouxiang, "1001", "2800.00", "抽象|68cm x 68cm", "交河故城");
        CartItem cartItem2 = new CartItem(R.drawable.oil_dangdai, "1002", "12000.00", "当代|68cm x 68cm", "洋河");
        CartItem cartItem3 = new CartItem(R.drawable.oil_fengjing, "1003", "1000.00", "风景|68cm x 68cm", "山城");
        CartItem cartItem4 = new CartItem(R.drawable.oil_jingwu, "1004", "2000.00", "静物|68cm x 68cm", "荡漾年华");
        CartItem cartItem5 = new CartItem(R.drawable.oil_renwu, "1005", "100.00", "人物|68cm x 68cm", "生活集");
        CartItem cartItem6 = new CartItem(R.drawable.oil_xiaoxiang, "1006", "350.00", "肖像|68cm x 68cm", "江南春");

        mCartItems.add(cartItem1);
        mCartItems.add(cartItem2);
        mCartItems.add(cartItem3);
        mCartItems.add(cartItem4);
        mCartItems.add(cartItem5);
        mCartItems.add(cartItem6);
    }


    @OnClick({R.id.back, R.id.tv_title_right, R.id.cb_checked_all, R.id.btn_payment})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.tv_title_right:
                //删除商品
                //去购买
                if(mShopCartAdapter!=null) {
                    //删除选中的商品
                    mShopCartAdapter.deleteGood();
                    //检查是否全选
//                    mShopCartAdapter.checkAll();
                    mShopCartAdapter.showTotalPrice();
                    if(mShopCartAdapter.getItemCount() == 0) {
                        //显示空界面

                    }
                }
                break;
            case R.id.btn_payment:

                break;
        }
    }
}
