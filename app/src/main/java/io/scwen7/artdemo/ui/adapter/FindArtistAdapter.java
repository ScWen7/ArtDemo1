package io.scwen7.artdemo.ui.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import io.scwen7.artdemo.R;
import io.scwen7.artdemo.data.bean.ArtistBean;
import io.scwen7.artdemo.weight.UpRoundImageView;

/**
 * Created by 解晓辉  on 2017/9/10 10:56 *
 * QQ  ：811733738
 * 作用:
 */

public class FindArtistAdapter extends BaseQuickAdapter<ArtistBean, BaseViewHolder> {
    public FindArtistAdapter(@LayoutRes int layoutResId, @Nullable List<ArtistBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ArtistBean item) {
        UpRoundImageView imageView = helper.getView(R.id.artistImage);
        Glide.with(mContext).load(item.getAvoter()).into(imageView);
    }
}
