package io.scwen7.artdemo.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.List;

import io.scwen7.artdemo.R;

/**
 * Created by 解晓辉  on 2017/9/9 17:30 *
 * QQ  ：811733738
 * 作用:
 */

public class FragmentController {

    private int containerId;
    private FragmentManager fm;
    private List<Fragment> fragments;

    private int preIndex = 0;
    private Fragment preFragment = null;
    private RadioGroup mRadioGroup;


    public FragmentController(AppCompatActivity activity, int containerId, List<Fragment> fragments, RadioGroup viewGroup) {
        this.containerId = containerId;
        fm = activity.getSupportFragmentManager();
        this.fragments = fragments;
        mRadioGroup = viewGroup;
        addFragments();
        setListener();
        RadioButton radioButton1 = (RadioButton) mRadioGroup.findViewById(R.id.rb_nav_find);
        radioButton1.setChecked(true);
    }

    private void addFragments() {
        FragmentTransaction ft = fm.beginTransaction();
        for (int i = 0; i < fragments.size(); i++) {
            Fragment fragment = fragments.get(i);
            if (fragment.isAdded()) {
                continue;
            }
            ft.add(containerId, fragments.get(i));
            ft.hide(fragment);
        }
        ft.commit();
    }

    /**
     * RadioGroup设置监听
     */
    private void setListener() {
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.e("TAG", "onCheckedChanged");
                int position = -1;
                switch (checkedId) {
                    case R.id.rb_nav_find:
                        position = 0;
                        break;
                    case R.id.rb_nav_session:
                        position = 1;
                        break;
                    case R.id.rb_nav_rent:
                        position = 2;
                        break;
                    case R.id.rb_nav_news:
                        position = 3;
                        break;
                    case R.id.rb_nav_user:
                        position = 4;
                        break;
                }
                showFragment(position);
            }
        });

    }

    private void showFragment(int position) {
        Log.e("TAG", "showFragment");
        Fragment toFragment = swiFragment(position);
        if (preFragment != toFragment) {
            FragmentTransaction ft = fm.beginTransaction();
            if (position > preIndex) {
                ft.setCustomAnimations(R.anim.slide_right_in, R.anim.slide_left_out);
            }
            else if (position < preIndex) {
                ft.setCustomAnimations(R.anim.slide_left_in, R.anim.slide_right_out);
            }
            if (preFragment != null) {
                ft.hide(preFragment);
            }
            if (toFragment != null) {
                ft.show(toFragment);
            }
            ft.commit();
        }
        this.preFragment = toFragment;
        preIndex = position;
    }

    private Fragment swiFragment(int position) {
        if (fragments != null && fragments.size() > 0) {
            return fragments.get(position);
        }
        return null;
    }
}
