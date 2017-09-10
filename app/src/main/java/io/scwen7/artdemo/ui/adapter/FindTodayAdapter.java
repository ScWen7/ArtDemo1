package io.scwen7.artdemo.ui.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import io.scwen7.artdemo.R;
import io.scwen7.artdemo.data.bean.TodayBean;
import io.scwen7.artdemo.utils.AppUtil;

/**
 * Created by 解晓辉  on 2017/9/10 11:10 *
 * QQ  ：811733738
 * 作用:
 */

public class FindTodayAdapter extends BaseQuickAdapter<TodayBean, BaseViewHolder> {
    public FindTodayAdapter(@LayoutRes int layoutResId, @Nullable List<TodayBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TodayBean item) {
        ImageView todayImage = helper.getView(R.id.todayImage);
        ImageView todayHead = helper.getView(R.id.todayHead);
        Glide.with(mContext).load(item.getProImage()).into(todayImage);
        Glide.with(mContext).load(item.getArtAvoter()).error(R.drawable.usernormal).into(todayHead);
        helper.setText(R.id.todayTitle, item.getProName())
                .setText(R.id.todayName, item.getArtName())
                .setText(R.id.todayPrice, AppUtil.getString(R.string.monen_symbol) + item.getPrice());

    }
}
