package io.scwen7.artdemo.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.scwen7.artdemo.R;
import io.scwen7.artdemo.base.BaseActivity;
import io.scwen7.artdemo.ui.fragment.FindFragment;
import io.scwen7.artdemo.ui.fragment.MineFragment;
import io.scwen7.artdemo.ui.fragment.NewsFragment;
import io.scwen7.artdemo.ui.fragment.RentFragment;
import io.scwen7.artdemo.ui.fragment.SessionFragment;
import io.scwen7.artdemo.utils.FragmentController;
import io.scwen7.artdemo.utils.StatusBarUtil;

public class MainActivity extends BaseActivity {


    private List<Fragment> mFragments;
    @BindView(R.id.rg_normal)
    RadioGroup mRgNormal;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        StatusBarUtil.setTranslucentForImageView(this, 0, null);
        initFragments();
        //Fragment管理
        FragmentController controller = new FragmentController(this, R.id.fragment_container, mFragments, mRgNormal);

    }

    public void getShow(View view) {
        Fragment fragment1 = null;
        FragmentManager fragmentManager = MainActivity.this.getSupportFragmentManager();
        List<Fragment> fragments = fragmentManager.getFragments();
        for (Fragment fragment : fragments) {
            if (fragment != null && fragment.isVisible())
                fragment1 = fragment;
        }
        if (fragment1 != null) {
            String simpleName = fragment1.getClass().getSimpleName();
            Log.e("TAG", "showFragment:" + simpleName);
        }

    }

    private void initFragments() {
        mFragments = new ArrayList<>();

        FindFragment findFragment = new FindFragment();
        mFragments.add(findFragment);

        SessionFragment sessionFragment = new SessionFragment();
        mFragments.add(sessionFragment);

        RentFragment rentFragment = new RentFragment();
        mFragments.add(rentFragment);

        NewsFragment newsFragment = new NewsFragment();
        mFragments.add(newsFragment);

        MineFragment mineFragment = new MineFragment();
        mFragments.add(mineFragment);

    }

}
