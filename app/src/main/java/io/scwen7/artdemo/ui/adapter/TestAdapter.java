package io.scwen7.artdemo.ui.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import io.scwen7.artdemo.R;

/**
 * Created by 解晓辉  on 2017/9/10 09:19 *
 * QQ  ：811733738
 * 作用:
 */

public class TestAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public TestAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_content, item);
//        Banner banner = helper.getView(R.id.find_banner);
//        //设置banner样式
//        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
//        banner.setIndicatorGravity(BannerConfig.CENTER);
//        banner.setImageLoader(new GlideImageLoader());
//        List<String> images = new ArrayList<>();
//        images.add("http://img.zcool.cn/community/01b72057a7e0790000018c1bf4fce0.png");
//        images.add("http://img.zcool.cn/community/01700557a7f42f0000018c1bd6eb23.jpg");
//
//        banner.setImages(images).start();
    }
}
