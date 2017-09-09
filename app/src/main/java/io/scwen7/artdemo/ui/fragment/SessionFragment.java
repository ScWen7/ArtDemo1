package io.scwen7.artdemo.ui.fragment;

import io.scwen7.artdemo.R;
import io.scwen7.artdemo.base.BaseFragment;

/**
 * Created by 解晓辉  on 2017/9/9 17:22 *
 * QQ  ：811733738
 * 作用:
 */

public class SessionFragment  extends BaseFragment{
    @Override
    protected int getLayoutId() {
        setLazy(true);
        return R.layout.fragment_session;
    }

    @Override
    protected void initData() {
//        view_pager = (ViewPager) findViewById(R.id.view_pager);
//        view_pager.setOffscreenPageLimit(3);
//
//        initCardItems();
//        initFragments();
//
//        view_pager.setPageTransformer(false, new CradTranformer(dpToPixels(2, this)));
//
//        CardFragmentAdapter cardFragmentAdapter = new CardFragmentAdapter(getSupportFragmentManager(), mFragments);
//        view_pager.setAdapter(cardFragmentAdapter);
    }
}
