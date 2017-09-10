package io.scwen7.artdemo.ui.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.scwen7.artdemo.R;
import io.scwen7.artdemo.base.BaseFragment;
import io.scwen7.artdemo.data.CardItem;
import io.scwen7.artdemo.ui.adapter.CardFragmentAdapter;
import io.scwen7.artdemo.utils.AppUtil;
import io.scwen7.artdemo.weight.CradTranformer;

/**
 * Created by 解晓辉  on 2017/9/9 17:22 *
 * QQ  ：811733738
 * 作用:
 */

public class SessionFragment extends BaseFragment {
    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    private List<Fragment> mFragments;

    private String[] images = {
            "http://images.artbloger.com/2000_1600_1/artwork/2017/04/26/Art_14931928612673.jpg",
            "http://images.artbloger.com/2000_1600_1/artwork/2017/09/07/Art_15047676405727.jpg",
            "http://images.artbloger.com/2000_1600_1/artwork/2017/08/07/Art_15020853807434.jpg",
            "http://images.artbloger.com/2000_1600_1/artwork/2017/06/26/Art_14984443432824.jpg",
            "http://images.artbloger.com/2000_1600_1/artwork/2017/09/07/Art_15047674396907.jpg",
            "http://images.artbloger.com/2000_1600_1/artwork/2017/03/27/Art_14906056861754.jpg",
    };

    private List<CardItem> mCardItems;
    private String link = "http://www.artbloger.com/";

    @Override
    protected int getLayoutId() {
        setLazy(true);
        return R.layout.fragment_session;
    }

    @Override
    protected void initData() {
        mViewpager.setOffscreenPageLimit(3);
        initCardItems();
        initFragments();

        mViewpager.setPageTransformer(false, new CradTranformer(AppUtil.dip2px(2)));

        CardFragmentAdapter cardFragmentAdapter = new CardFragmentAdapter(getChildFragmentManager(), mFragments);
        mViewpager.setAdapter(cardFragmentAdapter);
    }

    private void initCardItems() {
        mCardItems = new ArrayList<>();
        String content = getString(R.string.content);
        for (int i = 0; i < images.length; i++) {
            mCardItems.add(new CardItem(images[i], content, link));
        }
    }

    private void initFragments() {
        mFragments = new ArrayList<>();
        for (int i = 0; i < mCardItems.size(); i++) {
            mFragments.add(CardFragment.newInstance(mCardItems.get(i)));
        }
    }

}
