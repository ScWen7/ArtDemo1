package io.scwen7.artdemo.ui.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import io.scwen7.artdemo.R;
import io.scwen7.artdemo.data.bean.CartItem;
import io.scwen7.artdemo.utils.AppUtil;

/**
 * Created by 解晓辉  on 2017/9/9 20:44 *
 * QQ  ：811733738
 * 作用:
 */

public class ShopCartAdapter extends BaseQuickAdapter<CartItem, BaseViewHolder> {


    private TextView mTvCheckedArtworkNum;
    private TextView mTvCheckedMoney;
    private CheckBox mCbAll;

    public ShopCartAdapter(@LayoutRes int layoutResId, @Nullable List<CartItem> data,
                           TextView tvCheckedArtworkNum, TextView tvCheckedMoney, CheckBox cbAll) {
        this(layoutResId, data);
        this.mTvCheckedArtworkNum = tvCheckedArtworkNum;
        this.mTvCheckedMoney = tvCheckedMoney;
        this.mCbAll = cbAll;
        //显示总价格
        showTotalPrice();
        initListener(cbAll);
    }

    private void initListener(final CheckBox cbAll) {
        cbAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isChecked = cbAll.isChecked();
                checkAllOrNone(isChecked);
                showTotalPrice();
            }
        });
    }

    /**
     * 全选或者不选
     *
     * @param isChecked
     */
    public void checkAllOrNone(boolean isChecked) {
        if (mData != null && mData.size() > 0) {
            //说明有数据，没有删除
            //遍历集合进行修改状态操作
            for (int i = 0; i < mData.size(); i++) {
                CartItem goodsBean = mData.get(i);
                goodsBean.setCheck(isChecked);
            }
            notifyDataSetChanged();
            mCbAll.setChecked(isChecked);
        } else {
            mCbAll.setChecked(false);
        }
    }

    public  void showTotalPrice() {
        BigDecimal totalPrice = new BigDecimal("0.00");
        int checkCount = 0;
        if (mData != null && mData.size() > 0) {
            for (int i = 0; i < mData.size(); i++) {
                CartItem cartItem = mData.get(i);
                if (cartItem.isCheck()) {
                    BigDecimal price = new BigDecimal(cartItem.getPrice());
                    Log.e("TAG", "price:" + price);
                    totalPrice = totalPrice.add(price);
                    checkCount++;
                }
            }
            Log.e("TAG", "checkCount:" + checkCount + "totalPrice:" + totalPrice.doubleValue());
            mTvCheckedMoney.setText(AppUtil.getString(R.string.monen_symbol) + totalPrice);
            mTvCheckedArtworkNum.setText(checkCount + "");
        } else {
            mTvCheckedMoney.setText("0.00");
            mTvCheckedArtworkNum.setText(0 + "");

        }
    }


    /**
     * 检查选中状态
     */
    public void checkAll() {
        int number = 0;
        if (mData != null && mData.size() > 0) {
            for (int i = 0; i < mData.size(); i++) {
                CartItem cartItem = mData.get(i);
                if (!cartItem.isCheck()) {
                    //如果有一个是未选中的状态就设置为false
                    mCbAll.setChecked(false);
                    break;
                } else {
                    number++;
                }
            }
            //当选中的条目数与集合的大小相同则为全选
            if (number == mData.size()) {
                mCbAll.setChecked(true);
            }
        } else {
            mCbAll.setChecked(false);
        }
    }

    /**
     * 删除购物车中的商品
     */
    public void deleteGood() {
        //删除商品
        if (mData != null && mData.size() > 0) {

            for (Iterator iterator = mData.iterator(); iterator.hasNext(); ) {
                CartItem cartItem = (CartItem) iterator.next();
                if (cartItem.isCheck()) {
                    //根据对象找到在列表中的位置
                    int position = mData.indexOf(cartItem);
                    //从本地中删除
                    iterator.remove();
                    //刷新页面
                    notifyItemRemoved(position);
                }
            }
        }

    }

    public ShopCartAdapter(@LayoutRes int layoutResId, @Nullable List<CartItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, CartItem item) {
        helper.setChecked(R.id.cb_checked, item.isCheck())
                .setImageResource(R.id.iv_artwork_pic, item.getImage())
                .setText(R.id.tv_shopcart_artname, item.getName())
                .setText(R.id.tv_shopcart_artinfo, item.getModel())
                .setText(R.id.tv_shopcart_artprice, AppUtil.getString(R.string.monen_symbol) + item.getPrice());

        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = helper.getLayoutPosition();
                if (mData != null && mData.size() > 0) {
                    CartItem cartItem = mData.get(position);
                    //存储本地信息
                    cartItem.setCheck(!cartItem.isCheck());
                    //修checkbox状态
                    notifyItemChanged(position);
                    //修改总价格
                    showTotalPrice();
                    //检查选中状态
                    checkAll();
                }
            }
        });
    }
}
