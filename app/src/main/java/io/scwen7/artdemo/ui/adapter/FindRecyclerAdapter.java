package io.scwen7.artdemo.ui.adapter;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import io.scwen7.artdemo.R;
import io.scwen7.artdemo.data.bean.ArtistBean;
import io.scwen7.artdemo.data.bean.FindMultiItem;
import io.scwen7.artdemo.data.bean.TodayBean;
import io.scwen7.artdemo.ui.activity.ProductInfoActivity;
import io.scwen7.artdemo.utils.GlideImageLoader;

/**
 * Created by 解晓辉  on 2017/9/10 10:22 *
 * QQ  ：811733738
 * 作用:
 */

public class FindRecyclerAdapter extends BaseMultiItemQuickAdapter<FindMultiItem, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public FindRecyclerAdapter(List<FindMultiItem> data) {
        super(data);
        addItemType(FindMultiItem.BANNER, R.layout.item_find_banner);
        addItemType(FindMultiItem.SESSION, R.layout.item_find_session);
        addItemType(FindMultiItem.TODAY, R.layout.item_find_today);
        addItemType(FindMultiItem.ARTIST, R.layout.item_find_artist);
        addItemType(FindMultiItem.RENT, R.layout.item_find_rent);
    }

    @Override
    protected void convert(BaseViewHolder helper, FindMultiItem item) {
        switch (helper.getItemViewType()) {
            case FindMultiItem.BANNER:
                convertBannerData(helper, item);
                break;
            case FindMultiItem.SESSION:
                convertSessionData(helper, item);
                break;
            case FindMultiItem.TODAY:
                convertTodayData(helper, item);
                break;
            case FindMultiItem.ARTIST:
                convertArtistData(helper, item);
                break;
            case FindMultiItem.RENT:
                convertRentData(helper, item);
                break;
        }
    }

    private void convertRentData(BaseViewHolder helper, FindMultiItem item) {

    }

    private void convertArtistData(BaseViewHolder helper, FindMultiItem item) {

        RecyclerView recyclerArtist = helper.getView(R.id.home_artist);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);

        recyclerArtist.setLayoutManager(layoutManager);

        List<ArtistBean> artistBeen = new ArrayList<>();

        artistBeen.add(new ArtistBean("http://images.artbloger.com/2000_1600_1/artwork/2017/03/28/Art_14906813478741.jpg", ""));
        artistBeen.add(new ArtistBean("http://images.artbloger.com/2000_1600_1/avatar/2014/08/30/Art_14094030718641.jpg", ""));
        artistBeen.add(new ArtistBean("http://images.artbloger.com/2000_1600_1/artwork/2017/03/16/Art_14896482262315.jpg", ""));
        artistBeen.add(new ArtistBean("http://images.artbloger.com/2000_1600_1/artwork/2017/03/28/Art_14906805271244.jpg", ""));
        artistBeen.add(new ArtistBean("http://images.artbloger.com/2000_1600_1/cropcut/2015/04/10/Art_14286524256490.png", ""));

        FindArtistAdapter adapter = new FindArtistAdapter(R.layout.find_artist_item, artistBeen);
        recyclerArtist.setAdapter(adapter);

    }

    private void convertTodayData(BaseViewHolder helper, FindMultiItem item) {

        RecyclerView recyclerToday = helper.getView(R.id.home_today_hot);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2);
        recyclerToday.setLayoutManager(gridLayoutManager);

        final List<TodayBean> todayBeen = new ArrayList<>();

        todayBeen.add(new TodayBean("http://images.artbloger.com/2000_1600_1/artwork/2017/03/27/Art_14906022455981.jpg",
                "http://images.artbloger.com/70_70_3/avatar/2014/09/18/Art_14110247658528.jpg", "闲系列二", "6,000", "玟紫"));

        todayBeen.add(new TodayBean("http://images.artbloger.com/2000_1600_1/artwork/2017/03/27/Art_14906023121807.jpg",
                "http://images.artbloger.com/70_70_3/cropcut/2016/05/06/Art_14625165008547.png", "交河故城", "2,800", "棋至文化"));

        todayBeen.add(new TodayBean("http://images.artbloger.com/2000_1600_1/artwork/2017/03/27/Art_14906023268260.jpg",
                "http://images.artbloger.com/70_70_3/avatar/2014/09/18/Art_14110247658528.jpg", "洋和", "12,000", "菀儿"));

        todayBeen.add(new TodayBean("http://images.artbloger.com/70_70_3/avatar/2014/08/30/Art_14094073839207.JPG",
                "", "女人系列一", "13,000", "棋至文化"));


        final FindTodayAdapter adapter = new FindTodayAdapter(R.layout.find_today_item, todayBeen);
        recyclerToday.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mContext.startActivity(new Intent(mContext, ProductInfoActivity.class));
            }
        });
        helper.getView(R.id.showMore).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.addData(todayBeen);
            }
        });

    }

    private void convertSessionData(BaseViewHolder helper, FindMultiItem item) {
        ImageView ivSession = helper.getView(R.id.ivSession);
        Glide.with(mContext).load("http://images.artbloger.com/1242_621_1/artwork/2017/05/26/Art_14957696093067.jpg").into(ivSession);
    }

    private void convertBannerData(BaseViewHolder helper, FindMultiItem item) {
        Banner banner = helper.getView(R.id.find_banner);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.setImageLoader(new GlideImageLoader());
        List<String> images = new ArrayList<>();
        images.add("http://images.artbloger.com/750_500_3/artwork/2017/09/07/Art_15047686024685.jpg");
        images.add("http://images.artbloger.com/750_500_3/artwork/2017/06/28/Art_14986164236769.jpg");
        banner.setImages(images).start();
    }
}
